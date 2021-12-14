<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#login {
	overflow: auto;
	list-style: none;
	border : 1px solid black;
}
#not-login {
	overflow: auto;
	list-style: none;
	width : 250px;
	text-align : center;
	margin-left : 40%;
	margin-top : 15%;
	

}

ul {
	float: left;
}

a{
	text-decoration : none;
}
</style>
</head>
<body>

	<c:choose>
		<c:when test="${not empty mem.id }">
			<nav id="login">
				<li>
					<ul>
						<a href="${pageContext.request.contextPath}/main">Main</a>
					</ul>
					<ul>
						<a href="${pageContext.request.contextPath}/members/memberinfo">내정보 보기	</a>
					</ul>
					<ul>
						<a href="${pageContext.request.contextPath}/freeboard/list">자유게시판</a>
					</ul>
					<ul>
						<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
					</ul>


				</li>
			</nav>
		</c:when>

		<c:otherwise>
			<nav id="not-login">
				<hr>
				<a href="${pageContext.request.contextPath}/members/loginform">로그인</a>
				<hr>
				<a href="${pageContext.request.contextPath}/members/joinform">일반 회원가입</a>
				<hr>
				<a href="${pageContext.request.contextPath}/members/joinadminform">관리자	등록</a>
				<hr>
			</nav>
		</c:otherwise>

	</c:choose>
			


</body>
</html>