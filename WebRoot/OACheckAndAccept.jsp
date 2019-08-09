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
	var userList = null;
	var cur = null;
	$(function() {

		$.get("getApplyList", {
			p : ""
		}, success, "json");

		$("#applyList").change(function() {
			$.get("getApplyList", {
				p : ""
			}, success, "json");
		});

		$.get("getUserList", {
			p : ""
		}, disUserList, "json");

	});

	function disUserList(data) {
		userList = data;
		console.log(data);
		//给selectUser下拉框添加值
	}

	function success(data) {
		applyMap = data;
		var num = $('.applyList option').length;
		// 先判断购置计划下拉列表是否为空
		if (num == 0) {
			$.each(applyMap, function(key, values) {
				//console.log(values);
				/* $(values).each(function() {
					console.log(" " + this);
				}); */
				$op = $("<option>" + values[1] + "</option>");
				$op.appendTo($("#applyList"));
			});
		} else {
			for (var i = 1; i <= cur; i++) {
				$("#items" + i).remove();
			}
		}

		$
				.each(
						applyMap,
						function(key, values) {
							if (key == ($("#applyList").val()) && values[7] > 0) {
								for (var i = values[7]; i > 0; i--) {
									// 序号	
									var tdno = "<td align='center' style='vertical-align:middle;'>"
											+ i + "</td>";
									// 物品编码 
									var tdcode = "<td><input type='text' class='.input-mini form-control' value='"+values[4]+"'></td>";
									// 物品名称
									var tdname = "<td><input type='text' class='.input-mini form-control' value='"+values[5]+"'></td>";
									// 物品数量  
									var tdnum = "<td align='center' style='vertical-align:middle;'>1</td>";
									//不含税单价	
									var tdprice1 = "<td><input type='text' class='.input-mini form-control' ></td>";
									//不含税总价	
									var tdprice2 = "<td><input type='text' class='.input-mini form-control' ></td>";
									//增值税	
									var tdprice3 = "<td><input type='text' class='.input-mini form-control' ></td>";
									//价税合计
									var tdprice4 = "<td><input type='text' class='.input-mini form-control' ></td>";
									// 使用人
									var tduser = "<td colspan='2' style='vertical-align:middle;'><select id='selectUser"+i+"' class='form-control'></select></td>";
									$("#items tr:eq(3)").after(
											"<tr id='items"+i+"'>" + tdno
													+ tdcode + tdname + tdnum
													+ tdprice1 + tdprice2
													+ tdprice3 + tdprice4
													+ tduser + "</tr>");
								}

								//cur = $("#applyList").val();
								cur = values[7];
							}
						});

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
						id="applyList" class="form-control applyList"></select></td>
					<td colspan="1" id="t" style="vertical-align:middle;">部门盖章：</td>
					<td colspan="4"></td>
				</tr>
				<tr align="center">
					<td rowspan="2" style="vertical-align:middle;">序号</td>
					<td rowspan="2" style="vertical-align:middle;">物品编码</td>
					<td rowspan="2" style="vertical-align:middle;">物品名称</td>
					<td rowspan="2" style="vertical-align:middle;">数量</td>
					<td colspan="4" style="vertical-align:middle;">购入价（元）</td>
					<td rowspan="2" style="vertical-align:middle;width:100px">使用人</td>
				</tr>
				<tr align="center">
					<td>不含税单价</td>
					<td>不含税总价</td>
					<td>增值税</td>
					<td>价税合计</td>
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

					<td style="vertical-align:middle;" colspan="2">采购人：</td>
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
					<td colspan="2" style="vertical-align:middle;"><%=new Date()%></td>
				</tr>
				<tr>
					<td colspan="2" style="vertical-align:middle;">验收人：</td>
					<td style="vertical-align:middle;"><input type="text"
						class=".input-mini form-control" placeholder="当前登录的用户"
						value="${emp==null?'':emp.empname }" /></td>
					<!-- 验收人意见 -->
					<td colspan="2" style="vertical-align:middle;">验收人意见：</td>
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