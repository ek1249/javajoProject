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
<table border="1" cellpadding="0" cellspacing="0" align="center" width="100%">
	<tr align="center">
		<td>
			<table width="150" align="left" height="300" border="1">
				<tr bordercolor="white" align="center">
					<td><a href="masterpage.com?cnt=1"><input type="button" value="회원 리스트"></a></td>
				</tr>
				<tr bordercolor="white" align="center">
					<td><a href="masterpage.com?cnt=2"><input type="button" value="영화 리스트"></a></td>
				</tr>
				<tr bordercolor="white" align="center">
					<td><a href="masterpage.com?cnt=3"><input type="button" value="영화관 리스트"></a></td>
				</tr>
				<tr bordercolor="white" align="center">
					<td><a href="masterpage.com?cnt=4"><input type="button" value="상영관 리스트"></a></td>
				</tr>
				<tr bordercolor="white" align="center">
					<td><a href="masterpage.com?cnt=5"><input type="button" value="상영 시간 리스트"></a></td>
				</tr>
				<tr bordercolor="white" align="center">
					<td><a href="masterpage.com?cnt=6"><input type="button" value="게시판 리스트"></a></td>
				</tr>
				<tr bordercolor="white" align="center">
					<td><a href="masterpage.com?cnt=7"><input type="button" value="공지사항 리스트"></a></td>
				</tr>
			</table>
		</td>
		<td>
			<table border="1" width="750" height="300" align="center">
				<m:if test="${cnt==1 }">
					<tr>
						<td>
							<table border="1" align="center">
								<tr>
									<td>회원 아이디</td>
									<td>회원 이름</td>
									<td>회원 주소</td>
									<td>회원 이메일</td>
									<td>회원 성별</td>
								</tr>
								<m:forEach var="cl" items="${clist }">
									<tr>
										<td><a href="masterpage.com?id=${cl.customer_id }">${cl.customer_id }</a></td>
										<td>${cl.customer_name }</td>
										<td>${cl.customer_addr }</td>
										<td>${cl.customer_email }</td>
										<td>${cl.customer_gender }</td>
									</tr>
								</m:forEach>
									<tr bordercolor="white" align="center">
										<td colspan="5">${pagenum }</td>
									</tr>
							</table>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==2 }">
					<tr>
						<td>
							<table align="center" border="1" bordercolor="white">
								<tr>
									<td>영화 번호</td>
									<td>영화 제목</td>
									<td>영화 개봉일</td>
								</tr>
								<m:forEach var="ml" items="${mlist }">
									<tr>
										<td>${ml.movie_number }</td>
										<td><a href="detailMovie.com?movie_number=${ml.movie_number }">${ml.movie_name }</a></td>
										<td>${ml.movie_opendate }</td>
									</tr>
								</m:forEach>
									<tr bordercolor="white" align="center">
										<td colspan="3">${pagenum }</td>
									</tr>
									<tr align="right" bordercolor="white">
										<td colspan="3"><a href="insertMovie.com"><input type="button" value="영화 등록"></a></td>
									</tr>
							</table>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==3 }">
					<tr>
						<td>
							<table align="center" border="1" bordercolor="white">
								<tr>
									<td>영화관 번호</td>
									<td>영화관 이름</td>
									<td>영화관 위치</td>
								</tr>
								<m:forEach var="mtl" items="${mtlist }">
									<tr>
										<td>${mtl.movietheater_number }</td>
										<td><a href="movietheater.com?no=${mtl.movietheater_number }">${mtl.movietheater_name }</a></td>
										<td>${mtl.movietheater_loc }</td>
									</tr>
								</m:forEach>
									<tr bordercolor="white" align="center">
										<td colspan="3">${pagenum }</td>
									</tr>
							</table>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==4 }">
					<tr>
						<td>
							<table align="center" border="1" bordercolor="white">
								<tr>
									<td>영화관 번호</td>
									<td>상영관 번호</td>
									<td>상영관 좌석 수</td>
								</tr>
								<m:forEach var="tl" items="${tlist }">
									<tr>
										<td>${tl.movietheater_number }</td>
										<td><a href="movietheater.com?no=${tl.movietheater_number }">${tl.theater_number }</a></td>
										<td>${tl.theater_seat }</td>
									</tr>
								</m:forEach>
									<tr bordercolor="white" align="center">
										<td colspan="3">${pagenum }</td>
									</tr>
							</table>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==5 }">
					<tr>
						<td>
							<table align="center" border="1" bordercolor="white">
								<tr>
									<td>상영 번호</td>
									<td>상영 날짜</td>
									<td>상영 시작 시간</td>
									<td>상영관 번호</td>
									<td>영화 번호</td>
								</tr>
								<m:forEach var="rl" items="${rlist }">
									<tr>
										<td><a href="movietheater.com?no=1">${rl.running_number }</a></td>
										<td>${rl.running_date }</td>
										<td>${rl.running_start }</td>
										<td>${rl.theater_number }</td>
										<td>${rl.movie_number }</td>
									</tr>
								</m:forEach>
									<tr bordercolor="white" align="center">
										<td colspan="5">${pagenum }</td>
									</tr>
							</table>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==6 }">
					<tr>
						<td>
							<table align="center" border="1" bordercolor="white">
								<tr>
									<td>게시글 번호</td>
									<td>게시글 제목</td>
									<td>게시글 작성자</td>
									<td>게시글 작성일</td>
									<td>게시글 조회수</td>
								</tr>
								<m:forEach var="pl" items="${plist }">
									<tr>
										<td>${pl.postboard_number }</td>
										<td>
										<m:if test="${pl.postboard_p_level>0 }">
											<m:forEach var="i" begin="1" end="${pl.postboard_p_level }">
												&nbsp;&nbsp;
											</m:forEach>
										</m:if>
										<a href="postboarddetail.com?no=${pl.postboard_number }">${pl.postboard_title }</a></td>
										<td>${pl.customer_id }</td>
										<td>${pl.postboard_regdate }</td>
										<td>${pl.postboard_hit }</td>
									</tr>
								</m:forEach>
								<tr bordercolor="white" align="center">
									<td colspan="5">${pagenum }</td>
								</tr>
							</table>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==7 }">
					<tr>
						<td>
							<table align="center" border="1" bordercolor="white">
								<tr>
									<td>공지사항 번호</td>
									<td>공지사항 제목</td>
									<td>공지사항 작성일</td>
								</tr>
								<m:forEach var="bl" items="${blist }">
									<tr align="center">
										<td>${bl.board_number }</td>
										<td>
										<a href="boarddetail.com?no=${bl.board_number }">${bl.board_title }</a></td>
										<td>${bl.board_regdate }</td>
									</tr>
								</m:forEach>
								<tr bordercolor="white" align="center">
									<td colspan="5">${pagenum }</td>
								</tr>
							</table>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==8 }">
					<tr>
						<td>
							<form action="customerupdateok.com" method="post">
								<table>
									<tr>
										<td>아이디</td>
										<td><input type="text" name="id" value="${c.customer_id }" readonly="readonly"></td>
									</tr>
									<tr>
										<td>비밀번호</td>
										<td><input type="password" name="pw" value="${c.customer_pwd }"></td>
										<td><font color="blue" size="1"><b>8자리 이상 입력 하십시오.</b></font></td>
									</tr>
									<tr>
										<td>비밀번호 재입력</td>
										<td><input type="password" name="repw"></td>
									</tr>
									<tr>
										<td>이름</td>
										<td><input type="text" name="name" value="${c.customer_name }"></td>
									</tr>
									<tr>
										<td>주소</td>
										<td><input type="text" name="addr" value="${c.customer_addr }"></td>
									</tr>
									<tr>
										<td>전화</td>
										<td>
											<input type="text" name="teltop">
											-
											<input type="text" name="telmiddle">
											-
											<input type="text" name="telbottom">
										</td>
									</tr>
									<tr>
										<td>이메일</td>
										<td><input type="text" name="email" value="${c.customer_email }"></td>
									</tr>
									<tr>
										<td>성별</td>
										<td>
											<select name="gender">
												<option value="남자">남자</option>
												<option value="여자">여자</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan="2" align="right"><input type="submit" value="수정"></td>
										<td colspan="2" align="left"><a href="customerdeleteok.com?id=${c.customer_id }&pwd=${c.customer_pwd}"><input type="button" value="삭제"></a></td>
									</tr>
									<tr>
										<td colspan="4">
											<font color="red">${msg }</font>
										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</m:if>
			</table>
		</td>
	</tr>
</table>
</body>
</html>