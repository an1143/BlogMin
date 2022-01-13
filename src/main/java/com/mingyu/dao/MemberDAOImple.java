package com.mingyu.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mingyu.vo.MemberVo;




@Repository    //서비스 및에 있는 어노테이션 DAO를 스프링에 인식 시키는 역할 
public class MemberDAOImple implements MemberDAO {

	

	
	@Inject
	private SqlSession sqlSession;
	
	

	
	

	@Override
	public void insertMember(MemberVo mvo) {
		// TODO Auto-generated method stub
		sqlSession.insert("insertMember", mvo);

	}








}
