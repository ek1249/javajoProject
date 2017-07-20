package com.javajo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.javajo.dao.JavajoDao;
import com.javajo.vo.EventVo;
import com.oreilly.servlet.MultipartRequest;

public class EventInsertOkAction implements JavajoAction {

	JavajoDao dao = null;
	EventVo v = null;
	public EventInsertOkAction() {
		// TODO Auto-generated constructor stub
	dao = new JavajoDao();
	v = new EventVo();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String path = request.getRealPath("/event");
		System.out.println("path : "+path);
		MultipartRequest multi = new MultipartRequest(request, path,"UTF-8");
		String title = multi.getParameter("title");
		String fname = multi.getOriginalFileName("fname");
		String content = multi.getParameter("content");
		System.out.println(title+"///"+fname);
		v.setTitle(title);
		v.setFname(fname);
		v.setContent(content);
		String view = "";
		String msg = "";
		int re = dao.insertEvent(v);
		if(re == 1)
		{
			view = "event.com";
		}
		else
		{
			msg = "실패";
			request.setAttribute("msg", msg);
			view = "error.jsp";
		}
		
		return view;	
	}

}
