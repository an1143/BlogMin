package com.mingyu.security;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ShaEncoder {
		
		@Resource(name="passwordEncoder")
		ShaPasswordEncoder encoder;
		
		
		public String encoding(String str) {
			return encoder.encodePassword(str,null);
			
		}
		
		
		public String saltEncodeing(String str, String salt) {
			return encoder.encodePassword(str, salt);
		}
	
	
	
}
