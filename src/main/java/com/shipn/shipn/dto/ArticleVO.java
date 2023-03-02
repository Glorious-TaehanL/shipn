package com.shipn.shipn.dto;

import java.sql.Date;

public class ArticleVO {
	
	private Integer articleNO;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
	
	public Integer getArticleNO() {
		return articleNO;
	}
	
	public void setArticleNO(Integer articleNO) {
		this.articleNO = articleNO;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
	public int getViewCnt() {
		return viewCnt;
	}
	
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
}
