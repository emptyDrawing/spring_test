<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post" enctype="multipart/form-data" >
		who : <input type="text" name="name"/><br/>
		file : <input type="file" name="file"/><br/>
		<button type="submit">전송</button>
	</form>
</body>
</html>