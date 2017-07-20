package com.javajo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.MovieVo;
import com.oreilly.servlet.MultipartRequest;

public class InsertMovieOkAction implements JavajoAction {

	JavajoDao dao;

	public InsertMovieOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getRealPath("/img/");

		System.out.println("upload:" + path);
		int sizeLimit=1024*1024*1024;
	      
		MultipartRequest multi = new MultipartRequest(request, path,sizeLimit,"UTF-8");
		
		MovieVo j = new MovieVo();
		j.setMovie_name(multi.getParameter("movie_name"));
		j.setMovie_director(multi.getParameter("movie_director"));
		j.setMovie_actor(multi.getParameter("movie_actor"));
		j.setMovie_nation(multi.getParameter("movie_nation"));
		j.setMovie_runningtime(Integer.parseInt(multi.getParameter("movie_runningtime")));
		j.setMovie_grade(multi.getParameter("movie_grade"));
		j.setMovie_genre(multi.getParameter("movie_genre"));
		j.setMovie_opendate(multi.getParameter("movie_opendate"));
		j.setMovie_synop(multi.getParameter("movie_synop"));
		File file = multi.getFile("movie_image");
		
		if(file != null && file.getName() != null && !file.getName().equals(""))
		{	
			j.setMovie_image(file.getName());
		}
		
		j.setMovie_score(Double.parseDouble(multi.getParameter("movie_score")));
		
		
		File file1 = multi.getFile("movie_image1");
		
		if(file1 != null && file1.getName() != null && !file1.getName().equals(""))
		{	
			j.setMovie_image1(file1.getName());
		}
		
		File file2 = multi.getFile("movie_image2");
		if(file2 != null && file2.getName() != null && !file2.getName().equals("")){
			j.setMovie_image2(file2.getName());
		}
		
		File file3 = multi.getFile("movie_image3");
		if(file3 != null && file3.getName() != null && !file3.getName().equals("")){
			j.setMovie_image3(file3.getName());
		}
		
		
		int re = dao.insertMovie(j);
		String view = "listMovie.com";
		if(re != 1){
			request.setAttribute("msg", "영화등록에 실패하였습니다.");
			view = "error.jsp";
		}
		
		return view;
	}

}
