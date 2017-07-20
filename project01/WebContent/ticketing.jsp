<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>에매 하기</title>
<style type="text/css">
 input[type=checkbox] {
   display: none;
}

input[type=checkbox] + label{
    cursor: pointer;  
    position: relative;  
    top :4px;
    padding-left: 1px;  
    margin-right: 15px;  
    font-size: 13px;
}
 input[type=checkbox] + label:HOVER{
    cursor: pointer;    
    background-color: #935D5E
} 

input[type=checkbox] + label:BEFORE {     

    content: "";  
    display: inline-block;  
  
    width: 20px; 
    height: 20px;  
    margin-right: 15px;
    position: absolute;
    left: 0px;
    bottom: 1px;
    background-color: #0000;
    border-radius: 2px;
    box-shadow: inset 0px 1px 1px 0px rgba(0, 0, 0, .3), 0px 1px 0px 0px rgba(255, 255, 255, .8);
}
input[type=checkbox]:checked + label:BEFORE{

    content: "\2705";  /* 체크모양 */
    text-shadow: 0px 0px 0px rgba(0, 0, 0, .2);  
    font-size: 18px; 
    font-weight:800; 
    color: #0000;  
    background:#0000;
    text-align: center;  
    line-height: 18px;  

}   
</style>
<script type="text/javascript">
var origin_adult=0;
var origin_child=0;
var totsum = 0;
var str = "";
var arr = [];
function pre(){
	
history.back();

}

function aft(a,b){
   
   var n = confirm("좌석을 예매하시겠습니까?");
   if(n == true)
      {
      location.href("ticketingOk.com");
      }
}

function check_adult(seat_adult){
   origin_adult = seat_adult;
   sumtot();
   
   /* total_seat=eval(total_seat)+eval(seat_adult); */

}
function check_child(seat_child){
   origin_child=seat_child;
   sumtot();
   /* total_seat=eval(total_seat)+eval(seat_child); */

}
function sumtot()
{
   totsum = 0;
   totsum = eval(origin_adult)+eval(origin_child);
   
}

function CheckForm(n)
{
   var cnt=0;
   
   arr.push(n);
   for(i = 0; i < arr.length; i++)
      {
      for(j = i+1; j < arr.length; j++)
         {
         if(arr[i]==arr[j])
            {
            arr.splice(arr.indexOf(arr[j]),1);
            arr.splice(arr.indexOf(arr[j]),1);
            /* break; */
            }
         }
      } 
   /* alert("arr 의 인덱스  n번"+arr.indexOf(n)) */
   /* arr.splice(arr.indexOf(n),1) */
   document.getElementById("seat").innerHTML = arr;
   
   for(i = 0; i < document.chkseat.seat.length; i++)
      {
      if(document.chkseat.seat[i].checked==true && document.chkseat.seat[i].disabled != true)
         {
         cnt++;
         if(cnt > totsum)
         {
            alert("선택 인원을 초과 하셨습니다.");
            for(j = 0; j < document.chkseat.seat.length; j++)
               {
               if((document.chkseat.seat[j].value)==n)
                  {
                     document.chkseat.seat[j].checked=false;
                     /* str = str.substring(0, str.length-2); */
                  }
               }
            }
         }
      }
   
}
</script>
<style type="text/css">
div {
text-align: center;
}
#screen1{
background-color: #333333;
color: white;

}
#screen2{
text-align: center;
width:400px;
background-color: #999999;
color: white;

}
#tb{
background-color:#FFFBD4;
margin-top: 100px;
border-style: groove;

}

#btn1{
float: left;
}
#btn2{
float: right;
}
#btn3{
background-color :#333;
height :5px;
color: gray;
}

#foot{
background-color: #000000;
color: white;
}
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
<c:if test="${id!=null }">
${str }
</c:if>
</body>
</html>













