package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.HistoryDao;
import com.javajo.vo.HistoryVo;

public class TicketHistoryAction implements JavajoAction {

	HistoryDao dao = null;
	HistoryVo h = null;
	public TicketHistoryAction() {
		// TODO Auto-generated constructor stub
		dao = new HistoryDao();
		h = new HistoryVo();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<HistoryVo> list = dao.listHistory("javajo");
		System.out.println("listsize = "+list.size());
		request.setAttribute("list", list);
		
		return "ticketHistory.jsp";
	}

}
