package com.chiansofti.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chiansofti.entity.Apply;
import com.chiansofti.entity.Emp;
import com.chiansofti.service.ApplyService;
import com.chiansofti.serviceImpl.ApplyServiceImpl;
import com.mysql.jdbc.StringUtils;
@WebServlet("/apply")
public class ApplyServlet extends HttpServlet {
	
	
	 /**
     * 字符串编程数组
     * @return
     */
     public static String[] changToArrar(String str){
      str = str.substring(1, str.length()-1);
      str = str.replace("\"", "");
      String[] str1 = str.split(",");
         return str1;
     }
        @SuppressWarnings("deprecation")
		@Override
        protected void service(HttpServletRequest req, HttpServletResponse resp)
        		throws ServletException, IOException {
        	//1.设置编码
    		req.setCharacterEncoding("utf-8");
    		resp.setCharacterEncoding("utf-8");
    		resp.setContentType("text/html;charset=utf-8");
        	
        	//使用session获取当前登录人的信息
        	HttpSession session=req.getSession();
        	
        	Emp emp=(Emp) session.getAttribute("emp");
        	
        	//获取当前年份（使用Calendar函数）
        	//初始化日历
        	Calendar calendar=Calendar.getInstance();
        	//当前时间初始化日历时间
        	calendar.setTime(new Date());
        	//获取当前年份
        	String year=String.valueOf(calendar.get(Calendar.YEAR));
        	
        	//申请单编号（自动生成，格式：D年份-部门编号-序号(毫秒数))
        	long time=System.currentTimeMillis();
        	String Application="D"+year+"-"+emp.getDeptno()+"-"+time;
        	
        	//获取当前申请单创建的时间
        	Date create_time=new Date(System.currentTimeMillis());
        	
        	//获取当前申请人的编码
        	String empno=emp.getEmpno();
        	//获取是否为院管项目
        	int courtyard_project=0;
        	//获取审批状态
        	int approval_status=0;
        	if(emp.getPower()==0){
        	  approval_status=0;
        	}else{
        	  approval_status=1;
        	}
        	//标识id
        	String  consumableid[]=changToArrar(req.getParameter("consumableid"));
        	//易耗品编号
        	String  consumable_code[]=changToArrar(req.getParameter("consumable_code"));
        	//易耗品名称
        	String  consumable_name[]=changToArrar(req.getParameter("consumable_name"));
        	//易耗品数量
        	String  consumable_number[]=changToArrar(req.getParameter("consumable_number"));
        	//易耗品单价
        	String  consumable_price[]=changToArrar(req.getParameter("consumable_price"));
        	
        	for(int a=0;a<consumableid.length;a++){
        		if(consumable_code!=null){
        		Apply apply=new Apply();
        		//传入申请单编号
        		apply.setTablenum(Application);
        		//传入申请人id
        		apply.setEmpno(empno);
        		//传入申请单创建时间
        		apply.setCreate_time(create_time);
        		//传入易耗品编号
        		apply.setConsumable_code(consumable_code[a]);
        		//传入易耗品名称
        		apply.setConsumable_name(consumable_name[a]);
        		//传入易耗品数量
        		Integer consumablenumber=Integer.valueOf(consumable_number[a]);
        		apply.setConsumable_number(consumablenumber);
        		//传入易耗品单价
        		BigDecimal bd=new BigDecimal(consumable_price[a]);
        		bd=bd.setScale(2,BigDecimal.ROUND_HALF_UP );
        		apply.setConsumable_price(bd);
        		//传入是否为院管项目
        		apply.setCourtyard_project(courtyard_project);
        		//传入审批状态
        		apply.setApproval_status(approval_status);
        		//调用impl实现层把数据传入dao中
        		ApplyService applyService=new ApplyServiceImpl();
        		applyService.add(apply);
        		}	
        	}		
       }
}
