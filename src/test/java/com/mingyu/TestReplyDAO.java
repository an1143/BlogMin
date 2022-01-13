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

import com.mingyu.dao.BbsDAO;
import com.mingyu.dao.ReplyDAO;
import com.mingyu.vo.BbsVo;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.ReplyVo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //root-context.xml파일 로딩 위치 
public class TestReplyDAO {

	
	    // pom.xml에서 servlet 버전 높여 주어야됨
		private static final Logger logger= LoggerFactory.getLogger(TestReplyDAO.class);
	
	
		
	
		@Inject
		private ReplyDAO RepDao;
		


		
		
		//insert테스트
		@Test
		public void BbsDaoTest() throws Exception {
			// TODO Auto-generated method stub
			
			
			
			int i = 0; 
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("숫자를 입력해주세요");
			System.out.println("1=insert, 2=read 3=update 4=delet 5=list 6=totalData 7=uriCompo");
			i = sc.nextInt();  
			
			Map<String, Object> a = new HashMap<String, Object>();
			
			
			if(i==1) {
			
				
				    //쓰기
				ReplyVo rvo = new ReplyVo();
				//rvo.setRebid(7);
				rvo.setBid_tb(246);
				rvo.setReplycontent("안녕!!");
				rvo.setReplyer("강호");
			     RepDao.write2(rvo);


					
			}else if(i==2) {
				
				  //읽기
				RepDao.list2(246);
				

		     					
			}else if(i==3){
			
			     //수정
				ReplyVo rvo = new ReplyVo();
				rvo.setRebid(3);
				rvo.setBid_tb(246);
				rvo.setReplycontent("안녕33");
				
				RepDao.modify2(rvo);
			
			
			}else if(i==4){
			
				//삭제
				
				RepDao.delete2(3);
			
			
			
			}else if(i==5){
			
			     //댓글 리스트 불러오기
				
		
			  PageCriteria pCri = new FindCriteria();
			  pCri.setNumPerPage(2);
			  pCri.setPage(1);
				
				
				RepDao.reListPage(246, pCri);
			
			
			}else if(i==6){
				
		
				RepDao.reCount(246);
				
				
			}else if(i==7) {
				
//				UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/bbs/read").queryParam("bid",100).queryParam("numPerPage", 20).build();
//				
//				
//				logger.info("/bbs/read?bid=100&numPerPage=20");
//				logger.info(uriComponents.toString());
				
				
				
				RepDao.list2(246);
			
				
				
			}else if (i == 8) {
				
	
				
				
		
				
			}else if(i ==9) {
				
				
				
				
			}else {
				
				System.out.println("숫자 해당 없음 ");
			}
			
			
			
			
			
		}
		

		 
		 
}

