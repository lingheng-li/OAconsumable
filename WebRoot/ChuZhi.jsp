<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="application/x-javascript">
/*  $(document).ready(function () {
        $("#table").DataTable();
    });  */
    
    var i = 0;
    var t = 0;
	/* $(function(){
		if(${emp.power}==2){
	        $.ajax({
	            type: "POST",
	            url: "${pageContext.request.contextPath}/SelListServlet",
	            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
	            dataType: "json",
	             success:function(dataList){
					fun1(dataList);
				}
	        });
		}else{  }
	});
	function fun1(dataList){
		$("table tr:gt(0)").remove();
		//得到集合中的数据
		for(var i=0;i<dataList.length;i++){
			var dataObj = dataList[i];//{"dname":"xxxx","job":"xxxx","empNum":"xxxx"}
			var $tr = $("<tr ></tr>");
			var $td1 = $("<td ></td>");
			var $td2 = $("<td></td>");
			var $td3 = $("<td></td>");
			var $td4 = $("<td></td>");
			var $td5 = $("<td></td>");
			var $td6 = $("<td></td>");
			var $td7 = $("<td></td>");
			var $td8 = $("<td></td>");
			$td1.text(i);
			$td2.text(deptObj.name);
			$td3.text(deptObj.code);
			$td4.text(deptObj.p_code);
			$td5.text(deptObj.number);
			$td6.text(deptObj.price);
			$td7.text(deptObj.totalPrice);
			$td8.text(deptObj.use_name);
			$td9.text(deptObj.handle);
			$tr.append($td1).append($td2).append($td3).append($td4).append($td5).append($td6).append($td7).append($td8).append($td9);
			$("table").append($tr);
		}
	} */
    //添加行
    function addRow() {
        i++;
        t++;
        var rowTem = '<tr class="tr_' + i + '" align="center">'
            + '<td height="50px" align="center" >' + i + '</td>'
            + '<td ><select name="selname' + t + '"id="selname' + t + '" onchange=change(' + t + ') >'
            + '<option value="">请选择易消耗品名称</option>'
            + '</select></td>'
            + '<td name="td1' + t + '"id="td1' + t + '"></td>'
            + '<td name="td2' + t + '"id="td2' + t + '"></td>'
            + '<td name="td3' + t + '"id="td3' + t + '"></td>'
            + '<td name="td4' + t + '"id="td4' + t + '"></td>'
            + '<td name="td5' + t + '"id="td5' + t + '"></td>'
            + '<td name="td6' + t + '"id="td6' + t + '"></td>'
            + '<td > <select name="sel' + t + '"id="sel' + t + '">'
            + '<option value="">请选择处置原因</option>'
            + '<option value="年限到期">年限到期</option>'
            + '<option value="损坏、报废">损坏、报废</option>'
            +'<option value="其他">其他</option>'
            + '</select></td>'
            + '<td><a href="#" onclick=delRow(' + i + ') >删除</a></td>'
            + '</tr>';
            
        $("#table tbody:last").append(rowTem);
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/CZname",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: "json",
            success: function (data) {
                var selname = "#" + "selname" + t;
                for (var n = 0; n < data.length; n++) {
                    $(selname).append("<option value='"+n+"'>"+ data[n].name + "</option>");
                }
            },
            error: function (e) {
                console.log(e);
            }
        });
    }

    //已选择改变执行后面的内容
    function change(e) {
        var selname = "#" + "selname" + e;
        var a = $(selname).find("option:selected").text();
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/SelectServlet?name=" + a,
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: "json",
            success: function (data) {
                var td1 = "#" + "td1" + e;
                var td2 = "#" + "td2" + e;
                var td3 = "#" + "td3" + e;
                var td4 = "#" + "td4" + e;
                var td5 = "#" + "td5" + e;
                var td6 = "#" + "td6" + e;
                console.log(td1);
                $(td1).html(data[0].code);
                $(td2).html(data[0].p_code);
                $(td3).html(data[0].number);
                $(td4).html(data[0].price);
                $(td5).html(data[0].totalPrice);
                $(td6).html(data[0].use_name);
            },
            error: function (e) {
                alert("请求错误");
            }
        });
    }
       function change1() {
/*         arr=new String[5][2];
        for(var i=1;i<=t;i++){
        var sel = "#" + "sel" + i; 
        var td = "#" + "td1"+i;
        var b = $(sel).val();
        var a = $(td).val();
        console.log(a);
        console.log(b);
        arr[i][0]=a;
        arr[i][1]=b;
        } */
        var str1=new Array();
 	   	var str2=new Array();
        for(var i =1;i<=t;i++){
        str1[i] = $("#" + "td1" + i).text();
       	str2[i] = $("#" + "sel" + i).val();
        }
		datas = JSON.stringify(str1);//转为json字符串
	    datas2 = JSON.stringify(str2);//转为json字符串
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/Sub",
            data:{"code":datas,"name":datas2},
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: "json",
            success: function () {
            alert("提交成功");
            },
               error: function (e) {
                    console.log(a);
        			console.log(b);
            }
        });
    } 
    

     function change2(id){
     	var a =$("#code"+id).text();
          $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/Sub?bianh="+a,
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: "json",
            success: function () {
            alert("提交成功");
            },
               error: function (e) {
                    console.log(a);
        			console.log(b);
            }
        });
     }
          function change3(id){
     	var a =$("#code"+id).text();
          $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/Tuihui?bianh="+a,
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: "json",
            success: function () {
            alert("成功");
            },

        });
     }
    
    function delRow(_id) {
        $("#table .tr_" + _id).hide();
        i--;
    }
</script>
<html>
<head>
    <title>易耗品报废</title>
</head>

<body>

<jsp:include page="/include/OAMainMenus.jsp" flush="true">
		<jsp:param name="thisMuen" value="SelListServlet" />
	</jsp:include>
<form >
<table  id="table" width="1200px" border="1px" align="center" cellspacing="0px" cellpadding="0px" style="border:#c4e3f3">
    <tr width="100%">
        <%-- <caption align="center"><h3>低值易耗损处置申报审批单</h3></caption> --%>
        			<tr>
				<td colspan="8" align="center"><h4>低值易耗损处置申报审批单</h4></td>
			</tr>
        <td style="color:#8c8c8c;background-color:#d9edf7" width="47%" align="center" height="30px">
            所在单位
        </td>
        <td colspan="1"><input type="text" class=".input-mini form-control" "></td>
        <td width="30%" align="center">
            &nbsp;
        </td>
    </tr>
    <tr>
        <td colspan="2" width="100%">
            <table border="1px" width="100%" height="50px" align="center" cellspacing="0px" cellpadding="0px"
                   style="border:#c4e3f3">
                <tr align="center">
                    <td height="50px">序号</td>
                    <td>低值易消耗品名称</td>
                    <td>低值易消耗品编码</td>
                    <td>对应购置计划审批表编号</td>
                    <td>数量</td>
                    <td>单价（元）</td>
                    <td>总价（元）</td>
                    <td>使用人</td>
                    <td>处置原因</td>
                    <c:if test="${emp.power==0 }">
                    <td>
                        <button type="button" name="add" value="add" 
                                onclick="addRow()">添加
              			 </button>
                    </td>
                     </c:if > 
                </tr>
                <c:if test="${emp.power==2 }">
                  	<c:forEach items="${name}" var="na" varStatus="xuhao">
    		<tr class="tr_1" align="center">
							<td height="50px" align="center" id="xh">
							${xuhao.index+1}	
				</td>
				<td>
				<!-- 易耗品名称 -->${na.name}
				</td >
				<td id="code${xuhao.index+1}"><!-- 编号-->${na.code}</td>				
				<td>
					<!-- 编号2--> ${na.p_code}
				</td>
				<td>
					<!-- 数量--> ${na.number}
				</td>
								<td>
					<!-- 单价--> ${na.price}
				</td>
								<td>
					<!-- 总价--> ${na.totalPrice}
				</td>
								<td>
					<!-- 使用人--> ${na.use_name}
				</td>
								<td>
					<!-- 处置原因--> ${na.handle}
				</td>				
					<td colspan="9" align="center"><button style="width:100px;"
					onclick = "change2(${xuhao.index+1})"; class="btn btn-default btn-block" >通过</button>
					</td>
					<td colspan="9" align="center"><button style="width:100px;"
					onclick = "change3(${xuhao.index+1})"; class="btn btn-default btn-block" >驳回</button>
					</td>
				
			</tr>
			</c:forEach>
			</c:if>
            </table>
        </td>
    </tr>
  

    <c:if test="${emp.power==2 }">
        <tr align="center">
        <td>经办人意见</td>
       <td><textarea rows="2" cols="110"></textarea></td>
        </td>
    </tr>
    <tr align="center">
        <td >部门负责人意见</td>
        <td><textarea rows="2" cols="110"></textarea></td>
    </tr>
    <tr align="center">
        <td>部门（单位）盖章</td>
         <td><textarea rows="2" cols="110"></textarea></td>
    </tr>
    <tr align="center">
        <td>财务经办人意见</td>
         <td><textarea rows="2" cols="110"></textarea></td>
    </tr>
    <tr align="center">
        <td>财务负责人意见</td>
         <td><textarea rows="2" cols="110"></textarea></td>
    </tr>
    <tr align="center">
        <td>财务盖章</td>
        <td><textarea rows="2" cols="110"></textarea></td>
    </tr>
       </c:if>
    			<c:if test="${emp.power==0}">
    				<tr>
						<td colspan="9" align="center"><button style="width:100px;"
							onclick =change1();  class="btn btn-default btn-block" >提交</button>
							</td>
					</tr>
				</c:if>
				
</table>
</form>
</body>
</html>