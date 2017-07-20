package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.ScoreMovieVo;

public class NonMainAction implements JavajoAction {

	JavajoDao dao;
	int n = 0;
	public NonMainAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ArrayList<String> imglist = dao.movieImg();
		ArrayList<ScoreMovieVo> list = dao.scoreMovie();
		request.setAttribute("scorelist", list);		
		if(request.getParameter("id") != null && request.getParameter("id").equals("1"))
		{
			request.setAttribute("msg2", "로그인하세요.");
		}
		String btn = request.getParameter("btn");
		String img = request.getParameter("img");
		String path = request.getRealPath("/img")+"/";
		if(btn == null && img == null)
		{
			request.setAttribute("path", path);
			request.setAttribute("img", imglist.get(n));
		}
		
		else if(img != null && !img.equals(""))
		{
			request.setAttribute("path", path);
			request.setAttribute("img", img);
		}
		else if(btn.equals("1"))
		{
			n--;
			if(n == -1)
			{
				n = imglist.size()-1;
			}
			request.setAttribute("path", path);
			request.setAttribute("img", imglist.get(n));
		}
		else if(btn.equals("2"))
		{
			n++;
			if(n == imglist.size())
			{
				n = 0;
			}
			request.setAttribute("path", path);
			request.setAttribute("img", imglist.get(n));
		}
		ArrayList<MovietheaterVo> mtlist = dao.movietheaterlist();
		HttpSession session = request.getSession();
		session.setAttribute("mtlist", mtlist);
		session.setAttribute("id", null);
		session.setAttribute("cnt", 0);
		return "noLoginMain.jsp";
	}

}
