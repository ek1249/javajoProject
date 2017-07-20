package com.javajo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javajo.db.ConnectionProvider;
import com.javajo.vo.JavajoVo;



public class JavajoDao {
	
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
	
	

	//페이징 문자열을 반환하는 메소드
		public String pageStr(){
			String str = "";
			for(int i=1;i<=totalPage;i++){
				str += "<a href='listMovie.com?pageNUM="+i+"'>"+i+"</a>   ";
				
				
			}
			
			
			return str;
		}
		
		/*public ArrayList<JavajoVo> getImage(int movie_number){
			ArrayList<JavajoVo> list = new ArrayList<JavajoVo>();
			String sql = "select image01,image02,image03 from image where item_key=?";
			
			try{
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, movie_number);
				ResultSet rs =  pstmt.executeQuery();
				if(rs.next()){
					JavajoVo j = new JavajoVo();
					j.setImage01(rs.getString(1));
					j.setImage02(rs.getString(2));
					j.setImage03(rs.getString(3));
					list.add(j);
				}
				ConnectionProvider.close(rs, pstmt, conn);
			}catch(Exception e){System.out.println(e.getMessage());}
			
			
			return list;
		}*/
	
	public int getNextNo()
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
	
	public int insertMovie(JavajoVo m){
		int re = -1;
		String sql = "insert into movie values(?,?,?,?,?,?,?,?,?,?,?,null,?,?,?,?)";
		try{
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int no = getNextNo();
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
	//
	public ArrayList<JavajoVo> listMovie(int pageNUM){
		
		//this.pageNUM = pageNUM;
		
		ArrayList<JavajoVo> list = new ArrayList<JavajoVo>();
		
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
				JavajoVo m = new JavajoVo();
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
	
	
	
	
	public ArrayList<JavajoVo> searchMovie(String searchField, String searchWord , String[] movie_genre,String[] movie_nation,String[] movie_grade,int firstyear,int endyear){
		ArrayList<JavajoVo> list = new ArrayList<JavajoVo>();
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
				JavajoVo m = new JavajoVo();
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
	
	public JavajoVo getMovie(int movie_number){
		JavajoVo j = new JavajoVo();
		
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
				//무비 트레일러 12번 
				j.setMovie_score(rs.getDouble(13));
				j.setMovie_image1(rs.getString(14));
				j.setMovie_image2(rs.getString(15));
				j.setMovie_image3(rs.getString(16));
				System.out.println(rs.getString(14));
				System.out.println(rs.getString(15));
				System.out.println(rs.getString(16));
				
			}
			ConnectionProvider.close(rs, pstmt, conn);
			
		}catch(Exception e){System.out.println(e.getMessage());}
		
		return j;
	}
	
	
	public int updateMovie(JavajoVo m){
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
	

	
}
