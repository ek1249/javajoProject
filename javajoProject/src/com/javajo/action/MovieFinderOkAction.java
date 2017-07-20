package com.javajo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.JavajoDao;

public class MovieFinderOkAction implements JavajoAction {
	
	JavajoDao dao;
	int n;
	public MovieFinderOkAction() {
		// TODO Auto-generated constructor stub
		dao = new JavajoDao();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String searchField="";
		String searchWord="";
		String firstyear=request.getParameter("firstyear");
		String endyear=request.getParameter("endyear");
		int firstyear2=0;
		int endyear2=0;
		
		request.getParameter("movie_genre"); //이게 갯수면 이걸 배열에 넣어가지고 
		/*String movie_genre[] = new String[17];
		String movie_nation[]= new String[8];
		String movie_grade[] = new String[4];*/
		String movie_genre[]=null;
		String movie_nation[]=null;
		String movie_grade[]=null;
		
		if(request.getParameter("searchWord") != null)
		{
			searchField = request.getParameter("searchField");
			searchWord = request.getParameter("searchWord");
	
		}
		if(request.getParameterValues("movie_genre") != null){
			movie_genre = request.getParameterValues("movie_genre");
		}
		if(request.getParameterValues("movie_nation") != null){
			movie_nation = request.getParameterValues("movie_nation");
		}
		if(request.getParameterValues("movie_grade") != null){
			movie_grade = request.getParameterValues("movie_grade");
		}
		if(firstyear!=null && !firstyear.equals("") && endyear!=null && !endyear.equals("")){
			firstyear2 =Integer.parseInt(request.getParameter("firstyear")) ;
			endyear2 =Integer.parseInt(request.getParameter("endyear"));
			//System.out.println("무비파인더오케이액션 : "+firstyear);
		}
		//System.out.println("무비파인더오케이액션 : "+firstyear);
		
		request.setAttribute("list", dao.searchMovie(searchField, searchWord, movie_genre, movie_nation, movie_grade, firstyear2,endyear2));
		
		 n = dao.n;
		/* boolean a = false;
		 for(int i=1;i<n;i++){
			 if(i%16==0){
				 a = true;
				 request.setAttribute("a", a);
			 } 
		 }*/
		 
		String str ="검색 결과";
		
		request.setAttribute("str", str);
		System.out.println("액션 n : "+n);
		return "movieFinder.jsp";
	}

}
