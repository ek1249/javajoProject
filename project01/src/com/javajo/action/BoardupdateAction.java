package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.BoardVo;

public class BoardupdateAction implements JavajoAction {

	JavajoDao dao;
	public BoardupdateAction() {
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
		BoardVo b = dao.boarddetail(no);
		request.setAttribute("b", b);
		
		return "boardupdate.jsp";
	}

}
