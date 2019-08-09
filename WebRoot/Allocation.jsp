<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Allocation.jsp' starting page</title>
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
}

</style>

  </head>
  
  <body>
  <jsp:include page="/include/OAMainMenus.jsp" flush="false" />
  <hr />
  	<form action="" method="post">
		<table class="table table-bordered">
			<tr>
				<td colspan="8" align="center">低值易耗品调拨审批单</td>
			</tr>
    		<tr align="center">
    			<td colspan="2">所在单位</td>
    			<td colspan="2">${emp.deptno}</td>
    			<td colspan="2">调入部门</td>
    			<td colspan="2"><input type="text" class=".input-mini form-control"></td>
    		</tr>
			<tr align="center">
				<td style="vertical-align:middle;">序号</td>
				<td style="vertical-align:middle;">低值易耗品编码</td>
				<td style="vertical-align:middle;">低值易耗品名称</td>
				<td style="vertical-align:middle;">对应购置计划审批表编号</td>
				<td style="vertical-align:middle;">数量</td>
				<td style="vertical-align:middle;">购入价（元）</td>
				<td style="vertical-align:middle;">使用人</td>
				<td style="vertical-align:middle;"><button>添加</button></td>
			</tr>	
    		<tr>
				<td style="vertical-align:middle; width:50px">
					<!-- 序号 --> 1
				</td>
				<td>
					<!-- 低值易耗品编码 --> <input type="text"
					class=".input-mini form-control">
				</td>
				<td>
					<!-- 低值易耗品名称 --> <input type="text"
					class=".input-mini form-control">
				</td>
				<td>
					<!-- 低值易耗品名称 --> <input type="text"
					class=".input-mini form-control">
				</td>
				<td>
					<!-- 数量 --> <input type="text" class=".input-mini form-control">
				</td>
				<td>
					<!-- 单价 --> <input type="text" class=".input-mini form-control">
				</td>

				<td>
					<!-- 使用人 -->
					<div class="input-group">
						<input type="text" class="form-control" aria-label="...">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								&nbsp;<span class="glyphicon glyphicon-user"></span>
							</button>
							<ul class="dropdown-menu dropdown-menu-right">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
					</div>
				</td>
			</tr>
    	</table>
    </form>
  </body>
</html>
