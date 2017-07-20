package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostboardInsertAction implements JavajoAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = 0;
		HttpSession session = request.getSession(true);
		String msg = "게시글 등록";
		String id = (String)session.getAttribute("id");
		String view = "/javajo/postboardinsert.jsp";
		if(id.equals("") || id == null)
		{
			msg = "로그인 하십시오.";
			view = "catchme.com";
		}
		if(request.getParameter("no") != null)
		{
			msg = "답글 등록";
			no = Integer.parseInt(request.getParameter("no"));
		}
		request.setAttribute("msg2", msg);
		request.setAttribute("no", no);
		return view;
	}

}
