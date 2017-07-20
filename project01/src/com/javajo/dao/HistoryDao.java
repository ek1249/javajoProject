package com.javajo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.javajo.db.ConnectionProvider;
import com.javajo.vo.HistoryVo;

public class HistoryDao {
	
	public int makeHistory(String id, int movie_number,int movietheater_number,int theater_number, int running_number){
		int re = 0;
		int max = 0;

		try {
			
			String sql = "select nvl(max(history_no),0)+1 from history";
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
			System.out.println("historydao maxHistory : "+e.getMessage());
		}
		
		try {

			String sql3 = "insert into history values(?,?,?,?,?,?)";

			Connection conn = ConnectionProvider.getConnection();

			// ResultSet

			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setInt(1, max);
			pstmt3.setString(2, id);
			pstmt3.setInt(3, movie_number);
			pstmt3.setInt(4, theater_number);
			pstmt3.setInt(5, running_number);
			pstmt3.setInt(6, movietheater_number);

			int rs3 = pstmt3.executeUpdate();

			if (rs3 == 1) {
				re = 1;
			}

		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println("historydao makehistory : "+e2.getMessage());
		}
		return re;
	}
	
	public ArrayList<HistoryVo> listHistory(String id){
		ArrayList<HistoryVo> list = new ArrayList();
		HistoryVo h = null;
		try {
			 String sql = "select distinct  m.MOVIE_NAME, to_char(r.RUNNING_DATE,'yyyy-mm-dd'), r.RUNNING_START, mt.MOVIETHEATER_NAME, m.movie_image, t.history_no "
		               + "from history t, seat s, running r, movie m, movietheater mt "
		               + "where  r.RUNNING_NUMBER = t.RUNNING_NUMBER "
		               + "and t.MOVIE_NUMBER = m.MOVIE_NUMBER and mt.MOVIETHEATER_NUMBER = t.MOVIETHEATER_NUMBER "
		               + "and t.CUSTOMER_ID =? order by t.history_no desc";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				h = new HistoryVo();
				h.setMovie_name(rs.getString(1));
				h.setRunning_date(rs.getString(2));
				h.setRunning_start(rs.getString(3));
				h.setMovietheater_name(rs.getString(4));
				h.setMovie_image(rs.getString(5));
				
				list.add(h);
			
			}
			
			ConnectionProvider.close(rs, pstmt, conn);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("history list ::   "+e.getMessage());
		}
		
		return list;
	}
	
}
