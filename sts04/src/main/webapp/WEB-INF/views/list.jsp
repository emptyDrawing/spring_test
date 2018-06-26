<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Insert title here</title>
<script type="text/javascript">

	function detail(){
		$('.detailForm input').hide();
		$('.modal-title').html('상세페이지')
		$('.modal-footer').show();
		$('.well-input').show();
	}
	
	function edit(){
		$('.detailForm input').show();
		$('.modal-title').html('수정페이지');
		$('.modal-footer').hide();
		$('.well-input').hide();
	}
	
	$(function(){
		detail();
		$('#myModal-${sabun}').modal({show:true});
		$('.edit-item').click(function(){ edit(); });
		$('.modal-input').on('hide.bs.modal', function (e) { detail();	});
		/* $('.modal-input').on('hidden.bs.modal', function (e) { detail(); }); */
	});
	
	
</script>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">
			<p>테스트센터</p>
	      </a>
	    </div>
		<ul class="nav navbar-nav">
		 	<li><a href="#">Home</a></li>
		  	<li><a href="/guest/">List</a></li>
		  	<li><a href="#" data-toggle="modal" data-target=".bs-example-modal-lg">Add</a></li>
			<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg" role="document">
			    <div class="modal-content">
					<div class="modal-header">
						<h4>입력페이지</h4>
					</div>
					<div class="model-body">
						<form method="post">
							<div class="form-group">
								<label for="sabun">sabun</label>
								<input type="text" name="sabun" id="sabun" class="form-control" value="" placeholder="사번-숫자만">
							</div>
							<div class="form-group">
								<label for="name">name</label>
								<input type="text" name="name" id="name" class="form-control" value="" placeholder="이름">
							</div>
							<div class="form-group">
								<label for="pay">pay</label>
								<input type="text" name="pay" id="pay" class="form-control" value="" placeholder="금액-숫자만">
							</div>
					        <button type="submit" class="btn btn-primary">입력</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						</form>
			    	</div>
			 	</div>
			  </div>
			 </div>
		</ul>
	  </div>
	</nav>
	<!-- Context start -->
	<div class="list-group">
	<c:forEach items="${alist }" var="bean">
 	 	<button type="button" class="list-group-item" data-toggle="modal" data-target="#myModal-${bean.sabun }">
 	 		<span class="badge">${bean.pay }</span>
 	 	    <h4 class="list-group-item-heading">${bean.sabun }</h4>
    		<p class="list-group-item-text">[${bean.nalja }]-[${bean.name}]</p>
 	 	</button>
		<!-- Modal -->
		<div class="modal fade modal-input" id="myModal-${bean.sabun }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-${bean.sabun }">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel-${bean.sabun }">${bean.sabun}님의 상세페이지</h4>
		      </div>
		      <div class="modal-body">
		      	<form action="./${bean.sabun}" method="post" class="detailForm">
		      		<input type="hidden" name="_method" value="put">
					<div class="form-group">
						<label for="sabun">sabun</label>
						<div class="well well-sm">${bean.sabun }</div>
						<input type="hidden" name="sabun" id="sabun" class="form-control" value="${bean.sabun }" placeholder="사번-숫자만">
					</div>
					<div class="form-group">
						<label for="name">name</label>
						<div class="well well-sm well-input">${bean.name }</div>
						<input type="text" name="name" id="name" class="form-control" value="${bean.name }" placeholder="이름">
					</div>
					<div class="form-group">
						<label >nalja</label>
						<div class="well well-sm">${bean.nalja }</div>
					</div>
					<div class="form-group">
						<label for="pay">pay</label>
						<div class="well well-sm well-input">${bean.pay }</div>
						<input type="text" name="pay" id="pay" class="form-control" value="${bean.pay }" placeholder="금액-숫자만">
					</div>
					<input type="submit" class="btn btn-danger" value="수정완료" />
					<input type="button" class="btn btn-default" data-dismiss="modal" value="닫기"/>
				</form>
		      </div>
		      <div class="modal-footer">
		      	<form action="./${bean.sabun }" method="post">
		      		<input type="hidden" name="_method" value="delete"/>
			        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			        <button type="button" class="btn btn-primary edit-item">수정하기</button>
			        <button type="submit" class="btn btn-danger del-item">삭제하기</button>
		      	</form>
		      </div>
		    </div>
		  </div>
		</div>
 	</c:forEach>
	</div>
	

	
	
	
	<!-- Context end -->
</body>
</html>