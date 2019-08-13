<%@page import="com.chiansofti.entity.Emp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<script type="text/javascript">
		var applyMap = null;
		var userList = null;
		var curNum = null;// 易耗品数量
		var curEmpno = null;// 申请人编号
		var curDeptno = null;// 当前登录用户的部门编号，也就是验收人的部门编号
		var curApplyDetail = null;// 在审批中的申请
		var curApply=null;// 
		var isEx = null;// 是否在详情表中有数据
		var purch = null;// 采购人
		$(function () {
			curDeptno = '${emp.deptno}';

			$.get("getApplyList", {
				p: curDeptno
			}, success, "json");

			$("#applyList").change(function () {
				success(applyMap);
			});
		});

		function getCurApplyDetail(data) {
			curApplyDetail = data;
		}

		function getCurApply(data){
			curApply=data;
		}

		function success(data) {
			applyMap = data;
			// 购置计划数量
			var num = $('.applyList option').length;
			// 先判断购置计划下拉列表是否为空
			if (num == 0) {
				$.each(applyMap, function (key, values) {
					$op = $("<option>" + values[1] + "</option>");
					$op.appendTo($("#applyList"));
				});
			} else {
				// 清除易耗品列表
				for (var i = 1; i <= curNum; i++) {
					$("#items" + i).remove();
				}
			}
			// 增值税
			$("#valueAddedTax").html("");
			// 不含税单价
			$("#excludingTaxPrice").html("");
			// 不含税总价
			$("#excludingTaxPrices").html("");
			// 价税合计
			$("#priceWithTaxIncluded").html("");
			// 合计
			$("#totalNum").html("");

			// 添加易耗品
			$.each(applyMap, function (key, values) {
				// 匹配当前选择的购置计划
				if (key == ($("#applyList").val()) && values[7] > 0) {
					curNum = values[7];// 易耗品数量
					curEmpno = values[2];// 申请人编号
					var curTableNum = $("#applyList").val();

					$.ajaxSettings.async = false;
					$.get("getCurApplyDetail", {
						p: curTableNum
					}, getCurApplyDetail, "json");
					$.ajaxSettings.async = true;
					//curApplyDetail

					//购置计划编号
					console.log(curTableNum);

					console.log(curApplyDetail);

					// 从详情表中获取的购置计划数量
					var curApplyCount = Object.keys(curApplyDetail).length;

					console.log(curApplyCount);

					// 物品名称
					var name = values[5];

					if (curApplyCount > 0) {
						var i = curApplyCount;
						curNum = i;
						isEx = 1;
						
						$.ajaxSettings.async = false;
						$.get("getCurApply", {
							p: curTableNum
						}, getCurApply, "json");
						$.ajaxSettings.async = true;
						// curApply
						
						
						
						$.each(curApplyDetail, function (key, values) {
							// 合计
							$("#totalNum").html(curApplyCount);
							// 序号	
							var tdno = "<td align='center' style='vertical-align:middle;'>" + i + "</td>";
							// 物品编码 
							var tdcode = "<td style='vertical-align:middle;'>" + values[2] + "</td>";
							// 物品名称
							var tdname = "<td style='vertical-align:middle;'>" + name + "</td>";
							// 物品数量  
							var tdnum = "<td align='center' style='vertical-align:middle;'>1</td>";
							//不含税单价	
							var tdprice1 = "<td style='vertical-align:middle;text-align:center'>" + values[4] + "</td>";
							//不含税总价	
							var tdprice2 = "<td id='excludingTaxPrices" + i + "' style='vertical-align:middle;text-align:center'>" + values[4] + "</td>";
							//增值税	
							var tdprice3 = "<td style='vertical-align:middle;text-align:center'>" + values[5] + "</td>";
							//价税合计
							var tdprice4 = "<td id='priceWithTaxIncluded" + i + "' style='vertical-align:middle;text-align:center'>" + (Number(values[4]) + Number(values[5])) + "</td>";
							// 使用人
							var tduser = "<td colspan='2' style='vertical-align:middle;'>" + values[6] + "</td>";
							$("#items tr:eq(3)").after(
								"<tr id='items" + i + "'>" + tdno + tdcode + tdname + tdnum + tdprice1 + tdprice2 + tdprice3 + tdprice4 + tduser + "</tr>");
							purch = values[7];
							i--;

						});
							$("#acceptor").empty();
							console.log(curApply);
							$("#acceptor").html((curApply[2]==null||curApply[2]=="")?'${emp==null?'':emp.empname }':curApply[2]);
					} else {
						// 循环添加易耗品
						isEx = 0;
						$("#acceptor").empty();
						$("#acceptor").html('${emp==null?'':emp.empname }');
						for (var i = curNum; i > 0; i--) {
							// 合计
							$("#totalNum").html(curNum);
							// 序号	
							var tdno = "<td align='center' style='vertical-align:middle;'>" + i + "</td>";
							// 物品编码 
							var tdcode = "<td><input id='code" + i + "' type='text' class='.input-mini form-control' value='" + values[4] + "'></td>";
							// 物品名称
							var tdname = "<td><input id='name" + i + "' type='text' class='.input-mini form-control' value='" + values[5] + "'></td>";
							// 物品数量  
							var tdnum = "<td align='center' style='vertical-align:middle;'>1</td>";
							//不含税单价	
							var tdprice1 = "<td><input id='excludingTaxPrice" + i + "' type='number' class='.input-mini form-control' ></td>";
							//不含税总价	
							var tdprice2 = "<td id='excludingTaxPrices" + i + "' style='vertical-align:middle;text-align:center'></td>";
							//增值税	
							var tdprice3 = "<td><input id='valueAddedTax" + i + "' type='number' class='.input-mini form-control' ></td>";
							//价税合计
							var tdprice4 = "<td id='priceWithTaxIncluded" + i + "' style='vertical-align:middle;text-align:center'></td>";
							// 使用人
							var tduser = "<td colspan='2' style='vertical-align:middle;'><select id='selectUser" + i + "' class='form-control'></select></td>";
							$("#items tr:eq(3)").after(
								"<tr id='items" + i + "'>" + tdno + tdcode + tdname + tdnum + tdprice1 + tdprice2 + tdprice3 + tdprice4 + tduser + "</tr>");
						}
					}

					for (var i = 1; i <= curNum; i++) {
						//不含税单价改变事件
						$("#excludingTaxPrice" + i).change(function () {
							var eTP = 0;
							var PWTI = 0;
							for (var j = curNum; j > 0; j--) {
								eTP += Number($("#excludingTaxPrice" + j).val());
								$("#excludingTaxPrices" + j).html($("#excludingTaxPrice" + j).val());
								var temp = Number($("#excludingTaxPrice" + j).val()) + Number($("#valueAddedTax" + j).val());
								PWTI += temp;
								$("#priceWithTaxIncluded" + j).html(temp);
							}
							$("#excludingTaxPrice").html(eTP);
							$("#excludingTaxPrices").html(eTP);
							$("#priceWithTaxIncluded").html(PWTI);
						});
						//增值税改变事件
						$("#valueAddedTax" + i).change(function () {
							var eTP = 0;
							var PWTI = 0;
							for (var j = curNum; j > 0; j--) {
								eTP += Number($("#valueAddedTax" + j).val());
								var temp = Number($("#excludingTaxPrice" + j).val()) + Number($("#valueAddedTax" + j).val());
								PWTI += temp;
								$("#priceWithTaxIncluded" + j).html(temp);
							}
							$("#valueAddedTax").html(eTP);
							$("#priceWithTaxIncluded").html(PWTI);
						});
					}


				}
			});

			$.get("getUserList", {
				p: ""
			}, disUserList, "json");

		}

		function disUserList(data) {
			userList = data;
			console.log(data);
			//给selectUser(使用人)下拉框添加值
			for (var i = 1; i <= curNum; i++) {
				$("#selectUser" + i).empty();
				$op = $("<option></option>");
				$op.appendTo($("#selectUser" + i));
				$.each(userList, function (n, values) {
					$op = $("<option>" + values.empname + "</option>");
					$op.appendTo($("#selectUser" + i));
				});
			}

			$("#leader").empty();
			$("#purchasing").empty();
			$.each(userList, function (n, values) {
				$op = $("<option>" + values.empname + "</option>");
				if (values.position == "部门经理" && values.deptno == curDeptno) {
					$op.appendTo($("#leader"));
				}

				//给purchasing(采购人)下拉框添加值
				// 先检查详情表中是否已经有数据，也就是是否已经在审批中或者审批完成
				if (isEx != 1) {
					$op = $("<option>" + values.empname + "</option>");
					$op.appendTo($("#purchasing"));
				}else{
					$("#purchasing").empty();
					$op = $("<option>" + purch + "</option>");
					$op.appendTo($("#purchasing"));
				}
				// 设置申请人
				if (values.empno == curEmpno) {
					$("#proposer").html(values.empname);
					//console.log(values.empname);
				}
			});
		}
	</script>

	<style type="text/css">
		td {
			/* 为什么不生效？ */
			vertical-align: middle;
		}
	</style>

</head>

<body>
	<%
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String create_time = dateFormat.format(new Date());
	%>
	<%
	    Emp emp = (Emp) session.getAttribute("emp");
				int power = emp.getPower();
	%>
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
					<td colspan="2" style="vertical-align:middle;">
						<select id="applyList" class="form-control applyList"></select>
					</td>

					<td colspan="1" style="vertical-align:middle;">申请人：</td>
					<td colspan="1" style="vertical-align:middle;" id="proposer"></td>

					<td style="vertical-align:middle;" colspan="1">采购人：</td>
					<td id="purc" style="vertical-align:middle;"><select id="purchasing" class='form-control'></select>
					</td>
				</tr>
				<tr align="center">
					<td rowspan="2" style="vertical-align:middle;">序号</td>
					<td rowspan="2" style="vertical-align:middle;">物品编码</td>
					<td rowspan="2" style="vertical-align:middle;">物品名称</td>
					<td rowspan="2" style="vertical-align:middle;">数量</td>
					<td colspan="4" style="vertical-align:middle;">购入价（元）</td>
					<td rowspan="2" style="vertical-align:middle;width:200px">使用人</td>
				</tr>
				<tr align="center">
					<td>不含税单价</td>
					<td>不含税总价</td>
					<td>增值税</td>
					<td>价税合计</td>
				</tr>
				<tr>
					<td style="vertical-align:middle;text-align:left">合计：</td>
					<td colspan="2"></td>
					<td id="totalNum" style="vertical-align:middle;text-align:center"></td>
					<!-- 不含税单价 -->
					<td id="excludingTaxPrice" style="vertical-align:middle;text-align:center"></td>
					<!-- 不含税总价 -->
					<td id="excludingTaxPrices" style="vertical-align:middle;text-align:center"></td>
					<!-- 增值税 -->
					<td id="valueAddedTax" style="vertical-align:middle;text-align:center"></td>
					<!-- 价税合计 -->
					<td id="priceWithTaxIncluded" style="vertical-align:middle;text-align:center"></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="9"></td>
				</tr>
				<tr>
					<!-- 当前登录并且进入该页面的用户就是验收人 -->
					<td colspan="2" style="vertical-align:middle;">验收人：</td>
					<td id="acceptor" style="vertical-align:middle;">${emp==null?'':emp.empname }</td>

					<!-- 验收人意见 -->
					<td colspan="2" style="vertical-align:middle;">验收人意见：</td>
					<td colspan="2" style="vertical-align:middle;">
						<select id="accepter" class='form-control'>
							<option value="-1"></option>
							<option value="1">同意</option>
							<option value="2">不同意</option>
						</select>
					</td>

					<td style="vertical-align:middle;" colspan="1">日期：</td>
					<td colspan="2" style="vertical-align:middle;"><%=create_time%></td>
				</tr>

				<c:if test="<%=power > 0%>">
					<tr>
						<td colspan="2" style="vertical-align:middle;">部门负责人：</td>
						<td colspan="1" style="vertical-align:middle;">
							<select id="leader" class='form-control'></select>
						</td>
						<!-- 部门负责人意见 -->
						<td colspan="2" style="vertical-align:middle;">部门负责人意见：</td>
						<td colspan="2" style="vertical-align:middle;">
							<select id="deptHead" class='form-control'>
								<option value="-1"></option>
								<option value="1">同意</option>
								<option value="0">不同意</option>
							</select>
						</td>
						<td style="vertical-align:middle;" colspan="1">日期：</td>
						<td colspan="2" style="vertical-align:middle;"><%=create_time%></td>
					</tr>
					<tr>
						<td colspan="2" style="vertical-align:middle;">部门印章：</td>
						<td colspan="1" align="center" style="vertical-align:middle;">
							<input type="button" onclick="seal()" value="盖章" style="width:100px;"
								class="btn btn-default btn-block" />
						</td>
						<td colspan="4" id="seal" style="vertical-align:middle;color:red;text-align:center"></td>

						<td colspan="1" style="vertical-align:middle;">日期：</td>
						<td colspan="2" style="vertical-align:middle;" id="sealTime"><%=create_time%></td>
					</tr>
				</c:if>
				<tr>
					<td colspan="9" align="center">
						<button style="width:100px;" onclick="sub()" class="btn btn-default btn-block">提交</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<hr />

	<script type="text/javascript">
		// 印章
		function seal() {
			$("#seal").html("OK");
		}

		// 提交数据
		function sub() {
			var data1 = new Array();
			var j = 0;
			for (var i = 1; i <= curNum; i++) {
				// 表单编号
				data1[j++] = $("#applyList").val();
				// 易耗品编号
				data1[j++] = $("#code" + i).val();
				// 易耗品名称
				data1[j++] = $("#name" + i).val();
				// 数量
				data1[j++] = 1;
				// 不含税单价
				data1[j++] = $("#excludingTaxPrice" + i).val();
				// 增值税
				data1[j++] = $("#valueAddedTax" + i).val();
				// 使用人
				data1[j++] = $("#selectUser" + i).val();
				// 存放点
				data1[j++] = $("#selectUser" + i).val() == "" ? "仓库"
					: "使用人所在部门";//后台继续处理
				// 是否在用
				data1[j++] = $("#selectUser" + i).val() == "" ? "否" : "是";//后台继续处理
				// 采购人
				data1[j++] = $("#purchasing").val();
				// 验收人意见
				data1[j++] = $("#accepter").val();
				// 验收人编号
				data1[j++] = "<%=emp.getEmpno()%>";
				// 权限标记
				data1[j++] =<%=power %>;
				if (<%= power %> > 0) {
					data1[j++] = $("#deptHead").val();
					data1[j++] = $("#seal").html();
				}
				// 分割标记
				data1[j++] = "|";
			}
			var datas = JSON.stringify(data1);
			console.log(datas);
			$.post("subCheck", {
				"datas": datas
			}, function (data) {
				alert(data == 1 ? "提交成功" : "提交失败 ");
			});
		}
	</script>
</body>

</html>