package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.PostboardVo;

public class PostboarddeletetOkAction implements JavajoAction {

	JavajoDao dao;
	public PostboarddeletetOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = 0;
		String pwd = "";
		if(request.getParameter("no") != null && !request.getParameter("no").equals(""))
		{
			no = Integer.parseInt(request.getParameter("no"));
		}
		if(request.getParameter("pwd") != null && !request.getParameter("pwd").equals(""))
		{
			pwd = request.getParameter("pwd");
		}
		String view = "";
		String msg = "";
		PostboardVo p = dao.postboarddetail(no,false);
		if(pwd.equals(p.getPostboard_pwd()))
		{
			int re = dao.postboarddelete(no);
			if(re == 1)
			{
				view  = "postboardlist.com";
			}
			else
			{
				msg = "실패";
				view = "error.jsp";
			}
		}
		return view;
	}

}
