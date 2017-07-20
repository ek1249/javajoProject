package com.javajo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class JavajoFilter
 */
@WebFilter("/javajo/*")
public class JavajoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public JavajoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		int no = 0;
		HttpSession session = ((HttpServletRequest)request).getSession(true);
		String msg = "게시들 등록";
		String id = (String)session.getAttribute("id");
		
		if(id == null || id.equals(""))
		{
			msg = "로그인 하십시오.";
			request.setAttribute("msg2", msg);
			id = "1";
			((HttpServletResponse)response).sendRedirect("/project01/catchme.com?id="+id);
			
		}
		if(request.getParameter("no") != null)
		{
			msg = "답글 등록";
			no = Integer.parseInt(request.getParameter("no"));
		}
		request.setAttribute("msg2", msg);
		request.setAttribute("no", no);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
