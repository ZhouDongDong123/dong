<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base
	href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}${'/'}">
<title>员工管理页面</title>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- 引入jQuery核心js文件 -->
<script src="javascript/jQuery-1.12.4.js"></script>
<script src="motaikuang/jquery.min.js"></script>
<script src="motaikuang/bootstrap.min.js"></script>
<script src="motaikuang/popper.min.js"></script>
<link rel="stylesheet" href="motaikuang/bootstrap.min.css">
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 引入BootStrap核心js文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="javascript/conditionSelectReady.js"></script> -->

<!-- 
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

 -->




<script type="text/javascript">
//删除多个用户

function removeMoreEmployees(currentPage,obj){
	 var chk_value =[]; 
    $('input[name="emp_ids"]:checked').each(function(){ 
        chk_value.push($(this).val());
    }); 
    if(chk_value.length==0){
    	alert('你还没有选择任何内容！请先选中要删除的数据');
    }else{
    	alert(chk_value);
    	if(window.confirm('你确定要刪除这些嗎？')){
    		//此时一个请求过去判断能不能删除该专员  即共享表和访问表都要外键判断
    		$.ajax({
    			url:"removeMoreEmployeeReady.action",
    			type:"get",
    			data:{
    				 emp_ids:chk_value,
    				"currentPage":currentPage
    			},
    			success: function(msg){
    				if(msg.type=="success"){
    					//此时可以删除
    					alert("可以删除");
    					
				    					//***********************************************************
				    					if(window.confirm('你确定要刪除这些数据嗎？')){
				    			    		$.ajax({
				    			    			url:"removeMoreEmployees.action",
				    			    			type:"get",
				    			    			data:{
				    			    				emp_ids:chk_value,
				    			    				"currentPage":currentPage
				    			    			},
				    			    			success: function(msg){
				    			    				if(msg.type=="success"){
				    			    					alert("刪除成功");
				    			    					//同时当前页和记录数等都要改变(不加这一句会有问题，当前页这些数据不会刷新) */
				    			    					window.location.href = window.location.href;
				    			    					//location.reload();
				    			    					
				    			    			    }else{
				    			    			    	alert("刪除失敗");
				    			    				}
				    			    			}
				    			    		   
				    			    			});
				    			            return true;
				    			         }else{
				    			            //alert("取消");
				    			            return false;
				    			        }
    					
    			    }else{
    			    	if(msg.type=="1"){
    			    		alert("请先移除这些顾客的负责员工");
    			    	}else if(msg.type=="2"){
    			    		alert("请先删除这些顾客的访问记录");
    			    	}else{
    			    		alert("请先移除这些顾客的负责员工和该顾客的访问记录");
    			    	}
    				}
    			}
    		   
    			});
    		

          return true;
       }else{
          //alert("取消");
          return false;
      }
    }
	
}


//删除单个用户
/* function removeOneEmployee(emp_id,pageNum,obj){
	
}
 */
//删除一个专员需判断是否有外键
//要先删除共享表有关该顾客的empID 然后再删除该专员（还有共享表）
//
function removeOneEmployeeReadyAndDo(empId,pageNum,obj){
	if(window.confirm('你确定要刪除嗎？')){
		//此时一个请求过去判断能不能删除该专员  即共享表和访问表都要外键判断
		$.ajax({
			url:"removeOneEmployeeReady.action",
			type:"get",
			data:{
				"empId":empId,
				"currentPage":pageNum
			},
			success: function(msg){
				if(msg.type=="success"){
					//此时可以删除
					alert("可以删除");
					
					//***********************************************************
					if(window.confirm('你确定要刪除嗎？')){
						$.ajax({
							url:"removeOneEmployee.action",
							type:"get",
							data:{
								"emp_id":empId,
								"currentPage":pageNum
							},
							success: function(msg){
								if(msg.type=="success"){
									alert("刪除成功");
									//刪掉 byid的節點(其实这里可以不用反正我刷新该页面了)
									var tr=obj.parentNode.parentNode;
									var tbody=tr.parentNode;
									tbody.removeChild(tr);
									//同时当前页和记录数等都要改变(不加这一句会有问题，当前页这些数据不会刷新)
									//window.location.href = window.location.href;
									location.reload();
									
							    }else{
							    	alert("刪除失敗");
								}
							}
						   
							});
						
						//
				        return true;
				     }else{
				        //alert("取消");
				        return false;
				    }
					
			    }else{
			    	if(msg.type=="1"){
			    		alert("请先移除该顾客的负责员工");
			    	}else if(msg.type=="2"){
			    		alert("请先删除该顾客的访问记录");
			    	}else{
			    		alert("请先移除该顾客的负责员工和该顾客的访问记录");
			    	}
				}
			}
		   
			});
		

      return true;
   }else{
      //alert("取消");
      return false;
  }
}




function modifyEmployee(obj){
	//var d = {};
	var emp_value =[]; 
	var t = $('form').serializeArray();
	//t的值为[{name: "a1", value: "xx"},
	//{name: "a2", value: "xx"}...]
	$.each(t, function() {
	    //d[this.name] = this.value;
		emp_value.push(this.value);
	});
	//alert(JSON.stringify(d));
	//模态框数据验证
	var token = true;
	var patternEmail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var patternTel = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
	if(emp_value[1]=='' || emp_value[1].trim().length == 0 ){
		alert('请输入用户名：');
		token = false;
	}else if(emp_value[2]=='' || emp_value[2].trim().length == 0 ){
		alert('请输入密码：');
		token = false;
	}else if(!patternTel.test(emp_value[3])){
		token = false;
        alert("错误的手机号！");
    }else if(emp_value[4]=='' || emp_value[4].trim().length == 0 ){
		alert('请输入员工名字：');
		token = false;
	}else if(!patternEmail.test(emp_value[5])) {
		token = false;
        alert("错误的Email格式！");
    }else if(emp_value[6] < 1) {
    	token = false;
        alert("请选择员工类型！");
    }
	
	if(token == true){
		if(window.confirm('确定要修改嗎？')){
			$.ajax({
				url:"modifyEmployee.action",
				type:"get",
				data:{
					"empId":emp_value[0],
					"username":emp_value[1],
					"password":emp_value[2],
					"tel":emp_value[3],
					"name":emp_value[4],
					"email":emp_value[5],
					"emptype":emp_value[6]
					
				},
				success: function(msg){
					
					 if(msg.type=="success"){
						alert("修改成功");
						//同时当前页和记录数等都要改变(不加这一句会有问题，当前页这些数据不会刷新)
						//window.location.href = window.location.href;
						location.reload();
						
				    }else{
				    	alert("修改失敗");
					} 
				}
			   
				});
	        return true;
	     }else{
	        //alert("取消");
	        return false;
	    }  
	}
	
	
 	
}
	


//修改模态框
function motai(obj){
	var tr = obj.parentNode.parentNode;
	var $tr =$(tr);
	var childs = $tr.children();
	/* for(var i=0+1;i<childs.length-1;i++){
		alert(childs[i].innerHTML);
	} */
	//0选择 1、id所以从2开始
	$("#empId").val(childs[1].innerHTML);
	$("#username").val(childs[2].innerHTML);
	$("#password").val(childs[3].innerHTML);
	$("#tel").val(childs[4].innerHTML);
	$("#name").val(childs[5].innerHTML);
	$("#email").val(childs[6].innerHTML);
	if(childs[7].innerHTML =="经理" ){
		$("#emptype option[value='1'] ").attr("selected",true)
	}else if(childs[7].innerHTML =="普通员工" ){
		$("#emptype option[value='2'] ").attr("selected",true)
	}else{
		$("#emptype option[value='0'] ").attr("selected",true)
	}

}

</script>

</head>
<!-- 模态框美化 -->
<link href="css/font-awesomeForEmployee.min.css" rel="stylesheet"
	type="text/css" media="all">

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

<body>
	<div class="container">
		<!-- 标题行 -->
		<div class="row">
			<div class="col-md-12">
				<h1>员工管理页面</h1>
			</div>
		</div>
		<!-- 按钮行 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<!-- <button type="button" class="btn btn-primary">新增</button> -->
				<a class="btn btn-primary" href="addEmployee.action">新增</a>
				<button type="button" class="btn btn-danger"
					onclick="removeMoreEmployees(${pageInfo.pageNum},this)">删除(批量)</button>
				<!-- <a class="btn btn-primary" href="oneClickExport.action">一键导出本页数据</a> -->
			</div>
		</div>
		<!-- 表格数据行 -->
		<div class="row">
			<table class="table table-hover" id="mytable">
				<thead>
					<tr>
						<th>选择</th>
						<th>员工id</th>
						<th>员工登錄名</th>
						<th>員工密码</th>
						<th>員工電話</th>
						<th>員工姓名</th>
						<th>員工郵箱</th>
						<th>員工类型</th>
					</tr>
				</thead>
				<tbody>
					<!--
						                             从Model里拿到存放员工信息的list，在遍历之前要引入核心标签库，uri="http://java.sun.com/jsp/jstl/core" prefix="c"
						                             然后使用EL表达式获取employee的各个属性值，之后的两个按钮使用bootstrap组件按钮和字体图标，看看官方文档没什么好讲的
                          -->
					<c:forEach items="${pageInfo.list}" var="employee">
						<tr>
							<td><input type="checkBox" style="margin-top: 8px;"
								name="emp_ids" value="${employee.empId}" /></td>
							<td>${employee.empId}</td>
							<td>${employee.username}</td>
							<td>${employee.password}</td>
							<td>${employee.tel}</td>
							<td>${employee.name}</td>
							<td>${employee.email}</td>
							<td>${employee.emptype}</td>
							<td>
								<!-- 单个编辑我想用模态框 -->

								<button class="btn btn-primary btn" data-toggle="modal"
									data-target="#myModal" onclick="motai(this)">
									编辑 <span class="glyphicon glyphicon-pencil" aria-hidden="true"
										style="width: 100%;"></span>
								</button>

								<button class="btn btn-primary btn-xs" aria-label="Left Align"
									onclick="removeOneEmployeeReadyAndDo(${employee.empId},${pageInfo.pageNum},this)">
									删除<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</button>
							</td>
						</tr>
					</c:forEach>

					<!-- Modal -->
					<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">修改专员</h4>
								</div>
								<div class="modal-body">
									<!-- ========================================================= -->
									<div class="container">
										<form>
											<input type="text" class="form-control" name="empId"
												id="empId" hidden>
											<div class="form-group">
												<label for="user">员工登錄名:</label> <input type="text"
													class="form-control" name="username" id="username"
													placeholder="" readonly>
											</div>
											<div class="form-group">
												<label for="pwd">員工密码:</label> <input type="text"
													class="form-control" name="password" id="password"
													placeholder="">
											</div>
											<div class="form-group">
												<label for="tel">員工電話:</label> <input type="text"
													class="form-control" name="tel" id="tel" placeholder="">
											</div>
											<div class="form-group">
												<label for="user">員工姓名:</label> <input type="text"
													class="form-control" name="name" id="name" placeholder="">
											</div>
											<div class="form-group">
												<label for="email">員工郵箱:</label> <input type="email"
													class="form-control" name="email" id="email" placeholder="">
											</div>
											<div class="form-check">
												<label class="form-check-label"> <select
													class="text" name="emptype" id="emptype">
														<option value="0">请选择身份</option>
														<option value="1">经理</option>
														<option value="2">普通员工</option>
												</select>
												</label>
											</div>
											<!--  <button type="submit" class="btn btn-primary" style="margin-left:70%;">Save changes</button> -->
										</form>
									</div>
									<!-- ========================================================= -->
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary"
										onclick="modifyEmployee(this)">Save changes</button>
								</div>
							</div>
						</div>
					</div>


				</tbody>
			</table>
		</div>
		<!-- 提示分页信息行 -->
		<div class="row">
			<!-- 分页文字信息 ：拿到控制器处理请求时封装在pageInfo里面的分页信息-->
			<div class="col-md-6">当前${pageInfo.pageNum}页,共${pageInfo.pages }页,总${pageInfo.total }条记录
			</div>
			<!-- 分页码 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<!-- 
                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
                        2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
                      -->
					<li><a
						href="${pageContext.request.contextPath}/deleteEmployee.action?pn=1">首页</a>
					</li>
					<!-- 如果还有前页就访问当前页码-1的页面， -->
					<c:if test="${pageInfo.hasPreviousPage}">
						<li><a
							href="${pageContext.request.contextPath}/deleteEmployee.action?pn=${pageInfo.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<li>
						<!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  --> <c:forEach
							items="${pageInfo.navigatepageNums }" var="page_Nums">
							<c:if test="${page_Nums==pageInfo.pageNum }">
								<li class="active"><a href="#">${page_Nums}</a></li>
							</c:if>
							<c:if test="${page_Nums!=pageInfo.pageNum }">
								<li><a
									href="${pageContext.request.contextPath}/deleteEmployee.action?pn=${page_Nums}">${page_Nums}</a></li>
							</c:if>
						</c:forEach>
					</li>
					<!-- 如果还有后页就访问当前页码+1的页面， -->
					<c:if test="${pageInfo.hasNextPage}">
						<li><a
							href="${pageContext.request.contextPath}/deleteEmployee.action?pn=${pageInfo.pageNum+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a
						href="${pageContext.request.contextPath}/deleteEmployee.action?pn=${pageInfo.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>

</body>
</html>