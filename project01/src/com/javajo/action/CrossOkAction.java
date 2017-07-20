package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class CrossOkAction implements JavajoAction {

	JavajoDao dao;
	public CrossOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		boolean ok = dao.crossok(id);
		String msg = "";
		if(ok)
		{
			msg = "사용가능한 ID 입니다.";
		}
		else
		{
			msg = "이미 존재하는 ID 입니다.";
		}
		request.setAttribute("id", id);
		request.setAttribute("msg", msg);
		return "signup.com";
	}

}
