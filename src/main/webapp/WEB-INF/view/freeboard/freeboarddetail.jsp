<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#topNav{
		border : 1px solid black;
		overflow : auto;
		list-style : none;
	}
	ul{
		float : left;
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
				<tr>
					<td>제목</td>
					<td>${freeboard.title }</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${freeboard.memberEmail }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${freeboard.createDate}</td>
				</tr>
				<tr>
					<td>수정일</td>
					<td>${freeboard.modifyDate}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<div style="white-space:pre;">${freeboard.content}</div>
					</td>
				</tr>
		</table>
	</div>
	<div id="bottomDiv">
		<c:choose>
			<c:when test="${freeboard.memberEmail eq clientId}">
				<div>
					<a href="${pageContext.request.contextPath}/freeboard/updateForm?id=${freeboard.id}&title=${freeboard.title}">
						<button type="button">수정</button>
					</a>
					<a href="${pageContext.request.contextPath}/freeboard/deleteFbDetail?id=${freeboard.id }">
						<button type="button">삭제</button>
					</a>
				</div>
					
					
			</c:when>
			<c:otherwise>
				<a href="list">
					<button type="button">목록으로</button>
				</a>
			</c:otherwise>		
		</c:choose>
	</div>
	
	<hr>
	<div>
		<textarea id="comment" rows="3" cols="30" name="comment" ></textarea>
		<input type="button" id="commentbutton" value="등록" >
		<input type="button" id="commentList" value="덧글 보기" >
		<hr>
	</div>
	<br>
	<div id="commentplace"></div>	
			
	<script type="text/javascript">
		$(function(){
			
			$('#commentbutton').on('click',function(){
				
				$('#commentplace .commentTable, #commentplace hr').remove();
				commentvalue = $('#comment').val().trim();
				// '${clientId}' el 을 스크립트 태그안에서는 이렇게 따옴표로 감싸서 써야 문자로 인식한다.
				
				$.ajax({
					url : 'insertandlist',
					type : 'post',
					data : {
								'memberEmail' : '${clientId}',
								'freeboardNo' : '${freeboard.id}',
								'comment' : $('#comment').val().trim()
					},
					dataType : 'json',
					success : function(v){
						if( v != null){
							for( i = 0 ; i < v.length ; i++){
								
								html = "";
								html += "<table class='commentTable' border='1'>";
								html += "<tr>";
								html += "<td>아이디</td><td>등록일</td>";
								html += "</tr>";
								html += "<tr>";
								html += "<td>" + v[i].memberEmail + "</td><td>" + v[i].createDate + "</td>";
								html += "</tr>";
								html += "<tr>";
								html += "<td>내용</td><td>" + v[i].comment + "</td>";
								html += "</tr>";
								html += "</table>";
								
								//comment = v[i].comment;
								console.log(html);
								$('#commentplace').append(html+"<hr>");
								
								
							}
						}else{
							alert("덧글이 등록되지 않았습니다.")
							
						}
							
						
					},
					error : function(xhr){
						alert("상태 : " + xhr.status);
					}
					
					
				})
				
				
				
			})
			
			
			
				
			$('#commentList').on('click', function(){
				
				$('#commentplace .commentTable, #commentplace hr').remove();
				commentvalue = $('#comment').val().trim();
				// '${clientId}' el 을 스크립트 태그안에서는 이렇게 따옴표로 감싸서 써야 문자로 인식한다.
				
				$.ajax({
					url : 'commentList',
					type : 'post',
					data : {
								'freeboardNo' : '${freeboard.id}',
					},
					dataType : 'json',
					success : function(v){
						if( v != null){
							for( i = 0 ; i < v.length ; i++){
								
								html = "";
								html += "<table class='commentTable' border='1'>";
								html += "<tr>";
								html += "<td>아이디</td><td>등록일</td>";
								html += "</tr>";
								html += "<tr>";
								html += "<td>" + v[i].memberEmail + "</td><td>" + v[i].createDate + "</td>";
								html += "</tr>";
								html += "<tr>";
								html += "<td>내용</td><td>" + v[i].comment + "</td>";
								html += "</tr>";
								html += "</table>";
								
								//comment = v[i].comment;
								console.log(html);
								$('#commentplace').append(html+"<hr>");
								
								
							}
						}else{
							alert("덧글이 등록되지 않았습니다.")
							
						}
							
						
					},
					error : function(xhr){
						alert("상태 : " + xhr.status);
					}
					
					
				})
						
					
			})
				
				
			
			
				
				
			
		})
	</script>

</body>
</html>