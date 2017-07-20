package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.BoardVo;
import com.javajo.vo.CustomerVo;
import com.javajo.vo.MovieVo;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.PostboardVo;
import com.javajo.vo.RunningVo;
import com.javajo.vo.TheaterVo;

public class MasterpageAction implements JavajoAction {

	JavajoDao dao;
	public MasterpageAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int cnt = 1;
		String id = "";
		if(request.getParameter("id")!=null && !request.getParameter("id").equals(""))
		{
			id = request.getParameter("id");
			dao.cnt = 8;
		}
		cnt = dao.cnt;
		if(request.getParameter("cnt")!=null && !request.getParameter("cnt").equals(""))
		{
			cnt = Integer.parseInt(request.getParameter("cnt"));
		}
		int pagenum = 1;
		if(request.getParameter("pagenum")!=null && !request.getParameter("pagenum").equals(""))
		{
			pagenum = Integer.parseInt(request.getParameter("pagenum"));
		}
		if(cnt == 1)
		{
			dao.cnt = cnt;
			ArrayList<CustomerVo> clist = dao.customerlist(pagenum);
			request.setAttribute("clist", clist);
			String pagenum2 = dao.masterpagenum();
			request.setAttribute("pagenum", pagenum2);
		}
		else if(cnt == 2)
		{
			dao.cnt = cnt;
			ArrayList<MovieVo> mlist = dao.movielistpage(pagenum);
			request.setAttribute("mlist", mlist);
			String pagenum2 = dao.masterpagenum();
			request.setAttribute("pagenum", pagenum2);
		}
		else if(cnt == 3)
		{
			dao.cnt = cnt;
			ArrayList<MovietheaterVo> mtlist = dao.mastermovietheaterlist(pagenum);
			request.setAttribute("mtlist", mtlist);
			String pagenum2 = dao.masterpagenum();
			request.setAttribute("pagenum", pagenum2);
		}
		else if(cnt == 4)
		{
			dao.cnt = cnt;
			ArrayList<TheaterVo> tlist = dao.mastertheaterlist(pagenum);
			request.setAttribute("tlist", tlist);
			String pagenum2 = dao.masterpagenum();
			request.setAttribute("pagenum", pagenum2);
		}
		else if(cnt == 5)
		{
			dao.cnt = cnt;
			ArrayList<RunningVo> rlist = dao.masterrunninglist(pagenum);
			request.setAttribute("rlist", rlist);
			String pagenum2 = dao.masterpagenum();
			request.setAttribute("pagenum", pagenum2);
		}
		else if(cnt == 6)
		{
			dao.cnt = cnt;
			ArrayList<PostboardVo> plist = dao.postlist(pagenum);
			request.setAttribute("plist", plist);
			String pagenum2 = dao.masterpagenum();
			request.setAttribute("pagenum", pagenum2);
		}
		else if(cnt == 7)
		{
			dao.cnt = cnt;
			ArrayList<BoardVo> blist = dao.boardlist(pagenum);
			request.setAttribute("blist", blist);
			String pagenum2 = dao.masterpagenum();
			request.setAttribute("pagenum", pagenum2);	
		}
		else if(cnt==8)
		{
			CustomerVo c = dao.customerdetail(id);
			request.setAttribute("c", c);
		}
		request.setAttribute("cnt", cnt);
		return "masterpage.jsp";
	}

}
