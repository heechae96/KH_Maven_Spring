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
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, 
			HttpServletRequest req, Model model) {
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
	public String noticeList(Model model) {
		try {
			List<Notice> nList = nService.selectNoticeList();
			if (nList != null) {
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
}
