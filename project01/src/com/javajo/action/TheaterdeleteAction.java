package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.TheaterVo;

public class TheaterdeleteAction implements JavajoAction {

	JavajoDao dao;
	public TheaterdeleteAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ArrayList<MovietheaterVo> mtlist = dao.movietheaterlist();
		request.setAttribute("mtlist", mtlist);
		int mtno = 0;
		mtno = dao.movietheater_num;
		if(request.getParameter("mtno")!=null && !request.getParameter("mtno").equals(""))
		{
			mtno = Integer.parseInt(request.getParameter("mtno"));
		}
		ArrayList<TheaterVo> tlist = dao.theaterlist(mtno);
		request.setAttribute("tlist", tlist);
		int tno = 0;
		if(request.getParameter("tno")!=null && !request.getParameter("tno").equals(""))
		{
			tno = Integer.parseInt(request.getParameter("tno"));
		}
		TheaterVo t = dao.theaterdetail(tno);
		request.setAttribute("t", t);
		
			
		return "theaterdelete.jsp";
	}

}
