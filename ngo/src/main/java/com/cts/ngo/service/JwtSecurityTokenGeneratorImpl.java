package com.cts.ngo.service;/*
 *@author Myvin Barboza

 *
 * 1:54 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(Ngo ngo) {
        // TODO Auto-generated method stub
        String jwtToken="";
        jwtToken = Jwts.builder().setSubject(""+ngo.getId()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretkey").compact();
        Map<String,String> map = new HashMap();
        map.put("token", jwtToken);
        map.put("message", "UserSuccessfully Logged in");
        return map;
    }

}
