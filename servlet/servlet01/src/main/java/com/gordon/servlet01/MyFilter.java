package com.gordon.servlet01;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author:dongchen
 * @Date: 2022/11/20 14:58
 */
@WebFilter
public class MyFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filterConfig.getFilterName() = " + filterConfig.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
