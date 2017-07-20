package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.CommentboardVo;
import com.javajo.vo.PostboardVo;

public class PostboarddetailtAction implements JavajoAction {

	JavajoDao dao;
	public PostboarddetailtAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("/img/");
		int no = 0;
		no = dao.pno;
		if(request.getParameter("no")!=null && !request.getParameter("no").equals(""))
		{
			no = Integer.parseInt(request.getParameter("no"));
		}
		PostboardVo p = dao.postboarddetail(no,true);
		String id = dao.postboardid(no);
		String fname = p.getPostboard_fname();
		int n = 0;
		int n2 = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("id")!=null && session.getAttribute("id").equals("master"))
		{
			n = 2;
			request.setAttribute("n", n);
			if(fname != null)
			{
				n2 = 1;
				request.setAttribute("n2", n2);
			}
		}
		else if(id.equals((String)session.getAttribute("id")))
		{
			n = 1;
			request.setAttribute("n", n);
			if(fname != null)
			{
				n2 = 1;
				request.setAttribute("n2", n2);
			}
		}
		int pagenum = 1;
		if(request.getParameter("pagenum")!=null && !request.getParameter("pagenum").equals(""))
		{
			pagenum = Integer.parseInt(request.getParameter("pagenum"));
		}
		request.setAttribute("pagenum", dao.commpagenum());
		String content = "";
		if(request.getParameter("content")!=null && !request.getParameter("content").equals(""))
		{
			content = request.getParameter("content");
			CommentboardVo c = new CommentboardVo();
			int cno = 0;
			if(request.getParameter("cno")!=null && request.getParameter("cno").equals(""))
			{
				cno = Integer.parseInt(request.getParameter("cno"));
			}
			c.setCommentboard_number(cno);
			c.setCommentboard_content(content);
			c.setPostboard_number(no);
			int re = dao.comminsert(c);
			System.out.println(re);
		}
		System.out.println(content);
		ArrayList<CommentboardVo> clist = dao.commlist(pagenum,no);
		request.setAttribute("clist", clist);
		request.setAttribute("no", no);
		request.setAttribute("path", path);
		request.setAttribute("p", p);
		return "postboarddetail.jsp";
	}

}
