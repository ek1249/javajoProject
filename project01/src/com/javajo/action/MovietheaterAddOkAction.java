package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class MovietheaterAddOkAction implements JavajoAction {

	JavajoDao dao;
	
	public MovietheaterAddOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = "";
		String loc = "";
		String event = "";
		if(request.getParameter("name") != null && !request.getParameter("name").equals(""))
		{
			name = request.getParameter("name");
		}
		if(request.getParameter("loc") != null && !request.getParameter("loc").equals(""))
		{
			loc = request.getParameter("loc");
		}
		if(request.getParameter("event") != null && !request.getParameter("event").equals(""))
		{
			event = request.getParameter("event");
		}
		int re = dao.movietheateradd(name, loc, event);
		String view = "";
		String msg = "";
		if(re == 1)
		{
			view = "main.com";
		}
		else 
		{
			msg = "실패";
			view = "error.jsp";
		}
		request.setAttribute("msg", msg);
		return view;
	}

}
