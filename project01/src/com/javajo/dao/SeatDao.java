package com.javajo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.javajo.db.ConnectionProvider;
import com.javajo.vo.SeatVo;

public class SeatDao {

	public ArrayList<SeatVo> getSeat() {

		ArrayList<SeatVo> list = new ArrayList<SeatVo>();
		SeatVo s = null;
		try {
			String sql = "select * from seat";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				s = new SeatVo();
				s.setSeat_number(rs.getInt(1));
				s.setSeat_row(rs.getString(2));
				s.setSeat_column(rs.getString(3));
				s.setSeat_ft(rs.getString(4));
				s.setTicket_number(rs.getInt(5));
				s.setTheater_number(rs.getInt(6));

				list.add(s);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getSeat() : " + e.getMessage());
		}

		return list;
	}

	public ArrayList<SeatVo> Theater_seat(int theater_num) {
		ArrayList<SeatVo> list = new ArrayList<SeatVo>();
		System.out.println("seatDao��  theater_number :"+theater_num );
		try {
			String sql = "select seat_row, seat_column, seat_ft from seat where THEATER_NUMBER = ? order by seat_number";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, theater_num);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SeatVo s = new SeatVo();
				s.setSeat_row(rs.getString(1));
				s.setSeat_column(rs.getString(2));
				s.setSeat_ft(rs.getString(3));
				list.add(s);
			}
			ConnectionProvider.close(rs, pstmt, conn);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("theater_seat"+e.getMessage());
		}

		return list;
	}

	public int updateSeat(String arr[], int ticket_number, int theater_number) {
		int re = 0;

		try {
			for (int i = 0; i < arr.length; i++) {
				String row = "";
				String col = "";
				row = arr[i].substring(0, 1);
				col = arr[i].substring(1, 2);
				String sql = "update seat set SEAT_FT='y',ticket_number= ? where SEAT_ROW=? and SEAT_COLUMN=? and theater_number=?";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ticket_number);
				pstmt.setString(2, row);
				pstmt.setString(3, col);
				pstmt.setInt(4, theater_number);
				
				re = pstmt.executeUpdate();
				ConnectionProvider.close(null, pstmt, conn);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("update �κ�"+e.getMessage());
		}

		return re;

	}

}
