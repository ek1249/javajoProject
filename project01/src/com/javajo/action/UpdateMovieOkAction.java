package com.javajo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.dao.JavajoDao;
import com.javajo.vo.MovieVo;
import com.oreilly.servlet.MultipartRequest;

public class UpdateMovieOkAction implements JavajoAction {
	
	JavajoDao dao;
	public UpdateMovieOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path=request.getRealPath("/img");
		
		int sizeLimit=1024*1024*1024;
	      
	    MultipartRequest multi = new MultipartRequest(request, path,sizeLimit,"UTF-8");
		MovieVo j = new MovieVo();
		
		int movie_number = Integer.parseInt(multi.getParameter("movie_number"));
		j.setMovie_number(movie_number);
		j.setMovie_name(multi.getParameter("movie_name"));
		j.setMovie_director(multi.getParameter("movie_director"));
		j.setMovie_actor(multi.getParameter("movie_actor"));
		j.setMovie_nation(multi.getParameter("movie_nation"));
		j.setMovie_runningtime(Integer.parseInt(multi.getParameter("movie_runningtime")));
		j.setMovie_grade(multi.getParameter("movie_grade"));
		j.setMovie_genre(multi.getParameter("movie_genre"));
		j.setMovie_opendate(multi.getParameter("movie_opendate"));
		j.setMovie_synop(multi.getParameter("movie_synop"));
		j.setMovie_image(multi.getParameter("movie_image"));
		j.setMovie_score(Double.parseDouble(multi.getParameter("movie_score")));
		
		
		String oldimage = dao.getMovie(movie_number).getMovie_image();
		j.setMovie_image(oldimage);
		
		File file = multi.getFile("movie_image");
		
		if(file != null && file.getName() != null && !file.getName().equals("")){
			j.setMovie_image(file.getName());
		}
		
		
		
		String oldimage1 = dao.getMovie(movie_number).getMovie_image1();
		j.setMovie_image1(oldimage1);
		
		File file1 = multi.getFile("movie_image1");
		
		if(file1 != null && file1.getName() != null && !file1.getName().equals("")){
			j.setMovie_image1(file1.getName());
		}
		
		
		String oldimage2 = dao.getMovie(movie_number).getMovie_image2();
		j.setMovie_image2(oldimage2);
		
		File file2 = multi.getFile("movie_image2");
		
		if(file2 != null && file2.getName() != null && !file2.getName().equals("")){
			j.setMovie_image2(file2.getName());
		}
		
		
		String oldimage3 = dao.getMovie(movie_number).getMovie_image3();
		j.setMovie_image3(oldimage3);
		
		File file3 = multi.getFile("movie_image3");
		
		if(file3 != null && file3.getName() != null && !file3.getName().equals("")){
			j.setMovie_image3(file3.getName());
		}
		
		
		
		
		
		
		
		
		
		
		int re = dao.updateMovie(j);
		
		if(re == 1 && file != null && file.getName() != null && !file.getName().equals("") && oldimage!=null && !oldimage.equals("")){
			System.out.println("첨부파일 삭제");
			File f = new File(path+"/"+oldimage);
			f.delete();
		}
		
		if(re == 1 && file1 != null && file1.getName() != null && !file1.getName().equals("") && oldimage1!=null && !oldimage1.equals("")){
			System.out.println("첨부파일 삭제");
			File f1 = new File(path+"/"+oldimage1);
			f1.delete();
		}
		
		if(re == 1 && file2 != null && file2.getName() != null && !file2.getName().equals("") && oldimage2!=null && !oldimage2.equals("")){
			System.out.println("첨부파일 삭제");
			File f2 = new File(path+"/"+oldimage2);
			f2.delete();
		}
		
		if(re == 1 && file3 != null && file3.getName() != null && !file3.getName().equals("") && oldimage3!=null && !oldimage3.equals("")){
			System.out.println("첨부파일 삭제");
			File f3 = new File(path+"/"+oldimage3);
			f3.delete();
		}
		
		
		
	
		String view = "listMovie.com";
		if(re != 1){
			request.setAttribute("msg", "게시물 수정에 실패하였습니다!!ㅠㅠ");
			view = "error.jsp";
		}
		
		
		return view;
	}

}
