package org.kh.spring.member.store;

import java.util.List;

import org.kh.spring.member.domain.Member;

public interface MemberStore {

	/**
	 * 회원 로그인 Store
	 * 
	 * @param member
	 * @return Member
	 */
	public Member checkMemberlogin(Member member);

	public List<Member> selectMembers();

	/**
	 * 회원 상제 정보 조회 Store
	 * 
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);
}
