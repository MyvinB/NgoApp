package com.cts.ordering.filter;

/*
 @author Myvin Barboza
 01/03/20 10:58 AM 
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
                         final FilterChain chain) throws IOException,ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization");
        String proxyForwardedHostHeader = request.getHeader("X-Forwarded-Host");
        System.out.println("Proxy filter for proxy"+proxyForwardedHostHeader);
        if(proxyForwardedHostHeader==null){
            throw new ServletException("Pass only through api gateway");
        }
        if("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);

        }else {
            if(authHeader==null || !authHeader.startsWith("Bearer")) {
                throw new ServletException("Missing or invalid Authorization header");

            }
            final String token = authHeader.substring(7);
            final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
            System.out.println(claims.getSubject());
            String s[]= claims.getSubject().split("-");
            System.out.println(Arrays.toString(s));
            if(!s[1].equals("res")&&!s[1].equals("ngo"))  throw new ServletException("Invalid login user");
            request.setAttribute("claims", claims);
            chain.doFilter(req, res);
        }

    }
}
