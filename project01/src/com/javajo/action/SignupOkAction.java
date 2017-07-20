package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.CustomerVo;

public class SignupOkAction implements JavajoAction {

	JavajoDao dao;
	
	public SignupOkAction() {
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
		
		String view = "";
		String msg = "";
		//System.out.println(Integer.parseInt(pw));
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
			view = "signup.com";
		}
		
		int re = dao.singupok(c);
		if(re==1)
		{
			view = "catchme.com";
			
		}
		else
		{
			msg = "비밀번호를 8자리 이상 입력하십시오.";
			view = "signup.com";
		}
		request.setAttribute("msg2", msg);
		return view;
	}

}
