package com.mingyu.home.vo;


/*
 * 동적 게시판 VO
 * table : noticetitle (게시판 테이블)
 */



public class NoticeTitleVo {

	
	int main_title_no;          //메인 타이틀 구분번호 
	String main_title_name; 	//메인 타이틀 이름
	int sub_title_no;			//서브타이틀 구분번호
	String sub_title_name;		//서브 타이틀 이름
	String sub_table_name;		//데이터 베이스 이름
	String title_auth;			//권한
	
	
	
	public int getMain_title_no() {
		return main_title_no;
	}
	
	public void setMain_title_no(int main_title_no) {
		this.main_title_no = main_title_no;
	}
	
	public String getMain_title_name() {
		return main_title_name;
	}
	
	public void setMain_title_name(String main_title_name) {
		this.main_title_name = main_title_name;
	}
	
	public int getSub_title_no() {
		return sub_title_no;
	}
	
	public void setSub_title_no(int sub_title_no) {
		this.sub_title_no = sub_title_no;
	}
	
	public String getSub_title_name() {
		return sub_title_name;
	}
	
	public void setSub_title_name(String sub_title_name) {
		this.sub_title_name = sub_title_name;
	}
	
	public String getSub_table_name() {
		return sub_table_name;
	}
	
	public void setSub_table_name(String sub_table_name) {
		this.sub_table_name = sub_table_name;
	}
	
	public String getTitle_auth() {
		return title_auth;
	}
	
	public void setTitle_auth(String title_auth) {
		this.title_auth = title_auth;
	}
	
	
	
	
	
}
