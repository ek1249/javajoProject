package com.javajo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.PostboardVo;
import com.oreilly.servlet.MultipartRequest;

public class PostboardupdateOkAction implements JavajoAction {

	JavajoDao dao;
	public PostboardupdateOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("/img/");
		MultipartRequest multi = new MultipartRequest(request, path, "utf-8");
		PostboardVo p = new PostboardVo();
		int no =Integer.parseInt(multi.getParameter("no"));
		String pwd = dao.postboardpwd(no);
		String id = dao.postboardid(no);
		File file;
		String newfname="";
		String oldfname="";
		if(pwd.equals(multi.getParameter("pwd")))
		{
			p.setPostboard_number(Integer.parseInt(multi.getParameter("no")));
			p.setCustomer_id(multi.getParameter("id"));
			p.setPostboard_title(multi.getParameter("title"));
			p.setPostboard_pwd(multi.getParameter("pwd"));
			p.setPostboard_content(multi.getParameter("content"));
			p.setPostboard_type(multi.getParameter("type"));
			newfname = multi.getOriginalFileName("newfname");
			oldfname = request.getParameter("oldfname");
			System.out.println("new:"+newfname);			
			System.out.println("old:"+oldfname);
			if(newfname == null)
			{
				p.setPostboard_fname(oldfname);
			}
			else
			{
				p.setPostboard_fname(newfname);
			}
			
			
		}
		int re = dao.postboardupdate(p);
		String view = "";
		String msg = "";
		if(re == 1 && newfname != null)
		{
			file = new File(path+oldfname);
			file.delete();
			view = "postboardlist.com";
		}
		else if(re == 1 && newfname == null)
		{
			view = "postboardlist.com";
		}
		else
		{
			msg = "실패";
			view = "error.jsp";
		}
		request.setAttribute("msg", msg);
		return view;
	}

}
