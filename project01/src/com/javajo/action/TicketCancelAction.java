package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.TicketDao;

public class TicketCancelAction implements JavajoAction {

	TicketDao dao = null;
	public TicketCancelAction() {
		// TODO Auto-generated constructor stub
		
		dao = new TicketDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int re = 0;
		int re1 = 0;
		
		String view ="";
		if( request.getParameter("ticket_number") != null && !request.getParameter("ticket_number").equals(""))
		{
			re = dao.deleteTicket(Integer.parseInt(request.getParameter("ticket_number")));
			view ="main.com";
		}
		else
		{
			view = "error.jsp";
		}
	
			return view;
	
	}
}
