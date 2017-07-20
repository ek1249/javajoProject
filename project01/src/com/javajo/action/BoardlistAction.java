package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.BoardVo;

public class BoardlistAction implements JavajoAction {

	JavajoDao dao;
	public BoardlistAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int pagenum = 1;
		if(request.getParameter("pagenum") != null && !request.getParameter("pagenum").equals(""))
		{
			pagenum = Integer.parseInt(request.getParameter("pagenum"));
		}
		ArrayList<BoardVo> list = dao.boardlist(pagenum);
		HttpSession session = request.getSession(true);
		int n = 0;
		
		String id = "";
		if(session.getAttribute("id") != null && !session.getAttribute("id").equals(""))
		{
			id = (String)session.getAttribute("id");
		}
		if(id.equals("master"))
		{
			n = 1;
			request.setAttribute("n", n);
		}
		request.setAttribute("pagenum", dao.pagenum2());
		request.setAttribute("list", list);
		return "boardlist.jsp";
	}

}
