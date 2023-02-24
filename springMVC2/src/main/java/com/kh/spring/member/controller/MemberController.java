package com.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.spring.member.domain.Member;
import com.kh.spring.member.sevice.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;

	// 회원가입으로 이동
	@RequestMapping("/member/register.kh")
	public String registerView() {
		return "/member/register";
	}

	// 회원가입
	@RequestMapping(value = "/member/register.kh", method = RequestMethod.POST)
	public String memberRegister(HttpServletRequest req, @ModelAttribute Member member, String memberId,
			String memberPw, String memberName, String memberEmail, String memberPhone, String memberAddr,
			Model model) {
		try {
			int result = mService.insertMember(member);
			if (result > 0) {
				// return "redirect:/index.jsp";
				return "redirect:/";
			} else {
				model.addAttribute("msg", "회원가입 실패");
				return "common/error";
			}
		} catch (Exception e) {
			// 콘솔창에 에러 출력
			e.printStackTrace();
			// 에러 페이지에 에러 출력
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 로그인
	@RequestMapping(value = "/member/login.kh", method = RequestMethod.POST)
	public String login(HttpServletRequest req, @ModelAttribute Member member, String memberId, String memberPw,
			Model model) {
		try {
			Member mOne = mService.login(member);
			if (mOne != null) {
				HttpSession session = req.getSession();
				session.setAttribute("loginUser", mOne);
				return "redirect:/";
			} else {
				model.addAttribute("msg", "로그인 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 로그아웃
	@RequestMapping("/member/logout.kh")
	public String logout(HttpSession session, Model model) {
		if (session != null) {
			session.invalidate();
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그아웃 실패");
			return "common/error";
		}
	}

	// 마이페이지로 이동
	@RequestMapping("/member/myPage.kh")
	public String showMyPage(HttpSession session, Model model) {
		try {
			Member sessionMember = (Member) session.getAttribute("loginUser");
			if (sessionMember != null) {
				String memberId = sessionMember.getMemberId();
				Member member = mService.selectOneById(memberId);
				model.addAttribute("user", member);
				return "member/myPage";
			} else {
				model.addAttribute("msg", "마이페이지로 가기 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}

	}

	// 정보변경
	@RequestMapping(value = "/member/modify.kh", method = RequestMethod.POST)
	public String modifyInfo(HttpServletRequest req, @ModelAttribute Member member, String memberId, String memberPw,
			String memberName, String memberEmail, String memberPhone, String memberAddr, Model model) {
		try {
			int result = mService.modifyInfo(member);
			if (result > 0) {
				return "redirect:/";
			} else {
				model.addAttribute("msg", "정보변경 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
		
	}
	
	// 회원탈퇴
	@RequestMapping(value = "/member/delete.kh", method = RequestMethod.GET)
	public String deleteMember(HttpServletRequest req, String memberId, Model model) {
		try {
			// @RequestParam("memberID) String memberId
			// String id = req.getParameter("memberId");
			int result = mService.deleteMember(memberId);
			if (result > 0) {
				// 세션 반환 필요
				// 로그아웃에 구현되어 있음
				// -> 세션 반환하면서 redirect:/ 되어짐
				return "redirect:/member/logout.kh";
			} else {
				model.addAttribute("msg", "회원탈퇴 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	// /member/list.kh
	public String showMembers() {
		// 1. 페이징 없이 출력
		// 2. 페이징 처리해서 출력
		// 3. 검색해서 출력
		// 4. 검색하고 페이징 처리 출력
		return null;
	}

}
