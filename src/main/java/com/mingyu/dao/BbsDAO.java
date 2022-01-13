package com.mingyu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mingyu.an.FindController;
import com.mingyu.vo.BbsVo;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;


public interface BbsDAO {

	
	public void insert (BbsVo bvo) throws Exception;
	public BbsVo read (Integer bvo) throws Exception; 
	//public HashMap<String, BbsVo> read (Integer bvo) throws Exception;
	public BbsVo update (BbsVo bvo) throws Exception;

	public BbsVo delete (Integer userid) throws Exception;
	//public List<BbsVo> list () throws Exception;
	public List< BbsVo> list () throws Exception;
	
	public List< BbsVo> listPage(int page )throws Exception;
	
	
	public List< BbsVo> listCriteria(PageCriteria pageCria )throws Exception;
	
	
	public int totalData() throws Exception;
	
	public int countData(PageCriteria pCria) throws Exception;

	public List<BbsVo> listFind(FindCriteria pCria) throws Exception;
	
	public int findCountData(FindCriteria findCri) throws Exception;
	
}
