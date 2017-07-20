package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class PwdserchOkAction implements JavajoAction {

	JavajoDao dao;
	
	public PwdserchOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("teltop")+"-"+request.getParameter("telmiddle")+"-"+request.getParameter("telbottom");
		String pwd = dao.pwdserch(id, name, tel);
		String view = "";
		String msg = "";
		if(dao.pwdserchre==1)
		{
			request.setAttribute("pwd", pwd);
			request.setAttribute("name", name);	
			view = "pwdserchok.jsp";
			dao.pwdserchre = 0;
		}
		else
		{
			msg = "회원가입을 하세요.";
			request.setAttribute("msg", msg);
			view = "error.jsp";
		}
		return view;
	}

}
