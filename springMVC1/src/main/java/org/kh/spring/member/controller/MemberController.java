package org.kh.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.spring.member.domain.Member;
import org.kh.spring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;

	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, Model model) {
		try {
			String memberId = request.getParameter("member-id");
			String memberPw = request.getParameter("member-pw");
			Member mParam = new Member(memberId, memberPw);
			Member member = mService.checkMeberLogin(mParam);
			if (member != null) {
				// 성공하면 성공페이지

				HttpSession session = request.getSession();
				session.setAttribute("loginUser", member);

				// 이전 방식
				// response.sendRedirect("/index.jsp");

				// 새로운 방식
				return "redirect:/home.do";
			} else {
				// 실패하면 실패페이지

				// 이전 방식
				// request.setAttribute("msg", "실패~");
				// request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");

				// 새로운 방식 model객체에 담아서 보내주자!
				model.addAttribute("msg", "실패~");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/member/list.do", method = RequestMethod.GET)
	public String printMembers(Model model) {
		try {
			List<Member> mList = mService.selectMembers();
			if (!mList.isEmpty()) {
				model.addAttribute("mList", mList);
				return "member/list";
			} else {
				model.addAttribute("msg", "데이터가 존재하지 않습니다");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("mList", e.getMessage());
			return "common/error";
		}

	}

	@RequestMapping(value = "/member/detail.do", method = RequestMethod.GET)
	public String selectOneById(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("memberId");
			Member mOne = mService.selectOneById(id);
			if (mOne != null) {
				model.addAttribute("member", mOne);
				return "member/detail";
			} else {
				model.addAttribute("msg", "데이터가 존재하지 않습니다");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("mList", e.getMessage());
			return "common/error";
		}
	}

}