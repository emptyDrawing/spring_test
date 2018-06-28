<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${name }님이 올리신 파일은</h1>
	<h2><a href="./download?file=${reName }&orgin=${orginName}">ver1 : ${orginName }</a></h2>
	<h2><a href="./down/${orginName}?file=${reName }">ver2 : ${orginName }</a></h2>

</body>
</html>