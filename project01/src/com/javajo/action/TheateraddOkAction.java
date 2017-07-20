package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class TheateraddOkAction implements JavajoAction {

	JavajoDao dao;
	
	public TheateraddOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int seat = 0;
		int mtno = 0;
		if(request.getParameter("seat") != null && !request.getParameter("seat").equals(""))
		{
			seat = Integer.parseInt(request.getParameter("seat"));
		}
		if(request.getParameter("mtno") != null && !request.getParameter("mtno").equals(""))
		{
			mtno = Integer.parseInt(request.getParameter("mtno"));
		}
		
		int re = dao.theateradd(seat, mtno);
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
		return view;
	}

}
