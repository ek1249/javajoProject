package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.PostboardVo;

public class PostboardupdateAction implements JavajoAction {

	JavajoDao dao;
	public PostboardupdateAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int no = 0;
		if(request.getParameter("no") != null)
		{
			no = Integer.parseInt(request.getParameter("no"));
		}
		String path = request.getRealPath("/img")+"/";
		PostboardVo p = dao.postboarddetail(no,false);
		request.setAttribute("p", p);		
		request.setAttribute("path", path);		
		return "postboardupdate.jsp";
	}

}
