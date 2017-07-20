<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>
	<div class="container">
		<h2>영화 등록</h2>
		<form class="form-horizontal" action="insertMovieOk.com" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_name">영화 제목:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_name"
						placeholder="영화 제목을 써주세요." name="movie_name" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_director">감독 이름:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_director"
						 name="movie_director" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_actor">주연 배우:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_actor"
						 name="movie_actor" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_nation">개봉 국가:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_nation"
						 name="movie_nation" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_runningtime">상영 시간:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_runningtime"
						placeholder="러닝타임 작성예)140" name="movie_runningtime" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_grade">관람 가능 등급:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_grade"
						name="movie_grade" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_genre">영화 장르:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_genre"
						 name="movie_genre" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_opendate">개봉일:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_opendate"
						placeholder="작성예) yyyy/mm/dd" name="movie_opendate" required="required">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">줄거리:</label>
				<div class="col-sm-8">
				<textarea class="form-control" placeholder="줄거리를 입력해 주세요!" rows="9" id="comment" name="movie_synop" required="required"></textarea>
				
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image">포스터 이미지:</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image"
						 name="movie_image" required="required">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_score">평점:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="movie_score"
						placeholder="관리자는 평점 0으로 넣어주세요." name="movie_score" required="required">
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image1">스틸 이미지1:</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image1"
						 name="movie_image1" required="required">
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image2">스틸 이미지2:</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image2"
						 name="movie_image2" required="required">
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="movie_image3">스틸 이미지3:</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="movie_image3"
						 name="movie_image3" required="required">
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