<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ShowAllocation.jsp</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function() {
			$("#ShowAllocation").addClass("active");
		});
	});
</script>
<style type="text/css">
td {
	vertical-align: middle;
	width:50px;
}
</style>
  </head>
  <body>
  <jsp:include page="/include/OAMainMenus.jsp" flush="true" >
  	<jsp:param name="thisMuen" value="showAllocation" />
  </jsp:include>

  	<form action="" method="post">
		<table class="table table-bordered">
			<tr>
				<td colspan="8" align="center">低值易耗品调拨审批单</td>
			</tr>
			<tr align="center">
				<td>序号</td>
				<td>调拨单编号</td>
				<td>经办人</td>
				<td>经办时间</td>
				<td>调拨单状态</td>
				<td>操作</td>
			</tr>	
			<c:forEach items="${list}" var="allocation" varStatus="status">
    		<tr align="center">
				<td><!-- 序号 -->
				<input type="text" class=".input-mini form-control" value="${allocation.id}">
				</td>
				<td><!-- 调拨表编号 -->
				<input type="text" class=".input-mini form-control" id="id${status.index}" value="${allocation.allocationId}">
				</td> 
				<td>
					<!-- 经办人--> 
					<input type="text" class=".input-mini form-control" value="${allocation.dealer}">
				</td>
				<td>
					<!-- 经办时间 --> 
					<input type="text" class=".input-mini form-control" value="${allocation.create_time}">
				</td>
				<td>
					<!-- 调拨单状态--> 
					<input type="text" class=".input-mini form-control" value="${allocation.state}">
				</td>
				<td>
					<button id="allocation" onclick="Allocation(${status.index})" class="btn">审批</button>
				</td>
			</tr>
			</c:forEach>
    	</table>
    </form>
  </body>
  <script type="text/javascript">
  	function Allocation(id){
  		$.post(
  			"respAllocation",
  			{id:$("#id"+id).val()},
  			success
  		);
  	}
  	function success(id){
  		window.location.href="checkAllocation?id="+id;
  	}
  </script>
</html>
