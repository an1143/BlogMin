package com.mingyu.vo;

import java.util.Date;

public class BbsVo {

	private Integer bid_tb;
	private String subject;
	private String content;
	private String writer;
	private Date regdate;
	private int hit;
	
	
	public Integer getBid_tb() {
		return bid_tb;
	}
	public void setBid_tb(Integer bid_tb) {
		this.bid_tb = bid_tb;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
	
	    


	
	
}
