package com.javajo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.oreilly.servlet.MultipartRequest;

public class EventUpdateOkAction implements JavajoAction {

	JavajoDao dao = null;
	
	public EventUpdateOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getRealPath("/event");
		MultipartRequest multi = new MultipartRequest(request, path,"UTF-8");
		int no = Integer.parseInt(multi.getParameter("no"));
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String new_fname = multi.getOriginalFileName("fname");
		
		if(new_fname==null)
		{
			new_fname = dao.detailEvent(no).getFname();
		}
		else
		{
			File f = new File(path+"/"+dao.detailEvent(no).getFname());
			f.delete();
		}
		
		int re = dao.updateEvent(title, content, new_fname, no);
		if(re == 1)
		{
			return "event.com";
		}
		else
		{
			request.setAttribute("msg", "수정 실패");
			return "error.jsp";
		}
		
	}

}
