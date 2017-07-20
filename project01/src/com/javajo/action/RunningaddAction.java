package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.MovieVo;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.TheaterVo;

public class RunningaddAction implements JavajoAction {

	JavajoDao dao;
	public RunningaddAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pagenum = 1;
		if(request.getParameter("pagenum")!=null && !request.getParameter("pagenum").equals(""))
		{
			pagenum = Integer.parseInt(request.getParameter("pagenum"));
		}
		ArrayList<MovieVo> mlist = dao.movielistpage(pagenum);
		String pagenum2 = dao.moviepagenum();
		request.setAttribute("mlist", mlist);
		request.setAttribute("pagenum", pagenum2);
		ArrayList<MovietheaterVo> mtlist = dao.movietheaterlist();
		request.setAttribute("mtlist", mtlist);
		int mtno = 0;
		if(request.getParameter("mtno")!=null && !request.getParameter("mtno").equals(""))
		{
			mtno = Integer.parseInt(request.getParameter("mtno"));
		}
		ArrayList<TheaterVo> tlist = dao.theaterlist(mtno);
		request.setAttribute("tlist", tlist);
		
		return "runningadd.jsp";
	}

}
