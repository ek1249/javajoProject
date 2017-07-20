<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {
	text-decoration: none;
	}
	.dropdown {
	    position: relative;
	    display: inline-block;
	}
	
	.dropdown-content {
	    display: none;
	    position: absolute;
	    background-color: white;
	    min-width: 100px;
	    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	    padding: 1px 1px;
	    z-index: 1;
	}
	
	.dropdown:hover .dropdown-content {
	    display: block;
	}
</style>
</head>
<body>
<table cellpadding="0" cellspacing="0" align="left">
	<m:if test="${cnt==1 }">
	<tr>
		<td colspan="2">${id }님 환영합니다.</td>
	</tr>
	<tr>
		<td><a href="masterpage.com"><input type="button" value="관리자 모드"></a></td>
		<td><a href="catchme.com"><input type="button" value="로그아웃"></a></td>
	</tr>
	</m:if>
	<m:if test="${cnt==2 }">
	<tr>
		<td colspan="2">${id }님 환영합니다.</td>
	</tr>
	<tr>
		<td><a href="mypage.com"><input type="button" value="회원정보"></a></td>
		<td><a href="catchme.com"><input type="button" value="로그아웃"></a></td>
	</tr>
	</m:if>
	<m:if test="${id==null }">
		<tr>
			<td>
				<form action="login.com" method="post">
					<big>ID</big> <input type="text" name="id">
					<big>PassWord</big> <input type="password" name="pwd">
					<input type="submit" value="로그인">
				</form>
			</td>
		</tr>
		<tr>
			<td><a href="signup.com">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="idserch.com">아이디</a>/<a href="pwdserch.com">비밀번호 찾기</a></td>
		</tr>
	</m:if>
</table>
<table cellpadding="0" cellspacing="0" align="center" width="100%">
	<tr align="center">
		<td><h1><font color="gold" size="15"><a href="main.com">Catch Movie</a></font></h1></td>
	</tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0" align="center">
	<tr align="center">
		<td>
			<div class="dropdown">
			<span>영화</span>
			  <div class="dropdown-content">
					<p><a href="listMovie.com">영화 정보</a></p>
					<p><a href="movieFinder.com">무비 파인더</a></p>
			  </div>
			</div>
		</td>
		<td><a href="listMovie2.com">예매</a></td>
		<td>
			<div class="dropdown">
			  <span>영화관</span>
				  <div class="dropdown-content">
						<m:forEach var="mt" items="${mtlist }">
				    <p><a href="movietheater.com?no=${mt.movietheater_number }">${mt.movietheater_name}</a></p>
				</m:forEach>			
			  </div>
			</div>
		</td>
		<td><a href="event.com">이벤트</a></td>
		<td><a href="postboardlist.com">고객센터</a></td>
		<td><a href="boardlist.com">공지사항</a></td>
	</tr>
</table>
<hr>
<table align="center" width="100%">
	<tr align="center">
		<td><font size="15">${mtd.movietheater_name }</font></td>
	</tr>
</table>
<table border="1" bordercolor="gold" width="80%" cellpadding="0" cellspacing="0" align="center">
	<tr align="center" bordercolor="white">
		<m:forEach var="t" items="${th }">
			<td><a href="movietheater.com?tno=${t.theater_number }">${t.theater_number }상영관</a></td>
		</m:forEach>
	</tr>
</table>
<table border="1" bordercolor="gold" width="80%" cellpadding="0" cellspacing="0" align="center">
	<tr align="center" bordercolor="white">
		<m:forEach var="rd" items="${rd }">
			<td><a href="movietheater.com?date=${rd.running_date }">${rd.running_date }</a></td>
		</m:forEach>
	</tr>
</table>
<table border="1" bordercolor="gold" width="80%" cellpadding="0" cellspacing="0" align="center">
	<tr align="center" bordercolor="white">
		<td>영화 포스터</td>
		<td>영화 이름</td>
		<td>상영 날짜</td>
		<td>상영 시작 시간</td>
	</tr>
	<m:forEach var="rt" items="${rt }">
		<tr align="center" bordercolor="white">
			<td><img src="img/${rt.movie_image }" width="50" height="50"></td>
			<td>${rt.movie_name }</td>
			<td>${rt.running_date }</td>
			<td>${rt.running_start }</td>
		</tr>
	</m:forEach>
</table>
<m:if test="${id2==1 }">
<table cellpadding="0" cellspacing="0" align="right">
	<tr>
		<td><a href="movietheateradd.com"><input type="button" value="영화관 추가"></a></td>
		<td><a href="theateradd.com"><input type="button" value="상영관 추가"></a></td>
		<td><a href="runningadd.com"><input type="button" value="상영시간표 추가"></a></td>
	</tr>
	<tr>
		<td><a href="movietheaterupdate.com?no=${mtd.movietheater_number }"><input type="button" value="영화관 수정"></a></td>
		<td><a href="theaterupdate.com"><input type="button" value="상영관 수정"></a></td>
		<td><a href="runningupdate.com"><input type="button" value="상영시간표 수정"></a></td>
	</tr>
	<tr>
		<td><a href="movietheaterdelete.com?no=${mtd.movietheater_number }"><input type="button" value="영화관 삭제"></a></td>
		<td><a href="theaterdelete.com"><input type="button" value="상영관 삭제"></a></td>
		<td><a href="runningdelete.com"><input type="button" value="상영시간표 삭제"></a></td>
	</tr>
</table>
</m:if>
</body>
</html>