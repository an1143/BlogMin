package com.mingyu.home.dao;

/*
 * 동적 게시판 DAO
 * table : noticetitle (게시판 테이블)
 */


import java.util.List;




import com.mingyu.home.vo.NoticeTitleVo;

public interface NoticeTitleDAO {

	
	
	
	public void insert (NoticeTitleVo noticeTitleVo) throws Exception; 
	
	public List< NoticeTitleVo> select () throws Exception;
	
	public NoticeTitleVo update (NoticeTitleVo bvo) throws Exception;
	
	public NoticeTitleVo delete (int main_title_no, int sub_title_no ) throws Exception;
	
	
	
}
