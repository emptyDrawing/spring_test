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
	  	<li><a href="bbs/list">Guest.ver2</a></li>
	  	<li><a href="#">Guest.ver3</a></li>
	  </ul>
	  </div>
	</nav>
	<!-- Content start -->
	<div class="page-header">
		<h1>add-ver1</h1>
	</div>
	<form action="insert-ver1.bit" method="post">
		<div class="form-group" >
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" value="" placeholder="필수항목-숫자만"
			id="sabun" class="form-control" />
		</div>
		<div class="form-group" >
			<label for="name">name</label>
			<input type="text" name="name" value="" placeholder="이름넣어주세요"
			id="name" class="form-control" />
		</div>
		<div class="form-group" >
			<label for="pay">pay</label>
			<input type="text" name="pay" value="" placeholder="숫자만"
			id="pay" class="form-control" />
		</div>
		<button type="submit" class="btn btn-success">입력</button>
		<button type="reset" class="btn btn-default">취소</button>
	</form>	
	
	<!-- Content end -->
</body>
</html>