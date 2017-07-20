package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.EventVo;

public class EventAction implements JavajoAction {

	JavajoDao dao;
	public EventAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<EventVo> list = new ArrayList<EventVo>();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		int n = 0;
		if(id != null && id.equals("master"))
		{
			n = 1;
		}
		list = dao.listEvent();
		request.setAttribute("n", n);
		request.setAttribute("list", list);
		
		return "event.jsp";
	}

}
