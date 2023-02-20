package com.kh.spring.member.sevice;

import com.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 멤버 등록 Service
	 * 
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member);

	/**
	 * 멤버 로그인 Service
	 * 
	 * @param member
	 * @return Member
	 */
	public Member login(Member member);

	/**
	 * 마이페이지 Service
	 * 
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);

	/**
	 * 정보변경 Service
	 * @param member
	 * @return int
	 */
	public int modifyInfo(Member member);

}
