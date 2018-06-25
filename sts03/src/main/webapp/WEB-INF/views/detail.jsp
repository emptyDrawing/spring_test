<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
<script type="text/javascript">
	$(function(){
		$('input').hide();
		$('form:eq(0)>button').hide();
		$('#edit').click(function(){
			$(this).hide();
			$('input').show();
			$('form>button').show();
			$('#delete1>button').hide();
			$('.well').each(function(idx){
				if(idx==1 || idx==3) $(this).hide();
			});
		})
		
		$('#delete1').submit(function(e){
			//e.preventDefault();
			var result= window.confirm("삭제하시겠습니까");
			if(result)return true;
		    return false;
			//$(this).unbind('submit').submit();
		});
		
		
	});
</script>
<title>List</title>
</head>
<body>
<%@ include file="template/menu.jsp" %>

	<form method="post">
		<input type="hidden" name="_method" value="put">
		<div class="form-group">
			<label for="sabun">sabun</label>		
			<div class="well well-sm">${bean.sabun }</div>
			<input type="hidden" name="sabun" id="sabun" class="form-control" value="${bean.sabun}" placeholder="사번을 입력"/>
		</div>
		<div class="form-group">
			<label for="name">name</label>		
			<div class="well well-sm">${bean.name}</div>
			<input type="text" name="name" id="name" class="form-control" value="${bean.name}" placeholder="이름을 입력"/>
		</div>
		<div class="form-group">
			<label for="nalja">nalja</label>		
			<div class="well well-sm">${bean.nalja }</div>
		</div>
		<div class="form-group">
			<label for="pay">pay</label>		
			<div class="well well-sm">${bean.pay }</div>
			<input type="text" name="pay" id="pay" class="form-control" value="${bean.pay }" placeholder="금액을 입력"/>
		</div>
		<button type="submit" class="btn btn-danger">수정완료</button>
		<button type="reset" class="btn btn-default">리셋</button>
	</form>
	<button type="submit" class="btn btn-danger" id="edit">수정</button>
	<form method="post" id="delete1" style="display:inline;">
		<input type="hidden" name="_method" value="delete">
		<input type="hidden" name="sabum" value="${bean.sabun }">
		<button type="submit" class="btn btn-danger">삭제</button>		
	</form>
</body>
</html>