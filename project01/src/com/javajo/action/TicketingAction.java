package com.javajo.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javajo.dao.NameDao;
import com.javajo.dao.SeatDao;
import com.javajo.dao.TicketingDao;
import com.javajo.vo.RunningVo2;
import com.javajo.vo.SeatVo;


public class TicketingAction implements JavajoAction {

	SeatDao dao = null;
	TicketingDao dao_ticketing;
	NameDao ndao = null;

	public TicketingAction() {
		// TODO Auto-generated constructor stub
		dao = new SeatDao();
		dao_ticketing = new TicketingDao();
		ndao = new NameDao();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String row = "";
		String col = "";
		int cnt = 0;
		String str = "";

		HttpSession session = request.getSession(true);

		int movie_num = Integer.parseInt(request.getParameter("m_num"));
		String running_dt = request.getParameter("r_date");
		int movietheater_num = Integer.parseInt(request.getParameter("mt_num"));
		int running_num = Integer.parseInt(request.getParameter("r_num"));
		int theater_num = Integer.parseInt(request.getParameter("t_num"));

		System.out.println("영화번호:" + movie_num);
		System.out.println("상영날짜:" + running_dt);
		System.out.println("영화관번호:" + movietheater_num);
		System.out.println("상영번호(running_number):" + running_num);
		System.out.println("theater_num:" + theater_num);

		ArrayList<SeatVo> list = dao.Theater_seat(theater_num);// ����Ʈ :
																// seat_row,
																// seat_column,
																// seat_ft
		String movie_name = ndao.movieName(movie_num);
		String movie_img = ndao.movieimg(movie_num);
		String theater_name = ndao.TheaterName(theater_num);
		String movietheater_name = ndao.movietheaterName(movietheater_num);
		str += "<center>";
		str += "<table id='tb' width='60%' height='500px'>";
		str += "<tr>";
		str += "<td colspan='2'><div id='screen1'>인원/좌석</div></td>";
		str += "</tr>";
		str += "<tr>";
		str += "<td>";
		str += "<div ='seat'>일반:";
		for (int i = 0; i < 7; i++) {
			if (i == 0)
			{
				str += "<input type='radio' name='seat_adult' value='" + i
						+ "' onclick='check_adult(this.value)' checked='checked'>" + i + "명";
			}else{
				str += "<input type='radio' name='seat_adult' value='" + i + "' onclick='check_adult(this.value)'>" + i
						+ "명";
			}
		}
		str += "<br> 청소년:";
		for (int i = 0; i < 7; i++) {
			if (i == 0)
			{
				str += "<input type='radio' name='seat_child' value='" + i
						+ "' onclick='check_child(this.value)' checked='checked'>" + i + "명";
			}else{
				str += "<input type='radio' name='seat_child' value='" + i + "' onclick='check_child(this.value)'>" + i
						+ "명";
			}
			}
		str += "</td>";
		str += "<td>";
		str += movietheater_name+" / "+movie_name+"<br><b>"+running_dt+" / "+theater_name+"<b>";
		str += "</td>";
		str += "</tr>";
		str += "<tr>";
		str += "<td colspan='2'><center><div id ='screen2'>screen</div></center>";
		str += "</td>";		
		str += "</tr>";
		str += "<tr>";
		str += "<td colspan='2'>";
		str += "<form action='ticketingOk.com' name ='chkseat' method='post'>";
		str += "<center>";
		str += "<table>";
		str += "<tr>";
		for (SeatVo s : list) {

			if ((s.getSeat_ft()).equals("n")) {
				row = s.getSeat_row();
				col = s.getSeat_column();
				str += "<td><input type='checkbox' class='seat' name='seat' value='" + row + col + "' id ='" + row + col
						+ "' onclick='CheckForm(this.value);'>";
				str += "<label for='" + row + col + "'>" + row + col + "</label></td>";
				cnt++;

			} else {
				row = s.getSeat_row();
				col = s.getSeat_column();
				str += "<td><input type='checkbox' seat='seat' name='seat' value='" + row + col + "' id ='" + row + col
						+ "' checked='checked' disabled='disabled' onclick='CheckForm(this.value);'>";
				str += "<label for='" + row + col + "'>" + row + col + "</label></td>";
				cnt++;
			}
			if (cnt == 5) {
				cnt = 0;
				str += "</tr>";
				str += "<tr>";
			}
		}
		str += "</tr>";
		str += "</table>";
		str += "</center>";
		str += "</tr>";
		str += "<tr>";
		str += "<td id ='foot' colspan='2'>";
		str += "<input type='hidden' name='movie_number' value='"+movie_num+"'>";
		str += "<input type='hidden' name='movietheater_number' value='"+movietheater_num+"'>";
		str += "<input type='hidden' name='running_number' value='"+running_num+"'>";
		str += "<input type='hidden' name='theater_number' value='"+theater_num+"'>";
		str += "<div id ='btn1'><input type ='image' src ='pre.PNG' width='80px' height='80px' onclick = 'pre()'></div>";
		str += "<div id ='btn3'><center><table><tr><td  rowspan='3'><img src='img/"+movie_img+"' width='80px' height='80px'><td>"+movie_name+"</td><td  rowspan='3'><span id='seat'></td></tr><tr><td>"+running_dt+"</td></tr><tr><td>"+theater_name+"</td></tr></table></center></div>";
		str += "<div id ='btn2'><input type ='image' src ='aft.PNG'name='submit' value='submit' width='80px' height='80px' onclick = 'aft()'></div>";
		str += "</form></div>";
		str += "</td></tr>";
		str += "</table>";
		str += "</center>";

		request.setAttribute("str", str);

		return "ticketing.jsp";
	}

}
