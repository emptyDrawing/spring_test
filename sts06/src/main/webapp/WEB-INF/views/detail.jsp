<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-1.12.4.js"
  integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
  crossorigin="anonymous"></script>
<script type="text/javascript">
var btn=false;
	$(function(){
		$('input').attr('readonly','readonly');
		$('form>button').eq(0).on('click',function(){
			if(btn){$('form').submit();}
			else{
				$('.edit-target').removeAttr('readonly');
				$('#nalja').removeAttr('name');
				$('h1').html('수정페이지');
				btn=true;
			}
		});
		$('form>button').eq(1).click(function(){
			if(btn){
				$('input').attr('readonly','readonly');
				$('h1').html('상세페이지');
				btn=false;
			}else{
				window.history.back();
			}
		})
		$('form>button').eq(2).click(function(){
			var param='idx='+$('#sabun').val();
			$.post('./delete',param,function(){
				window.location.href='./list';
			});
		});
	});
</script>
</head>
<body>
	<h1>상세페이지</h1>
	<form action="update" method="post">
		<div>
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" id="sabun" value="${bean.sabun }"/>
		</div>
		<div>
			<label for="name">name</label>
			<input class="edit-target" type="text" name="name" id="name" value="${bean.name }"/>
		</div>
		<div>
			<label for="pay">pay</label>
			<input class="edit-target" type="text" name="pay" id="pay" value="${bean.pay}"/>
		</div>
		<div>
			<label for="nalja">nalja</label>
			<input type="text" name="nalja" id="nalja" value="${bean.nalja }"/>
		</div>
		<button type="button">수정</button>	
		<button type="button">뒤로</button>	
		<button type="button">삭제</button>	
	</form>
</body>
</html>