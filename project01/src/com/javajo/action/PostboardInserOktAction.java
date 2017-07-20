package com.javajo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.PostboardVo;
import com.oreilly.servlet.MultipartRequest;

public class PostboardInserOktAction implements JavajoAction {

	JavajoDao dao;
	
	public PostboardInserOktAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("/img");
		MultipartRequest multi = new MultipartRequest(request, path, "utf-8");
		PostboardVo p = new PostboardVo();
		p.setPostboard_number(Integer.parseInt(multi.getParameter("no")));
		p.setCustomer_id(multi.getParameter("id"));
		p.setPostboard_title(multi.getParameter("title"));
		p.setPostboard_pwd(multi.getParameter("pwd"));
		p.setPostboard_type(multi.getParameter("type"));
		p.setPostboard_content(multi.getParameter("content"));
		p.setPostboard_ip(request.getRemoteAddr());
		p.setPostboard_fname(multi.getOriginalFileName("fname"));
		int re = dao.postboardinsert(p);
		String view ="";
		String msg = "";
		if(re == 1)
		{
			view = "postboardlist.com";
		}
		else
		{
			msg = "등록에 실패하였습니다.";
			view = "javajo/postboardinsert.jsp?id="+multi.getParameter("id");
		}
		request.setAttribute("msg", msg);
		return view;
	}

}
