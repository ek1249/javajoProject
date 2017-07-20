package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.EventVo;

public class EventUpdateAction implements JavajoAction {

	JavajoDao dao = null;
	public EventUpdateAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int no = Integer.parseInt(request.getParameter("no"));
		EventVo e = dao.detailEvent(no);
		System.out.println(e.getFname());
		request.setAttribute("e", e);
		
		return "eventUpdate.jsp";
	}

}
