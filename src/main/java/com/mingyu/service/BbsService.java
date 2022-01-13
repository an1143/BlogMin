package com.mingyu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mingyu.an.FindController;
import com.mingyu.vo.BbsVo;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;

public interface BbsService {

	public void write(BbsVo bvo) throws Exception;
	
	public BbsVo read(Integer bid_tb) throws Exception; 

	public void modify(BbsVo bid_tb) throws Exception;
	
	public void remove(Integer bid_tb) throws Exception;
	
	public List< BbsVo> list() throws Exception;

	public List< BbsVo> listCriteria(PageCriteria pCria) throws Exception;
	
	public int totalData() throws Exception;
	
	public int listCountData(PageCriteria pCria) throws Exception;

	public List< BbsVo> listFind(FindCriteria pCria) throws Exception;
	
	public int findCountData(FindCriteria pCria) throws Exception;
	
}
