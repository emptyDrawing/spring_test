<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
<title>List</title>
</head>
<body>
<%@ include file="template/menu.jsp" %>
	<form action="./" method="post">
		<div class="form-group">
			<label for="sabun">sabun</label>		
			<input type="text" name="sabun" id="sabun" class="form-control" value="" placeholder="사번을 입력"/>
		</div>
		<div class="form-group">
			<label for="name">name</label>		
			<input type="text" name="name" id="name" class="form-control" value="" placeholder="이름을 입력"/>
		</div>
		<div class="form-group">
			<label for="pay">pay</label>		
			<input type="text" name="pay" id="pay" class="pay" value="" placeholder="금액을 입력"/>
		</div>
		<div role="group" class="btn-group">
			<button type="submit" class="btn btn-danger">입력</button>
			<button type="reset" class="btn btn-default">취소</button>
		</div>
	</form>

</body>
</html>