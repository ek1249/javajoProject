package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.RunningVo;
import com.javajo.vo.TheaterVo;

public class RunningdeleteAction implements JavajoAction {

	JavajoDao dao;
	public RunningdeleteAction() {
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
		tno = dao.theater_num;
		if(request.getParameter("tno")!=null && !request.getParameter("tno").equals(""))
		{
			tno = Integer.parseInt(request.getParameter("tno"));
		}
		ArrayList<RunningVo> rlist = dao.runninglist(tno);
		request.setAttribute("rlist", rlist);
		int rno = 0;
		if(request.getParameter("rno")!=null && !request.getParameter("rno").equals(""))
		{
			rno = Integer.parseInt(request.getParameter("rno"));
		}
		RunningVo r = dao.runningdetail(rno);
		request.setAttribute("r", r);
		return "runningdelete.jsp";
	}

}
