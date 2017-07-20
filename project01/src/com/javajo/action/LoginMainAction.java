package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.ScoreMovieVo;

public class LoginMainAction implements JavajoAction {

	JavajoDao dao;
	int n = 0;
	public LoginMainAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ArrayList<String> imglist = dao.movieImg();
		String view = "";
		String msg = "";
		String id = "";
		String pwd = "";
		if(request.getParameter("id") != null && request.getParameter("pwd") != null)
		{
			id = request.getParameter("id");
			pwd = request.getParameter("pwd");
		}
		int re = dao.loginOk(id, pwd);
		HttpSession session = request.getSession(true);
		String path = request.getRealPath("/img")+"/";
		if(id.equals("master"))
		{
			session.setAttribute("id", id);
			view = "loginMain2.jsp";
		}
		else if(re == 2)
		{
			
			session.setAttribute("id", id);
			view = "loginMain2.jsp";
		}
		else if(re == 1)
		{
			msg = "ID를 확인하십시오.";
			view = "catchme.com";
		}
		else if(re == 0)
		{
			msg = "비밀번호를 확인하십시오.";
			view = "catchme.com";
		}
		else if(re == -1)
		{
			msg = "회원가입을 하십시오.";
			view = "catchme.com";
		}
		int cnt = 0;
		if(id.equals("master"))
		{
			cnt = 1;
		}
		else
		{
			cnt = 2;
		}
		session.setAttribute("cnt", cnt);
		String btn = request.getParameter("btn");
		if(btn == null)
		{
			request.setAttribute("path", path);
			request.setAttribute("img", imglist.get(n));
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
		
		
		ArrayList<ScoreMovieVo> list = dao.scoreMovie();
		request.setAttribute("scorelist", list);
		request.setAttribute("msg", msg);
		return view;
	}

}
