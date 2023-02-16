package org.kh.spring.member.store;

import org.kh.spring.member.domain.Member;

public interface MemberStore {

	/**
	 * 회원 로그인 Store
	 * 
	 * @param member
	 * @return Member
	 */
	public Member checkMemberlogin(Member member);
}
