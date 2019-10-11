<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}${'/'}">
</head>
<!-- 引入jQuery核心js文件 -->
<script src="javascript/jQuery-1.12.4.js"></script>
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- 引入BootStrap核心js文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<style>
	html,body{
   		height: 100%;
   		width: 100%;
    }
</style>
<body>
	<div class="container-fluid" style="height: 100%;width: 100%;">
    		<div class="row">
    			<div class="navbar navbar-default" style="height: 10%;width: 100%;">
					<div class="navbar-header" style="height: 100%;width: 100%;">
						<a class="navbar-brand" href="#" style="font-size: 30px;">天眼电商管理</a>
						<div class="navbar-header navbar-right" style="margin-right: 5%;" >
							<a href="loginOut.action" class="navbar-brand" ><shiro:principal />你好！&nbsp&nbsp&nbsp&nbsp loginOut</a>
						</div>
					</div>
				</div>
    		</div>
    		
       		<div class="row" style="height:80%;width: 100%;">
       			<div class="col-xs-2" style="height: 100%;">
					<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
						<c:forEach items="${menuList }" var="p" varStatus="v" > 
							<shiro:hasPermission name="${p.pname }">
								<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading${v.index }">
									<h4 class="panel-title">
								        <a role="button" class="${p.pcolor} }"  style="width: 100%;" data-toggle="collapse" 
								        data-parent="#accordion" href="#collapse${v.index }" 
								        aria-expanded="true" aria-controls="collapse${v.index }">
								          	${p.pinfo }<!-- 专员信息管理 -->
								        </a> 
				    				</h4>
								</div>
								<div id="collapse${v.index }" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading${v.index }">
									<div class="panel-body">
										<!-- 遍历得到子权限 -->
										<c:forEach items="${p.list }" var="p2" varStatus="v2" >
											<shiro:hasPermission name="${p2.pname }">
												<a href="${p2.purl }" target="showAll" class="${p2.pcolor }" style="width: 100%;">${p2.pinfo }</a><!-- 增加专员 -->
												<br />
											</shiro:hasPermission>
										</c:forEach>
									</div>
								</div>
							</div>
							</shiro:hasPermission>
							
						</c:forEach>
					</div>
       			</div>
       			<div class="col-xs-10" style="height: 100%;">
       				<div style="height: 100%;">
       					<iframe name="showAll" src="right.action" frameborder="0" width="100%" height="100%">
       					<!-- 用于显示数据的 -->
       					</iframe>
       				</div>
       			</div>
    	</div>
 	</div>
</body>
</html>