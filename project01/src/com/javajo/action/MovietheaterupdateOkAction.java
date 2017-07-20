package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class MovietheaterupdateOkAction implements JavajoAction {

	JavajoDao dao;
	public MovietheaterupdateOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String loc = request.getParameter("loc");
		String event = request.getParameter("event");
		int re = dao.movietheaterupdate(no, name, loc, event);
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
