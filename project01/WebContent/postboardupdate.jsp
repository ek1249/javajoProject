<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
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
<form action="postboardupdateok.com" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${p.postboard_number }">
	<input type="hidden" name="oldfname" value="${p.postboard_fname }">
	<input type="hidden" name="id" value="${id }">
		<table width="100%" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td>제목 : </td>
				<td><input type="text" name="title" value="${p.postboard_title }"></td>
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
				<td>${p.postboard_fname}</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name="newfname">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" required="required"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="20" cols="30" name="content">${p.postboard_content }</textarea>
				</td>
			</tr>
		</table>
	<input type="submit" value="수정">
</form>
</body>
</html>