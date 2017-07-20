package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;

public class PostboarddeletetAction implements JavajoAction {

	JavajoDao dao;
	
	public PostboarddeletetAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = 0;
		if(request.getParameter("no") != null && !request.getParameter("no").equals(""))
		{
			no = Integer.parseInt(request.getParameter("no"));
		}
		request.setAttribute("no", no);
		HttpSession session = request.getSession();
		int re = 0;
		String view = "postboarddelete.jsp";
		if(session.getAttribute("id").equals("master"))
		{
			re = dao.postboarddelete(no);
		}
		
		if(re == 1)
		{
			view = "postboardlist.com";
		}
		return view;
	}

}
