<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <base href="<%=basePath%>"> --%>
<base href="#">

<title>My JSP 'OAMenus.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- <script type="text/javascript" src="js/jquery.min.js"></script> -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous">
	
</script>
<script type="text/javascript">
	$(function() {
		var thisMuen = $("#Menus").attr("name");
		$("#" + thisMuen).addClass("active");
	});
</script>

<script type="text/javascript">
	$(function(){
		$("#checkAndAccept").click(function() {
			$("#checkAndAccept").addClass("active");
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#showAllocation").click(function() {
			$("#showAllocation").addClass("active");
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#Allocation").click(function() {
			$("#Allocation").addClass("active");
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#checkAllocation").click(function() {
			$("#checkAllocation").addClass("active");
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#ApplyForward").click(function() {
			$("#ApplyForward").addClass("active");
		});  
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#ApplyFaceServlet").click(function() {
			$("#ApplyFaceServlet").addClass("active");
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#SelListServlet").click(function() {
			$("#SelListServlet").addClass("active");
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#stangingbook").click(function() {
			$("#stangingbook").addClass("active");
		});
	});
</script>
</head>

<body>
	<%
	    String me = request.getParameter("thisMuen");
	%>

	<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid" id="Menus" name="<%=me%>">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span><span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=basePath%>Main">ConSumableOA</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<!-- <li class="active"><a href="#">低值易耗品购置申请<span
						class="sr-only">(current1)</span></a></li> -->
				<li id="ApplyForward"><a href="<%=path%>/ApplyForward">低值易耗品购置申请</a></li>
				<li id="ApplyFaceServlet"><a href="<%=path%>/ApplyFaceServlet">低值易耗品购置申请审批</a></li>
				<li id="checkAndAccept"><a href="<%=path%>/checkAndAccept">低值易耗品验收</a></li>
				<li id="Allocation"><a href="<%=path%>/Allocation">低值易耗品调拨申请</a></li>
				<li id="showAllocation"><a href="<%=path%>/showAllocation">低值易耗品调拨查询</a></li>
				<li id="checkAllocation"><a>低值易耗品调拨审批</a></li>
				<li id="SelListServlet"><a href="<%=path%>/SelListServlet">低值易耗品处置（报废）</a></li>
				<li id="stangingbook"><a href="<%=path%>/stangingbook">易耗品台帐一览</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><c:if test="${emp!=null }"> ${emp.empname } </c:if><span
					 class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<%=path%>/logOut">退出登录</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">用户注册</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	
</body>
</html>
