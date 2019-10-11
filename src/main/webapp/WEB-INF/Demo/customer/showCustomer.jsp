<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}${'/'}">
    <title>Free HTML5 Bootstrap Admin Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

        <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<script type="text/javascript">

//这个用于查询
function search_method(){
		$("#searchEmployeeFoJump").submit();
}

</script>


<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"> <img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs"/>
                <span>欢迎光临</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> admin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.html">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> Change Theme / Skin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <!-- <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Dropdown <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li> -->
      
                
                 <li><a href="javascript:void(0);" onclick="search_method()" ><i class="glyphicon glyphicon-globe"></i>search</a></li>
       			<!-- <li><input type="button" /><i class="glyphicon glyphicon-globe"></i>search></li> -->
                <li>
                    <form  action="showEmployeeByCondition.action" class="navbar-search pull-left" id="searchEmployeeFoJump">
                    	<input type="text" name="pn" value="1" id="pn" hidden>
                        <input placeholder="Search" class="search-query form-control col-md-10"
                               type="text" name="condition" id="searchEmployees" >
                    </form>
                </li>
            </ul>

        </div>
    </div>
    <!-- topbar ends -->
<div class="ch-container">
   
    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i>系统管理员</h2>

        <div class="box-icon">
            <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
            <a href="#" class="btn btn-minimize btn-round btn-default"><i
                    class="glyphicon glyphicon-chevron-up"></i></a>
            <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
        </div>
        
    </div>
    <div class="box-content">
    <!-- <div class="alert alert-info">For help with such table please check <a href="http://datatables.net/" target="_blank">http://datatables.net/</a></div> -->
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    	<!-- ============================================================ -->
    	<thead>
		    <tr>
		         <tr>
                      <th>员工id</th>
                      <th>员工登錄名</th>
                      <th>員工密码</th>
                      <th>員工電話</th>
                      <th>員工姓名</th>
                      <th>員工郵箱</th>
                      <th>員工类型</th>
                    </tr>
		    </tr>
	    </thead>
	    <!-- ============================================================ -->
	    <tbody>
	    <!-- pageInfo.list -->
    		<c:forEach items="${pageInfo.list}" var="employee"> 	 
                   	  <tr>
			        <td>${employee.empId}</td>
			        <td class="center">${employee.username}</td>
			        <td class="center">${employee.password}</td>
			       
			        <td class="center">${employee.tel}</td>
			        <td class="center">${employee.name}</td>
			        <td class="center">${employee.email}</td>
			         <td class="center">
			            <span class="label-success label label-default">${employee.tel}</span>
			        </td>
			        
			        <td class="center">
			            <a class="btn btn-success" href="#">
			                <i class="glyphicon glyphicon-zoom-in icon-white"></i>
			                View
			            </a>
			            <a class="btn btn-info" href="#">
			                <i class="glyphicon glyphicon-edit icon-white"></i>
			                Edit
			            </a>
			            <a class="btn btn-danger" href="#">
			                <i class="glyphicon glyphicon-trash icon-white"></i>
			                Delete
			            </a>
			        </td>
			    </tr>

                   </c:forEach>
  
	    </tbody>
	   </table>
    </div>
    </div>
    </div>
    <!--/span-->

    </div><!--/row-->
    
    <!-- 提示分页信息行 -->
        <div class="row">
                <!-- 分页文字信息 ：拿到控制器处理请求时封装在pageInfo里面的分页信息-->
                <div class="col-md-6">
                	    当前${pageInfo.pageNum}页,共${pageInfo.pages }页,总${pageInfo.total }条记录,页大小${pageInfo.pageSize }
                </div>
                <!-- 分页码 -->
                <div class="col-md-6" style="margin-left: 70%;">
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

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
    <div class="row">
        <div class="col-md-9 col-lg-9 col-xs-9 hidden-xs">
            <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
            <!-- Charisma Demo 2 -->
            <ins class="adsbygoogle"
                 style="display:inline-block;width:728px;height:90px"
                 data-ad-client="ca-pub-5108790028230107"
                 data-ad-slot="3193373905"></ins>
            <script>
                (adsbygoogle = window.adsbygoogle || []).push({});
            </script>
        </div>


    </div>
    <!-- Ad ends -->

    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="http://usman.it" target="_blank">欢迎来到本系统</a> 2019-9-30</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="#">Dongdong</a></p>
    </footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>


</body>
</html>
 