package com.mingyu.home.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mingyu.home.vo.NoticeTitleVo;

/*
 * 동적 게시판 DAOImpl
 * table : noticetitle (게시판 테이블)
 */

@Repository    //서비스 및에 있는 어노테이션 DAO를 스프링에 인식 시키는 역할 
public class NoticeTitleDAOImpl implements NoticeTitleDAO {

	
	@Inject
	private SqlSession sqlSession;
	
	
	
	@Override
	public void insert(NoticeTitleVo noticeTitleVo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("noticetitleInsert001", noticeTitleVo);
	}

	@Override
	public List<NoticeTitleVo> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeTitleVo update(NoticeTitleVo bvo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeTitleVo delete(int main_title_no, int sub_title_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
