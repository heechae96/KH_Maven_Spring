package org.kh.spring.member.service;

import org.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 로그인 Service
	 * 
	 * @param member
	 * @return Members
	 */
	public Member checkMeberLogin(Member member);

}
