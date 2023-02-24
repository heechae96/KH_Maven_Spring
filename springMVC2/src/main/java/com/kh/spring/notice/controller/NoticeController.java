package com.kh.spring.notice.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.domain.PageInfo;
import com.kh.spring.notice.domain.Search;
import com.kh.spring.notice.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService nService;

	@RequestMapping("/notice/write.kh")
	public String wrtie() {
		return "notice/write";
	}

	@RequestMapping(value = "/notice/write.kh", method = RequestMethod.POST)
	public String wrtie(@ModelAttribute Notice notice,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest req,
			Model model) {
		try {
			// 파일이 있는 경우
			// if (!uploadFile.getOriginalFilename().equals("")) {
			if (!uploadFile.isEmpty()) {
				// 파일 복사(지정한 경로 업로드)
				String filePath = saveFile(uploadFile, req);
				if (filePath != null) {
					// 이름을 가져와서 이름을 지정
					notice.setNoticeFileName(uploadFile.getOriginalFilename());
					// 파일 경로를 가져와서 파일 경로를 지정
					notice.setNoticeFilePath(filePath);
				}
			}
			int result = nService.insertNotice(notice);
			if (result > 0) {
				return "redirect:/";
			} else {
				model.addAttribute("msg", "공지사항 등록 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}

	}

	// 업로드 파일 메서드
	private String saveFile(MultipartFile uploadFile, HttpServletRequest req) {
		// 내가 원하는 경로 : 프로젝트 경로
		String root = req.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles";
		// 폴더가 없으면 만들것
		File folder = new File(savePath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		String filePath = savePath + "/" + uploadFile.getOriginalFilename();
		File file = new File(filePath);
		try {
			// 주어진 경로에 해당 파일을 전송(파일 복사)
			uploadFile.transferTo(file);
			return filePath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/notice/list.kh")
	public String noticeList(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
		try {
			int totalCnt = nService.getListCnt();
			PageInfo pi = this.getPageInfo(page, totalCnt);
			List<Notice> nList = nService.selectNoticeList(pi);
			if (nList != null) {
				model.addAttribute("pi", pi);
				model.addAttribute("list", nList);
				return "notice/list";
			} else {
				model.addAttribute("msg", "등록된 공지사항 없음");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 페이징처리 관련 메서드
	private PageInfo getPageInfo(int currPage, int totalCnt) {
		PageInfo pi = null;
		int boardLimit = 10;
		int naviLimit = 5;

		// int lastPage = (int) ((double) totalCnt / boardLimit + 0.9);
		int lastPage = (int) Math.ceil((double) totalCnt / boardLimit);
		// int startNavi = (((int) ((double) currPage / naviLimit + 0.9)) - 1) *
		// naviLimit + 1;
		int startNavi = ((currPage - 1) / naviLimit) * naviLimit + 1;
		int endNavi = startNavi + naviLimit - 1;
		if (endNavi > lastPage) {
			endNavi = lastPage;
		}
		pi = new PageInfo(currPage, boardLimit, naviLimit, startNavi, endNavi, totalCnt, lastPage);
		return pi;
	}

	@RequestMapping("/notice/detail.kh")
	public String noticeDetail(int noticeNo, Model model) {
		try {
			Notice notice = nService.selectOneById(noticeNo);
			model.addAttribute("notice", notice);
			return "notice/detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	@RequestMapping("/notice/remove.kh")
	public String noticeRemove(int noticeNo, Model model) {
		try {
			int result = nService.noticeRemove(noticeNo);
			if (result > 0) {
				return "redirect:/notice/list.kh";
			} else {
				model.addAttribute("msg", "공지사항 삭제 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	@RequestMapping("/notice/modify.kh")
	public String noticeModify(int noticeNo, Model model) {
		try {
			Notice notice = nService.selectOneById(noticeNo);
			if (notice != null) {
				model.addAttribute("notice", notice);
				return "notice/modify";
			} else {
				model.addAttribute("msg", "공지사항 조회 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	@RequestMapping(value = "/notice/modify.kh", method = RequestMethod.POST)
	public String noticeModify(@ModelAttribute Notice notice, Model model,
			@RequestParam(value = "reloadFile", required = false) MultipartFile reloadFile, HttpServletRequest req) {
		try {
			// 수정할때. 새로 업데이트된 파일이 있는 경우
			if (!reloadFile.isEmpty()) {
				// 기존 업로드된 파일 체크 후
				if (notice.getNoticeFileName() != null) {
					// 기존 파일 삭제
					this.deleteFile(notice.getNoticeFileName(), req);
				}
				// 새로 업로드된 파일 복사(지정된 경로 업로드)
				String modifyPath = this.saveFile(reloadFile, req);
				if (modifyPath != null) {
					// notice에 새로운 파일 이름, 파일 경로 set
					notice.setNoticeFileName(reloadFile.getOriginalFilename());
					notice.setNoticeFilePath(modifyPath);
				}

			}

			// DB에서 공지사항 수정(UPDATE)
			System.out.println("테스트: " + notice);
			int result = nService.updateNotice(notice);
			if (result > 0) {
				return "redirect:/notice/detail.kh?noticeNo=" + notice.getNoticeNo();
			} else {
				model.addAttribute("msg", "공지사항 수정 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 업로드 파일 삭제 메서드
	private void deleteFile(String fileName, HttpServletRequest req) throws Exception {
		String root = req.getSession().getServletContext().getRealPath("resources");
		String delPath = root + "/uploadFiles";
		String delFilePath = delPath + "/" + fileName;
		File delFile = new File(delFilePath);
		if (delFile.exists()) {
			delFile.delete();
		}
	}

	// 공지사항 검색
	@RequestMapping("/notice/search.kh")
	public String noticeSearch(
			// @RequestParam("searchValue") String keyword,
			// @RequestParam(value = "searchCondition") String condition, 
			@ModelAttribute Search search,
			@RequestParam(value = "page", required = false, defaultValue = "1") int currentPage,
			Model model) {
		try {
			System.out.println("테스트: " + search);
			int totalCnt = nService.getListCnt(search);
			PageInfo pi = this.getPageInfo(currentPage, totalCnt);
			List<Notice> searchList = nService.selectListByKeyword(pi, search);
//			if (searchList != null) {	// null은 지금 정상작동 X. else로 가지 않는다
			if (!searchList.isEmpty()) {
				model.addAttribute("pi", pi);
				model.addAttribute("search", search);
				model.addAttribute("sList", searchList);
				return "notice/search";
			} else {
				model.addAttribute("msg", "공지사항 검색 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}

	}
}
