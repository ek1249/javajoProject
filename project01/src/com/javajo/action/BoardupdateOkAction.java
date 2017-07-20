package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.BoardVo;
import com.oreilly.servlet.MultipartRequest;

public class BoardupdateOkAction implements JavajoAction {

	JavajoDao dao;
	public BoardupdateOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("/img/");
		MultipartRequest multi = new MultipartRequest(request, path, "utf-8");
		BoardVo b = new BoardVo();
		b.setBoard_number(Integer.parseInt(multi.getParameter("no")));
		b.setBoard_title(multi.getParameter("title"));
		b.setBoard_content(multi.getParameter("content"));
		String oldfname = request.getParameter("oldfname");
		String newfname = multi.getOriginalFileName("fname");
		if(newfname == null)
		{
			b.setBoard_fname(oldfname);
		}
		else
		{
			b.setBoard_fname(newfname);
		}
		int re = dao.boardupdate(b);
		String view = "";
		String msg = "";
		if(re == 1)
		{
			view = "boardlist.com";
		}
		else
		{
			msg = "실패";
			view = "error.jsp";
		}
		request.setAttribute("msg", msg);
		return view;
	}

}
