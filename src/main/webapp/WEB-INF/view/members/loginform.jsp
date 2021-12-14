<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
  <html>
    <head>
      <title>로그인 </title>
      <style>
      	#loginform{
      		
      		margin-left : 40%;
      		margin-top : 17%;
      		width : 300px;
      	
      	}
      	label{
      		display : inline-block;
      		width : 40px;
      	}
      	input[type=submit]{
      		margin-left : 35%;
      	}
      	
      	a{
			text-decoration : none;
		}
		button{
			margin-left : 32.7%;
		}
      </style>
    </head>
  <body id="loginform">
    <div>
        <form method="post" action="/securityexam/authenticate">
          <div>
            <label>ID</label>
            <input type="text" name="userId" required="required">
          </div>
          <br>
          <div>
            <label>PW</label>
            <input type="password" name="password" required="required">
          </div>
          <br>
          <div>
            <input type="submit" value="로그인">
          </div>
        </form>
        <br>
        <button type="button">	
		  <a href="${pageContext.request.contextPath}/main">메인으로</a>
		</button> 
    </div>
      
  </body>
</html>