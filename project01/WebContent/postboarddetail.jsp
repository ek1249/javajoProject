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
<table border="1" width="50%" cellpadding="0" cellspacing="0" align="center">
	<tr align="center" bordercolor="white">
		<td>제목 : </td>
		<td>${p.postboard_title }</td>
	</tr>
	<tr align="center" bordercolor="white">
		<td>작성자 : </td>
		<td>${p.customer_id }</td>
	</tr>
	<tr align="center" bordercolor="white">
		<td>작성일 : </td>
		<td>${p.postboard_regdate }</td>
	</tr>
	<tr align="center" bordercolor="white">
		<td>조회수 : </td>
		<td>${p.postboard_hit }</td>
	</tr>
	<tr align="center" bordercolor="white">
		<td>작성자 IP : </td>
		<td>${p.postboard_ip }</td>
	</tr>
	<tr align="center" bordercolor="white">
		<td>문의 사항 : </td>
		<td>${p.postboard_type }</td>
	</tr>
	<m:if test="${n2==1 }">
	<tr align="center" bordercolor="white">
		<td>첨부파일 : </td>
		<td><img src="img/${p.postboard_fname }" width="300" height="200"></td>
	</tr>
	</m:if>
	<tr align="center" bordercolor="white">
		<td colspan="2">내용 : </td>
	</tr>
	<tr align="center" bordercolor="white">
		<td colspan="2" width="400" height="200">${p.postboard_content }</td>
	</tr>
</table>
<m:if test="${id!=null }">
<form action="postboarddetail.com" method="post">
	<table align="center">
		<tr>
			<td><textarea rows="2" cols="45" name="content"></textarea></td>
			<td><input type="submit" value="등록"></td>
		</tr>
	</table>
</form>
</m:if>
<table width="50%" cellpadding="0" cellspacing="0" align="center">
	<m:forEach var="cl" items="${clist }">
		<tr>
			<td>${cl.commentboard_number }</td>
			<td>
			<m:if test="${cl.commentboard_c_level>0 }">
				<m:forEach var="i" begin="1" end="${cl.commentboard_c_level }">
					&nbsp;&nbsp;
				</m:forEach>
			</m:if>
			<td>${cl.commentboard_content }</td>
			<td>${p.postboard_regdate }</td>
			<%-- <td><a href="postboarddetail.com?cno=${cl.commentboard_number }"><input type="button" value="답글등록"></a></td> --%>
		</tr>
	</m:forEach>
</table>
<center>${pagenum }</center>
<table align="right">
	<tr>
		<m:if test="${n==2 }">
		<td><a href="javajo/postboardinsert.jsp?no=${p.postboard_number }"><input type="button" value="답글달기"></a></td>
		<td><a href="postboardupdate.com?no=${p.postboard_number }"><input type="button" value="수정"></a></td>
		<td><a href="postboarddelete.com?no=${p.postboard_number }"><input type="button" value="삭제"></a></td>
		</m:if>
		<m:if test="${n==1 }">
		<td><a href="postboardupdate.com?no=${p.postboard_number }"><input type="button" value="수정"></a></td>
		<td><a href="postboarddelete.com?no=${p.postboard_number }"><input type="button" value="삭제"></a></td>
		</m:if>
	</tr>
</table>

</body>
</html>