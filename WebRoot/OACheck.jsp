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
<script type="text/javascript" src="js/jquery.min.js"></script>

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
		
	})

</script>

<style type="text/css">
td {
	vertical-align: middle;
}

#t {
	/* vertical-align: middle; */
	
}
</style>

</head>

<body>
	<hr />
	<form action="" method="post">
		<table class="table table-bordered">
			<tr>
				<td colspan="9" align="center">低值易耗品验收单</td>
			</tr>
			<tr>
				<td colspan="2" id="t" style="vertical-align:middle;">部门（单位）盖章：</td>
				<td></td>
				<td style="vertical-align:middle;">购置计划审批表编号：</td>
				<td colspan="5" style="vertical-align:middle;">
					<div class="col-lg-12">
						<div class="input-group">
							<input type="text" class="form-control" aria-label="...">
							<div class="input-group-btn">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									&nbsp;<span class="glyphicon glyphicon-list-alt"></span>
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
					</div>
				</td>
			</tr>
			<tr align="center">
				<td rowspan="2" style="vertical-align:middle;">序号</td>
				<td rowspan="2" style="vertical-align:middle;">低值易耗品编码</td>
				<td rowspan="2" style="vertical-align:middle;">低值易耗品名称</td>
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
				<td colspan="2" style="vertical-align:middle;">验收人：</td>
				<td><input type="text" class=".input-mini form-control"
					placeholder="当前登录的用户"></td>
				<td style="vertical-align:middle;">采购人：</td>
				<td><input type="text" class=".input-mini form-control"
					placeholder="计划审批表中获取"></td>
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
				<td style="vertical-align:middle;">日期：</td>
				<td colspan="5" style="vertical-align:middle;">当前时间</td>
			</tr>
			<tr>
				<td colspan="9" align="center"><button style="width:100px;"
						type="submit" class="btn btn-default btn-block">提交</button></td>
			</tr>
		</table>

	</form>
	<hr />
</body>

</html>