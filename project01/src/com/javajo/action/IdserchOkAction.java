package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class IdserchOkAction implements JavajoAction {

	JavajoDao dao;
	
	public IdserchOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String tel = request.getParameter("teltop")+"-"+request.getParameter("telmiddle")+"-"+request.getParameter("telbottom");
		String id = dao.idserch(name, tel);
		String view = "";
		String msg = "";
		if(dao.idserchre==1)
		{
			request.setAttribute("name", name);
			request.setAttribute("id", id);		
			view = "idserchok.jsp";
			dao.idserchre = 0;
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
