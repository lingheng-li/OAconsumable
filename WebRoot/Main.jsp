<%@page import="com.chiansofti.entity.Emp"%>
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

 <title>OA易耗品管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">

</script>
</head>

<body>
	<%
	    Emp emp = (Emp) session.getAttribute("emp");
	    if(emp==null){
	    	response.sendRedirect("Login.jsp"); 
	    }
	%>
	<jsp:include page="/include/OAMainMenus.jsp" flush="true" />
	<jsp:include page="/include/Welcome.jsp" flush="true" />
</body>
</html>
