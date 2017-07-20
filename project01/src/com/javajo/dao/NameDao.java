package com.javajo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javajo.db.ConnectionProvider;

public class NameDao {
	

	public String movieimg(int movie_number)
	{
		String name = "";
		try {
			String sql = "select movie_image from movie where movie_number=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movie_number);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				name = rs.getString(1);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("moviename : "+e.getMessage());
		}
		
		return name;
	}


	public String movieName(int movie_number)
	{
		String name = "";
		try {
			String sql = "select movie_name from movie where movie_number=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movie_number);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				name = rs.getString(1);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("moviename : "+e.getMessage());
		}
		
		return name;
	}
	
	public String TheaterName(int theater_number)
	{
		String name = "";
		try {
			String sql ="select theater_number, theater_starttime, theater_endtime from theater where theater_number =?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, theater_number);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				name = rs.getString(1)+"상영관  "+" 상영시간  "+rs.getString(2)+":00 ~"+rs.getString(3)+":00";
			}
			ConnectionProvider.close(rs, pstmt, conn);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("theaterName :"+e.getMessage());
		}
		return name;
		
	}
	
	public String movietheaterName(int movietheater_number){
		
		String name = "";
		try {
			String sql = "select movietheater_name from movietheater where movietheater_number =?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movietheater_number);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				name = rs.getString(1);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("mtname  "+e.getMessage());
		}
		return name;
	}
	
	
	
	
	
	
	
	
	
}
