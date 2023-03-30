package com.iefihz.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreZuulFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

    //ZuulFilter类型，有pre, routing, post, error
    @Override
    public String filterType() {
        return "pre";
    }

    //数字越大越靠后执行
    @Override
    public int filterOrder() {
        return 1;
    }

    //是否执行这个ZuulFilter
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        LOGGER.info("请求的host: {}", request.getRemoteHost());
        return null;
    }
}
