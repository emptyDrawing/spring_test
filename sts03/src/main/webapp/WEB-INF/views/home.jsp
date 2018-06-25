<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
<title>Home</title>
</head>
<body>
<%@ include file="template/menu.jsp" %>

<div class="jumbotron">
  <h1>Hello, world!</h1>
  <p>The time on the server is ${serverTime}</p>
  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
</div>


</body>
</html>
