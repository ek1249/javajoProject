package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.TicketingDao;
import com.javajo.vo.MovieVo;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.RunningVo;
import com.javajo.vo.RunningVo2;

public class ListMovieAction2 implements JavajoAction {
   
   TicketingDao dao;
   public ListMovieAction2() {
      // TODO Auto-generated constructor stub
      dao = new TicketingDao();
   }

   @Override
   public String proRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      String view ="";
      HttpSession session = request.getSession(true);
      
      
      
      int movie_number = 0;
      int movietheater_number=0;
      int running_number =0;
      int theater_number=0;
      
      String running_date="";
      
      movie_number = dao.movie_number;

      if(request.getParameter("movie_number") != null && !request.getParameter("movie_number").equals("") && Integer.parseInt(request.getParameter("movie_number"))!=0)
      {
            
         dao.movie_number = 0;
         dao.movietheater_number =0;
         dao.running_number = 0;
         dao.running_date = "";
         movie_number = Integer.parseInt(request.getParameter("movie_number"));
         String movie_name = request.getParameter("movie_name");
      }
      String movie_name = request.getParameter("movie_name");
      request.setAttribute("movie_name", movie_name);
      
      movietheater_number = dao.movietheater_number;
      if(request.getParameter("movietheater_number") != null && !request.getParameter("movietheater_number").equals("")&& Integer.parseInt(request.getParameter("movietheater_number"))!=0)
      {

         dao.movietheater_number =0;
         dao.running_number = 0;
         dao.running_date = "";
          movietheater_number = Integer.parseInt(request.getParameter("movietheater_number"));
      }
      running_number = dao.running_number;
      if(request.getParameter("running_number")!=null && !request.getParameter("running_number").equals("")&& Integer.parseInt(request.getParameter("running_number"))!=0)
      {
         running_number = Integer.parseInt(request.getParameter("running_number"));
      }
      
      theater_number = dao.theater_number;
      if((request.getParameter("theater_number")!=null && !request.getParameter("theater_number").equals("")&& Integer.parseInt(request.getParameter("theater_number"))!=0))
      {
         theater_number = Integer.parseInt(request.getParameter("theater_number"));
      }
         running_date = dao.running_date;
      if(request.getParameter("running_date")!=null && !request.getParameter("running_date").equals(""))
      {
         
   
         running_date = request.getParameter("running_date");
         
      }
      
      ArrayList<MovieVo> list = dao.listMovie();
      ArrayList<MovietheaterVo> list_mt = dao.listMovietheater(movie_number);
      ArrayList<RunningVo2> list_r = dao.listRunning(movie_number,movietheater_number);
      
      ArrayList<RunningVo2> list_re = dao.listResult(movie_number,movietheater_number,running_date);
      
      session.setAttribute("list", list);
      session.setAttribute("list_mt", list_mt);
      session.setAttribute("list_r", list_r);
      session.setAttribute("list_re", list_re);
      
      int movie_num = 0;
      int movietheater_num = 0;
      String running_dt = "";
      int running_num = 0;
      int theater_num = 0;
      if(request.getParameter("movie_num")!=null && !request.getParameter("movie_num").equals(""))
      {
         movie_num = Integer.parseInt(request.getParameter("movie_num"));
         movietheater_num = Integer.parseInt(request.getParameter("movietheater_num"));
         running_dt = request.getParameter("running_dt");
         running_num = Integer.parseInt(request.getParameter("running_num"));
         theater_num = Integer.parseInt(request.getParameter("theater_num"));
      
         request.setAttribute("m_num", movie_num);
         request.setAttribute("mt_num", movietheater_num);
         request.setAttribute("r_date", running_dt);
         request.setAttribute("r_num", running_num);
         request.setAttribute("t_num", theater_num);
      }
      view = "listMovie2.jsp";
      
      return view;
   }

}