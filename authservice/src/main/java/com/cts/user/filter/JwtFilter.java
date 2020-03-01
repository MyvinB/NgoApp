package com.cts.user.filter;

/*
 @author Myvin Barboza
 01/03/20 1:49 PM 
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class JwtFilter extends GenericFilterBean {
    public void doFilter(final ServletRequest req, final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;



        String proxyForwardedHostHeader = request.getHeader("X-Forwarded-Host");
        System.out.println("Proxy filter for proxy"+proxyForwardedHostHeader);
        if(proxyForwardedHostHeader==null){
            throw new ServletException("Pass only through api gateway");
        }


            chain.doFilter(req, res);
        }

    }
