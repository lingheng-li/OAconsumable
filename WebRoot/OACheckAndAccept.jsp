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
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript">
	var applyMap = null;
	$(function() {
		$("#applyList").change(function() {
			/* alert($("#applyList").val()); */
		});
		$.get("getApplyList", {
			p : ""
		}, success, "json");

	});
	function setApplyNo(text) {
		/* alert($(text).html()); */
	}
	function success(data) {
		applyMap = data;
		/* $("#applyList").empty(); */
		$.each(applyMap, function(key, values) {
			/* console.log(key); */
			console.log(values);
			/*  $(values).each(function() {
				console.log(" " + this);
			});  */
			$op = $("<option>" + values[1] + "</option>");
			$op.appendTo($("#applyList"));

		});
		/* alert($("#applyList").val()); */
		/* $("#items").empty(); */
		$.each(applyMap, function(key, values) {
			if (key == ($("#applyList").val()) && values[7] > 0) {
				//alert(values[7]);
				for (var i = values[7]; i > 0; i--) {
					/* $("<tr id='items"+i+"'></tr>").after($("#items")); */
					$("#items tr:eq(3)").after("<tr id='items"+i+"'>"+"<td><input type='text' class='.input-mini form-control' value='"+values[4]+"'></td>"+"</tr>");
					/* var td = "<tr id='items"+i+"'><td align='center' style='vertical-align:middle;'>"
							+ i + "</td>";
					// 物品编码 
					td += "<td><input type='text' class='.input-mini form-control' value='"+values[4]+"'></td>";
					// alert(values[4]);
					// 物品名称
					td += "<td><input type='text' class='.input-mini form-control' value='"+values[5]+"'></td>";
					// 物品数量  
					td += "<td align='center' style='vertical-align:middle;'>1</td></tr>";
					$(td).appendTo($("#items"+i)); */
				}
			}
		});
		/* 	$("#emp").empty();
			var $option = null;
			if (applyMap.length == 0) {
				$option = $("<option></option>");
				$option.tiex("此部门无人");
				$option.appendTo($("#emp"));
			} else {
				for (var i = 0; i < applyMap.size; i++) {
					var empObj = empList[i];
					$option = $("<option></option>");
					$option.text(empObj.ename);
					$option.appendTo($("#emp"));
					alert(applyMap.ename);
				}
			} */
	}
</script>

<style type="text/css">
td {
	vertical-align: middle;
	/* 为什么不生效？ */
}
</style>

</head>
<body>
	<jsp:include page="/include/OAMainMenus.jsp" flush="true">
		<jsp:param name="thisMuen" value="checkAndAccept" />
	</jsp:include>
	<!-- <hr /> -->

	<form action="" method="post">
		<table class="table table-bordered">
			<tbody id="items">
				<tr>
					<td colspan="9" align="center">低值易耗品验收单</td>
				</tr>
				<tr>
					<td colspan="2" style="vertical-align:middle;">购置计划编号：</td>
					<td colspan="2" style="vertical-align:middle;"><select
						id="applyList" class="form-control"></select></td>
					<td colspan="1" id="t" style="vertical-align:middle;">部门盖章：</td>
					<td colspan="4"></td>
				</tr>
				<tr align="center">
					<td rowspan="2" style="vertical-align:middle;">序号</td>
					<td rowspan="2" style="vertical-align:middle;">物品编码</td>
					<td rowspan="2" style="vertical-align:middle;">物品名称</td>
					<td rowspan="2" style="vertical-align:middle;">数量</td>
					<td colspan="4" style="vertical-align:middle;">购入价（元）</td>
					<td rowspan="2" style="vertical-align:middle;">使用人</td>
				</tr>
				<tr align="center">
					<td>不含税单价</td>
					<td>不含税总价</td>
					<td>增值税</td>
					<td>价税合计</td>
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
						<!-- 数量 --> <input type="text" class=".input-mini form-control">
					</td>
					<td>
						<!-- 不含税单价 --> <input type="text" class=".input-mini form-control">
					</td>
					<td>
						<!-- 不含税总价 --> <input type="text" class=".input-mini form-control">
					</td>
					<td>
						<!-- 增值税 --> <input type="text" class=".input-mini form-control">
					</td>
					<td>
						<!-- 价税合计 --> <input type="text" class=".input-mini form-control">
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
				<tr>
					<td style="vertical-align:middle;">合计</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2" style="vertical-align:middle;">部门（单位）负责人：</td>
					<td>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="数据库中获取"
								aria-label="...">
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
						</div> <!-- /input-group -->
					</td>

					<td style="vertical-align:middle;">采购人：</td>
					<td><div class="input-group">
							<input type="text" class="form-control" placeholder="员工表中获取"
								aria-label="...">
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
						</div> <!-- /input-group --></td>
					<td style="vertical-align:middle;">日期：</td>
					<td colspan="3" style="vertical-align:middle;"><%=new Date()%></td>
				</tr>
				<tr>
					<td colspan="2" style="vertical-align:middle;">验收人：</td>
					<td style="vertical-align:middle;"><input type="text"
						class=".input-mini form-control" placeholder="当前登录的用户"
						value="${emp==null?'':emp.empname }" /></td>
					<!-- 验收人意见 -->
					<td style="vertical-align:middle;">验收人意见：</td>
					<td colspan="3" style="vertical-align:middle;"><textarea
							class="form-control" rows="1"></textarea></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="9" align="center"><button style="width:100px;"
							type="submit" class="btn btn-default btn-block">提交</button></td>
				</tr>
			</tbody>
		</table>

	</form>
	<hr />
</body>

</html>