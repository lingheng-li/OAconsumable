<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.chiansofti.entity.Emp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>购置申请单</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js">
</script>

<script type="text/javascript">
$(function(){
	$("#button").click(function() {
		$("#").addClass("active");
	});
});


function  tteess(id){
		$.get(
			"ApplyAuditServlet",
			{tablenumid:$("#tablenum"+id).val()},
			success1
		);
	}
function  bbbaa(id){
	$.get(
		"ApplystatusServlet",
		{tablenumid:$("#tablenum"+id).val()},
		success2
	);
}

function success1(empList){
	alert("审核成功！");
	window.location.reload();
};

function success2(empList){
	alert("驳回成功！");
	window.location.reload();
};
</script>

<style type="text/css">
td {
	vertical-align: middle;
}
</style>

</head>
<body>
<jsp:include page="/include/OAMainMenus.jsp" flush="true">
		<jsp:param name="thisMuen" value="ApplyFaceServlet" />
	</jsp:include>
		<table class="table table-bordered">
			
			<tr>
				<td colspan="9" align="center">低值易耗品购置申请单</td>
			</tr>
			
			<tr>
				<td colspan="8" style="vertical-align:middle;">
					<div >
						<select class="form-control">
							<option value = "1">长江勘测规划设计研究院</option>
							<option value = "1B001">长江勘测规划设计研究研究厄瓜多尔分公司</option>
							<option value = "1B002">长江勘测规划设计研究研究秘鲁分公司</option>
							<option value = "1D001">长江勘测规划设计研究有限责任公司</option>
							<option value = "1D001C005">长江勘测规划设计研究有限责任公司上海分公司</option>
							<option value = "1D001C006">长江勘测规划设计研究有限责任公司西藏分公司</option>
							<option value = "1D001C006">长江勘测规划设计研究有限责任公司广州分公司</option>
							<option value = "1D001C011">长江勘测规划设计研究有限责任公司重庆分公司</option>
							<option value = "1D001C014">长江勘测规划设计研究有限责任公司巴基斯坦分公司</option>
							<option value = "1D001C019">长江勘测规划设计研究有限责任公司云南分公司</option>
							<option value = "1D001C020">长江勘测规划设计研究有限责任公司四川分公司</option>
							<option value = "1D001C021">长江勘测规划设计研究有限责任公司浙江分公司</option>
							<option value = "1D001D001">长江中兴工程顾问（平潭）有限责任公司</option>
						</select>
					</div>
				</td>
				<th style="vertical-align:middle;">低值易耗品购置申请单</th>
			</tr>
			
			<tr align="center">
				<td colspan="2" style="vertical-align:middle;">所在单位</td>
				<td colspan="7" style="vertical-align:middle;"><input type="text" value="${sessionScope.emp.deptno}"class=".input-mini form-control"></td>
			</tr>
			
       </table>
       <c:if test="${sessionScope.emp.power==0}">
	    <table id="table" class="table table-bordered">
   			<tr id="tr1" align="center">
				<td rowspan="2" colspan="1" style="vertical-align:middle;">序号</td>
				<td rowspan="2" colspan="1"style="vertical-align:middle;">低值易耗品编码</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">低值易耗品名称</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">单价（元）</td>
				<td rowspan="2" colspan="2" style="vertical-align:middle;">数量</td>
				<td rowspan="2" colspan="2" style="vertical-align:middle;">总价（元）</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">审核状态</td>
			</tr>
		  	 <tr align="center">
			</tr> 
			 <c:if test="${list != null}"> 
				<c:forEach var="Applylo" items="${list}" varStatus="status">
					<tr>
						<td colspan="1" align="center" class="value" ><input id="tablenum" class=".input-mini form-control" name="sqdxh"  value="${Applylo.tablenum}" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="yhpName"  value="${Applylo.consumable_code}" ignore="ignore" datatype="*1-50" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="yhpCode"  value="${Applylo.consumable_name}" ignore="ignore" datatype="*1-50" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="price"  value="${Applylo.consumable_price}" ignore="ignore" datatype="*1-50" readonly></td>
						<td colspan="2" class="value"><input class=".input-mini form-control" name="amount"  value="${Applylo.consumable_number}" ignore="ignore" datatype="*1-100" readonly></td>
						<td colspan="2" class="value"><input class=".input-mini form-control" name="totalPrice"  value="${Applylo.totalPrice}" ignore="ignore" datatype="*1-100" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="applystatus"  value="${Applylo.applystatus}" ignore="ignore" datatype="*1-100" readonly></td>
					</tr>
				</c:forEach>
 			</c:if>	
 			</table>
   		</c:if>
   		<c:if test="${sessionScope.emp.power!=0}">
   		 <table id="table" class="table table-bordered">
   			<tr id="tr1" align="center">
				<td rowspan="2" colspan="1" style="vertical-align:middle;">序号</td>
				<td rowspan="2" colspan="1"style="vertical-align:middle;">低值易耗品编码</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">低值易耗品名称</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">单价（元）</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">数量</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">总价（元）</td>
				<td rowspan="2" colspan="3" style="vertical-align:middle;">操作</td>
			</tr>
		  	 <tr align="center">
			</tr> 
			 <c:if test="${list != null}"> 
				<c:forEach var="Applylo" items="${list}" varStatus="status">
					<tr>
						<td colspan="1" align="center" class="value" ><input id="tablenum${status.index}" class=".input-mini form-control" name="sqdxh"  value="${Applylo.tablenum}" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="yhpName"  value="${Applylo.consumable_code}" ignore="ignore" datatype="*1-50" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="yhpCode"  value="${Applylo.consumable_name}" ignore="ignore" datatype="*1-50" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="price"  value="${Applylo.consumable_price}" ignore="ignore" datatype="*1-50" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="amount"  value="${Applylo.consumable_number}" ignore="ignore" datatype="*1-100" readonly></td>
						<td colspan="1" class="value"><input class=".input-mini form-control" name="totalPrice"  value="${Applylo.totalPrice}" ignore="ignore" datatype="*1-100" readonly></td>
						<td colspan="3" class="value" align="center">
						<button onclick="tteess(${status.index})" style="width:100px;" type="button" class="btn btn-default btn-block">审核</button>
						<button onclick="bbbaa(${status.index})" style="width:100px;" type="button" class="btn btn-default btn-block">驳回</button>
						</td>		
					</tr>
				</c:forEach>
 			</c:if>	
			</table>
				<table class="table table-bordered">
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">部门审核人</td>
				<td colspan="6" style="vertical-align:middle;"><input value="${sessionScope.emp.empname}" type="text" class=".input-mini form-control" readonly></td>
			</tr>
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">备注</td>
				<td colspan="6" style="vertical-align:middle;"><input type="text" class=".input-mini form-control" ></td>

			<tr>
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">部门(单位)盖章</td>
				<td colspan="6" style="vertical-align:middle;"><input type="text" class=".input-mini form-control" readonly></td>

			<!-- <tr>
				<td id ="button" colspan="9" align="center">
					<button style="width:100px;"type="button" class="btn btn-default btn-block">提交审核</button>
				</td>
			</tr>  -->
					
		</table>
			</c:if>
			
</body>

</html> 



