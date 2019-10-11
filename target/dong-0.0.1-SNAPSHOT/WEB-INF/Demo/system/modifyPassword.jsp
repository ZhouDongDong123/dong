<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}${'/'}">
<title>超级</title>
</head>

<!-- 信息验证 -->
<!-- <script src="javascript/jquery.validate.js"></script>
<script src="javascript/jquery.validate.min.js"></script>
<script src="javascript/validate/editCustomer.js"></script> -->
<!-- 引入jQuery核心js文件 -->
<script src="javascript/jQuery-1.12.4.js"></script>
<script src="motaikuang/jquery.min.js"></script>
<script src="motaikuang/bootstrap.min.js"></script>
<script src="motaikuang/popper.min.js"></script>
<link rel="stylesheet" href="motaikuang/bootstrap.min.css">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 引入BootStrap核心js文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script>
	function modifySystemPassword(obj){
/* 		alert("hahaha");
		$("#modifySystemPassword").submit(); */
	    var form_value =[]; 
		var t = $('#modifySystemPassword').serializeArray();
		//t的值为[{name: "a1", value: "xx"},
		//{name: "a2", value: "xx"}...]
		$.each(t, function() {
		    //d[this.name] = this.value;
			form_value.push(this.value);
		});
		//数据验证
		var token = true;
		
		if(form_value[1]=='' || form_value[1].trim().length < 6 ){
			alert('输入原密码错误：');
			token = false;
		}else if(form_value[2]=='' || form_value[2].trim().length < 6 ){
			alert('输入新密码错误(最小6位)：');
			token = false;
		}else if(form_value[3]=='' || form_value[2].trim() != form_value[3].trim() ){
			token = false;
	        alert("确认密码错误！");
	    }
		
		if(token == true){
			$.ajax({
				url:"modifySystemPassword.action",
				type:"post",
				data:{
					"db_oldPassword":form_value[0],
					"oldPassword":form_value[1],
					"newPassword":form_value[2],
					"confirm":form_value[3]
				},
				success: function(msg){
					if(msg.type=="success"){
						//此时可以删除
						alert("修改成功");
						//同时当前页和记录数等都要改变(不加这一句会有问题，当前页这些数据不会刷新)
						//window.location.href = window.location.href;
						//修改成功后，模态框应该消失
						if(document.all) {//IE
							document.getElementById("clickMe").click();
						}
						// 其它浏览器
						else {
							var e = document.createEvent("MouseEvents");
							e.initEvent("click", true, true);
							document.getElementById("clickMe").dispatchEvent(e);
						}
						//
				    }else{
				    	alert("修改失敗");
				    	
					}
				}
			});
		}
		
	};
	
	$(document).ready(function(){
		if(document.all) {//IE
			document.getElementById("clickMe").click();
		}
		// 其它浏览器
		else {
			var e = document.createEvent("MouseEvents");
			e.initEvent("click", true, true);
			document.getElementById("clickMe").dispatchEvent(e);
		}
	});

</script> 


<body>


<button id="clickMe" οnclick="clicked" class="btn btn-success" data-toggle="modal" data-target="#new" hidden>
 <span style="color:#ff0000;"></span>
自动弹出模态框
 </button>  

<!-- <button class="btn btn-primary btn" data-toggle="modal"
	data-target="#myModal" onclick="motai(this)">
	编辑 <span class="glyphicon glyphicon-pencil" aria-hidden="true" style="width: 100%;"></span>
</button> -->

<!-- 编辑模态Modal -->
	<div class="modal fade bs-example-modal-sm" id="new" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改超级管理员密码</h4>
				</div>
				<div class="modal-body">
					<!-- ========================================================= -->
					<div class="container">
						<form id="modifySystemPassword">
						
						<!-- 这里应该把密码和输入的密码一起放过去 -->
							<input type="text" class="form-control" name="db_oldPassword" value="${user.password }" hidden>
							<div class="form-group">
								<label for="pwd">原密码:</label> <input type="password"
									class="form-control" name="oldPassword" id="oldPassword" placeholder="">
							</div>
							<div class="form-group">
								<label for="pwd">新密码:</label> <input type="password"
									class="form-control" name="newPassword" id="newPassword" placeholder="">
							</div>
							<div class="form-group">
								<label for="confirm">确认新密码:</label> <input type="password"
									class="form-control" name="confirm" id="confirm" placeholder="">
							</div>
							
						</form>
					</div>
					<!-- ========================================================= -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="submitBtn"
						onclick="modifySystemPassword()">Save changes</button>
				</div>
			</div>
		</div>
	</div>



</body>
</html>