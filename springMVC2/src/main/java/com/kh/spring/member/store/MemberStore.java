package com.kh.spring.member.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.spring.member.domain.Member;

public interface MemberStore {

	/**
	 * 멤버 등록 Store
	 * 
	 * @param session
	 * @param member
	 * @return int
	 */
	public int insertMember(SqlSession session, Member member);

	/**
	 * 멤버 로그인 Store
	 * 
	 * @param session
	 * @param member
	 * @return Member
	 */
	public Member login(SqlSession session, Member member);

	/**
	 * 마이페이지 Store
	 * 
	 * @param session
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(SqlSession session, String memberId);

	/**
	 * 정보변경 Store
	 * 
	 * @param session
	 * @param member
	 * @return int
	 */
	public int modifyInfo(SqlSession session, Member member);

	/**
	 * 회원탈퇴 Store
	 * 
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(SqlSession session, String memberId);

}
