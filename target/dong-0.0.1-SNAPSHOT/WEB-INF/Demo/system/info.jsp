<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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


<body>
<script type="text/javascript">

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

<button id="clickMe" οnclick="clicked" class="btn btn-success" data-toggle="modal" data-target="#new" hidden>
 <span style="color:#ff0000;"></span>
自动弹出模态框
 </button>  

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
					<h4 class="modal-title" id="myModalLabel">个人信息</h4>
				</div>
				<div class="modal-body">
					<!-- ========================================================= -->
					<div class="container">
						<form>
							<div class="form-group">
								<label for="pwd">用户id</label> <input type="text"
									class="form-control" name="emp_id" id="emp_id" value="${user.empId }" readOnly placeholder="">
							</div>
							<div class="form-group">
								<label for="pwd">用户名:</label> <input type="text" value="${user.username }" readOnly  
									class="form-control" name="username" id="username" placeholder="">
							</div>
							<div class="form-group" hidden>
								<label for="confirm">密码:</label> <input type="text" value="${user.password }" readOnly 
									class="form-control" name="PASSWORD" id="PASSWORD" placeholder="">
							</div>
							<div class="form-group">
								<label for="confirm">手机号:</label> <input type="text" value="${user.tel }" readOnly 
									class="form-control" name="tel" id="tel" placeholder="">
							</div>
							<div class="form-group">
								<label for="confirm">名字:</label> <input type="text" value="${user.name }" readOnly 
									class="form-control" name="NAME" id="NAME" placeholder="">
							</div>
							<div class="form-group">
								<label for="confirm">邮箱:</label> <input type="text" value="${user.email }" readOnly 
									class="form-control" name="email" id="email" placeholder="">
							</div>

						</form>
					</div>

				</div>
	
			</div>
		</div>
	</div>



</body>
</html>