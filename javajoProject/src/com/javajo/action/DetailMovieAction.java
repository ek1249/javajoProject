package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;

public class DetailMovieAction implements JavajoAction {

	JavajoDao dao;
	public DetailMovieAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int movie_number = Integer.parseInt(request.getParameter("movie_number"));
		
		request.setAttribute("m",dao.getMovie(movie_number));
		//request.setAttribute("i", dao.getImage(movie_number));
		
		return "detailMovie.jsp";
	}

}
