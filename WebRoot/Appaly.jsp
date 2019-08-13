<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.chiansofti.entity.Emp"%>
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
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js">
</script>

<script type="text/javascript">
	
	var i =1;
	//添加行
	function addRow() {
	    // i++;
	    var rowTem = '<tr class="tr1' + i+ '">'
	        + '<td align="center" id="serialnumber' + i + '">'+(i+1)+'</td>'
	        + '<td><input type="Text" class=".input-mini form-control" id="consumable_code' + i + '"/></td>'
			+ '<td><input type="Text" class=".input-mini form-control" id="consumable_name' + i + '"/></td>'
			+ '<td><input type="Text" class=".input-mini form-control" id="consumable_number' + i + '"/></td>'
			+ '<td colspan="2"><input type="Text" class=".input-mini form-control" id="consumable_price' + i + '"/></td>'
			+ '<td colspan="2"><input type="Text" class=".input-mini form-control" id="text' + i + '"/></td>'
	        + '<td align="center"><input type="button"  onclick=delRow('+i+') style="background: url(images/delete.png)no-repeat; width:100px; height:40px;display:block;" ></td>'
	        + '</tr>';
	      $("#table tbody:last").append(rowTem);
		  i++;
	
	};
	//删除行
	function delRow(_id) {
	    $("#table .tr1"+_id).hide();
	    i--;
	};
	function  sucommit(){
		var consumableid=[];
		var consumable_code=[];
		var consumable_name=[];
		var consumable_number=[];
		var consumable_price=[];
		for(var j=0;j<i;j++){
			consumableid[j]=$("#serialnumber"+j).text();
			consumable_code[j]=$("#consumable_code"+j).val();
			consumable_name[j]=$("#consumable_name"+j).val();
			consumable_number[j]=$("#consumable_number"+j).val();
			consumable_price[j]=$("#consumable_price"+j).val();
		}
		consumableid=JSON.stringify(consumableid);
		consumable_code=JSON.stringify(consumable_code);
		consumable_name=JSON.stringify(consumable_name);
		consumable_number=JSON.stringify(consumable_number);
		consumable_price=JSON.stringify(consumable_price); 
		$.post(
			"apply",
			{"consumableid":consumableid,"consumable_code":consumable_code,"consumable_name":consumable_name,"consumable_number":consumable_number,"consumable_price":consumable_price}, 
			success
			);
	};
	
	function success(empList){
		window.location.href="ApplyFaceServlet";
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
		<jsp:param name="thisMuen" value="ApplyForward" />
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
				<td colspan="1" id="serialnumber0" align="center" >1</td>
			<!-- 低值易耗品编码 -->
				<td colspan="1"><input id="consumable_code0" type="text"class=".input-mini form-control"></td>
			<!-- 低值易耗品名称 -->
				<td colspan="1"><input id="consumable_name0" type="text"class=".input-mini form-control"></td>
			<!-- 数量 -->
				<td colspan="1"><input id="consumable_number0" type="text" class=".input-mini form-control"></td>
			<!-- 单价 -->
				<td colspan="2"><input id="consumable_price0" type="text" class=".input-mini form-control"></td>
			<!-- 总价 -->
				<td colspan="2"><input type="text" value="可不填" class=".input-mini form-control"></td>
			<!-- 删除 -->
			    <td colspan="1" align="center"  nowrap><a href="#" onclick="delRow();" style="background: url(images/delete.png)no-repeat; width:100px; height:40px;display:block;"></a></td>
			</tr>
			</table>
			
			<table class="table table-bordered">
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">经办人</td>
				<td colspan="6" style="vertical-align:middle;"><input id="personname" value="${sessionScope.emp.empname}" type="text" class=".input-mini form-control"></td>
			</tr>
			
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">备注(说明)</td>
				<td colspan="6" style="vertical-align:middle;"><input id="remarkmation" type="text" class=".input-mini form-control"></td>
			</tr>
			
			<tr align="center">
				<td colspan="3" style="vertical-align:middle;">部门(单位)盖章</td>
				<td colspan="6" style="vertical-align:middle;"><input type="text" class=".input-mini form-control" readonly></td>

			<tr>
				<td id ="button" colspan="9" align="center">
					<button style="width:100px;"type="button" onclick="sucommit()" class="btn btn-default btn-block">提交</button>
				</td>
			</tr>
					
		</table>
</body>

</html> 



