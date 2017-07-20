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
<table cellpadding="0" cellspacing="0" align="center" width="100%">
	<tr>
		<td>
			<table width="200" align="left" height="500">
				<tr>
					<td>회원</td>
				</tr>
				<tr><td><hr></td></tr>
				<tr>
					<td><a href="mypage.com?cnt=1"><input type="button" value="회원 정보 수정"></a></td>
				</tr>
				<tr>
					<td><a href="mypage.com?cnt=2"><input type="button" value="회원  탈퇴"></a></td>
				</tr>
				<tr>
					<td>예매</td>
				</tr>
				<tr><td><hr></td></tr>
				<tr>
					<td><a href="mypage.com?cnt=3"><input type="button" value="예매 확인"></a></td>
				</tr>
				<tr>
					<td><a href="mypage.com?cnt=4"><input type="button" value="예매 취소"></a></td>
				</tr>
			</table>
		</td>
		<td>
			<table border="1" width="700" height="500">
				<m:if test="${cnt==0 }">
					<tr>
	         			<td>
         					<h3>티켓확인</h3>
							<m:choose>
							<m:when test="${list[0] ne '' }">
							<img src="img/${list[7] }" width="100px" height="150px"><br>
							영화이름: ${list[0] }
							상영날짜: ${list[1] }<br>
							상영시간: ${list[2] }
							영화관: ${list[3] }<br>
							인원수: ${list[4] }
							좌석: ${list[5] }
							</m:when>
							<m:otherwise>
							<h2>예매내역이 없습니다.</h2>
							</m:otherwise>
							</m:choose>
							<hr>
							<a href="ticketHistory.com">결제한 영화</a>
	         			</td>
					</tr>
				</m:if>
				<m:if test="${cnt==1 }">
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
											<input type="number" name="teltop">
											-
											<input type="number" name="telmiddle">
											-
											<input type="number" name="telbottom">
										</td>
									</tr>
									<tr>
										<td>이메일</td>
										<td><input type="email" name="email" value="${c.customer_email }"></td>
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
										<td colspan="4" align="center"><input type="submit" value="수정"></td>
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
				<m:if test="${cnt==2 }">
					<tr bordercolor="white">
						<td>
							<form action="customerdeleteok.com" method="post">
								<table>
									<tr>
										<td>아이디</td>
										<td><input type="text" name="id" value="${id }" readonly="readonly"></td>
									</tr>
									<tr>
										<td>비밀번호</td>
										<td><input type="password" name="pwd"></td>
									</tr>
									<tr align="center">
										<td colspan="2"><input type="submit" value="삭제"></td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==3 }">
					<tr bordercolor="white">
						<td>
							<h3>티켓확인</h3>
							<m:choose>
							<m:when test="${list[0] ne '' }">
							<img src="img/${list[7] }" width="100px" height="150px"><br>
							영화이름: ${list[0] }
							상영날짜: ${list[1] }<br>
							상영시간: ${list[2] }
							영화관: ${list[3] }<br>
							인원수: ${list[4] }
							좌석: ${list[5] }
							</m:when>
							<m:otherwise>
							<h2>예매내역이 없습니다.</h2>
							</m:otherwise>
							</m:choose>
							<hr>
							<a href="ticketHistory.com">결제한 영화</a>
						</td>
					</tr>
				</m:if>
				<m:if test="${cnt==4 }">
					<tr bordercolor="white">
						<td>
							<h3>티켓확인</h3>
							<m:choose>
							<m:when test="${list[0] ne '' }">
							<img src="img/${list[7] }" width="100px" height="150px"><br>
							영화이름: ${list[0] }
							상영날짜: ${list[1] }<br>
							상영시간: ${list[2] }
							영화관: ${list[3] }<br>
							인원수: ${list[4] }
							좌석: ${list[5] }
							<a href="ticketCancel.com?ticket_number=${list[6] }"><h3>티켓취소</h3></a>
							</m:when>
							<m:otherwise>
							<h2>예매내역이 없습니다.</h2>
							</m:otherwise>
							</m:choose>
							<hr>
							<a href="ticketHistory.com">결제한 영화</a>
						</td>
					</tr>
				</m:if>
			</table>
		</td>
	</tr>
</table>
</body>
</html>