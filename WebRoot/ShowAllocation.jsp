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
    
    <title>My JSP 'Allocation.jsp' starting page</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#button").click(function() {
			$("#Allocation").addClass("active");
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
<!--   <hr /> -->
  	<form action="" method="post">
		<table class="table table-bordered">
			<tr>
				<td colspan="8" align="center">低值易耗品调拨审批单</td>
			</tr>
			<tr align="center">
				<td style="vertical-align:middle;">序号</td>
				<td style="vertical-align:middle;">调拨单编号</td>
				<td style="vertical-align:middle;">经办人</td>
				<td style="vertical-align:middle;">经办时间</td>
				<td style="vertical-align:middle;">调拨单状态</td>
				<td style="vertical-align:middle;">操作</td>
			</tr>	
			<c:forEach items="${list}" var="allocation">
    		<tr align="center">
				<td>
					<!-- 序号 --> ${allocation.id}
				</td>
				<td>
					<!-- 调拨表编号 --> ${allocation.allocationId}
				</td>
				<td>
					<!-- 经办人--> ${allocation.dealer}
				</td>				
				<td>
					<!-- 经办时间 --> ${allocation.create_time}
				</td>
				<td>
					<!-- 调拨单状态--> ${allocation.state}
				</td>
				<td>
					<button>审批</button>
				</td>
			</tr>
			</c:forEach>
    	</table>
    </form>
  </body>
</html>
