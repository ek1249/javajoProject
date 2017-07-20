package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.RunningVo;
import com.javajo.vo.RunningtableVo;
import com.javajo.vo.TheaterVo;

public class MovietheaterAction implements JavajoAction {

	JavajoDao dao;
	
	public MovietheaterAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = 0;
		no = dao.movietheater_num;
		if(request.getParameter("no") != null && !request.getParameter("no").equals(""))
		{
			no = Integer.parseInt(request.getParameter("no"));
		}
		HttpSession session = request.getSession();
		MovietheaterVo mt = dao.movietheaterdetail(no);
		session.setAttribute("mtd", mt);
		ArrayList<TheaterVo> list = dao.theaterlist(no);
		request.setAttribute("th", list);
		int tno = 0;
		tno = dao.theater_num;
		if(request.getParameter("tno") != null && !request.getParameter("tno").equals(""))
		{
			tno = Integer.parseInt(request.getParameter("tno"));
		}
		ArrayList<RunningVo> rdlist = dao.runningdatelist(tno);
		session.setAttribute("rd", rdlist);
		String date = "";
		if(request.getParameter("date") != null && !request.getParameter("date").equals(""))
		{
			date = request.getParameter("date");
		}
		ArrayList<RunningtableVo> rtlist = dao.runningtable(date);
		request.setAttribute("rt", rtlist);
		int id = 0;
		if(session.getAttribute("id") != null && session.getAttribute("id").equals("master"))
		{
			id = 1;
			request.setAttribute("id2", id);
		}
		return "movietheater.jsp";
	}

}
