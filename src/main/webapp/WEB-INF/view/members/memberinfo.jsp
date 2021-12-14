<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
  <head>
    <title>회원 가입폼 </title>
    <style type="text/css">
    	#topNav{
    		border : 1px solid black;
    		overflow : auto;
    		list-style : none;
    	}
    	
    	ul{
    		float : left;
    	}
    	
    	#middleDiv{
    		clear : both;
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
			
			<c:if test="${not empty loginId }">
				<ul>
					<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
				</ul>
			</c:if>
			

		</li>
	</nav>
  
    <div id="middleDiv">
      <div>
        <h1>회원정보</h1>
        <p>로그인한 회원 정보를 표기합니다.</p>
      </div>
      
      <table border="1">
      	<thead>
      		<tr>
      			<th>내 정보</th>
      		</tr>
      	</thead>
      	<tbody>
      		<tr>
      			<td>이름</td>
      			<td>${member.name }</td>
      		</tr>
      		<tr>
      			<td>이메일</td>
      			<td>${member.email }</td>
      		</tr>
      		<tr>
      			<td>계정 생성일</td>
      			<td>${member.createDate }</td>
      		</tr>
      		<tr>
      			<td>계정 수정일</td>
      			<td>${member.modifyDate }</td>
      		</tr>
      	</tbody>
      </table>

        

    </div>
  </body>