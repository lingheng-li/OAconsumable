<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>低值易耗品台账</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript">
	/* $(function(){
		$("#button").click(function() {
			$("#stangingbook").addClass("active");
		});
	}); */
	$(function(){
			$.get(
				"stangingbook",
				//{deptNo:$("#menu").val()},
				success,
				"jion"
			);
	});
	function success(data){
		//for(var i=0;i<cobj.length;i++){
		//var cobj = cobj[i];
		// alert(cobj.consumable_name);
		/* var $tr=$("<tr></tr>");
		var $td1=$("<td></td>");
		var $td2=$("<td></td>");
		var $td3=$("<td></td>");
		var $td4=$("<td></td>");
		var $td5=$("<td></td>");
		var $td6=$("<td></td>");
		var $td7=$("<td></td>");
		var $td8=$("<td></td>");
		//低值易耗品名称
		$td1.text(cobj.consumable_name);
		//低值易耗品编码
		$td2.text(cobj.consumable_num);
		//购置时间
		$td3.text(cobj.accept_time);
		//对应购置计划审批表编号
		$td4.text(cobj.tablenum);
		//数量
		$td5.text(cobj.consumable_num);
		//单价（元）
		$td6.text(cobj.tax_price);
		//存放点
		$td7.text(cobj.address);
		//使用人
		$td8.text(cobj.emp_name);  */
		// alert(data);
		} 
	
	/* function fun(adasd){
			$("").text(adasd);
		}
		function fun2(){
			alert("网络延迟..");
		} */
	
</script>
<style type="text/css">
td {
	vertical-align: middle;
}

</style>
  </head>
  
  <body>
  <jsp:include page="/include/OAMainMenus.jsp" flush="true" >
  	<jsp:param name="thisMuen" value="stangingbook" />
  </jsp:include>
  	<form action="stangingbook" method="post">
		<table class="table table-bordered">
			<tr>
				<td colspan="9" align="center">低值易耗品台账</td>
			</tr>
    		<tr align="center">
    			<td colspan="2">部门（单位）盖章：</td>
    			<td ></td>
    			<td ></td>
    			<td ></td>
    			<td ></td>
    			<td ></td>
    			<td ></td>
    			<td ></td>
    		</tr>
			<tr align="center">
				<td style="vertical-align:middle;">序号</td>
				<td style="vertical-align:middle;">低值易耗品名称</td>
				<td style="vertical-align:middle;">低值易耗品编码</td>
				<td style="vertical-align:middle;">购置时间</td>
				<td style="vertical-align:middle;">对应购置计划审批表编号</td>
				<td style="vertical-align:middle;">数量</td>
				<td style="vertical-align:middle;">单价（元）</td>
				<td style="vertical-align:middle;">存放点</td>
				<td style="vertical-align:middle;">使用人</td>
			</tr>	
				<c:forEach items="${cobj}" var="str" varStatus="vs">
	    		<tr id="menu">
					<td style="vertical-align:middle; width:50px">
						<!-- 序号 -->  <input type="text"
						class=".input-mini form-control" value="${str.id}">
					</td>
					<td>
						<!-- 低值易耗品名称--> <input type="text"
						class=".input-mini form-control" value="${str.consumable_name}">
					</td>
					<td>
						<!-- 低值易耗品编码 --> <input type="text"
						class=".input-mini form-control" value="${str.consumable_num}">
					</td>
					<td>
						<!-- 购置时间 --> <input type="text"
						class=".input-mini form-control" value="${str.accept_time}">
					</td>
					<td>
						<!-- 对应购置计划审批表编号--> 
						<input type="text" class=".input-mini form-control" value="${str.tablenum}">
					</td>
					<td>
						<!-- 数量--> <input type="text" class=".input-mini form-control" value="${str.consumable_num}">
					</td>
					<td>
						<!-- 单价（元） --> <input type="text"
						class=".input-mini form-control" value="${str.tax_price}">
					</td>
					<td>
						<!-- 存放点 --> <input type="text"
						class=".input-mini form-control" value="${str.address}">
					</td>
					<td>
						<!-- 使用人 --> <input type="text"
						class=".input-mini form-control" value="${str.emp_name}">
					</td>
				</tr>
			</c:forEach>
    	</table>
    </form>
  </body>
</html>
