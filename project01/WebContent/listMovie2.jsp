<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script type="text/javascript">
 var str="";
 function pro() {
   var n = confirm("메인으로 가시겠습니까?");
    if(n)
       {
   history.back();
       }
}
 
 
 function chk(n){
    str+=n
    
    document.getElementById("msg").innerHTML = str;
    
 }
 
 
 </script>

  
</head>
<div class="container"  style="background-color:#FFFBD4">
<body >
<h2 style="background-color:#000000"align="center"><font color="#FFFFFF">예매</font></h2>
${ticket_str }

<hr>
 <table align="right">
   <form action="ticketing.com" method="post">
      <input type="hidden" name="m_num" value="${m_num }">
      <input type="hidden" name="mt_num" value="${mt_num }">
      <input type="hidden" name="r_date" value="${r_date }">
      <input type="hidden" name="r_num" value="${r_num }">
      <input type="hidden" name="t_num" value="${t_num }">
   <m:if test="${id!=null }">
   <tr>
   <td><input type="button" class="btn btn-danger" value="이전" onclick="pro()"></td>
   <td><input type="submit" class="btn btn-primary" value="다음"></td>
   </tr>
   </m:if>
</tr>
   </form>
   </table>
<table border="0" width="100%" height="800" align="center">
<tr>
<td>
<h2 style="background-color:#BDBDBD ">영화</h2>

<hr>
<div style="width:100%; height:500px; overflow:auto; overflow-y:scroll">
<table  border="1" width="300" height="300" align="left">

   <c:forEach var ="m" items="${list }">
   <tr>
      <td><a href="listMovie2.com?movie_number=${m.movie_number }"  >${m.movie_name }</a></td>
   </tr>   
   </c:forEach>
   
</table>
</div>
</td>
<td>
<h2 style="background-color:#BDBDBD ">영화관</h2>
<hr>
<div style="width:100%; height:500px; overflow:auto; overflow-y:scroll">
<table  border="1" width="200" height="300" align="left">

   <c:forEach var="mt" items="${list_mt }">
   <tr>
      <td><a href="listMovie2.com?movie_number=${mt.movie_number}&movietheater_number=${mt.movietheater_number }">${mt.movietheater_name }</a></td>
   </tr>
   </c:forEach>
   </table>
   </div>
</td>
<td>
<h2 style="background-color:#BDBDBD ">상영날짜</h2>
<hr>
<div style="width:100%; height:500px; overflow:auto; overflow-y:scroll">
<table border="1" width="200" height="300" align="left" >

   <c:forEach var="r" items="${list_r }">
   <tr>
      <td><a href="listMovie2.com?movie_number=${r.movie_number}&movietheater_number=${r.movietheater_number }&running_date=${r.running_date}"> ${r.running_date }</a></td>
   </tr>
   </c:forEach>
   </table>
   </div>
</td>
<td>
<h2 style="background-color:#BDBDBD ">시간</h2>
<hr>
<div style="width:100%; height:500px; overflow:auto; overflow-y:scroll">
<table border="1" width="300" height="300" align="left" >

   <c:forEach var="re" items="${list_re }">
   <tr>
      <td><a href="listMovie2.com?movie_num=${re.movie_number}&movietheater_num=${re.movietheater_number }&running_dt=${re.running_date}&running_num=${re.running_number}&theater_num=${re.theater_number}">제${re.theater_number }상영관, 시작시간: ${re.running_start }</a></td>
   </tr>
   </c:forEach>
   </table>
   </div>

</td>
</tr>
</table>
  
</body>
</html>