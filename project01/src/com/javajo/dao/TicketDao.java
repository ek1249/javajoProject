package com.javajo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.javajo.db.ConnectionProvider;


public class TicketDao {
	
	public int deleteTicket(int ticket_number){
		
		int re = 0;
		
		try {
			  String sql = "update seat set seat_ft='n', ticket_number = null where ticket_number = ?";
			  Connection conn = ConnectionProvider.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, ticket_number);
			  
			  if(pstmt.executeUpdate() != 0)
			  {
				  re = 1;
			  }
			  
			  ConnectionProvider.close(null, pstmt, conn);
			  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("deleteTicket 의 싯 업데이트"+e.getMessage());
		}
		
		try {
			String sql = "delete from ticket where ticket_number=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ticket_number);
			
			if(pstmt.executeUpdate()==1)
			{
				re+=1;
			}
			ConnectionProvider.close(null, pstmt, conn);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("deleteTicket 의 딜리트 부분   :: "+e.getMessage());
		}
		
		return re;
	}
	
	public ArrayList checkTicket(String id){
		ArrayList list = new ArrayList();
		String movie_name="";
		String run_date ="";
		String run_start ="";
		String movietheater_name = "";
		String people_num="";
		String seat ="";
		int ticket_number=0; 
		String movie_image ="";
		try {
			 String sql = "select m.MOVIE_NAME, to_char(r.RUNNING_DATE,'yyyy-mm-dd'), r.RUNNING_START, mt.MOVIETHEATER_NAME, s.SEAT_ROW, s.SEAT_COLUMN, t.TICKET_PEOPLENUM, t.ticket_number, m.movie_image "
		               + "from ticket t, seat s, running r, movie m, movietheater mt "
		               + "where t.TICKET_NUMBER= s.TICKET_NUMBER and r.RUNNING_NUMBER = t.RUNNING_NUMBER "
		               + "and t.MOVIE_NUMBER = m.MOVIE_NUMBER and mt.MOVIETHEATER_NUMBER = t.MOVIETHEATER_NUMBER "
		               + "and t.CUSTOMER_ID =?";
			 Connection conn = ConnectionProvider.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         ResultSet rs = pstmt.executeQuery();
	         while(rs.next())
	         {
	        	  movie_name = rs.getString(1);
	              run_date = rs.getString(2);
	              run_start = rs.getString(3);
	              movietheater_name = rs.getString(4);
	              people_num = rs.getString(7);
	              seat += rs.getString(5)+rs.getString(6)+",";
	              ticket_number = rs.getInt(8);
	              movie_image = rs.getString(9);
	         }
	         System.out.println("movie_name : "+movie_name);
	         list.add(movie_name);
	         list.add(run_date);
	         list.add(run_start);
	         list.add(movietheater_name);
	         list.add(people_num);
	         seat = seat.substring(0, seat.length()-1);
	         System.out.println("seat    : "+seat);
	         list.add(seat);
	         list.add(ticket_number);
	         list.add(movie_image);
	         ConnectionProvider.close(rs, pstmt, conn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	

	public int makeTicket(int person_num,int movie_number,int movietheater_number,int theater_number, String id, int running_number){
		int re = 0;
		int max = 0;

		try {
			
			String sql = "select nvl(max(ticket_number),0)+1 from ticket";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				max = rs.getInt(1);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ticketdao maxTicket : "+e.getMessage());
		}
		
		try {

			String sql3 = "insert into ticket values(?,sysdate,?,?,?,?,?,?)";

			Connection conn = ConnectionProvider.getConnection();

			// ResultSet

			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setInt(1, max);
			pstmt3.setInt(2, person_num);
			pstmt3.setInt(3, movie_number);
			pstmt3.setInt(4, movietheater_number);
			pstmt3.setInt(5, theater_number);
			pstmt3.setString(6, id);
			pstmt3.setInt(7, running_number);

			int rs3 = pstmt3.executeUpdate();

			if (rs3 == 1) {
				re = max;
			}

		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println("ticketdao maketicket : "+e2.getMessage());
		}
		return max;
	}
	
	
	
}








