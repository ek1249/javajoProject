package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;

public class MovietheaterdeleteAction implements JavajoAction {

	JavajoDao dao;
	public MovietheaterdeleteAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		int re = dao.movietheaterdelete(no);
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
