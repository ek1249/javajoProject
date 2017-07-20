package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.CustomerVo;

public class CustomerupdateOkAction implements JavajoAction {

	JavajoDao dao;
	public CustomerupdateOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String repw = request.getParameter("repw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String teltop = request.getParameter("teltop");
		String telmiddle = request.getParameter("telmiddle");
		String telbottom = request.getParameter("telbottom");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String tel = teltop+"-"+telmiddle+"-"+telbottom;
		
		CustomerVo c = new CustomerVo();
		String msg = "";
		if(pw.equals(repw) && pw.length()>=8)
		{
			c.setCustomer_id(id);
			c.setCustomer_pwd(pw);
			c.setCustomer_name(name);
			c.setCustomer_addr(addr);
			c.setCustomer_tel(tel);
			c.setCustomer_email(email);
			c.setCustomer_gender(gender);
		}
		else if(!pw.equals(repw))
		{
			msg = "비밀번호를 확인하십시오.";
			request.setAttribute("msg", msg);
		}
		int re = dao.customerupdate(c);
		String view = "";
		String msg2 = "";
		if(re == 1)
		{
			view = "main.com";
			dao.cnt = 1;
		}
		else
		{
			msg2 = "실패";
			request.setAttribute("msg", msg2);
			view = "error.jsp";
		}
		return view;
	}

}
