package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.HistoryDao;
import com.javajo.dao.JavajoDao;
import com.javajo.dao.TicketDao;
import com.javajo.vo.CustomerVo;
import com.javajo.vo.HistoryVo;

public class MypageAction implements JavajoAction {

	JavajoDao dao;
	TicketDao dao2 = null;
	HistoryDao dao3;
	HistoryVo h;
	public MypageAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
		dao2 = new TicketDao();
		h = new HistoryVo();
		dao3 = new HistoryDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int cnt = 0;
		if(request.getParameter("cnt")!=null && !request.getParameter("cnt").equals(""))
		{
			cnt = Integer.parseInt(request.getParameter("cnt"));
		}
		request.setAttribute("cnt", cnt);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		CustomerVo c = dao.customerdetail(id);
		request.setAttribute("c", c);
		ArrayList list = dao2.checkTicket("javajo");
		if(cnt == 3)
		{
			ArrayList<HistoryVo> hlist = dao3.listHistory("javajo");
			System.out.println("listsize = "+list.size());
			request.setAttribute("hlist", hlist);
		}
		
		request.setAttribute("list", list);
		return "mypage.jsp";
	}

}
