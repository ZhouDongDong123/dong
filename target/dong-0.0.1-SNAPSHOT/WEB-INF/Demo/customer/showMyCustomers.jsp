<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}${'/'}">
<title>显示所有客户页面</title>

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

</head>
<!-- 模态框美化 -->
<link href="css/font-awesomeForcustomer.min.css" rel="stylesheet"
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

<script>



$(document).ready(function(){
	//ajax请求返回所有的专员信息然后添加到模态框供选择
	//初始化页面这个应该在页面加载完成之后就完成
	//这里返回的对象很明显不应该带客户专员密码
	$.ajax({
		url:"findAllEmployeesOnCunstomer.action",
		type:"get",
		//Content-Type: "application/json;charset=utf-8",
		data:{
			
		},
		success: function(msg){
			//msg就是list对象可以length获取长度也可以遍历选择单个对象
			//<div class="custom-control custom-checkbox">
			 //   <input type="checkbox" name id="defaultUnchecked" value="msg[i].empId" name=selectEmployees>
			//    <label class="custom-control-label" for="defaultUnchecked">&nbsp&nbsp&nbsp&nbsp&nbsp   Default unchecked</label>
			//</div>
			//$(“body”).append($h1);
			var div = document.createElement("div");
			div.setAttribute("class","custom-control custom-checkbox");// 
			var $employeeForm = $("#FormOnChangerEmployee");
			for(var i=0;i<msg.length;i++){
				
				var label = document.createElement("label");
				//label.setAttribute("class","custom-control-label");
				//label.setAttribute("for","defaultUnchecked");
				var username=msg[i].username; 
				label.innerHTML=username;
				
				var input = document.createElement("input");
				input.setAttribute("type","checkbox");
			//	input.setAttribute("class","custom-control-input");
				input.setAttribute("id","defaultUnchecked");
				input.setAttribute("name","selectEmployees");
				//这个还应该给属性value已标记这个专员id
				input.setAttribute("value",msg[i].empId);
				div.appendChild(input);
				div.appendChild(label);
				$employeeForm[0].appendChild(div);
			}
			
		}
		});
})

function modifyEmployeesReady(cid,pageNum,obj){
	//通过cid查找该顾客选择的专员
	$.ajax({
		url:"findSelectedEmployeesOnCunstomer.action",
		type:"get",
		//Content-Type: "application/json;charset=utf-8",
		data:{
			"cid":cid
		},
		success: function(msg){
			 $("#cidInFormOnChangerEmployee").attr("value",cid);
			if(msg.length!=0){
				  //
				  
				  $("input[name='selectEmployees']").attr("checked", false);
				  
				  for(var i=0;i<msg.length;i++){
					  $("input[name='selectEmployees'][value='"+msg[i].empId+"']").attr("checked", true);
				  }
			}else{
				alert("无专员负责");
			}
			 
		}
		});
}
function modifyEmployeesDo(obj,pageNum){
	//1、通过cid查找该顾客选择的有的专员
	//2、得到所有选中的专员
	var chk_value =[];//定义一个数组    
    $('input[name="selectEmployees"]:checked').each(function(){//遍历每一个名字为nodes的复选框，其中选中的执行函数    
    	chk_value.push($(this).val());//将选中的值添加到数组chk_value中    
    });
    //alert(chk_value);
    var cid = $("#cidInFormOnChangerEmployee").val();
	//3、遍历选中的专员id 如果在 已经在专员id集合内（不做任何事）不在的话共享表加上（add）也就是把这个顾客分给这些员工
	//4、遍历已经有的专员id集，如果专员id 不在选中的id内（移除该员工），在的话共享表（不做任何事）
	if(chk_value.length==0){
		if(window.confirm('注意此时该顾客没有专员负责专员!!!你确定继续嗎？')){
			$.ajax({
				url:"removeAllEmployeesDo.action",
				type:"get",
				data:{
					"cid":cid,
				},
				success: function(msg){
					if(msg.type=="success"){
						alert("修改成功");
						//同时当前页和记录数等都要改变(不加这一句会有问题，当前页这些数据不会刷新) */
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
		
	}else{
		if(window.confirm('你确定要重新分配员工嗎？')){
			$.ajax({
				url:"modifyEmployeesDoThing.action",
				type:"get",
				data:{
					"emp_ids" : chk_value,
					"cid":cid,
					"pageNum":pageNum,
				},
				success: function(msg){
					if(msg.type=="success"){
						alert("修改成功");
						//同时当前页和记录数等都要改变(不加这一句会有问题，当前页这些数据不会刷新) */
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
//删除一个顾客
//要先删除共享表有关该顾客的cid 然后再删除该用户
//删除单个用户
function removeOnecustomer(cid,pageNum,obj){
	if(window.confirm('你确定要刪除嗎？')){
		//此时一个请求过去判断能不能删除该顾客  即共享表和访问表都要外键判断
		
		$.ajax({
			url:"removeOneCustomerReady.action",
			type:"get",
			data:{
				"cid":cid,
			},
			success: function(msg){
				if(msg.type=="success"){
					//此时可以删除
					alert("可以删除");
					//************************************************
					$.ajax({
						url:"removeOneCustomer.action",
						type:"get",
						data:{
							"cid":cid,
							"currentPage":pageNum
						},
						success: function(msgTwo){
							if(msgTwo.type=="success"){
								//此时可以删除
								alert("刪除成功");
								//同时当前页和记录数等都要改变(不加这一句会有问题，当前页这些数据不会刷新)
								//window.location.href = window.location.href;
								location.reload();
								
						    }else{
						    	alert("刪除失敗");
							}
						}
					});
					
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
		
		
		
		
		/* 
	 	$.ajax({
			url:"removeOneEmployee.action",
			type:"get",
			data:{
				"emp_id":emp_id,
				"currentPage":pageNum
			},
			success: function(msg){
				if(msg.type=="success"){
					//此时可以删除
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
		   
			}); */
        return true;
     }else{
        //alert("取消");
        return false;
    }
}

//修改模态框
function motai(obj){
	var tr = obj.parentNode.parentNode;
	var $tr =$(tr);
	//得到所有表单数据
	var childs = $tr.children();
	//0选择 1、id所以从2开始
	$("#cid").val(childs[1].innerHTML);
	$("#cusname").val(childs[2].innerHTML);
	$("#address").val(childs[3].innerHTML);
	$("#contact").val(childs[4].innerHTML);
	$("#tel").val(childs[5].innerHTML);
	$("#email").val(childs[6].innerHTML);
}

//改 在数据库中
function modifycustomer(obj){
	//var d = {};
	var emp_value =[]; 
	var t = $('#customForm').serializeArray();
	//t的值为[{name: "a1", value: "xx"},
	//{name: "a2", value: "xx"}...]
	$.each(t, function() {
	    //d[this.name] = this.value;
		emp_value.push(this.value);
	});
	//alert(JSON.stringify(d));
	//alert(emp_value);
 	if(window.confirm('确定要修改嗎？')){
		$.ajax({
			url:"modifycustomer.action",
			type:"get",
			data:{
				"cid":emp_value[0],
				"cusname":emp_value[1],
				"address":emp_value[2],
				"contact":emp_value[3],
				"tel":emp_value[4],
				"email":emp_value[5]
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




</script>





<body>
	<div class="container">
		<!-- 标题行 -->
		<div class="row">
			<div class="col-md-12">
				<h1>顾客管理页面</h1>
			</div>
		</div>
		<!-- 按钮行 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<!-- <button type="button" class="btn btn-primary">新增</button> -->
				<a class="btn btn-primary" href="jumpAddMyCustomerPage.action">新增</a>
				<button type="button" class="btn btn-danger">(-_-)</button>
				<!-- <a class="btn btn-primary" href="oneClickExport.action">一键导出本页数据</a> -->
			</div>
		</div>
		<!-- 表格数据行 -->
		<div class="row">
			<table class="table table-hover" id="mytable">
				<thead>
					<tr>
						<!-- cid | cusName | Address  | contact | tel    | email        | username | -->
						<th>所属专员</th>
						<th>顾客id</th>
						<th>顾客名字</th>
						<th>顾客地址</th>
						<th>顾客联系人</th>
						<th>顾客電話</th>
						<th>顾客郵箱</th>
					</tr>
				</thead>
				<tbody>
					<!--
						                             从Model里拿到存放顾客信息的list，在遍历之前要引入核心标签库，uri="http://java.sun.com/jsp/jstl/core" prefix="c"
						                             然后使用EL表达式获取customer的各个属性值，之后的两个按钮使用bootstrap组件按钮和字体图标，看看官方文档没什么好讲的
                          -->
					<c:forEach items="${pageInfo.list}" var="customer">
						<tr>
							<td>${customer.username}</td>
							<td>${customer.cid}</td>
							<td>${customer.cusname}</td>
							<td>${customer.address}</td>
							<td>${customer.contact}</td>
							<td>${customer.tel}</td>
							<td>${customer.email}</td>
							<td>
								<!-- 单个编辑我想用模态框 -->

								<button class="btn btn-primary btn" data-toggle="modal"
									data-target="#myModal" onclick="motai(this)">
									编辑 <span class="glyphicon glyphicon-pencil" aria-hidden="true"
										style="width: 100%;"></span>
								</button>

								<button class="btn btn-primary btn-xs" aria-label="Left Align"
									data-toggle="modal" data-target="#myModalForModifyEmployees"
									onclick="modifyEmployeesReady(${customer.cid},${pageInfo.pageNum},this)">
									专员<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</button>
								<button class="btn btn-primary btn-xs" aria-label="Left Align" onclick="removeOnecustomer(${customer.cid},${pageInfo.pageNum},this)">
									删除<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</button>
							</td>
						</tr>
					</c:forEach>

					<!-- 编辑模态Modal -->
					<div class="modal fade bs-example-modal-sm" id="myModal"
						tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">修改顾客</h4>
								</div>
								<div class="modal-body">
									<!-- ========================================================= -->
									<div class="container">
										<form id="customForm">
											<input type="text" class="form-control" name="cid" id="cid"
												hidden>
											<div class="form-group">
												<label for="user">顾客名字:</label> <input type="text"
													class="form-control" name="cusname" id="cusname"
													placeholder="" readonly>
											</div>
											<div class="form-group">
												<label for="pwd">顾客地址:</label> <input type="text"
													class="form-control" name="address" id="address"
													placeholder="">
											</div>
											<div class="form-group">
												<label for="tel">顾客联系人:</label> <input type="text"
													class="form-control" name="contact" id="contact"
													placeholder="">
											</div>
											<div class="form-group">
												<label for="user">顾客電話:</label> <input type="text"
													class="form-control" name="tel" id="tel" placeholder="">
											</div>
											<div class="form-group">
												<label for="email">顾客郵箱:</label> <input type="email"
													class="form-control" name="email" id="email" placeholder="">
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
										onclick="modifycustomer(this)">Save changes</button>
								</div>
							</div>
						</div>
					</div>

					<!-- =============================================================================== -->
					<!-- 编辑专员模态Modal -->
					<div class="modal fade bs-example-modal-sm" id="myModalForModifyEmployees" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">修改顾客专员信息</h4>
										</div>
										<div class="modal-body">
											<!-- ========================================================= -->
											<div class="container">
												<form id="FormOnChangerEmployee">
													<input type="text" class="form-control" name="cid" id="cidInFormOnChangerEmployee" hidden>
													<!-- 内容 -->
												</form>
											</div>
											<!-- ========================================================= -->
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary"
												onclick="modifyEmployeesDo(this,${pageInfo.pageNum})">Save
												changes</button>
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
					<li><a href="findmyCustomers.action?pn=1">首页</a></li>
					<!-- 如果还有前页就访问当前页码-1的页面， -->
					<c:if test="${pageInfo.hasPreviousPage}">
						<li><a
							href="findmyCustomers.action?pn=${pageInfo.pageNum-1}"
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
								<li><a href="findmyCustomers.action?pn=${page_Nums}">${page_Nums}</a></li>
							</c:if>
						</c:forEach>
					</li>
					<!-- 如果还有后页就访问当前页码+1的页面， -->
					<c:if test="${pageInfo.hasNextPage}">
						<li><a
							href="findmyCustomers.action?pn=${pageInfo.pageNum+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="findmyCustomers.action?pn=${pageInfo.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>

</body>
</html>