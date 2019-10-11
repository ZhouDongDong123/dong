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
<!-- 引入jQuery核心js文件 -->
<script src="javascript/jQuery-1.12.4.js"></script>
<script src="motaikuang/jquery.min.js"></script>
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
<style>
	.error{
		color:red ;
		font-style:italic
	}
</style>
<script type="text/javascript" src="javascript/My97DatePicker/WdatePicker.js"></script>
<!-- 注意这里路径问题 -->
<script type="text/javascript"
	src="javascript/My97DatePicker/WdatePicker.js"></script>
<script src="javascript/jQuery-1.12.4.js"></script>
<script src="javascript/jquery.validate.js"></script>
<script src="javascript/jquery.validate.min.js"></script>
<script src="javascript/validate/addCustomervisit.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//ajax请求获取所有顾客
	$.ajax({
 			url:"readyCustomerForCustomervisit.action",
 			type:"get",
 			data:{
 			},
 			success: function(msg){
 				//<option value="顾客id">经理</option>
 				var $select = $("#selectCustomer");
 				for(var i=0;i<msg.length;i++){
 					var option = document.createElement("option");
 					//选择框的名字里面值是 id
 					option.setAttribute("value",msg[i].cid);
 					option.innerHTML = msg[i].cusname;
 					$select[0].appendChild(option);
 				}
 			}
 		   
 	  });
	//ajax请求获取所有专员
	$.ajax({
			url:"readyEmployeeForCustomervisit.action",
			type:"get",
			data:{
			},
			success: function(msg){
				//<option value="顾客id">经理</option>
				var $select = $("#selectEmployee");
				for(var i=0;i<msg.length;i++){
					var option = document.createElement("option");
					option.setAttribute("value",msg[i].empId);
					option.innerHTML = msg[i].username;
					$select[0].appendChild(option);
				}
			}
		   
	  });
})

</script>
<body>
	<div class="signupform">
		<h1>增加访问记录</h1>
		<div class="container">
			<div class="w3_info">
				<form action="addCustomervisit.action" method="post" id="addCustomervisitId">
					<div class="input-group">
						<span><i class="fa fa-user" aria-hidden="true"></i></span> 
						<!-- 这里应该是一个选择框 -->
						<!-- <input type="text" placeholder="顾客:" name="cusname" required="" /> -->
						<select class="text" name="cid" id="selectCustomer">
							<option value="0">请选择顾客</option>
						</select>
					</div>
					<div class="input-group">
						<span><i class="fa fa-user" aria-hidden="true"></i></span> 
						<select class="text" name="empId" id="selectEmployee">
							<option value="0">请选择专员</option>
						</select>
					</div>
					<div class="input-group">
						<span><i class="fa fa-lock" aria-hidden="true"></i></span> <input
							type="text" placeholder="联系人:" name="contact" required="" />
					</div>
					<div class="input-group">
						<span><i class="fa fa-lock" aria-hidden="true"></i></span>
						<input placeholder="访问时间：" class="Wdate" onclick = "WdatePicker()"  name="formatDate" required="" />
					</div>

					<button class="btn btn-danger btn-block" type="submit">Add
						Customervisit</button>
				</form>
			</div>
			<div class="clear"></div>
		</div>

	</div>
	<div class="footer"></div>
	</div>
</body>
</html>