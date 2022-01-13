package com.mingyu.dao;

import java.util.Map;

public interface UserDAO {

	//회원가입
	public int insertUser(Map<String, String>map);
	
	//로그인
	public Map<String, Object> selectUser (String userid);
	
}
