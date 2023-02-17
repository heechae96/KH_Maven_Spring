package org.kh.spring.member.service;

import java.util.List;

import org.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 로그인 Service
	 * 
	 * @param member
	 * @return Members
	 */
	public Member checkMeberLogin(Member member);

	/**
	 * 회원 목록 조회 Service
	 * 
	 * @return List<Member>
	 */
	public List<Member> selectMembers();

	/**
	 * 회원 목록 상제 조회 Service
	 * 
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);

}
