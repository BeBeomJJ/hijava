<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#topNav {
		list-style: none;
		border : 1px solid black;
		overflow : auto;
	}

	ul {
		float: left;
	}
	


	#writeBoard{
		clear: both;
		border : 1px solid gray;
		width : 600px;
	}
	
	a{
		text-decoration : none;
	}
</style>

</head>
<body>

	<nav id="topNav">
		<li>
		
			<ul>
				<a href="${pageContext.request.contextPath}/main">Main</a>
			</ul>
			<ul>
				<a href="${pageContext.request.contextPath}/members/memberinfo">내
					정보 보기</a>
			</ul>
			<ul>
				<a href="${pageContext.request.contextPath}/freeboard/list">자유게시판</a>
			</ul>
			<c:if test="${not empty clientId }">
				<ul>
					<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
				</ul>
			</c:if>

		</li>
	</nav>
	<br>
	
	<div id="writeBoard">
		<form method="post" action="update">
			<input type="hidden" name="id" value="${freeboard.id }">
			제목 : &nbsp; <input type="text" name="title" value="${freeboard.title }" required="required"><br>
			<span id="content">내용 :</span> &nbsp;<br>
			<textarea rows="20" cols="60"  name="content" required="required">${freeboard.content }</textarea>
			<br>
			<div>
				<button type="reset">초기화</button>
				<a href="${pageContext.request.contextPath}/freeboard/freeboardDetail?id=${freeboard.id}&title=${freeboard.title}">
					<button type="button">취소</button>
				</a>
				<input type="submit" value="수정" >
			</div>
				
		</form>
	</div>
</body>
</html>