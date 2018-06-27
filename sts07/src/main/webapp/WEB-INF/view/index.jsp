<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
			<form method="POST" enctype="multipart/form-data" action="./upload">
			  File to upload: <input type="file" name="upfile"><br/>
			  Notes about the file: <input type="text" name="note"><br/>
			  <br/>
			  <input type="submit" value="Press"> to upload the file!
			</form>

	</body>
</html>
