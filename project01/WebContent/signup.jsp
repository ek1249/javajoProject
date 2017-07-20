<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><font size="10" color="rainbow"><b>회원가입</b></font></center>
<hr color="silver">
<table border="1" align="center">	
	<form action="crossok.com" method="post">		
		<tr align="center" bordercolor="white">
			<td bordercolor="silver">ID</td>
			<td><input type="text" name="id" value="${id }" required="required"></td>
			<td><input type="submit" value="중복확인"></td>
		</tr>
	</form>
	<form action="signupok.com" method="post">
		<input type="hidden" name="id" value="${id }">
		<tr align="center" bordercolor="white">
			<td bordercolor="silver">PassWord</td>
			<td><input type="password" name="pw" required="required"></td>
			<td><font color="blue" size="1"><b>8자리 이상 입력 하십시오.</b></font></td>
		</tr>
		<tr align="center" bordercolor="white">
			<td bordercolor="silver">RePassWord</td>
			<td><input type="password" name="repw" required="required"></td>
		</tr>
		<tr align="center" bordercolor="white">
			<td bordercolor="silver">이름</td>
			<td><input type="text" name="name" required="required"></td>
		</tr>
		<tr align="center" bordercolor="white">
			<td bordercolor="silver">주소</td>
			<td><input type="text" name="addr" required="required"></td>
		</tr>
		<tr align="center" bordercolor="white">
			<td bordercolor="silver">전화번호</td>
			<td>
				<input type="number" name="teltop" required="required">
				-
				<input type="number" name="telmiddle" required="required">
				-
				<input type="number" name="telbottom" required="required">
			</td>
		</tr>
		<tr align="center" bordercolor="white">
			<td bordercolor="silver">e-mail</td>
			<td>
				<input type="email" name="email" required="required">
			</td>
		</tr>
		<tr align="center" bordercolor="white">
			<td bordercolor="silver">성별</td>
			<td>
				<select name="gender" required="required">
					<option value="남자">남자</option>
					<option value="여자">여자</option>
				</select>
			</td>
		</tr>
	</table>
	<table align="center">
		<tr align="center">
			<td><input type="submit" value="회원가입"></td>
			<td><a href="catchme.com"><input type="button" value="취소"></a></td>
		</tr>
	</form>
</table>
<table align="center">
	<tr>
		<td colspan="4"><font color="red"><b>${msg }</b></font></td>
		<td colspan="4"><font color="red"><b>${msg2 }</b></font></td>
	</tr>
</table>
</body>
</html>