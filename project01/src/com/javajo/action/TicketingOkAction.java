package com.javajo.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.HistoryDao;
import com.javajo.dao.SeatDao;
import com.javajo.dao.TicketDao;

public class TicketingOkAction implements JavajoAction {

	SeatDao dao = null;
	TicketDao tdao = null;
	HistoryDao hdao = null;
	public TicketingOkAction() {
		// TODO Auto-generated constructor stub
		dao = new SeatDao();
		tdao = new TicketDao();
		hdao = new HistoryDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int movie_number = 0;
		int movietheater_number = 0;
		int running_number = 0;
		int theater_number = 0;
		
		String arr[] = request.getParameterValues("seat");
		
		if(request.getParameter("movie_number")!=null && request.getParameter("movietheater_number")!=null){
		
			movie_number = Integer.parseInt(request.getParameter("movie_number"));
			movietheater_number = Integer.parseInt(request.getParameter("movietheater_number"));
			running_number = Integer.parseInt(request.getParameter("running_number"));
			theater_number = Integer.parseInt(request.getParameter("theater_number"));
			
			System.out.println("movie_number :"+ movie_number+"movietheater_number :"+ movietheater_number+"running_number :"+ running_number+"theater_number :"+ theater_number);
			
		}
		HttpSession session = request.getSession(true);
		String id = "";
		if(session.getAttribute("id")!=null && !session.getAttribute("id").equals(""))
		{
			id = (String)session.getAttribute("id");
		}
		int er = tdao.makeTicket(arr.length, movie_number, movietheater_number, theater_number, id, running_number);	
		int re1 = hdao.makeHistory("javajo", movie_number, movietheater_number, theater_number, running_number);
		
		int re = dao.updateSeat(arr, er, theater_number);
	
		if(re != 0 && er != 0 && re1 != 0)
		{
			
				return "ticketingOk.jsp";
			
		}
		else
		{
			request.setAttribute("msg", "결제가 실패했습니다.");
			return "error.jsp";
		}
	}

}
