package com.mingyu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mingyu.vo.BbsVo;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;


@Repository
public class BbsDAOImpl implements BbsDAO {

	
	@Inject
	private SqlSession sqlSession;
	
	
	
	
	@Override
	public void insert(BbsVo bvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("insert", bvo);

	}

	@Override
	public BbsVo read(Integer bvo) throws Exception {
		// TODO Auto-generated method stub
		
		
		return sqlSession.selectOne("read", bvo);
	}

//	@Override
//	public HashMap<String, BbsVo> read(Integer bvo) throws Exception {
//		// TODO Auto-generated method stub
//		
//		HashMap<String, BbsVo> hm = sqlSession.selectOne("read",bvo);
//		System.out.println(hm);
//		
//		return null;
//	}

	
	
	@Override
	public BbsVo update(BbsVo bvo) throws Exception {
		
		
		sqlSession.update("update", bvo);
		return null;
	}
	

	
	
	

	@Override
	public BbsVo delete(Integer userid) throws Exception {
		
		sqlSession.delete("delete", userid);
		return null;
	}

	@Override
	public List <BbsVo> list() throws Exception {
		// TODO Auto-generated method stub
		
	
		List<BbsVo> bbsList = sqlSession.selectList("list"); 	
	
		//Map<String, BbsVo> vo = bbsList.get(1);
		//System.out.println(vo);

		return bbsList;
		


	}
	
	
//	  @Override 
//	  public List<BbsVo> list() throws Exception {
//	  
//	  List<BbsVo> bbsList = sqlSession.selectList("list");
//	  return bbsList;
//	  }

	@Override
	public List<BbsVo> listPage(int page) throws Exception {
		
		
		
		List<BbsVo> bbsList = sqlSession.selectList("listPage", page); 	
	
		
		return bbsList;
	}

		@Override
		public List<BbsVo> listCriteria(PageCriteria pageCria) throws Exception {
			// TODO Auto-generated method stub
			
			System.out.println("test1");
			System.out.println(pageCria.getStrPage());
			System.out.println(pageCria.getEndPage());
			
			
			List<BbsVo> bbsList = sqlSession.selectList("listCriteria", pageCria); 	
			System.out.println("test2");
			return bbsList;
	}

		@Override
		public int totalData() throws Exception {
			
			
			
			return sqlSession.selectOne("totalData") ;
		}

		
		@Override
		public int countData(PageCriteria pCria) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectOne("countData",pCria);
		}

		
		
		@Override
		public List<BbsVo> listFind(FindCriteria findCri) throws Exception {
			// TODO Auto-generated method stub
			
			
			System.out.println("진입+!!!!"+findCri.getPage());
			return sqlSession.selectList("listFind", findCri);
		}

		@Override
		public int findCountData(FindCriteria findCri) throws Exception {
			
			return sqlSession.selectOne("findCountData", findCri);
		}
	 

}
