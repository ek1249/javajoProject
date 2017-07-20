<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
		<h2>영화 등록</h2>
		<form class="form-horizontal" action="updateMovieOk.com" method="post" enctype="multipart/form-data">
		
			<div class="form-group">
				<input type="hidden" name="movie_number" value="${m.movie_number }">
				<label class="control-label col-sm-2" for="movie_name">영화 제목:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_name"
						 name="movie_name" value="${m.movie_name }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_director">감독 이름:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_director"
						 name="movie_director" value="${m.movie_director }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_actor">주연 배우:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_actor"
						 name="movie_actor" value="${m.movie_actor }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_nation">개봉 국가:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_nation"
						 name="movie_nation" value="${m.movie_nation }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_runningtime">상영 시간:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_runningtime"
						name="movie_runningtime"
						value="${m.movie_runningtime }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_grade">관람 가능 등급:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_grade"
						name="movie_grade" value="${m.movie_grade }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_genre">영화 장르:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_genre"
						 name="movie_genre" value="${m.movie_genre }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_opendate">개봉일:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_opendate"
						name="movie_opendate" value="${m.movie_opendate }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">줄거리:</label>
				<div class="col-sm-8">
				<textarea class="form-control" rows="9" id="comment" name="movie_synop">${m.movie_synop }</textarea>
				
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image">포스터 이미지: ${m.movie_image}</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image"
						 name="movie_image">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_score">평점:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_score"
						 name="movie_score" value="${m.movie_score }">
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
					<input type="file" class="form-control" id="movie_image"
						 name="movie_image3">
				</div>
			</div>
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">영화 수정</button>
					<button type="reset" class="btn">취소</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>