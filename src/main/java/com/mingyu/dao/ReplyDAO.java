package com.mingyu.dao;

import java.util.List;

import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.ReplyVo;

public interface ReplyDAO {

	
	public List<ReplyVo> list2(Integer bid_td) throws Exception;
	public void write2(ReplyVo rvo) throws Exception;
	public void modify2(ReplyVo rvo) throws Exception;
	public void delete2(Integer rebid) throws Exception;
	
	
	
	public List<ReplyVo> reListPage(Integer bid_tb, PageCriteria pCri) throws Exception;
	public int reCount(Integer bid_tb)throws Exception;
	
	
	
}
