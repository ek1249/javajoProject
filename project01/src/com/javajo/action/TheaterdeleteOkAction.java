package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class TheaterdeleteOkAction implements JavajoAction {

	JavajoDao dao;
	public TheaterdeleteOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int tno = 0;
		if(request.getParameter("tno2")!=null && !request.getParameter("tno2").equals(""))
		{
			tno = Integer.parseInt(request.getParameter("tno2"));
		}
		int re = dao.theaterdelete(tno);
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
