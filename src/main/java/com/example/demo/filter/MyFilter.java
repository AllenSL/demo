package com.example.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Slf4j
@WebFilter(urlPatterns = "/test/*", filterName = "myFilter")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.info(">>>>>>>>>>>>>>filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();
        log.info("请求url: {}",requestUri);
        String method = request.getMethod();
        log.info("请求method: {}",method);
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("请求parameter: {}",parameterMap);
        StopWatch sw = new StopWatch();
        sw.start("method:【"+method+"】 execute time");
        filterChain.doFilter(servletRequest,servletResponse);
        sw.stop();
        log.info(sw.prettyPrint());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
