package com.cts.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/*
 @author Myvin Barboza
 29/02/20 8:32 AM
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();


        logger.info("request ->{} request uri ->{}",request,request.getRequestURI());

        return null;
    }
}