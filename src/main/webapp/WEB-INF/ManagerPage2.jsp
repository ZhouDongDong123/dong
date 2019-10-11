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
					<!-- ********************************************************************* -->
						<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
						
						
							<!-- ********************************************************************* -->
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingOne">
									<h4 class="panel-title">
								        <a role="button" class="btn btn-primary btn-block"  style="width: 100%;" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
								          	合作专员信息管理查询
								        </a> 
								
				    				</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">
										<a href="addEmployee.action" target="showAll" class="btn btn-primary btn-block" style="width: 100%;">增加专员</a>
										<br />
										<a  href="deleteEmployee.action" target="showAll"  class="btn btn-danger btn-block" style="width: 100%;">删除专员</a>
										<br />
										<a  href="deleteEmployee.action" target="showAll"  class="btn btn-success btn-block" style="width: 100%;">修改专员</a>
										<br />
										<a  href="showEmployee.action" target="showAll"  class="btn btn-warning btn-block" style="width: 100%;">查找专员</a>
									</div>
								</div>
							</div>
							<!-- ********************************************************************* -->
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingTwo">
									<h4 class="panel-title">
								        <a  class="collapsed btn btn-primary btn-block" style="width: 100%;" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
								         	客户信息管理
								        </a>
				     				</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
									<div class="panel-body">
				<!-- 						<button type="button" class="btn btn-danger btn-block"  style="width: 100%;"  data-toggle="modal" data-target="#myModal" >
											查看客户信息
										</button> -->
										<a  href="jumpAddCustomerPage.action" target="showAll" class="btn btn-danger btn-block" style="width: 100%;">新增客户信息</a>
										<br />
										<a  href="findAllCustomers.action" target="showAll" class="btn btn-success btn-block" style="width: 100%;">查看客户信息</a>
									</div>
								</div>
							</div>
							<!-- ********************************************************************* -->
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingThree">
												<h4 class="panel-title">
											        <a class="collapsed  btn btn-primary btn-block" style="width: 100%;" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
											         	 客户拜访记录管理
											        </a>
							     				</h4>
											</div>
											<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
												<div class="panel-body">
													<a href="jumpaddCustomervisitPage.action" target="showAll"  class="btn btn-danger btn-block" style="width: 100%;">增加拜访记录</a>
													<br />
													<a href="showCustomervisit.action" target="showAll"  class="btn btn-success btn-block" style="width: 100%;">查看拜访记录</a>
		
												</div>
											</div>
										</div>
							<!-- ********************************************************************* -->
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingFour">
												<h4 class="panel-title">
											        <a class="collapsed  btn btn-primary btn-block" style="width: 100%;" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapsedFour" aria-expanded="false" aria-controls="collapsedFour">
											         	 系统管理
											        </a>
							     				</h4>
											</div>
											<div id="collapsedFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
												<div class="panel-body">
													<a href="" class="btn btn-danger btn-block" style="width: 100%;">修改密码</a>
													<br />
												</div>
											</div>
										</div>
						
							<!-- ********************************************************************* -->
						</div>
						<!-- ********************************************************************* -->  	
				<!-- +++++++++++++++++++++++++++++++++++++++++++++ -->
       			</div>
       			
       			<div class="col-xs-10" style="height: 100%;">
       				<div style="height: 100%;">
       					<iframe name="showAll" src="right.action" frameborder="0" width="100%" height="100%">
       					
       					</iframe>
       				</div>
       			</div>

    	</div>
       </div>
</body>
</html>