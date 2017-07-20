<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	<div class="container">
		<h2>영화 등록</h2>
		<form class="form-horizontal" action="insertMovieOk.com" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_name">영화 제목:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_name"
						placeholder="영화 제목을 써주세요." name="movie_name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_director">감독 이름:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_director"
						 name="movie_director">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_actor">주연 배우:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_actor"
						 name="movie_actor">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_nation">개봉 국가:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_nation"
						 name="movie_nation">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_runningtime">상영 시간:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_runningtime"
						placeholder="러닝타임 작성예)140" name="movie_runningtime">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_grade">관람 가능 등급:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_grade"
						name="movie_grade">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_genre">영화 장르:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_genre"
						 name="movie_genre">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_opendate">개봉일:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_opendate"
						placeholder="작성예) yyyy/mm/dd" name="movie_opendate">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">줄거리:</label>
				<div class="col-sm-8">
				<textarea class="form-control" placeholder="줄거리를 입력해 주세요!" rows="9" id="comment" name="movie_synop"></textarea>
				
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image">포스터 이미지:</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image"
						 name="movie_image">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_score">평점:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_score"
						placeholder="관리자는 평점 0으로 넣어주세요." name="movie_score">
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image1">스틸 이미지1:</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image1"
						 name="movie_image1">
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image2">스틸 이미지2:</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image2"
						 name="movie_image2">
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image3">스틸 이미지3:</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image3"
						 name="movie_image3">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">영화 등록</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>