package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class BoarddeleteAction implements JavajoAction {

	JavajoDao dao;
	public BoarddeleteAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = 0;
		if(request.getParameter("no") != null)
		{
			no = Integer.parseInt(request.getParameter("no"));
		}
		int re = dao.boarddelete(no);
		String view = "";
		String msg = "";
		if(re == 1)
		{
			view = "boardlist.com";
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
