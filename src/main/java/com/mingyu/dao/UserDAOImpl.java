package com.mingyu.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {

	
	@Inject
	private SqlSession SqlSession;
	
	
	
	@Override
	public int insertUser(Map<String, String> map) {
		
		return SqlSession.insert("userInsertUser",map);
	}

	@Override
	public Map<String, Object> selectUser(String userid) {
		// TODO Auto-generated method stub
		return SqlSession.selectOne("userSelectUser",userid);
	}

}
