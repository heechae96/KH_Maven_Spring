package com.kh.spring.notice.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.domain.PageInfo;
import com.kh.spring.notice.store.NoticeStore;

@Repository
public class NoticeStoreImpl implements NoticeStore {

	@Override
	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pi) {
		/**
		 * limit 10, 1~10, 0 : offset
		 * limit 10, 11~20 10 : offset
		 * limit 10, 21~30 20 : offset
		 */
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		//																		null은 오타가 아님
		//																		-> 넘겨줄게 없음을 의미
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}

	@Override
	public Notice selectOneById(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneById", noticeNo);
		return notice;
	}

	@Override
	public int noticeRemove(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.noticeRemove", noticeNo);
		return result;
	}

	@Override
	public int getListCnt(SqlSession session) {
		int result = session.selectOne("NoticeMapper.getListCnt");
		return result;
	}

	@Override
	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

}
