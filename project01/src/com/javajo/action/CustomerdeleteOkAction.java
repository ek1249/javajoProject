package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.CustomerVo;

public class CustomerdeleteOkAction implements JavajoAction {

	JavajoDao dao;
	
	public CustomerdeleteOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String id = "";
		String pwd = "";
		if(request.getParameter("id")!=null && !request.getParameter("id").equals(""))
		{
			id = request.getParameter("id");
		}
		if(request.getParameter("pwd")!=null && !request.getParameter("pwd").equals(""))
		{
			pwd = request.getParameter("pwd");
		}
		
		int re = dao.customerdelete(id, pwd);
		String view = "";
		String msg = "";
		if(re==1 && session.getAttribute("id").equals("master"))
		{
			view = "main.com";
			dao.cnt=1;
		}
		else if(re==1)
		{
			view = "catchme.com";
		}
		else
		{
			msg = "실패";
			request.setAttribute("msg", msg);
			view = "error.jsp";
		}
		return view;
	}

}
