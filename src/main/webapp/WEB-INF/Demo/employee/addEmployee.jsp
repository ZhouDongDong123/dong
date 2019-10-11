<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}${'/'}">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="" />
<link href="css/font-awesomeForEmployee.min.css" rel="stylesheet"
	type="text/css" media="all">
<link href="css/styleForEmployee.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/weizhiForEmployee.css" rel="stylesheet">

</head>

<style>
.select {
	margin-top: 0px;
	outline: none;
	border: 1px solid #BBBBBB;
	border-radius: 4px;
	position: relative;
	width: 170px;
}

.text {
	height: 40px;
	-webkit-appearance: none;
	appearance: none;
	border: none;
	font-size: 18px;
	padding: 0px 10px;
	display: block;
	width: 100%;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	background-color: #FFFFFF;
	color: #333333;
	border-radius: 4px;
}
</style>

<!-- 注意这里路径问题 -->
<script type="text/javascript"
	src="javascript/My97DatePicker/WdatePicker.js"></script>
<script src="javascript/jQuery-1.12.4.js"></script>
<script src="javascript/jquery.validate.js"></script>
<script src="javascript/jquery.validate.min.js"></script>
<script src="javascript/validate/addEmployee.js"></script>
<style>
	.error{
		color:red ;
		font-style:italic
	}
</style>

<!-- 这里增加需要做重名验证 -->

<script type="text/javascript">
function checkName(obj){
	var username = $(obj).val();
	$.ajax({
		url:"checkEmployeeName.action",
		type:"get",
		data:{
			"username":username
		},
		success: function(msg){
			if(msg.type=="success"){
				//校验成功
				$("#usernameCheck")[0].innerHTML = "<br />校验成功！";
				
		    }else{
		    	$("#usernameCheck")[0].innerHTML = "<br />该用户名重名！";
			}
		}
	   
		});
	
}


</script>

<body>
	<div class="signupform">
		<h1>增加专员</h1>
		<div class="container">
			<div class="w3_info">
				<form action="addEmployeeForDatabase.action" method="post" id="addEmployeeId">
					<div class="input-group">
						<span><i class="fa fa-user" aria-hidden="true"></i></span> <input
							type="text" placeholder="员工登录名:" name="username" required=""  onblur="checkName(this)"/>
							<span id="usernameCheck"style="color: red;"></span>
					</div>
					<div class="input-group">
						<span><i class="fa fa-user" aria-hidden="true"></i></span> <input
							type="password" placeholder="员工密码:" name="password" required="" />
					</div>

					<div class="input-group">
						<span><i class="fa fa-lock" aria-hidden="true"></i></span> <input
							type="text" placeholder="员工联系电话:" name="tel" required="" />
					</div>
					<div class="input-group">
						<span><i class="fa fa-lock" aria-hidden="true"></i></span> <input
							type="text" placeholder="员工名字：" name="name" required="" />
					</div>


					<div class="input-group">
						<span><i class="fa fa-envelope" aria-hidden="true"></i></span> 
						<input type="email" name="email" placeholder="员工Email" required="" />
					</div>
					<div class="select">
						<select class="text" name="emptype">
							<option value="0">请选择身份</option>
							<option value="1">经理</option>
							<option value="2">普通员工</option>
						</select>
					</div>

					<button class="btn btn-danger btn-block" type="submit">Add
						Employee</button>
				</form>
			</div>
			<div class="clear"></div>
		</div>

	</div>
	<div class="footer"></div>
	</div>
</body>
</html>