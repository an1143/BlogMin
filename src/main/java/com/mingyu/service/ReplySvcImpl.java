package com.mingyu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mingyu.dao.ReplyDAO;
import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.ReplyVo;



@Service
public class ReplySvcImpl implements ReplySvc {

	
	@Inject
	private ReplyDAO dao;
	
	
	@Override
	public void inputReply(ReplyVo rvo) throws Exception {
		// TODO Auto-generated method stub
		dao.write2(rvo);
	}


	@Override
	public List<ReplyVo> replyList(Integer bid_tb) throws Exception {
		// TODO Auto-generated method stub
		return dao.list2(bid_tb);
	}


	@Override
	public void modifyReply(ReplyVo rvo) throws Exception {
		// TODO Auto-generated method stub
	
		dao.modify2(rvo);
	}


	@Override
	public void delReply(Integer rebid) throws Exception {
		// TODO Auto-generated method stub
		dao.delete2(rebid);
	}


	@Override
	public List<ReplyVo> reListPage(Integer bid_tb, PageCriteria pCri) throws Exception {
		// TODO Auto-generated method stub
		return dao.reListPage(bid_tb, pCri);
	}


	@Override
	public int reCount(Integer bid_tb) throws Exception {
		// TODO Auto-generated method stub
		return dao.reCount(bid_tb);
	}



	

}
