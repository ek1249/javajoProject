package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.MovietheaterVo;

public class MovietheaterupdateAction implements JavajoAction {

	JavajoDao dao;
	
	public MovietheaterupdateAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		MovietheaterVo mt = dao.movietheaterdetail(no);
		request.setAttribute("mt", mt);
		return "movietheaterupdate.jsp";
	}

}
