package com.mingyu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mingyu.sqlSessionFactoryTest;
import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.ReplyVo;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	
	
	@Inject
	private SqlSession SqlSession;
	
	
	@Override
	public List<ReplyVo> list2(Integer bid_td) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectList("list2", bid_td);
	}

	@Override
	public void write2(ReplyVo rvo) throws Exception {
		System.out.println("write2!!!!!!");
		// TODO Auto-generated method stub
		SqlSession.insert("write2", rvo);
	}

	@Override
	public void modify2(ReplyVo rvo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.update("modify2", rvo);
	}

	@Override
	public void delete2(Integer rebid) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.delete("delete2", rebid);
		
	}

	@Override
	public List<ReplyVo> reListPage(Integer bid_tb, PageCriteria pCri) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> reMap = new HashMap<>();
		
		System.out.println("reListPage start");
		
		reMap.put("bid_tb",bid_tb);
		reMap.put("pCri", pCri);
		
		return SqlSession.selectList("reListPage", reMap);
	}

	@Override
	public int reCount(Integer bid_tb) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectOne("reCount",bid_tb);
	}

}
