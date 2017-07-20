package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class RunningaddOkAction implements JavajoAction {

	JavajoDao dao;
	public RunningaddOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int tno2 = 0;
		int mno2 = 0;
		String rd = "";
		String rs = "";
		if(request.getParameter("tno2")!=null && !request.getParameter("tno2").equals(""))
		{
			tno2 = Integer.parseInt(request.getParameter("tno2"));
		}
		if(request.getParameter("mno2")!=null && !request.getParameter("mno2").equals(""))
		{
			mno2 = Integer.parseInt(request.getParameter("mno2"));
		}
		if(request.getParameter("tno2")!=null && !request.getParameter("tno2").equals(""))
		{
			rd = request.getParameter("rd");
		}
		if(request.getParameter("rs")!=null && !request.getParameter("rs").equals(""))
		{
			rs =request.getParameter("rs");
		}
		int re = dao.runningadd(tno2, mno2, rd, rs);
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
