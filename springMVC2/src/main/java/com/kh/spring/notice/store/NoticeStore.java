package com.kh.spring.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.domain.PageInfo;
import com.kh.spring.notice.domain.Search;

public interface NoticeStore {

	/**
	 * 공지사항 등록 Store
	 * 
	 * @param session
	 * @param notice
	 * @return int
	 */
	public int insertNotice(SqlSession session, Notice notice);

	/**
	 * 공지사황 조회 Store
	 * 
	 * @param session
	 * @param pi
	 * @return List<Notice>
	 */
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pi);

	/**
	 * 공지사항 상세조회 Store
	 * 
	 * @param session
	 * @param noticeNo
	 * @return Notice
	 */
	public Notice selectOneById(SqlSession session, int noticeNo);

	/**
	 * 공지사항 삭제 Store
	 * 
	 * @param session
	 * @param noticeNo
	 * @return int
	 */
	public int noticeRemove(SqlSession session, int noticeNo);

	/**
	 * 공지사항 갯수 조회 Store
	 * 
	 * @param session
	 * @return int
	 */
	public int getListCnt(SqlSession session);
	
	/**
	 * 키워드를 포함한 공지사항 갯수 Store
	 * @param session
	 * @param search
	 * @return int
	 */
	public int getListCnt(SqlSession session, Search search);

	/**
	 * 공지사항 수정 Store
	 * 
	 * @param session
	 * @param notice
	 * @return int
	 */
	public int updateNotice(SqlSession session, Notice notice);

	/**
	 * 공지사항 검색 Store
	 * 
	 * @param session
	 * @param pi 
	 * @param search
	 * @return List<Notice>
	 */
	public List<Notice> selectListByKeyword(SqlSession session, PageInfo pi, Search search);

}
