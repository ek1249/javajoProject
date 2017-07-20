package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.EventVo;

public class EventDetailAction implements JavajoAction {

	
	JavajoDao dao = null;
	EventVo e = null;
	public EventDetailAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
		e = new EventVo(); 
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int no = Integer.parseInt(request.getParameter("no"));
		e = dao.detailEvent(no);
		request.setAttribute("e", e);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		int n = 0;
		if(id != null && id.equals("master"))
		{
			n = 1;
			request.setAttribute("n", n);
		}
		return "eventDetail.jsp";
	}

}
