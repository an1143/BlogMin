package com.mingyu.vo;

import java.sql.Date;

public class ReplyVo {

	
	private Integer rebid;
	private Integer bid_tb;
	private String replycontent;
	private String replyer;
	private Date regdate;
	private Date updatedate;
	
	
	
	
	public Integer getRebid() {
		return rebid;
	}
	
	public void setRebid(Integer rebid) {
		this.rebid = rebid;
	}
	
	public Integer getBid_tb() {
		return bid_tb;
	}
	
	public void setBid_tb(Integer bid_tb) {
		this.bid_tb = bid_tb;
	}
	
	public String getReplycontent() {
		return replycontent;
	}
	
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	
	public String getReplyer() {
		return replyer;
	}
	
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public Date getUpdatedate() {
		return updatedate;
	}
	
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	
	
	
	
}
