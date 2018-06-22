<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex10 page</h1>
<c:if test="${login ne true}">
	<h2>로그인</h2>
	<form action="lec02">
		id:<input type="text" name="id"/><br/>
		pw:<input type="text" name="pw"/><br/>
		<button type="submit">로그인</button>
	</form>
</c:if>
</body>
</html>