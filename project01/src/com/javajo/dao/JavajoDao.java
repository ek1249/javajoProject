package com.javajo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javajo.db.ConnectionProvider;
import com.javajo.vo.BoardVo;
import com.javajo.vo.CommentboardVo;
import com.javajo.vo.CustomerVo;
import com.javajo.vo.EventVo;
import com.javajo.vo.MovieVo;
import com.javajo.vo.MovietheaterVo;
import com.javajo.vo.PostboardVo;
import com.javajo.vo.RunningVo;
import com.javajo.vo.RunningtableVo;
import com.javajo.vo.ScoreMovieVo;
import com.javajo.vo.TheaterVo;

public class JavajoDao {

	int pagesize = 10;
	int totalrecode=0;
	int totalpage=1;
	public int movietheater_num=0;
	public int theater_num=0;
	public int cnt = 1;
	public int idserchre = -1;
	public int pwdserchre = -1;
	public int pno = 0;
	//쿼리된 리스트의 갯수를 가져오는 변수
		public static int n;
		/*//한화면에 보여줄 페이지의 수를 제한할 변수 
		public int pageGRUOP = 3;*/
		
		//한화면에 보여줄 레코드의 수 
		int pageSIZE =12;
		
		//전체 레코드수를 저장할 변수
		int totalRecord=0;
		
		//전체 페이지수를 저장할 변수
		int totalPage = 1;
	
	public ArrayList<ScoreMovieVo> scoreMovie()
	{
		ArrayList<ScoreMovieVo> list = new ArrayList<ScoreMovieVo>();
		String sql = "select rownum,movie_name,movie_score,movie_image from (select movie_name,movie_score,movie_image from movie order by movie_score desc, movie_name) where rownum <= 10";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				ScoreMovieVo sm = new ScoreMovieVo();
				sm.setRownum(rs.getInt(1));
				sm.setMovie_name(rs.getString(2));
				sm.setMovie_score(rs.getDouble(3));
				sm.setMovie_image(rs.getString(4));
				list.add(sm);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<String> movieImg()
	{
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select movie_image from movie";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String name = rs.getString(1);
				list.add(name);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public int loginOk(String id, String pwd)
	{
		int re = -1;
		String sql = "select customer_id, customer_pw from customer";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				if(id.equals(rs.getString(1)) && pwd.equals(rs.getString(2)))
				{
					re = 2;
					break;
				}
				else if(id.equals(rs.getString(1)))
				{
					re = 0;
				}
				else if(pwd.equals(rs.getString(2)))
				{
					re = 1;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}	
	public int singupok(CustomerVo c)
	{
		int re = -1;
		String sql = "insert into customer values(?,?,?,?,?,?,?)";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getCustomer_id());
			stmt.setString(2, c.getCustomer_pwd());
			stmt.setString(3, c.getCustomer_name());
			stmt.setString(4, c.getCustomer_addr());
			stmt.setString(5, c.getCustomer_tel());
			stmt.setString(6, c.getCustomer_email());
			stmt.setString(7, c.getCustomer_gender());
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public boolean crossok(String id)
	{
		boolean t = true;
		//System.out.println(id);
		String sql = "select customer_id from customer where customer_id = ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				t = false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
		}
		
		return t;
	}
	public String idserch(String name, String tel)
	{
		String id = "";
		String sql = "select customer_id from customer where customer_name = ? and customer_tel = ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, tel);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				idserchre = 1;
				id = rs.getString(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return id;
	}
	public String pwdserch(String id, String name, String tel)
	{
		String pwd = "";
		String sql = "select customer_pw from customer where customer_id = ? and customer_name = ? and customer_tel = ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, tel);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				pwdserchre = 1;
				pwd = rs.getString(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return pwd;
	}		
	public ArrayList<PostboardVo> postlist(int pagenum)
	{
		ArrayList<PostboardVo> list = new ArrayList<PostboardVo>();
		int start = (pagenum-1)*pagesize+1;
		String sql = "select * from postboard order by postboard_p_ref desc, postboard_p_step";
		try{
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "select count(*) from postboard";
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalrecode = rs2.getInt(1);
			}
			if(totalrecode != 0)
			{
				totalpage = totalrecode/pagesize;
			}
			if(totalrecode%pagesize != 0)
			{
				totalpage++;			
			}
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.absolute(start);
			int n = 0;
			do
			{
				PostboardVo p = new PostboardVo();
				p.setPostboard_number(rs.getInt(1));
				p.setPostboard_title(rs.getString(2));
				p.setPostboard_pwd(rs.getString(3));
				p.setPostboard_content(rs.getString(4));
				p.setPostboard_hit(rs.getInt(5));
				p.setPostboard_regdate(rs.getDate(6));
				p.setPostboard_ip(rs.getString(7));
				p.setPostboard_p_ref(rs.getInt(8));
				p.setPostboard_p_level(rs.getInt(9));
				p.setPostboard_p_step(rs.getInt(10));
				p.setPostboard_fname(rs.getString(11));
				p.setPostboard_type(rs.getString(12));
				p.setCustomer_id(rs.getString(13));
				list.add(p);
				n++;
				if(n == pagesize)
				{
					break;
				}
			}while(rs.next());
			ConnectionProvider.close(rs2, stmt2, null);
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public String pagenum()
	{
		String pagenum = "";
		for(int i = 1; i <= totalpage; i++)
		{
			pagenum += "<a href='postboardlist.com?pagenum="+i+"'>"+i+"</a> ";
		}
		return pagenum;
	}
	public String pagenum2()
	{
		String pagenum = "";
		for(int i = 1; i <= totalpage; i++)
		{
			pagenum += "<a href='boardlist.com?pagenum="+i+"'>"+i+"</a> ";
		}
		return pagenum;
	}
	public int autonum()
	{
		int no = 0;
		String sql = "select nvl(max(postboard_number),0)+1 from postboard";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				no = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return no;
	}
	public int postboardinsert(PostboardVo p)
	{
		int re = -1;
		int pno = p.getPostboard_number();
		String sql = "insert into postboard values(?,?,?,?,0,sysdate,?,?,?,?,?,?,?)";
		try{
			Connection conn = ConnectionProvider.getConnection();
			int no = autonum();
			int p_ref = no;
			int p_level = 0;
			int p_step = 0;
			if(pno != 0)
			{
				PostboardVo pv = postboarddetail(pno,false);
				p_ref = pv.getPostboard_p_ref();
				p_level = pv.getPostboard_p_level();
				p_step = pv.getPostboard_p_step();
				
				updatestep(p_ref,p_step);
				
				p_level++;
				p_step++;
			}			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			stmt.setString(2, p.getPostboard_title());
			stmt.setString(3, p.getPostboard_pwd());
			stmt.setString(4, p.getPostboard_content());
			stmt.setString(5, p.getPostboard_ip());
			stmt.setInt(6, p_ref);
			stmt.setInt(7, p_level);
			stmt.setInt(8, p_step);
			stmt.setString(9, p.getPostboard_fname());
			stmt.setString(10, p.getPostboard_type());
			stmt.setString(11, p.getCustomer_id());
			re = stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public String postboardid(int no)
	{
		String re = "";
		String sql = "select customer_id from postboard where postboard_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				re = rs.getString(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public String postboardpwd(int no)
	{
		String re = "";
		String sql = "select postboard_pwd from postboard where postboard_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				re = rs.getString(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public PostboardVo postboarddetail(int pno, boolean hitadd) {
		// TODO Auto-generated method stub
		this.pno = pno;
		PostboardVo p = new PostboardVo();
		String sql = "select * from postboard where postboard_number = ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			if(hitadd)
	         {
	            String sql2 = "update postboard set postboard_hit=postboard_hit+1 where postboard_number=?";
	            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
	            pstmt2.setInt(1, pno);
	            pstmt2.executeUpdate();
	            pstmt2.close();
	         }
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pno);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				p.setPostboard_number(rs.getInt(1));
				p.setPostboard_title(rs.getString(2));
				p.setPostboard_pwd(rs.getString(3));
				p.setPostboard_content(rs.getString(4));
				p.setPostboard_hit(rs.getInt(5));
				p.setPostboard_regdate(rs.getDate(6));
				p.setPostboard_ip(rs.getString(7));
				p.setPostboard_p_ref(rs.getInt(8));
				p.setPostboard_p_level(rs.getInt(9));
				p.setPostboard_p_step(rs.getInt(10));
				p.setPostboard_fname(rs.getString(11));
				p.setPostboard_type(rs.getString(12));
				p.setCustomer_id(rs.getString(13));
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return p;
	}
	public void updatestep(int p_ref, int p_step) {
		// TODO Auto-generated method stub
		String sql = "update postboard set postboard_p_step+1 where postboard_p_ref = ? and postboard_p_step > ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, p_ref);
			stmt.setInt(2, p_step);
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public int postboardupdate(PostboardVo p)
	{
		int re = -1;
		String sql = "update postboard set postboard_title=?,postboard_content=?,postboard_fname=?,postboard_type=? where postboard_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getPostboard_title());
			stmt.setString(2, p.getPostboard_content());
			stmt.setString(3, p.getPostboard_fname());
			stmt.setString(4, p.getPostboard_type());
			stmt.setInt(5, p.getPostboard_number());
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public ArrayList<BoardVo> boardlist(int pagenum)
	{
		ArrayList<BoardVo> list  = new ArrayList<BoardVo>();
		int start = (pagenum-1)*pagesize+1;
		String sql = "select * from board order by board_regdate desc";
		try{
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "select count(*) from board";
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalrecode = rs2.getInt(1);
			}
			if(totalrecode != 0)
			{
				totalpage = totalrecode/pagesize;
			}
			if(totalrecode%pagesize != 0)
			{
				totalpage++;			
			}
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			int n = 0;
			rs.absolute(start);
			do
			{
				BoardVo b = new BoardVo();
				b.setBoard_number(rs.getInt(1));
				b.setBoard_title(rs.getString(2));
				b.setBoard_content(rs.getString(3));
				b.setBoard_regdate(rs.getDate(4));
				b.setBoard_fname(rs.getString(5));
				list.add(b);
				n++;
				if(n == pagesize)
				{
					break;
				}
			}while(rs.next());
			ConnectionProvider.close(rs2, stmt2, null);
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public int boardnum()
	{
		int no = 0;
		String sql = "select nvl(max(board_number),0)+1 from board";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				no = rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return no;
	}
	public int boardinsert(BoardVo b)
	{
		int re = -1;
		int no = boardnum();
		String sql = "insert into board values(?,?,?,sysdate,?)";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			stmt.setString(2, b.getBoard_title());
			stmt.setString(3, b.getBoard_content());
			stmt.setString(4, b.getBoard_fname());
			re = stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public BoardVo boarddetail(int no)
	{
		BoardVo b = new BoardVo();
		String sql = "select * from board where board_number = ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				b.setBoard_number(rs.getInt(1));
				b.setBoard_title(rs.getString(2));
				b.setBoard_content(rs.getString(3));
				b.setBoard_regdate(rs.getDate(4));
				b.setBoard_fname(rs.getString(5));
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return b;
	}
	public int postboarddelete(int no)
	{
		int re = -1;
		String sql = "delete postboard where postboard_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int boardupdate(BoardVo b)
	{
		int re = -1;
		String sql = "update board set board_title=?,board_content=?,board_fname=? where board_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, b.getBoard_title());
			stmt.setString(2, b.getBoard_content());
			stmt.setString(3, b.getBoard_fname());
			stmt.setInt(4, b.getBoard_number());
			System.out.println(b.getBoard_title());
			System.out.println(b.getBoard_content());
			System.out.println(b.getBoard_fname());
			System.out.println(b.getBoard_number());
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int boarddelete(int no)
	{
		int re = -1;
		String sql = "delete board where board_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public ArrayList<MovietheaterVo> movietheaterlist()
	{
		ArrayList<MovietheaterVo> list = new ArrayList<MovietheaterVo>();
		String sql = "select * from movietheater";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				MovietheaterVo mt = new MovietheaterVo();
				mt.setMovietheater_number(rs.getInt(1));
				mt.setMovietheater_name(rs.getString(2));
				mt.setMovietheater_loc(rs.getString(3));
				mt.setMovietheater_event(rs.getString(4));
				list.add(mt);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public MovietheaterVo movietheaterdetail(int no)
	{
		movietheater_num = no;
		MovietheaterVo mt = new MovietheaterVo();
		String sql = "select * from movietheater where movietheater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				mt.setMovietheater_number(rs.getInt(1));
				mt.setMovietheater_name(rs.getString(2));
				mt.setMovietheater_loc(rs.getString(3));
				mt.setMovietheater_event(rs.getString(4));
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return mt;
	}
	public int movietheaterupdate(int no, String name, String loc, String event)
	{
		int re = -1;
		String sql = "update movietheater set movietheater_name=?,movietheater_loc=?,movietheater_event=? where movietheater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, loc);
			stmt.setString(3, event);
			stmt.setInt(4, no);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int movietheaterdelete(int no)
	{
		int re = -1;
		String sql = "delete movietheater where movietheater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public ArrayList<TheaterVo> theaterlist(int no)
	{
		movietheater_num = no;
		ArrayList<TheaterVo> list = new ArrayList<TheaterVo>();
		String sql = "select theater_number from theater where movietheater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				TheaterVo t = new TheaterVo();
				t.setTheater_number(rs.getInt(1));
				list.add(t);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<RunningVo> runningdatelist(int tno)
	{
		theater_num = tno;
		ArrayList<RunningVo> list = new ArrayList<RunningVo>();
		String sql = "select distinct to_char(running_date,'yy/mm/dd') from running where theater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tno);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				RunningVo r = new RunningVo();
				r.setRunning_date(rs.getString(1));
				list.add(r);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<RunningtableVo> runningtable(String date)
	{
		ArrayList<RunningtableVo> list = new ArrayList<RunningtableVo>();
		String sql = "select movie_name, running_date, running_start, movie_image from running r, movie m where r.movie_number = m.movie_number and to_char(running_date,'yy/mm/dd') = ? and theater_number = ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, date);
			stmt.setInt(2, theater_num);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				RunningtableVo rt = new RunningtableVo();
				rt.setMovie_name(rs.getString(1));
				rt.setRunning_date(rs.getString(2));
				rt.setRunning_start(rs.getString(3));
				rt.setMovie_image(rs.getString(4));
				list.add(rt);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public int mtnum()
	{
		int no = 0;
		String sql = "select nvl(max(movietheater_number),0)+1 from movietheater";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				no = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return no;
	}
	public int movietheateradd(String name, String loc, String event)
	{
		int re = -1;
		int no = mtnum();
		String sql = "insert into movietheater values(?,?,?,?)";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			stmt.setString(2, name);
			stmt.setString(3, loc);
			stmt.setString(4, event);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
public ArrayList<MovieVo> listMovie(int pageNUM){
		
		//this.pageNUM = pageNUM;
		
		ArrayList<MovieVo> list = new ArrayList<MovieVo>();
		
		try{
			
			Connection conn = ConnectionProvider.getConnection();
			
			//전체레코드 수를 totalRecord에 담는다.
			
			
			String sql2 = "select count(*) from movie";
			
			
			Statement stmt2 = conn.createStatement();
			ResultSet rs2= stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalRecord = rs2.getInt(1);
			}
			rs2.close();
			stmt2.close();
			
			//전체페이지수를 구한다.
			totalPage = totalRecord / pageSIZE;
			
			if(totalRecord % pageSIZE != 0)
				totalPage++;
			
			
			//만약에 현재페이지가 1페이지라면 start=1	end=10
			//만약에 현재페이지가 2페이지라면 start=11	end=20
			//						3			21
			//						4			31
			int start = (pageNUM-1)*pageSIZE+1;
			/*int end = start+pageSIZE-1;*/
			
			
			/*if(end > totalRecord)
				end = totalRecord;	
			
			*/
			String sql = "select * from movie";
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.absolute(start);
			int no = 0;
			//String img = "";
			//System.out.println(rs.next());
			do{
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
				//img=rs.getString(11);
				m.setMovie_score(rs.getDouble(13));
				list.add(m);
				no++;
				if(no==pageSIZE)
					break;
				
			}while(rs.next());
			
				
			ConnectionProvider.close(rs, stmt, conn);
		}catch(Exception e){System.out.println(e.getMessage());}
		
		return list;
	}
	public MovieVo getMovie(int movie_number){
		MovieVo j = new MovieVo();
		
		String sql = "select * from movie where movie_number=?";
		
		try{
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movie_number);
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()){
				
				j.setMovie_number(rs.getInt(1));
				j.setMovie_name(rs.getString(2));
				j.setMovie_director(rs.getString(3));
				j.setMovie_actor(rs.getString(4));
				j.setMovie_nation(rs.getString(5));
				j.setMovie_runningtime(rs.getInt(6));
				j.setMovie_grade(rs.getString(7));
				j.setMovie_genre(rs.getString(8));
				String str = rs.getString(9);
				String str2 = str.substring(0, 11);
				j.setMovie_opendate(str2);
				j.setMovie_synop(rs.getString(10));
				j.setMovie_image(rs.getString(11));
				j.setMovie_score(rs.getDouble(13));
				j.setMovie_image1(rs.getString(14));
				j.setMovie_image2(rs.getString(15));
				j.setMovie_image3(rs.getString(16));
				
			}
			ConnectionProvider.close(rs, pstmt, conn);
			
		}catch(Exception e){System.out.println(e.getMessage());}
		
		return j;
	}
	public int movienum()
	{
		int no = 0;
		String sql = "select nvl(max(movie_number),0)+1 from movie";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				no = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		return no;
	}
	public int updateMovie(MovieVo m){
		int re = -1;
		
		
		String sql ="update movie set movie_name=?, movie_director=?, movie_actor=?,movie_nation=?,movie_runningtime=?,movie_grade=?,movie_genre=?,movie_opendate=?,movie_synop=?,movie_image=?,movie_score=?,movie_image1=?,movie_image2=?,movie_image3=? where movie_number=?";
		
		try{
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMovie_name());
			pstmt.setString(2, m.getMovie_director());
			pstmt.setString(3, m.getMovie_actor());
			pstmt.setString(4, m.getMovie_nation());
			pstmt.setInt(5, m.getMovie_runningtime());
			pstmt.setString(6, m.getMovie_grade());
			pstmt.setString(7, m.getMovie_genre());
			pstmt.setString(8, m.getMovie_opendate());
			pstmt.setString(9, m.getMovie_synop());
			pstmt.setString(10, m.getMovie_image());
			pstmt.setDouble(11, m.getMovie_score());
		
			pstmt.setString(12, m.getMovie_image1());
			pstmt.setString(13, m.getMovie_image2());
			pstmt.setString(14, m.getMovie_image3());
			pstmt.setInt(15, m.getMovie_number());
			
			re = pstmt.executeUpdate();
			
		}catch(Exception e){System.out.println(e.getMessage());}
	
		
		
		return re;
	}
	
	public int insertMovie(MovieVo m){
		int re = -1;
		String sql = "insert into movie values(?,?,?,?,?,?,?,?,?,?,?,null,?,?,?,?)";
		try{
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int no = movienum();
			//m.setMovie_number(no);
			pstmt.setInt(1,no);
			pstmt.setString(2, m.getMovie_name());
			pstmt.setString(3, m.getMovie_director());
			pstmt.setString(4, m.getMovie_actor());
			pstmt.setString(5, m.getMovie_nation());
			pstmt.setInt(6, m.getMovie_runningtime());
			pstmt.setString(7, m.getMovie_grade());
			pstmt.setString(8, m.getMovie_genre());
			pstmt.setString(9, m.getMovie_opendate());
			pstmt.setString(10, m.getMovie_synop());
			pstmt.setString(11, m.getMovie_image());
			pstmt.setDouble(12, m.getMovie_score());
			pstmt.setString(13, m.getMovie_image1());
			pstmt.setString(14, m.getMovie_image2());
			pstmt.setString(15, m.getMovie_image3());
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
			
		}catch(Exception e){System.out.println(e.getMessage());}
		
		
		return re;
	}
	public ArrayList<MovieVo> movielistpage(int pagenum)
	{
		ArrayList<MovieVo> list = new ArrayList<MovieVo>();
		int start = (pagenum-1)*pagesize+1;
		String sql = "select * from movie order by movie_number desc";
		try{
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "select count(*) from movie";
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalrecode = rs2.getInt(1);
			}
			if(totalrecode != 0)
			{
				totalpage = totalrecode/pagesize;
			}
			if(totalrecode%pagesize != 0)
			{
				totalpage++;			
			}
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.absolute(start);
			int n = 0;
			do
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
				m.setMovie_score(rs.getDouble(13));
				list.add(m);
				n++;
				if(n == pagesize)
				{
					break;
				}
			}while(rs.next());
			ConnectionProvider.close(rs2, stmt2, null);
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public String moviepagenum()
	{
		String pagenum = "";
		for(int i = 1; i <= totalpage; i++)
		{
			pagenum += "<a href='runningadd.com?pagenum="+i+"'>"+i+"</a> ";
		}
		return pagenum;
	}
	public int theaternum()
	{
		int no = 0;
		String sql = "select nvl(max(theater_number),0)+1 from theater";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				no = rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return no;
	}
	public int theateradd(int seat, int mtno)
	{
		int re = -1;
		int no = theaternum();
		String sql = "insert into theater values(?,null,null,?,?,null)";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			stmt.setInt(2, seat);
			stmt.setInt(3, mtno);			
			re = stmt.executeUpdate();			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int theaterupdate(TheaterVo t)
	{
		int re = -1;
		String sql = "update theater set theater_seat=?, movietheater_number=? where theater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, t.getTheater_seat());
			stmt.setInt(2, t.getMovietheater_number());
			stmt.setInt(3, t.getTheater_number());
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public TheaterVo theaterdetail(int tno)
	{
		TheaterVo t = new TheaterVo();
		String sql = "select * from theater where theater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tno);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				t.setTheater_number(rs.getInt(1));
				t.setTheater_seat(rs.getInt(4));
				t.setMovietheater_number(rs.getInt(5));
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return t;
	}
	public int theaterupdate(int tno2, int seat2, int mtno2)
	{
		int re = -1;
		String sql = "update theater set theater_seat=?,movietheater_number=? where theater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, seat2);
			stmt.setInt(2, mtno2);
			stmt.setInt(3, tno2);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int theaterdelete(int tno)
	{
		int re = -1;
		String sql = "delete theater where theater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tno);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int runningnum()
	{
		int no = 0;
		String sql = "select nvl(max(running_number),0)+1 from running";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				no = rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return no;
	}
	public int runningadd(int tno2, int mno2, String rd, String rs)
	{
		int re = -1;
		int no = runningnum();
		String sql = "insert into running values(?,?,?,to_date(?,'yyyy/mm/dd'),?)";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			stmt.setInt(2, tno2);
			stmt.setInt(3, mno2);
			stmt.setString(4, rd);
			stmt.setString(5, rs);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public ArrayList<RunningVo> runninglist(int tno)
	{
		ArrayList<RunningVo> list = new ArrayList<RunningVo>();
		String sql = "select * from running where theater_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tno);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				RunningVo r = new RunningVo();
				r.setRunning_number(rs.getInt(1));
				r.setTheater_number(rs.getInt(2));
				r.setMovie_number(rs.getInt(3));
				r.setRunning_date(rs.getString(4));
				r.setRunning_start(rs.getString(5));
				list.add(r);
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public RunningVo runningdetail(int rno)
	{
		RunningVo r = new RunningVo();
		String sql = "select * from running where running_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rno);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				r.setRunning_number(rs.getInt(1));
				r.setTheater_number(rs.getInt(2));
				r.setMovie_number(rs.getInt(3));
				r.setRunning_date(rs.getString(4));
				r.setRunning_start(rs.getString(5));
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return r;
	}
	public int runningupdate(int rno, int tno, int mno, String rd, String rs)
	{
		int re = -1;
		String sql = "update running set theater_number=?, movie_number=?, running_date=to_date(?,'yyyy/mm/dd'), running_start=? where running_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tno);
			stmt.setInt(2, mno);
			stmt.setString(3, rd);
			stmt.setString(4, rs);
			stmt.setInt(5, rno);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int runningdelete(int rno)
	{
		int re = -1;
		String sql = "delete running where running_number=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rno);
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public CustomerVo customerdetail(String id)
	{
		CustomerVo c = new CustomerVo();
		String sql = "select * from customer where customer_id=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				c.setCustomer_id(id);
				c.setCustomer_pwd(rs.getString(2));
				c.setCustomer_name(rs.getString(3));
				c.setCustomer_addr(rs.getString(4));
				c.setCustomer_tel(rs.getString(5));
				c.setCustomer_email(rs.getString(6));
				c.setCustomer_gender(rs.getString(7));
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return c;
	}
	public int customerupdate(CustomerVo c)
	{
		int re = -1;
		String sql = "update customer set customer_pw=?,customer_name=?,customer_addr=?,customer_tel=?,customer_email=?,customer_gender=? where customer_id=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getCustomer_pwd());
			stmt.setString(2, c.getCustomer_name());
			stmt.setString(3, c.getCustomer_addr());
			stmt.setString(4, c.getCustomer_tel());
			stmt.setString(5, c.getCustomer_email());
			stmt.setString(6, c.getCustomer_gender());
			stmt.setString(7, c.getCustomer_id());
			re = stmt.executeUpdate();
			ConnectionProvider.close(null, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int customerdelete(String id, String pwd)
	{
		int re = -1;
		String sql = "select customer_pw from customer where customer_id=?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				if(pwd.equals(rs.getString(1)))
				{
					String sql2 = "delete customer where customer_id='"+id+"'";
					Statement stmt2 = conn.createStatement();
					re = stmt2.executeUpdate(sql2);
					ConnectionProvider.close(null, stmt2, null);
				}
				
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public String masterpagenum()
	{
		String pagenum = "";
		for(int i = 1; i <= totalpage; i++)
		{
			pagenum += "<a href='masterpage.com?pagenum="+i+"'>"+i+"</a> ";
		}
		return pagenum;
	}
	public ArrayList<CustomerVo> customerlist(int pagenum)
	{
		ArrayList<CustomerVo> list = new ArrayList<CustomerVo>();
		int start = (pagenum-1)*pagesize+1;
		String sql = "select * from customer where customer_id!='master'";
		try{
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "select count(*) from customer";
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalrecode = rs2.getInt(1);
			}
			if(totalrecode != 0)
			{
				totalpage = totalrecode/pagesize;
			}
			if(totalrecode%pagesize != 0)
			{
				totalpage++;			
			}
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.absolute(start);
			int n = 0;
			do
			{
				CustomerVo c = new CustomerVo();
				c.setCustomer_id(rs.getString(1));
				c.setCustomer_pwd(rs.getString(2));
				c.setCustomer_name(rs.getString(3));
				c.setCustomer_addr(rs.getString(4));
				c.setCustomer_tel(rs.getString(5));
				c.setCustomer_email(rs.getString(6));
				c.setCustomer_gender(rs.getString(7));
				list.add(c);
				n++;
				if(n==pagesize)
				{
					break;
				}
			}while(rs.next());
			ConnectionProvider.close(rs2, stmt2, null);
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<MovietheaterVo> mastermovietheaterlist(int pagenum)
	{
		ArrayList<MovietheaterVo> list = new ArrayList<MovietheaterVo>();
		int start = (pagenum-1)*pagesize+1;
		String sql = "select * from movietheater";
		try{
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "select count(*) from movietheater";
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalrecode = rs2.getInt(1);
			}
			if(totalrecode != 0)
			{
				totalpage = totalrecode/pagesize;
			}
			if(totalrecode%pagesize != 0)
			{
				totalpage++;			
			}
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.absolute(start);
			int n = 0;
			do
			{
				MovietheaterVo mt = new MovietheaterVo();
				mt.setMovietheater_number(rs.getInt(1));
				mt.setMovietheater_name(rs.getString(2));
				mt.setMovietheater_loc(rs.getString(3));
				mt.setMovietheater_event(rs.getString(4));
				list.add(mt);
				n++;
				if(n==pagesize)
				{
					break;
				}
			}while(rs.next());
			ConnectionProvider.close(rs2, stmt2, null);
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<TheaterVo> mastertheaterlist(int pagenum)
	{
		ArrayList<TheaterVo> list = new ArrayList<TheaterVo>();
		int start = (pagenum-1)*pagesize+1;
		String sql = "select * from theater";
		try{
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "select count(*) from theater";
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalrecode = rs2.getInt(1);
			}
			if(totalrecode != 0)
			{
				totalpage = totalrecode/pagesize;
			}
			if(totalrecode%pagesize != 0)
			{
				totalpage++;			
			}
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.absolute(start);
			int n = 0;
			do
			{
				TheaterVo t = new TheaterVo();
				t.setTheater_number(rs.getInt(1));
				t.setTheater_seat(rs.getInt(4));
				t.setMovietheater_number(rs.getInt(5));
				list.add(t);
			}while(rs.next());
			ConnectionProvider.close(rs2, stmt2, null);
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<RunningVo> masterrunninglist(int pagenum)
	{
		ArrayList<RunningVo> list = new ArrayList<RunningVo>();
		int start = (pagenum-1)*pagesize+1;
		String sql = "select * from running order by theater_number, running_number";
		try{
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "select count(*) from running";
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalrecode = rs2.getInt(1);
			}
			if(totalrecode != 0)
			{
				totalpage = totalrecode/pagesize;
			}
			if(totalrecode%pagesize != 0)
			{
				totalpage++;			
			}
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.absolute(start);
			int n = 0;
			do
			{
				RunningVo r = new RunningVo();
				r.setRunning_number(rs.getInt(1));
				r.setTheater_number(rs.getInt(2));
				r.setMovie_number(rs.getInt(3));
				r.setRunning_date(rs.getString(4));
				r.setRunning_start(rs.getString(5));
				list.add(r);
				n++;
				if(n==pagesize)
				{
					break;
				}
			}while(rs.next());
			ConnectionProvider.close(rs2, stmt2, null);
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public String pageStr(){
		String str = "";
		for(int i=1;i<=totalPage;i++){
			str += "<a href='listMovie.com?pageNUM="+i+"'>"+i+"</a>   ";
			
			
		}
		
		
		return str;
	}
	public ArrayList<MovieVo> searchMovie(String searchField, String searchWord , String[] movie_genre,String[] movie_nation,String[] movie_grade,int firstyear,int endyear){
		ArrayList<MovieVo> list = new ArrayList<MovieVo>();
		String sql = "select * from movie";
		int cnt =0;
		//만약에 검색어가 왔다면
		if(searchWord != null && !searchWord.equals("")){
			sql +=" where "+searchField+" like '%"+searchWord+"%'";
			cnt++;
			//System.out.println(sql);
		}
		
		
		if(movie_genre != null && !movie_genre.equals("")){
			
			for(int i=0;i<movie_genre.length;i++){
				if(cnt==0 && i==0){
						sql +=" where movie_genre like '%"+movie_genre[i]+"%'";
						cnt++;
					
				}
				else if(i==0 && cnt !=0){
					sql +=" and movie_genre like '%"+movie_genre[i]+"%'";
				}
				else{
					sql +=" or movie_genre like '%"+movie_genre[i]+"%'";
				}
			}
		}
		if(movie_nation != null && !movie_nation.equals("")){
			for(int i=0;i<movie_nation.length;i++){
				if(cnt==0 && i==0){
					
						sql +=" where movie_nation like '%"+movie_nation[i]+"%'";
						cnt++;
					
				}
				else if(i==0 && cnt !=0){
					sql +=" and movie_nation like '%"+movie_nation[i]+"%'";
				}
				else{
					sql +=" or movie_nation like '%"+movie_nation[i]+"%'";
				}
			}
		}
		if(movie_grade != null && !movie_grade.equals("")){
			for(int i=0;i<movie_grade.length;i++){
				if(cnt==0 && i==0){
					sql +=" where movie_grade like '%"+movie_grade[i]+"%'";
					cnt++;
		
				}
			
				else if(i==0 && cnt!=0){
					sql +=" and movie_grade like '%"+movie_grade[i]+"%'";
				}
				else{
					sql +=" or movie_grade like '%"+movie_grade[i]+"%'";
				}
			}
		}
		
		if(firstyear!=0 && endyear != 0){
			if(cnt==0){
				sql += " where to_char(movie_opendate,'yyyy') between "+firstyear+" and "+endyear+"";
				cnt++;
			}
			else{
				sql += " and to_char(movie_opendate,'yyyy') between "+firstyear+" and "+endyear+"";
			}
		}
		System.out.println(sql);
		try{
			
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//String img = "";
			//System.out.println(rs.next());
			
			while(rs.next()){
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
				//img=rs.getString(11);
				m.setMovie_score(rs.getDouble(13));
				list.add(m);
				
			}
			n = list.size();
			//System.out.println(img);
			ConnectionProvider.close(rs, stmt, conn);
		}catch(Exception e){System.out.println(e.getMessage());}
		
		return list;
	}
	public ArrayList<EventVo> listEvent(){
		
		ArrayList<EventVo> list = new ArrayList<EventVo>();
		
		try {
			String sql ="select * from event";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				EventVo e = new EventVo();
				e.setEvent_no(rs.getInt(1));
				e.setCustomer_id(rs.getString(2));
				e.setTitle(rs.getString(3));
				e.setRegdate(rs.getString(4));
				e.setHit(rs.getInt(5));
				e.setContent(rs.getString(6));
				e.setFname(rs.getString(7));
				
				list.add(e);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("listEvent : "+e.getMessage());
		}
		
		return list;
		
	}
	public int getMax(){
		
		int no = 0;
		try {
			String sql ="select nvl(max(event_no),0)+1 from event";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				no = rs.getInt(1);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getMax : "+e.getMessage());
		}
		
		return no;
		
	}
	public int insertEvent(EventVo v)
	{
		int re = 0;
		try {
			String sql ="insert into event values(?,?,?,sysdate,?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getMax());
			pstmt.setString(2, null);
			pstmt.setString(3, v.getContent());
			pstmt.setInt(4, 0);
			pstmt.setString(5, v.getContent());
			pstmt.setString(6, v.getFname());
			re = pstmt.executeUpdate();
			if(re == 1)
			{
				re = 1;
			}
			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("insertEvent : "+ e.getMessage());
		}
		
		return re;
	}
	public int deleteEvent(int no)
	{
		int re = 0;
		try {
			String sql = "delete from event where event_no=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("deleteEvent : "+e.getMessage());
		}
		
		return re;
	}
	public EventVo detailEvent(int no){
		
		EventVo e = null;
		try {
			String sql = "select * from event where event_no=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				e = new EventVo();
				e.setEvent_no(rs.getInt(1));
				e.setCustomer_id(rs.getString(2));
				e.setTitle(rs.getString(3));
				e.setRegdate(rs.getString(4));
				e.setHit(rs.getInt(5));
				e.setContent(rs.getString(6));
				e.setFname(rs.getString(7));
			}
			
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println("detailEvent() :"+ e2.getMessage());
		}
		return e;
	}
	public int updateEvent(String title, String content, String fname, int no)
	{
		int re = 0;
		try {
			String sql ="update event set title =?, content =?, fname =? where event_no =?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, fname);
			pstmt.setInt(4, no);
			
			re = pstmt.executeUpdate();
			
			if(re == 1)
			{
				re = 1;
			}
			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("updateEvent : "+ e.getMessage());
		}
		
		return re;
		
		
	}
	public String commpagenum()
	{
		String pagenum = "";
		for(int i = 1; i <= totalpage; i++)
		{
			pagenum += "<a href='postboarddetail.com?pagenum="+i+"'>"+i+"</a> ";
		}
		return pagenum;
	}
	public ArrayList<CommentboardVo> commlist(int pagenum,int pno)
	{
		ArrayList<CommentboardVo> list = new ArrayList<CommentboardVo>();
		int start = (pagenum-1)*pagesize+1;
		String sql = "select * from commentboard where postboard_number="+pno+" order by commentboard_c_ref desc, commentboard_c_step";
		try{
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "select count(*) from commentboard";
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next())
			{
				totalrecode = rs2.getInt(1);
			}
			if(totalrecode != 0)
			{
				totalpage = totalrecode/pagesize;
			}
			if(totalrecode%pagesize != 0)
			{
				totalpage++;			
			}
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.absolute(start);
			int n = 0;
			do
			{
				CommentboardVo c = new CommentboardVo();
				c.setCommentboard_number(rs.getInt(1));
				c.setCommentboard_content(rs.getString(2));
				c.setCommentboard_regdate(rs.getString(3));
				c.setCommentboard_c_ref(rs.getInt(4));
				c.setCommentboard_c_level(rs.getInt(5));
				c.setCommentboard_c_step(rs.getInt(6));
				c.setPostboard_number(rs.getInt(7));
				list.add(c);
				n++;
				if(n == pagesize)
				{
					break;
				}
			}while(rs.next());
			ConnectionProvider.close(rs2, stmt2, null);
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public int commnum()
	{
		int no = 0;
		String sql = "select nvl(max(commentboard_number),0)+1 from commentboard";
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				no = rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return no;
	}
	public int comminsert(CommentboardVo c)
	{
		int re = -1;
		int cno = c.getCommentboard_number();
		String sql = "insert into commentboard values(?,?,sysdate,?,?,?,?)";
		try{
			Connection conn = ConnectionProvider.getConnection();
			int no = commnum();
			int c_ref = no;
			int c_level = 0;
			int c_step = 0;
			if(cno != 0)
			{
				CommentboardVo cv = commentboarddetail(cno);
				c_ref = cv.getCommentboard_c_ref();
				c_level = cv.getCommentboard_c_level();
				c_step = cv.getCommentboard_c_step();
				
				cupdatestep(c_ref,c_step);
				
				c_level++;
				c_step++;
			}			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			stmt.setString(2, c.getCommentboard_content());
			stmt.setInt(3, c_ref);
			stmt.setInt(4, c_level);
			stmt.setInt(5, c_step);
			stmt.setInt(6, c.getPostboard_number());
			re = stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public CommentboardVo commentboarddetail(int cno)
	{
		CommentboardVo c = new CommentboardVo();
		String sql = "select * from commentboard where commentboard_number = ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cno);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				c.setCommentboard_number(rs.getInt(1));
				c.setCommentboard_content(rs.getString(2));
				c.setCommentboard_regdate(rs.getString(3));
				c.setCommentboard_c_ref(rs.getInt(4));
				c.setCommentboard_c_level(rs.getInt(5));
				c.setCommentboard_c_step(rs.getInt(6));
				c.setPostboard_number(rs.getInt(7));
				
			}
			ConnectionProvider.close(rs, stmt, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return c;
	}
	public void cupdatestep(int c_ref, int c_step) {
		// TODO Auto-generated method stub
		String sql = "update commentboard set commentboard_c_step+1 where commentboard_c_ref = ? and commentboard_c_step > ?";
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, c_ref);
			stmt.setInt(2, c_step);
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}

