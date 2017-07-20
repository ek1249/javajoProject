package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.JavajoVo;

public class ListMovieAction implements JavajoAction {
	
	JavajoDao dao;
	public ListMovieAction() {
		// TODO Auto-generated constructor stub
		dao= new JavajoDao();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNUM=1;
		if(request.getParameter("pageNUM") != null){
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		
		
		ArrayList<JavajoVo> list =  dao.listMovie(pageNUM);
		
		String view = "listMovie.jsp";
		if(list.isEmpty()){
			request.setAttribute("msg", "리스트 검색에 실패했습니다.");
			view = "error.jsp";
		}
		request.setAttribute("li", list);
		String upload = request.getRealPath("/upload2/");
		request.setAttribute("path", upload);
		
		request.setAttribute("pageStr", dao.pageStr());
		
		return view;
	}

}
