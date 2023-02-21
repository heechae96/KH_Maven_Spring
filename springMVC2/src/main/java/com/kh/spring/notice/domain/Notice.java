package com.kh.spring.notice.domain;

import java.sql.Timestamp;

public class Notice {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWriter;
	private Timestamp nCreateDate;
	private Timestamp nUpdateDate;
	private String noticeFileName;
	private String noticeFilePath;
	
	public Notice() {
		super();
	}

	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, Timestamp nCreateDate,
			Timestamp nUpdateDate, String noticeFileName, String noticeFilePath) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.nCreateDate = nCreateDate;
		this.nUpdateDate = nUpdateDate;
		this.noticeFileName = noticeFileName;
		this.noticeFilePath = noticeFilePath;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Timestamp getnCreateDate() {
		return nCreateDate;
	}

	public void setnCreateDate(Timestamp nCreateDate) {
		this.nCreateDate = nCreateDate;
	}

	public Timestamp getnUpdateDate() {
		return nUpdateDate;
	}

	public void setnUpdateDate(Timestamp nUpdateDate) {
		this.nUpdateDate = nUpdateDate;
	}

	public String getNoticeFileName() {
		return noticeFileName;
	}

	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}

	public String getNoticeFilePath() {
		return noticeFilePath;
	}

	public void setNoticeFilePath(String noticeFilePath) {
		this.noticeFilePath = noticeFilePath;
	}

	@Override
	public String toString() {
		return "Notice [번호=" + noticeNo + ", 제목=" + noticeTitle + ", 내용=" + noticeContent
				+ ", 작성자=" + noticeWriter + ", 작성일=" + nCreateDate + ", 수정일=" + nUpdateDate
				+ ", 파일명=" + noticeFileName + ", 파일경로=" + noticeFilePath + "]";
	}
	
}
