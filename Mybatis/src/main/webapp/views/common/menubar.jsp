<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  
<style>
    .login-area a{
        text-decoration: none;
        color: black;
        font-size: 12px;
    }

    .nav-area{
        background: black;
        color: white;
        height: 50px;
    }
    .menu{
        display: table-cell;
        width: 250px;
        height: 50px;
        vertical-align: middle;
        font-size: 20px;
        font-weight: bold;
    }
    .outer{
    	width: 900px;
    	background: black;
    	color: white;
    	margin: auto;
    	margin-top: 50px;
    }
    .menu a{
    	text-decoration: none;
    	color: white;
    }
</style>
</head>
<body>
<c:if test="${not empty alertMsg}">
	<script>
		alert("${alertMsg}")
	</script>
	<c:remove var="alertMsg"/>
</c:if>

    <h1 align="center">welcome to Mybatis World</h1>
    <br>

    <div class="login-area" align="right">
       <c:choose>
       <c:when test="${empty loginUser}">
	        <form action="login.me" method="post">
		        <table>
		            <tr>
		                <td>아이디</td>
		                <td><input type="text" name="userId" required></td>
		                <td rowspan="2"><button type="submit" style="height: 50px;">로그인</button></td>
		            </tr>
		            <tr>
		                <td>비밀번호</td>
		                <td><input type="password" name="userPwd" required></td>
		                
		            </tr>
		            <tr>
		                <td colspan="3" align="center">
		                    <a href="${pageContext.request.contextPath}/enrollForm.me">회원가입</a>
		                    <a href="">아이디/비번찾기</a>
		                </td> 
		            </tr>
	            </table>
	        </form>
     	</c:when>
       	<c:otherwise>
        	<!-- 로그인후 -->
	        <div>
	            <table>
	                <tr>
	                    <td colspan="2">
	                        <h3>${loginUser.userName}님 환영합니다. </h3>
	                    </td>
	                    <td></td>
	                </tr>
	                <tr>
	                    <td><a href="mypage.me">마이페이지</a></td>
	                    <td><a href="logout.me">로그아웃</a></td>
	                </tr>
	            </table>
	        </div>
        </c:otherwise>
        </c:choose>
    </div>
    <br>

    <div class="nav-area" align="center">
        <div class="menu"><a href="${pageContext.request.contextPath}">HOME</a></div>
        <div class="menu"><a href="">공지사항</a></div>
        <div class="menu"><a href="list.bo?cpage=1">게시판</a></div>
        <div class="menu"><a href="">ETC</a></div>
    </div>
</body>
</html>