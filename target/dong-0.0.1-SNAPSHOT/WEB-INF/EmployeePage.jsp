<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
							<a class="navbar-brand" >loginOut</a>
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
											          	产品管理
											        </a>
							    				</h4>
											</div>
											<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
												<div class="panel-body">
													<a href="" class="btn btn-danger btn-block" style="width: 100%;">增加产品</a>
													<br />
													<a  href="showAllPage.jsp" target="showAll"  class="btn btn-success btn-block" style="width: 100%;">查看产品</a>
												</div>
											</div>
										</div>
							<!-- ********************************************************************* -->
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingTwo">
									<h4 class="panel-title">
								        <a  class="collapsed btn btn-primary btn-block" style="width: 100%;" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
								         	 类别管理
								        </a>
				     				</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
									<div class="panel-body">

										<!-- <a href="" class="btn btn-danger btn-block" style="width: 100%;">增加类别</a>    data-target="#myModal"-->	
										
										<!-- 
											<a href="" target="right" class="btn btn-danger btn-block"  onclick="showModal()" style="width: 100%; data-toggle="modal" >增加类别</a>
										 -->
										<button type="button" class="btn btn-danger btn-block"  style="width: 100%;"  data-toggle="modal" data-target="#myModal" >
											  增加类别
										</button>
										
										
										<div id="modal" >
											<!-- Modal -->
											<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
											  <div class="modal-dialog" role="document">
											    <div class="modal-content">
											      <div class="modal-header">
											        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
											        <h4 class="modal-title" id="myModalLabel">增加类别</h4>
											      </div>
											      <div class="modal-body">
											        <form action="categorysManager" >
											        	<div class="form-group">
															<!-- get请求url后面链接参数可能会把?给覆盖掉可以使用post或下一句话解决 -->
															<input type="text" name="op" value="addCategorys" hidden="hidden" />
															类别名字:<input class="form-control" type="text" name="category_name"/></td>
															类别信息:<input class="form-control" type="text" name="category_desc"/></td>
											        	</div>
											        	<div style="text-align: center;">
											        		<input type="submit" class="btn btn-primary" value="提交"/>
															<input type="reset" class="btn btn-primary" value="重置"/>
											        	</div>
													</form>
											      </div>
											      <div class="modal-footer">
											        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											        <button type="button" class="btn btn-primary">Save changes</button>
											      </div>
											    </div>
											  </div>
											</div>
										</div>
																		
										
										<br />
										<a  href="categorysManager?op=showAllbyPage&currentPage=1&pageSize=2" target="showAll" class="btn btn-success btn-block" style="width: 100%;">查看类别</a>
									</div>
								</div>
							</div>
							<!-- ********************************************************************* -->
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingThree">
												<h4 class="panel-title">
											        <a class="collapsed  btn btn-primary btn-block" style="width: 100%;" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
											         	 提供者管理
											        </a>
							     				</h4>
											</div>
											<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
												<div class="panel-body">
													<a href="" class="btn btn-danger btn-block" style="width: 100%;">增加提供者</a>
													<br />
													<a   href="providersManager?op=showAllbyPage&currentPage=1&pageSize=2" target="showAll"  class="btn btn-success btn-block" style="width: 100%;">查看提供者</a>
												</div>
											</div>
										</div>
							<!-- ********************************************************************* -->
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingFour">
												<h4 class="panel-title">
											        <a class="collapsed  btn btn-primary btn-block" style="width: 100%;" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapsedFour" aria-expanded="false" aria-controls="collapsedFour">
											         	 订单管理
											        </a>
							     				</h4>
											</div>
											<div id="collapsedFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
												<div class="panel-body">
													<a href="" class="btn btn-danger btn-block" style="width: 100%;">增加订单</a>
													<br />
													<a  href="html/Admin/Order/addOrder.jsp" target="showAll"  class="btn btn-success btn-block" style="width: 100%;">查看订单</a>
												</div>
											</div>
										</div>
							<!-- ********************************************************************* -->
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingFive">
									<h4 class="panel-title">
								        <a class="collapsed btn btn-primary btn-block" style="width: 100%;" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapsedFive" aria-expanded="false" aria-controls="collapsedFive">
								         	 用户管理
								        </a>
				     				</h4>
								</div>
								<div id="collapsedFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
									<div class="panel-body">
										<a href="" class="btn btn-danger btn-block" style="width: 100%;">增加用户</a>
										<br />
										<a  href="userManager?op=showAllbyPage&currentPage=1&pageSize=2" target="showAll"  class="btn btn-success btn-block" style="width: 100%;">查看用户</a>
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
       					<iframe name="showAll" src="html/right.jsp" frameborder="0" width="100%" height="100%">
       					
       					</iframe>
       				</div>
       			</div>

    	</div>
       </div>
</body>
</html>