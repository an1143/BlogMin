package com.mingyu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.mingyu.dao.BbsDAO;
import com.mingyu.vo.BbsVo;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //root-context.xml파일 로딩 위치 
public class TestBbsDAO {

	
	    // pom.xml에서 servlet 버전 높여 주어야됨
		private static final Logger logger= LoggerFactory.getLogger(TestBbsDAO.class);
	
	
		
	
		@Inject
		private BbsDAO BbsDao;
		
		

		
		
		//insert테스트
		@Test
		public void BbsDaoTest() throws Exception {
			// TODO Auto-generated method stub
			
			
			
			int i = 0; 
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("숫자를 입력해주세요");
			System.out.println("1=insert, 2=read 3=update 4=delet 5=list 6=totalData 7=uriCompo");
			i = sc.nextInt();  
			
			
			
			
			if(i==1) {
			
				
				    //쓰기
					BbsVo bvo = new BbsVo();
					bvo.setBid_tb(66);
					bvo.setContent("안녕");
					bvo.setSubject("제목");
					bvo.setWriter("작성자");
					BbsDao.insert(bvo);
					
			}else if(i==2) {
				
				  //읽기
				  BbsDao.read(15);

		     					
			}else if(i==3){
			
			     //수정
				 BbsVo bvo = new BbsVo();
				 bvo.setBid_tb(66);
				 bvo.setSubject("수정제목");
				 bvo.setContent("수정내용");
				
				BbsDao.update(bvo);
			
			
			}else if(i==4){
			
				//삭제
				BbsDao.delete(12);
			
			
			}else if(i==5){
			
			     //전체 리스트 불러오기
				
				PageCriteria pageCria = new PageCriteria();
				pageCria.setNumPerPage(5);
				pageCria.setPage(2);
			
				
			     BbsDao.listCriteria(pageCria);	
			
			}else if(i==6){
				
				System.out.println("총개수" +BbsDao.totalData());
				
				
			}else if(i==7) {
				
//				UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/bbs/read").queryParam("bid",100).queryParam("numPerPage", 20).build();
//				
//				
//				logger.info("/bbs/read?bid=100&numPerPage=20");
//				logger.info(uriComponents.toString());
				
				
				
				
				UriComponents uriComponents2 = UriComponentsBuilder.newInstance().path("/{module}/{page}").queryParam("bid", 100).queryParam("numPerPage", 20).build().expand("bbs","read").encode();
				
				logger.info("/bbs/read?bid=100&numPerPage=20");
				logger.info(uriComponents2.toString());
				
				
				
			}else if (i == 8) {
				
				
				FindCriteria cri = new FindCriteria();
				
				cri.setPage(2);
				cri.setFindType("S");
				cri.setKeyword("dd");
				
				logger.info("***********테스트**************");
				
				List<BbsVo> list = BbsDao.listFind(cri);
				
				
				for(BbsVo bvo: list) {
					
					logger.info("글번호 "+bvo.getBid_tb());
				}
				
				
				logger.info("**********개수 출력**************");
				
				logger.info("개수:" + BbsDao.findCountData(cri));
				
				
				
			}else if(i ==9) {
				
				
				
				
			}else {
				
				System.out.println("숫자 해당 없음 ");
			}
			
			
			
			
			
		}
		

		 
		 
}

