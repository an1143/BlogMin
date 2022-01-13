package com.mingyu.vo;

import java.util.Date;

public class MemberVo {

	
			
			private String USERID;
			private String USERPWD;
			private String USERNAME;
			private String EMAIL;
			private Date REGDATE;
			private Date UPDATEDATE;
			
	
	
	
	
			
			public String getUSERID() {
				return USERID;
			}
			public void setUSERID(String uSERID) {
				USERID = uSERID;
			}
			public String getUSERPWD() {
				return USERPWD;
			}
			public void setUSERPWD(String uSERPWD) {
				USERPWD = uSERPWD;
			}
			public String getUSERNAME() {
				return USERNAME;
			}
			public void setUSERNAME(String uSERNAME) {
				USERNAME = uSERNAME;
			}
			public String getEMAIL() {
				return EMAIL;
			}
			public void setEMAIL(String eMAIL) {
				EMAIL = eMAIL;
			}
			public Date getREGDATE() {
				return REGDATE;
			}
			public void setREGDATE(Date rEGDATE) {
				REGDATE = rEGDATE;
			}
			public Date getUPDATEDATE() {
				return UPDATEDATE;
			}
			public void setUPDATEDATE(Date uPDATEDATE) {
				UPDATEDATE = uPDATEDATE;
			}
			
	
	
		 @Override
		 public String toString() {
			return "Member = "+USERID;
		 }
	
	

	}
