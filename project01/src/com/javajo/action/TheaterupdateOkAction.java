package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class TheaterupdateOkAction implements JavajoAction {

	JavajoDao dao;
	public TheaterupdateOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tno2 = 0;
		int seat2 = 0;
		int mtno2 = 0;
		if(request.getParameter("tno2")!=null && !request.getParameter("tno2").equals(""))
		{
			tno2 = Integer.parseInt(request.getParameter("tno2"));
		}
		if(request.getParameter("seat2")!=null && !request.getParameter("seat2").equals(""))
		{
			seat2 = Integer.parseInt(request.getParameter("seat2"));
		}
		if(request.getParameter("mtno2")!=null && !request.getParameter("mtno2").equals(""))
		{
			mtno2 = Integer.parseInt(request.getParameter("mtno2"));
		}
		int re = dao.theaterupdate(tno2, seat2, mtno2);
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
