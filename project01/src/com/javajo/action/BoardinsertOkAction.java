package com.javajo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.BoardVo;
import com.oreilly.servlet.MultipartRequest;

public class BoardinsertOkAction implements JavajoAction {

	JavajoDao dao;
	public BoardinsertOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String path = request.getRealPath("/img");
		MultipartRequest multi = new MultipartRequest(request, path, "utf-8");
		BoardVo b = new BoardVo();
		b.setBoard_title(multi.getParameter("title"));
		b.setBoard_content(multi.getParameter("content"));
		b.setBoard_fname("");
		File file = multi.getFile("fname");
		if(file != null && !file.getName().equals("") && file.getName() != null)
		{
			b.setBoard_fname(file.getName());
		}
		String view = "";
		String msg = "";
		int re = dao.boardinsert(b);
		if(re == 1)
		{
			view = "boardlist.com?id="+id;
		}
		else 
		{
			msg = "실패하였습니다.";
			view = "error.jsp";
		}
		request.setAttribute("msg", msg);
		return view;
	}

}
