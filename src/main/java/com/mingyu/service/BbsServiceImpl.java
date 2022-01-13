package com.mingyu.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mingyu.an.FindController;
import com.mingyu.dao.BbsDAO;
import com.mingyu.vo.BbsVo;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;




//DAO와 컨트롤의 중간단계 
@Service
public class BbsServiceImpl implements BbsService{

	@Inject
	private BbsDAO bdao;

	@Override
	public void write(BbsVo bvo) throws Exception {
		// TODO Auto-generated method stub
		bdao.insert(bvo);
	}

	@Override
	public  BbsVo read(Integer bid_tb) throws Exception {
		// TODO Auto-generated method stub
		return bdao.read(bid_tb);
	}

	@Override
	public void modify(BbsVo bid_tb) throws Exception {
		// TODO Auto-generated method stub
		bdao.update(bid_tb);
	}

	@Override
	public void remove(Integer bid_tb) throws Exception {
		// TODO Auto-generated method stub
		bdao.delete(bid_tb);
	}

	@Override
	public List<BbsVo> list() throws Exception {
		// TODO Auto-generated method stub
		return bdao.list();
	}

	@Override
	public List<BbsVo> listCriteria(PageCriteria pCria) throws Exception {
		// TODO Auto-generated method stub
		
		return bdao.listCriteria(pCria);
	}

	@Override
	public int totalData() throws Exception {
		// TODO Auto-generated method stub
		return bdao.totalData();
	}

	@Override
	public int listCountData(PageCriteria pCria) throws Exception {
		// TODO Auto-generated method stub
		return bdao.countData(pCria);
	}

	@Override
	public List<BbsVo> listFind(FindCriteria pCria) throws Exception {
		// TODO Auto-generated method stub
		return bdao.listFind(pCria);
	}

	@Override
	public int findCountData(FindCriteria pCria) throws Exception {
		// TODO Auto-generated method stub
		return bdao.findCountData(pCria);
	}

	
	

	

}
