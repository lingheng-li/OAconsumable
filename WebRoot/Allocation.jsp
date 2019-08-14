<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>低值易耗品调拨申请</title>
<script
    src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript">

/* 	$(document).ready(function () {
	    $("#table").DataTable();
	}); */
  	var i =1;
	//添加行
	function addRow(){
		    var rowTem ='<tr align="center" id="tr'+(i+1)+'">'
		        +'<td style="width:100px'+'">'
		        +'<input id="id'+i+'" name="id" type="text" class=".input-mini form-control" ></td>'
				+'<td><input id="inp'+i+'" name="code" type="text" class=".input-mini form-control" value="" onblur="fun1('+i+')"></td>'
				+'<td><!-- 低值易耗品名称 --> <input type="text" id="name'+i+'" class=".input-mini form-control" ></td>'
				+'<td><!-- 表单编号 --> <input type="text" class=".input-mini form-control" id="tablenum'+i+'"></td>'
				+'<td><!-- 数量 --> <input type="text" class=".input-mini form-control" value="1"></td>'
				+'<td><!-- 单价 --> <input type="text" class=".input-mini form-control" id="price'+i+'"></td>'
				+'<td><!-- 使用人 --><input type="text" class=".input-mini form-control" id="user'+i+'"></td>'
				+'<td><!-- 预使用人 --><input type="text" name="user" class=".input-mini form-control" id="user1'+i+'"></td>'
		/* 		+ '<td align="center"><input type="button"  onclick=delRow('+i+') ></td>' */
				+'</tr>';
		      $("#tr").after(rowTem);
			  i++;
	}
	//删除行
	function delRow(_id) {
	    $("#tr"+_id).hide();
	    i--;
	}
	var ids=[];
    function fun1(a){
		$.post(
			"AddAllocation",
			{code:$("#inp"+a).val()}, 
			function(data){
				var id=data.id;
				ids[a-1]=id;
				var name=data.consumable_name;
				var tablenum=data.tablenum;
				var price=data.tax_price;
				var user=data.emp_name;
				$("#id"+a).attr("value",id);
				$("#name"+a).attr("value",name);
				$("#tablenum"+a).attr("value",tablenum);
				$("#price"+a).attr("value",price);
				$("#user"+a).attr("value",user);
			},
			"json"
			);
	};
</script>
<style type="text/css">
td {
	vertical-align: middle;
}
</style>
  </head>
  <body>
   <jsp:include page="/include/OAMainMenus.jsp" flush="true" >
  	<jsp:param name="thisMuen" value="Allocation" /> 
  </jsp:include>
		<table class="table table-bordered">
			<tr>
				<td colspan="8" align="center">低值易耗品调拨申请单</td>
			</tr>
    		<tr align="center">
    			<td colspan="2">所在单位</td>
    			<td colspan="1"><input type="text" class=".input-mini form-control" value="${emp.deptno}"></td>
    			<td colspan="2">调入部门</td>
    			<td colspan="2"><input type="text" class=".input-mini form-control" id="rdeptno"></td>
    			<td><input type="button" id="btn1" onclick="addRow()" value="添加"></td>
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
			<tr align="center">
				<td colspan="2">调出部门审批：</td>
				<td></td>
				<td>调入部门审批：</td>
				<td></td>
				<td>财务职产部核实盖章：</td>
				<td colspan="2"></td>
			</tr>
			<tr align="center">
				<td colspan="2" >负责人：</td>
				<td></td>
				<td>负责人：</td>
				<td colspan="1" ></td>
				<td>负责人：</td>
				<td colspan="2"></td>
			</tr>
			<tr align="center">
				<td colspan="2" >经办人：</td>
				<td>${emp.empname}</td>
				<td>经办人：</td>
				<td colspan="1"></td>
				<td>经办人：</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="8" align="center"><button style="width:100px;"
					id="btn" onclick="up()" class="btn btn-default btn-block">提交</button></td>
			</tr>
    	</table>
  </body>
  <script type="text/javascript">
   	function up(){
   		var users=[];
   		for(var j=0;j<i-1;j++){
   			users[j]=$("#user1"+(j+1)).val();
   		}
   		ids=JSON.stringify(ids);
   		users=JSON.stringify(users);
  		$.post(
  			"InsertAllocationable",
  			{rdeptno:$("#rdeptno").val(),"ids":ids,"users":users},
  			success,
  			"json"
  		);
  	};
  	function success(datas){
  		if(datas==1){
  			window.location.href="showAllocation";
  		}else{
  			alert("提交失败");
  		}
  	}
  </script>
</html>
