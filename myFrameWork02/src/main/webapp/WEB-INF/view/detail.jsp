<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

</head>
<body>
	<ul class="nav nav-pills">
		<li role="presentation"><a href="index.jsp">Home</a></li>
		<li role="presentation" class="active"><a href="list.do">List</a></li>
		<li role="presentation"><a href="#">Login</a></li>
	</ul>
	<div class="jumbotron">
		<h1>Hello, world!</h1>
		<p>...</p>
		<p>
			<a class="btn btn-primary btn-lg" href="#" role="button">Learn
				more</a>
		</p>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Contents Start -->
				<ol class="breadcrumb">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="list.do">List</a></li>
					<li class="active">${view} : ${bean.sabun }</li>
				</ol>
				<h1>${view} : ${bean.sabun }</h1>
				<form action="update.do" method="post">
					<div class="form-group">
						<label for="sabun">sabun</label>
						<input type="text" value="${bean.sabun }"
							class="form-control" id="sabun" name="sabun" readonly="readonly"  />
					</div>
					<div class="form-group">
						<label for="name">name</label>
						<input type="text" value="${bean.name }"
							class="form-control" id="name" name="name" ${noEdit } />
					</div>
					<div class="form-group">
						<label for="nalja">pay</label>
						<input type="date" value="${bean.nalja }"
							class="form-control" id="nalja" name="nalja" disabled="disabled" />
					</div>
					<div class="form-group">
						<label for="pay">pay</label>
						<input type="text" value="${bean.pay }"
							class="form-control" id="pay" name="pay" ${noEdit } />
					</div>
					<c:if test="${view eq 'Update' }">
					<div class="form-group">
						<button type="submit" class="btn btn-primary">수정</button>
					</div>
					</c:if>
				</form>
					<c:if test="${view eq 'Detail' }">
				<div class="col-md-6 btn-group-justified" role="group" aria-label="...">
					<a class="btn btn-primary btn-lg" role="button" href="edit.do?idx=${bean.sabun}">수정</a>
					<a class="btn btn-danger btn-lg" role="button" href="delete.do?idx=${bean.sabun}">삭제</a>
				</div>
				</c:if>
				<!-- Contents End -->
			</div><!-- 	<div class="col-md-12">	-->
		</div>
		<div class="row">
			<div class="col-md-12">
				<!-- footer start -->
				<p class="text-center text-uppercase">CopyRight &copy; 빈그림.
					2018. 테스트용 페이지.</p>

				<!-- fotter End -->
			</div>
		</div>

	</div>
	<!-- container end -->

</body>
</html>