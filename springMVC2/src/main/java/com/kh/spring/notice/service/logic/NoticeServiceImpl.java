package com.kh.spring.notice.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.domain.PageInfo;
import com.kh.spring.notice.domain.Search;
import com.kh.spring.notice.service.NoticeService;
import com.kh.spring.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeStore nStore;
	@Autowired
	private SqlSession session;

	@Override
	public int insertNotice(Notice notice) {
		return nStore.insertNotice(session, notice);
	}

	@Override
	public List<Notice> selectNoticeList(PageInfo pi) {
		List<Notice> nList = nStore.selectNoticeList(session, pi);
		return nList;
	}

	@Override
	public Notice selectOneById(int noticeNo) {
		Notice notice = nStore.selectOneById(session, noticeNo);
		return notice;
	}

	@Override
	public int noticeRemove(int noticeNo) {
		int result = nStore.noticeRemove(session, noticeNo);
		return result;
	}

	@Override
	public int getListCnt() {
		int result = nStore.getListCnt(session);
		return result;
	}
	
	@Override
	public int getListCnt(Search search) {
		int result = nStore.getListCnt(session, search);
		return result;
	}

	@Override
	public int updateNotice(Notice notice) {
		int result = nStore.updateNotice(session, notice);
		return result;
	}

	@Override
	public List<Notice> selectListByKeyword(PageInfo pi, Search search) {
		List<Notice> list = nStore.selectListByKeyword(session, pi, search);
		return list;
	}

}
