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
#topNav {
	list-style: none;
	border : 1px solid black;
	overflow : auto;
}

ul {
	float: left;
}
#middleDiv{
	clear: both;
	border : 1px solid black;
	width : 600px;
	height : auto;
}


#writebutton{
	float : right;
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

	<div id="middleDiv">
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="freeboard">
					<tr>
						<td>${freeboard.number }</td>
						<td>
							<a href="freeboardDetail?id=${freeboard.id}&title=${freeboard.title}">${freeboard.title }</a>
						</td>
						<td>${freeboard.memberEmail }</td>
						<td>${freeboard.createDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<div id="writebutton">
			<button type="button">
				<a href="insertform">글쓰기</a>
			</button>
		</div>
	</div>
	
	<br>

	<c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
		<a href="list?start=${pageIndex}">${status.index +1 }</a>&nbsp; &nbsp;
	</c:forEach>

</body>
</html>