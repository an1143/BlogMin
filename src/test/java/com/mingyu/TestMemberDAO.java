package com.mingyu;

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

import com.mingyu.dao.MemberDAO;
import com.mingyu.vo.MemberVo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //root-context.xml파일 로딩 위치 
public class TestMemberDAO {

	
	    // pom.xml에서 servlet 버전 높여 주어야됨
		private static final Logger logger= LoggerFactory.getLogger(TestMemberDAO.class);
	
	
		
	
		@Inject
		private MemberDAO memberDAO;
		
		

		
		@Test
		public void insertMember() throws Exception {
			// TODO Auto-generated method stub
			
			MemberVo mvo = new MemberVo();
			mvo.setUSERID("test32");
			mvo.setUSERPWD("123");
			mvo.setUSERNAME("이름");
			mvo.setEMAIL("ddddd@Sssss");
			
			memberDAO.insertMember(mvo);
			
			
			
		}
		
		
		
		 
		 
}

