package com.cts.user.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cts.user.domain.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	
	public Map<String, String> generateToken(User user) {
		// TODO Auto-generated method stub
		String jwtToken="";
		jwtToken = Jwts.builder().setSubject(user.getUserId()+"-"+user.getUserType()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256,"secretkey").compact();
		Map<String,String> map = new HashMap();
		map.put("token", jwtToken);
		map.put("message", "UserSuccessfully Logged in");
		return map;
	}


	


	

}
