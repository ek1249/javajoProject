<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <title id="movie_title">${m.movie_name }&lt;영화상세 &lt; 영화 | 캐치무비</title>
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
<div class="container-fluid">
    <div class="row">
    <p>
    <div class="col-md-2" style="float:left;"> <h2 align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;영화상세</strong></h2></div>
 	<m:if test="${n==1 }">
    	<div class="col-md-1" style="float:left;"> <a href="updateMovie.com?movie_number=${m.movie_number }"><button type="button" class="btn btn-primary" >수정</button></a> </div>
	</m:if>
    </p>
    </div>
	</div>


<hr>
<div class="container">

 
<div class="row">
	<div class="col-md-3">
	 <a href="img/${m.movie_image }" title="포스터 크게 보기 새창" target="_blank">
	<img alt="${m.movie_name } 새창" src="img/${m.movie_image }" width="220" height="340" style="display: block;">포스터 크게 보기
	</a>
	</div>
	<div style="float: left;">
		<h3><strong>${m.movie_name }</strong></h3>
		<br>
		<label><b>감독 : ${m.movie_director } / </b></label>
		<label><b>주연 배우 :${m.movie_actor }</b></label><br>
		<label><b>장르 : ${m.movie_genre }</b></label>&nbsp;&nbsp;/&nbsp;&nbsp;
		<label><b>기본 :&nbsp; ${m.movie_grade },&nbsp; ${m.movie_runningtime }분,
		&nbsp;${m.movie_nation }</b></label><br>
		<label><b>개봉 :&nbsp; ${m.movie_opendate }</b></label><br>
		<br>
			<%-- <label>${m.movie_synop }</label> --%>
	</div>
</div>
<br><br><br>
<hr>
<div class="row">
	 <div class="col-md-10" style="line-height: 3.0em">
		<label>${m.movie_synop }</label>
	
	</div> 

</div>

<br><br>

<div class="container">
    <h3><strong>스틸 이미지</strong></h3>  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
          <img src="img/${m.movie_image1 }" alt="${m.movie_image1 }" style="width:100%;">
      </div>
      <div class="item">
        <img src="img/${m.movie_image2 }" alt="${m.movie_image2 }" style="width:100%;">
      </div>
       <div class="item">
        <img src="img/${m.movie_image3 }" alt="${m.movie_image3 }" style="width:100%;">
     	 </div>
     	
   </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>



</div>



</body>
</html>