<%@ page language="java" contentType="text/html "
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jquery登录注册表单切换小部件</title>
<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}${'/'}">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<script type="text/javascript" src="javascript/jQuery-1.12.4.js"></script>
<link href="css/loginStyle.css" rel="stylesheet" type="text/css" media="all" />
<script src="javascript/jQuery-1.12.4.js"></script>
<script src="javascript/jquery.validate.js"></script>
<script src="javascript/jquery.validate.min.js"></script>
<script src="javascript/validate/login.js"></script>
<style>
	.error{
		color:red ;
		font-style:italic
	}
</style>
<body>

<div class="main">
	<h1><f:message key='signOrResign'/></h1>
	
	<div class="w3_login">
		<div class="w3_login_module">
			<div class="module form-module">
				<div class="toggle">
					<i class="fa fa-times fa-pencil"></i>
					<div class="tooltip"><f:message key='clickToSwitch'/></div>
				</div>
				<div class="form">
					<h2><f:message key="loginAccount"/></h2>
					<div class="cta">
					<a href="changeLanguage.action?locale=zh_CN">中文</a>
					<a href="changeLanguage.action?locale=en_US">English</a>
					</div>
					
					<font class="warningInfo" color="red" size = "2">${mess==null?"":mess}</font><br>
					<form action="loginForMyRealm.action" method="get" id="loginCheck"><!--loginForMyRealm  login-->
						<input type="text" name="sessionTime" value="1" style="display : none" />
						<input type="text" name="username" placeholder="<f:message key='username'/>" required=" " />
						<input type="password" name="password" placeholder="<f:message key='password'/>" required=" " />
						<input type="submit" value="<f:message key='login'/>" />
					</form>
				</div>
				<div class="form">
					<h2><f:message key='createAccount'/></h2>
					<form action="login.action" method="post">
						<input type="text" name="op" value="regUser" style="display : none" />
						<input type="text" name="Username" placeholder="<f:message key='username'/>" required=" " onblur="checkRegUser(this)"/>
						<span id="messProductCheckForUsername"></span>
						<input type="password" name="Password" placeholder="<f:message key='password'/>" required=" " onblur="checkRegUser(this)"/>
						<span id="messProductCheckForPassword"></span>
						<input type="email" name="Email" placeholder="<f:message key='email'/>" required=" " onblur="checkRegUser(this)"/>
						<span id="messProductCheckForEmail"></span>
						<input type="text" name="Phone" placeholder="<f:message key='tel'/>" required=" " onblur="checkRegUser(this)"/>
						<span id="messProductCheckForPhone"></span>
						<input type="submit" value="<f:message key='SignUp'/>"/>
					</form>
				</div>
				<div class="cta"><a href="#"><f:message key='forgetPassword'/>?</a></div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('.toggle').click(function(){
		$(this).children('i').toggleClass('fa-pencil');
		$('.form').animate({height: "toggle",'padding-top': 'toggle','padding-bottom': 'toggle',opacity: "toggle"}, "slow");
	});
</script>

</body>
</html>