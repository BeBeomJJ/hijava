<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freeboard insert</title>
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
	textarea{
		display : inline;
	}
	#content{
		vertical-align : top;
	}
	form div{
		
		width : 150px;
		margin-left : 75%;
	}
	input[type=submit]{
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
				<a href="../members/memberinfo">내
					정보 보기</a>
			</ul>
			<ul>
				<a href="../freeboard/list">자유게시판</a>
			</ul>
			<c:if test="${not empty clientId }">
				<ul>
					<a href="../logout">로그아웃</a>
				</ul>
			</c:if>

		</li>
	</nav>
	<br>

	


	<div id="writeBoard">
		<form method="post" action="insert">
			제목 : &nbsp; <input type="text" name="title" required="required"><br>
			<span id="content">내용 :</span> &nbsp; <textarea id="contents" rows="20" cols="60"  name="content" required="required" ></textarea><br>
			<div>
				<button type="reset">초기화</button>
				<a href="list">
					<button type="button">취소</button>
				</a>
				
				<input type="submit" value="등록" >
			</div>
				
		</form>
	</div>
	

</body>
</html>