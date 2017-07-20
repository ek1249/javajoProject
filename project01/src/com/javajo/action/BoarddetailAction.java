package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.BoardVo;

public class BoarddetailAction implements JavajoAction {

	JavajoDao dao;
	
	public BoarddetailAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = 0;
		String id = "";
		if(request.getParameter("no") != null && !request.getParameter("no").equals(""))
		{
			no = Integer.parseInt(request.getParameter("no"));
		}
		HttpSession session = request.getSession(true);
		id = (String)session.getAttribute("id");
		String path = request.getRealPath("/img")+"/";
		BoardVo b = dao.boarddetail(no);
		int n = 0;
		int n2= 0;
		if(b.getBoard_fname() != null)
		{
			n = 1;
			request.setAttribute("n", n);
		}
		if(id!=null && id.equals("master"))
		{
			n2 = 1;
			request.setAttribute("n2", n2);
		}
		request.setAttribute("path", path);
		request.setAttribute("b", b);
		return "boarddetail.jsp";
	}

}
