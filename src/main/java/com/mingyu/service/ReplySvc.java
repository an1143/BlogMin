package com.mingyu.service;

import java.util.List;

import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.ReplyVo;

public interface ReplySvc {

	
	
	public void inputReply(ReplyVo rvo) throws Exception ;
	public List<ReplyVo> replyList(Integer bid_tb) throws Exception ;
	public void modifyReply(ReplyVo rvo) throws Exception ;
	public void delReply(Integer rebid) throws Exception ;
	
	public List<ReplyVo> reListPage(Integer bid_tb, PageCriteria pCri) throws Exception;
	public int reCount(Integer bid_tb)throws Exception;
	
	
	
	
}
