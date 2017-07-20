package com.javajo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class EventDeleteAction implements JavajoAction {

	JavajoDao dao = null;
	public EventDeleteAction() {
		// TODO Auto-generated constructor stub
	dao = new JavajoDao();
	
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int no = Integer.parseInt(request.getParameter("no"));
		String file = dao.detailEvent(no).getFname();
		int re = dao.deleteEvent(no);
		String path = request.getRealPath("/event"+"/"+file);
		
		if(re == 1)
		{
			File f = new File(path);
			f.delete();
		return "event.com";
		}
		else
		{
			request.setAttribute("msg", "삭제 실패");
			return "error.jsp";
		}
	}

}
