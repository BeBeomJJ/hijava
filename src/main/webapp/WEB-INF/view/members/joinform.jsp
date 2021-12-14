<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
	form{
		margin-left : 40%;
		margin-top : 15%;
	}
	label{
		display : inline-block;
		width : 70px;
	}
	input[type=submit]{
		margin-left : 12%;
	}
	
	a{
		text-decoration : none;
	}
	button{
		margin-left : 47.2%;	
	}
</style>
</head>
<body>
	<div>
		<form method="post" action="/securityexam/members/join">
		  <div>
		    <label>이름</label>
		    <input type="text" name="name" required="required">
		  </div>
		  <br>
		  <div>
		    <label>비밀번호</label>
		    <input type="password" name="password" required="required">
		  </div>
		  <br>
		  <div>
		    <label>이메일</label>
		    <input type="text" name="email" required="required">
		  </div>
		  <br>
		  <div>
		    <input type="submit" value="가입하기">
		  </div>
		</form>
		<br>
		<button type="button">
		  <a href="${pageContext.request.contextPath }/main">메인으로</a>
		</button> 
	</div>
</body>
</html>