package org.kh.spring.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.spring.member.domain.Member;
import org.kh.spring.member.store.MemberStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MeberStoreImpl implements MemberStore{

	@Autowired
	private SqlSession session;
	
	@Override
	public Member checkMemberlogin(Member member) {
		Member result = session.selectOne("MemberMapper.checkMeberLogin", member);
		return result;
	}

}
