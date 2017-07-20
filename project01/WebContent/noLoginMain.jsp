<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core"%>
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
<font color="red"><b>${msg }</b></font>
<font color="red"><b>${msg2 }</b></font>
<table width="100%" cellpadding="0" cellspacing="0" align="center">
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
	<tr align="center">
		<td><h1><font color="gold" size="15">Catch Me</font></h1></td>
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
<table width="100%" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td colspan="3" align="center" bgcolor="beige">영화 순위</td>
		<td rowspan="12" align="center">
		<table>
			<tr>
				<td>
					<form action="catchme.com" method="post">
						<input type="hidden" name="btn" value="1">
						<input type="submit" value="◀">
					</form>
				</td>
				<td><img src="img/${img }" width="700" height="500"></td>
				<td>
					<form action="catchme.com" method="post">
						<input type="hidden" name="btn" value="2">
						<input type="submit" value="▶">
					</form>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr align="center" bgcolor="beige">
		<td>순위</td>
		<td>제목</td>
		<td>평점</td>
	</tr>
	<m:forEach var="sm" items="${scorelist }">
		<tr bgcolor="beige">
			<td align="center">${sm.rownum }</td>
			<td align="center"><a href="catchme.com?img=${sm.movie_image }">${sm.movie_name }</a></td>
			<td align="center">${sm.movie_score }</td>
		</tr>
	</m:forEach>
</table>

</body>
</html>