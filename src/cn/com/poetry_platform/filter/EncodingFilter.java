package cn.com.poetry_platform.filter;

import cn.com.poetry_platform.utils.ConfigFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 此过滤器用于设置编码集。
 */
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain fc) throws IOException, ServletException {

        //System.out.println("EncodingFilter.doFilter() begin.................");
        // 我们首先先把ServletRequest，ServletResponse 转成 --> HttpServletRequest, HttpServletResponse
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        // 设置编码集
        String encoding = ConfigFactory.getString("common.encoding", "UTF-8");
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=" + encoding);
        // 调用FilterChain
        fc.doFilter(request, response);
        //System.out.println("EncodingFilter.doFilter()   end.................");
    }

    @Override
    public void destroy() {
    }
}