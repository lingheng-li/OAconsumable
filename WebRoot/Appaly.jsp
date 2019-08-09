<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>低值易耗品购置申请单</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery.min.js"></script> 
<script type="text/javascript" src="js/jquery.dataTables.js"></script> 
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
	$(function(){
		$("#button").click(function(){
			$.get(
			"apply",
			{consumable_code:$("#ip1").val(),consumable_name:$("#ip2").val(),consumable_number:$("#ip3").val(),consumable_price:$("#ip4").val()}, 
			success,
			"json"
		);
	})
	});
	
	function success(empList){
	alert("输入正确！");
	}
	
	
/* 	$(document).ready(function () {
	    $("#table").DataTable();
	}); */
	var i =0;
	//添加行
	function addRow() {
	    // i++;
	    var rowTem = '<tr class="tr1' + i+ '">'
	        + '<td align="center">'+(i+2)+'</td>'
	        + '<td><input type="Text" class=".input-mini form-control" id="txt2' + i + '"/></td>'
			+ '<td><input type="Text" class=".input-mini form-control" id="txt3' + i + '"/></td>'
			+ '<td><input type="Text" class=".input-mini form-control" id="txt4' + i + '"/></td>'
			+ '<td colspan="2"><input type="Text" class=".input-mini form-control" id="txt5' + i + '"/></td>'
			+ '<td colspan="2"><input type="Text" class=".input-mini form-control" id="txt6' + i + '"/></td>'
	        + '<td align="center"><input type="button"  onclick=delRow('+i+') style="background: url(images/delete.png)no-repeat; width:100px; height:40px;display:block;" ></td>'
	        + '</tr>';
	      $("#table tbody:last").append(rowTem);
		  i++;
	
	}
	//删除行
	function delRow(_id) {
	    $("#table .tr1"+_id).hide();
	    i--;
	}
</script>

<style type="text/css">
td {
	vertical-align: middle;
}
</style>

</head>

<body>
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
				<td colspan="7" style="vertical-align:middle;"><input type="text" class=".input-mini form-control"></td>
			</tr>
			
       </table>
	    <table id="table" class="table table-bordered">
			<tr id="tr1" align="center">
				<td rowspan="2" colspan="1" style="vertical-align:middle;">序号</td>
				<td rowspan="2" colspan="1"style="vertical-align:middle;">低值易耗品编码</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">低值易耗品名称</td>
				<td rowspan="2" colspan="1" style="vertical-align:middle;">数量</td>
				<td rowspan="2" colspan="2" style="vertical-align:middle;">单价（元）</td>
				<td rowspan="2" colspan="2" style="vertical-align:middle;">总价</td>
				<td colspan="1" align="center"  nowrap><a href="#" onclick="addRow();" style="background: url(images/add2.png)no-repeat; width:100px; height:40px;display:block;"></a></td>
			</tr>
			
		  	<tr align="center">
			</tr>
			
			<tr> 
			<!-- 序号 -->
				<td colspan="1" align="center" >1</td>
			<!-- 低值易耗品编码 -->
				<td colspan="1"><input id="ip1" type="text"class=".input-mini form-control"></td>
			<!-- 低值易耗品名称 -->
				<td colspan="1"><input id="ip2" type="text"class=".input-mini form-control"></td>
			<!-- 数量 -->
				<td colspan="1"><input id="ip3" type="text" class=".input-mini form-control"></td>
			<!-- 单价 -->
				 <td colspan="2"><input id="ip4" type="text" class=".input-mini form-control"></td>
			<!-- 总价 -->
				<td colspan="2"><input type="text" class=".input-mini form-control"></td>
			<!-- 删除 -->
			    <td colspan="1" align="center"  nowrap><a href="#" onclick="delRow();" style="background: url(images/delete.png)no-repeat; width:100px; height:40px;display:block;"></a></td>
			</tr>
			</table>
			
			<table class="table table-bordered">
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">经办人意见</td>
				<td colspan="6" style="vertical-align:middle;"><input type="text" class=".input-mini form-control"></td>
			</tr>
			
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">部门负责人意见</td>
				<td colspan="6" style="vertical-align:middle;"><input type="text" class=".input-mini form-control"></td>
			</tr>
			
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">部门(单位)盖章</td>
				<td colspan="6" style="vertical-align:middle;"><input type="text" class=".input-mini form-control"></td>

			<tr>
				<td id ="button" colspan="9" align="center">
					<button style="width:100px;"type="button" class="btn btn-default btn-block">提交</button>
				</td>
			</tr>
					
		</table>
</body>

</html> 



