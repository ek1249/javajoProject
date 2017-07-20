package com.javajo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import com.javajo.db.ConnectionProvider;
import com.javajo.vo.MovieVo;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.RunningVo;
import com.javajo.vo.RunningVo2;

public class TicketingDao {
   public static int movie_number;
   public static int movietheater_number;
   public static String running_date;
   public static int running_number;
   public static int theater_number;
   public static int left_seat;
   public static int seat;
   
   
   public ArrayList<RunningVo2> listResult(int movie_number,int movietheater_number,String running_date ){
      this.running_date= running_date;
      
      System.out.println(movie_number);
      System.out.println(movietheater_number);
      System.out.println(running_date);
      
      //this.movietheater_number=movietheater_number;
      ArrayList<RunningVo2> list_re = new ArrayList<RunningVo2>();
      String sql = "select running_start ,t.theater_number, running_number,m.movie_number,mt.movietheater_number, r.running_date from running r,movietheater mt, movie m,theater t where mt.movietheater_number = t.movietheater_number and m.movie_number = r.movie_number and r.theater_number = t.theater_number and mt.movietheater_number=? and to_char(running_date,'yyyy-mm-dd') = ? and m.movie_number=?";
      /*String sql3 ="select max(theater_seat) from theater where theater_number=?";
      String sql2 ="select nvl(count(seat_number),0) from seat where seat_ft = 'y' and theater_number=?";*/
      try {
        
         Connection conn = ConnectionProvider.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, movietheater_number);
            pstmt.setString(2, running_date);
            pstmt.setInt(3, TicketingDao.movie_number);
            
            
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            RunningVo2 v = new RunningVo2();
            v.setRunning_start(rs.getString(1)); 
                v.setTheater_number(rs.getInt(2));
                v.setRunning_number(rs.getInt(3));
                v.setMovie_number(rs.getInt(4));
                v.setMovietheater_number(rs.getInt(5));
                v.setRunning_date(rs.getString(6).substring(0, 10));
              
                list_re.add(v);
         }
         
      
         ConnectionProvider.close(rs, pstmt, conn);
      /*   ConnectionProvider.close(rs2, pstmt2, conn);
         ConnectionProvider.close(rs3, pstmt3, conn);
         */
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println("i=listResult : "+e.getMessage());
      }
      
      return list_re;
   }
   
   
   
   
   
   public int left_seat(int movietheater_number){
      
      int a=0;
      int b=0;
      try {
         //String sql ="select count(*) from seat where seat_ft = 'y' and theater_number = ?";
         String sql3 ="select max(theater_seat) from theater where theater_number=?";
         String sql2 ="select nvl(count(seat_number),0) from seat where seat_ft = 'y' and theater_number=?";
         
         Connection conn = ConnectionProvider.getConnection();
         PreparedStatement pstmt3= conn.prepareStatement(sql3);
         pstmt3.setInt(1, theater_number);
         ResultSet rs3 = pstmt3.executeQuery();
         
         if(rs3.next())
         {
            b=rs3.getInt(1);
         }
         System.out.println("b:"+b);
         
         PreparedStatement pstmt2 = conn.prepareStatement(sql2);
         pstmt2.setInt(1, theater_number);
         ResultSet rs2 = pstmt2.executeQuery();
         
         if(rs2.next())
         {
            a=rs2.getInt(1);
         }
         
         ConnectionProvider.close(rs2, pstmt2, conn);
         ConnectionProvider.close(rs3, pstmt3, conn);
         
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println(e.getMessage());
      }
      seat = b-a;
      System.out.println("dao.seat"+seat);
      return seat;
   }

   public ArrayList<RunningVo2> listRunning(int movie_number,int movietheater_number){
      this.movietheater_number=movietheater_number;
      ArrayList<RunningVo2> list_r = new ArrayList<RunningVo2>();
      
      String sql="select distinct running_date from running r,movietheater mt, movie m,theater t where mt.movietheater_number = t.movietheater_number and m.movie_number = r.movie_number and r.theater_number = t.theater_number and m.movie_number =? and mt.movietheater_number =?";
   
      try {
         Connection conn = ConnectionProvider.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);

         pstmt.setInt(1, TicketingDao.movie_number);
         pstmt.setInt(2, movietheater_number);
         
         ResultSet rs =pstmt.executeQuery();

         while(rs.next())
         {
            RunningVo2 r = new RunningVo2();
            r.setRunning_date(rs.getString(1).substring(0, 10));
            list_r.add(r);
         }
         
         ConnectionProvider.close(rs, pstmt, conn);
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println(e.getMessage());
      }
      
      
      return list_r;
   }
   

   public ArrayList<MovietheaterVo> listMovietheater(int movie_number){
      ArrayList<MovietheaterVo> list_mt = new ArrayList<MovietheaterVo>();
      this.movie_number=movie_number;
      String sql= "select distinct mt.movietheater_name, mt.movietheater_number from movietheater mt, movie m,running r, theater t where mt.movietheater_number = t.movietheater_number and m.movie_number = r.movie_number and r.theater_number = t.theater_number and m.movie_number =?";
      try {
         Connection conn = ConnectionProvider.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
           
         
         pstmt.setInt(1,movie_number);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            MovietheaterVo m = new MovietheaterVo();
            m.setMovietheater_name(rs.getString(1));
            m.setMovietheater_number(rs.getInt(2));
            list_mt.add(m);
         
         
         }
         ConnectionProvider.close(rs, pstmt, conn);
         
         
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println(e.getMessage());
      }
      
      return list_mt;
   }
   
   public ArrayList<MovieVo> listMovie(){
      
      ArrayList<MovieVo> list = new ArrayList<MovieVo>();
      
      String sql ="select * from movie ";
      
      try {
         Connection conn = ConnectionProvider.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs=stmt.executeQuery(sql);
         while(rs.next())
         {
            MovieVo m = new MovieVo();
            m.setMovie_number(rs.getInt(1));
            m.setMovie_name(rs.getString(2));
            m.setMovie_director(rs.getString(3));
            m.setMovie_actor(rs.getString(4));
            m.setMovie_nation(rs.getString(5));
            m.setMovie_runningtime(rs.getInt(6));
            m.setMovie_grade(rs.getString(7));
            m.setMovie_genre(rs.getString(8));
            m.setMovie_opendate(rs.getString(9));
            m.setMovie_synop(rs.getString(10));
            m.setMovie_image(rs.getString(11));
            m.setMovie_score(rs.getInt(13));
            
            list.add(m);
            
            
         }
         ConnectionProvider.close(rs, stmt, conn);
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println(e.getMessage());
      }
   
      
      
      return list;
   }

}