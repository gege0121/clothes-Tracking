package com.ascending.training.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
    public Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("i am at logger");
    }

    @Override
    public void destroy() {

    }


//    private Logger logger=LoggerFactory.getLogger()
//    public void init(FilterConfig filterConfig){
//
//    }
//    @Override

}
