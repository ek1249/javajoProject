<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
		<td><a href="/project01/masterpage.com"><input type="button" value="관리자 모드"></a></td>
		<td><a href="/project01/catchme.com"><input type="button" value="로그아웃"></a></td>
	</tr>
	</m:if>
	<m:if test="${cnt==2 }">
	<tr>
		<td colspan="2">${id }님 환영합니다.</td>
	</tr>
	<tr>
		<td><a href="/project01/mypage.com"><input type="button" value="회원정보"></a></td>
		<td><a href="/project01/catchme.com"><input type="button" value="로그아웃"></a></td>
	</tr>
	</m:if>
	<m:if test="${id==null }">
		<tr>
			<td>
				<form action="/project01/login.com" method="post">
					<big>ID</big> <input type="text" name="id">
					<big>PassWord</big> <input type="password" name="pwd">
					<input type="submit" value="로그인">
				</form>
			</td>
		</tr>
	</m:if>
</table>
<table cellpadding="0" cellspacing="0" align="center" width="100%">
	<tr align="center">
		<td><h1><font color="gold" size="15"><a href="/project01/main.com">Catch Movie</a></font></h1></td>
	</tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0" align="center">
	<tr align="center">
		<td>
			<div class="dropdown">
			<span>영화</span>
			  <div class="dropdown-content">
					<p><a href="/project01/listMovie.com">영화 정보</a></p>
					<p><a href="/project01/movieFinder.com">무비 파인더</a></p>
			  </div>
			</div>
		</td>
		<td>예매</td>
		<td>
			<div class="dropdown">
			  <span>영화관</span>
				  <div class="dropdown-content">
						<m:forEach var="mt" items="${mtlist }">
				    <p><a href="/project01/movietheater.com?no=${mt.movietheater_number }">${mt.movietheater_name}</a></p>
				</m:forEach>			
			  </div>
			</div>
		</td>
		<td><a href="/project01/event.com">이벤트</a></td>
		<td><a href="/project01/postboardlist.com">고객센터</a></td>
		<td><a href="/project01/boardlist.com">공지사항</a></td>
	</tr>
</table>
<hr>
<center><font size="5">${msg2 }</font></center>
<center><font size="5" color="red">${msg }</font></center>
<hr>
<form action="/project01/postboardinsertok.com" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${id }">
	<input type="hidden" name="no" value="${no }">
		<table width="100%" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td>제목 : </td>
				<td><input type="text" name="title" required="required"></td>
			</tr>
			<tr>
				<td>작성자 : </td>
				<td>${id }</td>
			</tr>		
			<tr>
				<td>문의사항</td>
				<td>
					<select name="type">
						<option value="영화문의">영화문의</option>
						<option value="예매문의">예매문의</option>
						<option value="영화관문의">영화관문의</option>
						<option value="고객문의">고객문의</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>첨부파일 : </td>
				<td colspan="2">
					<input type="file" name="fname">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" required="required"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="20" cols="30" name="content" required="required"></textarea>
				</td>
			</tr>
		</table>
	<input type="submit" value="등록">
</form>
</body>
</html>