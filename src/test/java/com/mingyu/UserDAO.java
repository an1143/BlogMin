package com.mingyu;

import java.util.Scanner;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mingyu.user.UserDTO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //root-context.xml파일 로딩 위치 
public class UserDAO {

	
	    // pom.xml에서 servlet 버전 높여 주어야됨
		private static final Logger logger= LoggerFactory.getLogger(UserDAO.class);
	
	
		
	
		@Inject
		private UserDAO userDao;
		
		

		
		
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
			
				
				
		
					
			}else {
				
				  //읽기
			
			}
			
			
			
			
		}
		

		 
		 
}

