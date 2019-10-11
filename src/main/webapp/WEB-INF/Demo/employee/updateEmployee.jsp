<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}${'/'}">
<title>员工管理页面</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
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
                <a class="btn btn-primary" href="addEmployeeForPageJump.action">新增</a>
                <button type="button" class="btn btn-danger ">修改(批量)</button>
                <!-- <a class="btn btn-primary" href="oneClickExport.action">一键导出本页数据</a> -->
            </div>
        </div>
        <!-- 表格数据行 -->
        <div class="row">
            <table class="table table-hover">
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
                     	 	<td><input type="checkBox" style="margin-top: 8px;" name="" value="${employee.empId}"/></td>
                            <td>${employee.empId}</td>
                            <td>${employee.username}</td>
                            <td>${employee.password}</td>
                            <td>${employee.tel}</td>
                            <td>${employee.name}</td>
                            <td>${employee.email}</td>
                            <td>${employee.emptype}</td>
                         <td>
                         	<!-- 单个编辑我想用模态框 -->
                            <button class="btn btn-primary btn-xs">
                             	     编辑<span class="glyphicon glyphicon-pencil" aria-hidden="true" style="width: 100%;"  data-toggle="modal" data-target="#myModal"></span>
                            </button>
                            			 <!-- <button type="button" class="btn btn-danger btn-block"  style="width: 100%;"  data-toggle="modal" data-target="#myModal" >
											  增加类别
										</button> -->
										
										<!--
										<div id="modal" >
											Modal
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
																get请求url后面链接参数可能会把?给覆盖掉可以使用post或下一句话解决
																<input type="text" name="op" value="addCategorys" hidden="hidden" />
																类别名字:<input class="form-control" type="text" name="category_name"/>
																类别信息:<input class="form-control" type="text" name="category_desc"/>
												        	</div>
												        	<div style="text-align: center;" >
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
                             -->
                            						 
                            					
												     
												      
                            
                            
                            
                            
                            <button class="btn btn-primary btn-xs" aria-label="Left Align">
                         	                   删除<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                         </td>
                    </tr>
                     </c:forEach>
                  </tbody>
            </table>
        </div>
        <!-- 提示分页信息行 -->
        <div class="row">
                <!-- 分页文字信息 ：拿到控制器处理请求时封装在pageInfo里面的分页信息-->
                <div class="col-md-6">
                	    当前${pageInfo.pageNum}页,共${pageInfo.pages }页,总${pageInfo.total }条记录
                </div>
                <!-- 分页码 -->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                      <ul class="pagination">
                      <!-- 
                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
                        2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
                      -->
                       <li>
                            <a href="${pageContext.request.contextPath}/showEmployee.action?pn=1">首页</a>
                       </li>
                       <!-- 如果还有前页就访问当前页码-1的页面， -->
                       <c:if test="${pageInfo.hasPreviousPage}">
                         <li>
                          <a href="${pageContext.request.contextPath}/showEmployee.action?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                          </a>
                        </li>
                       </c:if>
                        <li>
                        <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                          <c:forEach items="${pageInfo.navigatepageNums }" var="page_Nums">
                            <c:if test="${page_Nums==pageInfo.pageNum }">
                             <li class="active"><a href="#">${page_Nums}</a></li>
                            </c:if>
                            <c:if test="${page_Nums!=pageInfo.pageNum }">
                             <li ><a href="${pageContext.request.contextPath}/showEmployee.action?pn=${page_Nums}">${page_Nums}</a></li>
                            </c:if>
                          </c:forEach>
                        </li>
                         <!-- 如果还有后页就访问当前页码+1的页面， -->
                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                              <a href="${pageContext.request.contextPath}/showEmployee.action?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                        </c:if>
                         <li><a href="${pageContext.request.contextPath}/showEmployee.action?pn=${pageInfo.pages}">末页</a></li>
                      </ul>
                    </nav>
                </div>
        </div>
    </div>
</body>
</html>