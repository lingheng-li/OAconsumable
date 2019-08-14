<%@ page language="java" import="java.util.*,com.chiansofti.entity.Allocation" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>低值易耗品调拨审批</title>
<script
    src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<style type="text/css">
td {
	vertical-align: middle;
}
</style>
  </head>
  <body>
   <jsp:include page="/include/OAMainMenus.jsp" flush="true" >
  	<jsp:param name="thisMuen" value="checkAllocation" /> 
  </jsp:include>
		<table class="table table-bordered">
			<tr>
				<td colspan="8" align="center">低值易耗品调拨审批单</td>
			</tr>
    		<tr align="center">
    			<td colspan="2">所在单位</td>
    			<td colspan="1"><input type="text" class=".input-mini form-control" value="${list[0].fdeptno}"></td>
    			<td colspan="1">审批表编号</td>
    			<td colspan="1"><input type="text" id="allocationid" class=".input-mini form-control" value="${list[0].allocationId}"></td>
    			<td colspan="2">调入部门</td>
    			<td colspan="1"><input type="text" class=".input-mini form-control" id="rdeptno" value="${list[0].rdeptno}"></td>
    		</tr>
			<tr align="center" id="tr">
				<td>序号</td>
				<td>低值易耗品编码</td>
				<td>低值易耗品名称</td>
				<td>对应购置计划审批表编号</td>
				<td>数量</td>
				<td>购入价（元）</td>
				<td>使用人</td>
				<td>预使用人</td>
			</tr>
			<c:forEach items="${list}" var="allocation" varStatus="status">
			<tr align="center" >
		       <td style="width:50px">
		        <input type="text" class=".input-mini form-control" value="${allocation.id}"></td>
				<td><input type="text" class=".input-mini form-control" value="${allocation.consumable.consumable_code}"></td>
				<td><!-- 低值易耗品名称 --> <input type="text" class=".input-mini form-control" value="${allocation.consumable.consumable_name}"></td>
				<td><!-- 表单编号 --> <input type="text" class=".input-mini form-control" value="${allocation.consumable.tablenum}"></td>
				<td><!-- 数量 --> <input type="text" class=".input-mini form-control" value="1"></td>
				<td><!-- 单价 --> <input type="text" class=".input-mini form-control" value="${allocation.consumable.tax_price}"></td>
				<td><!-- 使用人 --><input type="text" class=".input-mini form-control" value="${allocation.consumable.emp_name}"></td>
				<td><!-- 预使用人 --><input type="text" name="user" class=".input-mini form-control" value="${allocation.username}"></td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="2">调出部门审批：</td>
				<td><input type="text" id="user2" class=".input-mini form-control" value=""></td>
				<td>调入部门审批：</td>
				<td><input type="text" id="user5" class=".input-mini form-control" value=""></td>
				<td>财务职产部核实盖章：</td>
				<td colspan="2"><input type="text" id="user8" class=".input-mini form-control" value=""></td>
			</tr>
			<tr align="center">
				<td colspan="2" >负责人：</td>
				<td><input type="text" id="user1" class=".input-mini form-control" value=""></td>
				<td>负责人：</td>
				<td colspan="1" ><input type="text" id="user4" class=".input-mini form-control" value=""></td>
				<td>负责人：</td>
				<td colspan="2"><input type="text" id="user7" class=".input-mini form-control" value=""></td>
			</tr>
			<tr align="center">
				<td colspan="2" >经办人：</td>
				<td><input type="text" id="user" class=".input-mini form-control" value="${list[0].dealer}"></td>
				<td>经办人：</td>
				<td colspan="1"><input type="text" id="user3" class=".input-mini form-control" value=""></td>
				<td>经办人：</td>
				<td colspan="2"><input type="text" id="user6" class=".input-mini form-control" value=""></td>
			</tr>
			<c:if test="${list[0].fdeptno==emp.deptno&&list[0].state<emp.power}">
				<tr>
					<td colspan="8" align="center"><button style="width:100px;"
						id="btn" onclick="allowed()" class="btn btn-default btn-block">同意</button></td>
				</tr>
				<c:if test="${emp.power==2}">
					<tr>
						<td colspan="8" align="center"><button style="width:100px;"
							id="btn" onclick="refuse()" class="btn btn-default btn-block">驳回</button></td>
					</tr>
				</c:if>
			</c:if>
			<c:if test="${list[0].rdeptno==emp.deptno&&(list[0].state-3)<emp.power}">
				<tr>
					<td colspan="8" align="center"><button style="width:100px;"
						id="btn" onclick="allowed()" class="btn btn-default btn-block">同意</button></td>
				</tr>
				<c:if test="${emp.power==2}">
					<tr>
						<td colspan="8" align="center"><button style="width:100px;"
							id="btn" onclick="refuse()" class="btn btn-default btn-block">驳回</button></td>
					</tr>
				</c:if>
			</c:if>
			<c:if test="${emp.deptno=='d102'&&(list[0].state-6)<emp.power}">
				<tr>
					<td colspan="8" align="center"><button style="width:100px;"
						id="btn" onclick="allowed()" class="btn btn-default btn-block">同意</button></td>
				</tr>
				<c:if test="${emp.power==2}">
					<tr>
						<td colspan="8" align="center"><button style="width:100px;"
							id="btn" onclick="refuse()" class="btn btn-default btn-block">驳回</button></td>
					</tr>
				</c:if>
			</c:if>
    	</table>
  </body>
  <script type="text/javascript">
  	var a = '<%= request.getAttribute("state") %>';
  	var p = '<%= request.getAttribute("power") %>';
  	var b="已审批";
  	for(var i=1;i<=a;i++){
  		$("#user"+i).attr("value",b);
  	};
  	var c=parseInt(a)+1;
  	var power = parseInt(p);
   	function allowed(){
		$.post(
			"saveAllocation",
			{state:c,id:$("#allocationid").val()},
			success
		);
  	};

   	function refuse(){
		$.post(
			"saveAllocation",
			{state:power,id:$("#allocationid").val()},
			success
		);
  	}; 
  	function success(date){
  			window.location.href="checkAllocation?id="+$("#allocationid").val();
  	}
  </script>
</html>
