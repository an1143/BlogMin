package com.mingyu.homeTest;

import java.util.Scanner;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mingyu.dao.BbsDAO;
import com.mingyu.dao.MemberDAO;
import com.mingyu.home.dao.NoticeTitleDAO;
import com.mingyu.home.vo.NoticeTitleVo;
import com.mingyu.vo.MemberVo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //root-context.xml파일 로딩 위치 
public class NoticeTitleTestDAO {

	
	    // pom.xml에서 servlet 버전 높여 주어야됨
		private static final Logger logger= LoggerFactory.getLogger(NoticeTitleTestDAO.class);
	
	
	
		@Inject
		private NoticeTitleDAO noticeTitleDAO;
		
		
		@Test
		public void HomeControolerTest() throws Exception {
			// TODO Auto-generated method stub
		
			Scanner sc = new Scanner(System.in);
			System.out.println("숫자를 입력해주세요");
			System.out.println("1=insert, 2=read 3=update 4=delet 5=list 6=totalData 7=uriCompo");
			int i = sc.nextInt();  
			
			
			if(i==1) 
			{
				NoticeTitleVo noticeVo = new NoticeTitleVo();
				
				noticeVo.setMain_title_name("게시판1");
				noticeVo.setMain_title_no(0);
				noticeVo.setSub_title_no(0);
				noticeVo.setSub_title_name("서브게시판");
				noticeVo.setSub_table_name("noticetitle");
				noticeVo.setTitle_auth("전체");
				
				
				noticeTitleDAO.insert(noticeVo);
			}
			
			
			
			
			
		}
		
		
		
		 
		 
}

