<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <title id="movie_title">${m.movie_name }&lt;영화상세 &lt; 영화 | 캐치무비</title>
    

</head>
<body>
<div class="container-fluid">
    <div class="row">
    <p>
    <div class="col-md-2" style="float:left;"> <h2 align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;영화상세</strong></h2></div>
 
    <div class="col-md-1" style="float:left;"> <a href="updateMovie.com?movie_number=${m.movie_number }"><button type="button" class="btn btn-primary" >수정</button></a> </div>
	
    </p>
    </div>
	</div>


<hr>
<div class="container">

 
<div class="row">
	<div class="col-md-3">
	 <a href="upload2/${m.movie_image }" title="포스터 크게 보기 새창" target="_blank">
	<img alt="${m.movie_name } 새창" src="upload2/${m.movie_image }" width="220" height="340" style="display: block;">포스터 크게 보기
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
        <img src="upload2/${m.movie_image1 }" alt="${m.movie_image1 }" style="width:100%;">
      </div>

      <div class="item">
        <img src="upload2/${m.movie_image2 }"  alt="${m.movie_image2 }" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="upload2/${m.movie_image3 }" alt="${m.movie_image3 }" style="width:100%;">
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



</body>
</html>