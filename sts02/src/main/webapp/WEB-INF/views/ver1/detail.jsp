<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="./">
			<p>비트교육센터</p>
	      </a>
	    </div>
	  <ul class="nav navbar-nav">
	  	<li><a href="./">home</a></li>
	  	<li><a href="list-ver1.bit">Guest.ver1</a></li>
	  	<li><a href="#">Guest.ver2</a></li>
	  	<li><a href="#">Guest.ver3</a></li>
	  </ul>
	  </div>
	</nav>
	<!-- Content start -->
	<div class="page-header">
		<h1>detail-ver1</h1>
	</div>
	<div class="well well-sm">${bean.sabun }</div>
	<div class="well well-sm">${bean.name }</div>
	<div class="well well-sm">${bean.nalja }</div>
	<div class="well well-sm">${bean.pay }</div>
	<div class="btn-group">
	<a href="edit-ver1.bit?idx=${bean.sabun }" role="btn" class="btn btn-success"">수정</a>
	<a href="del-ver1.bit?idx=${bean.sabun }" role="btn" class="btn btn-danger">삭제</a>
	</div>
	
	
	
	<!-- Content end -->
</body>
</html>