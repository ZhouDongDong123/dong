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
<script type="text/javascript" src="javascript/My97DatePicker/WdatePicker.js"></script>
<script src="javascript/jQuery-1.12.4.js"></script>
<script src="javascript/jquery.validate.js"></script>
<script src="javascript/jquery.validate.min.js"></script>
<script src="javascript/validate/addCustomer.js"></script>
<style>
	.error{
		color:red ;
		font-style:italic
	}
</style>


<body>
	<div class="signupform">
		<h1>增加顾客</h1>
		<div class="container">
			<div class="w3_info">
				<form action="addCustomerForDatabase.action" method="post" id="addCustomerId">
					<div class="input-group">
						<span><i class="fa fa-user" aria-hidden="true"></i></span> <input
							type="text" placeholder="姓名:" name="cusname" required="" />
					</div>
					<div class="input-group">
						<span><i class="fa fa-user" aria-hidden="true"></i></span> <input
							type="text" placeholder="地址:" name="address" required="" />
					</div>
					<div class="input-group">
						<span><i class="fa fa-lock" aria-hidden="true"></i></span> <input
							type="text" placeholder="顾客联系人:" name="contact" required="" />
					</div>
					<div class="input-group">
						<span><i class="fa fa-lock" aria-hidden="true"></i></span> <input
							type="text" placeholder="電話：" name="tel" required="" />
					</div>
					<div class="input-group">
						<span><i class="fa fa-lock" aria-hidden="true"></i></span> <input
							type="text" placeholder="郵箱：" name="email" required="" />
					</div>
					
					<div class="input-group">
						<span><i class="fa fa-lock" aria-hidden="true"></i></span> <input
							type="text" placeholder="" name="username" readOnly value="${user.username }" required="" />
					</div>
					<button class="btn btn-danger btn-block" type="submit">Add
						Customer</button>
				</form>
			</div>
			<div class="clear"></div>
		</div>

	</div>
	<div class="footer"></div>
	</div>
</body>
</html>