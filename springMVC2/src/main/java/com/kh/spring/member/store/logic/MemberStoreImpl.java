package com.kh.spring.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.domain.Member;
import com.kh.spring.member.store.MemberStore;

@Repository
public class MemberStoreImpl implements MemberStore{

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public Member login(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.login", member);
		return mOne;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

	@Override
	public int modifyInfo(SqlSession session, Member member) {
		int result = session.update("MemberMapper.modifyInfo", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

}
