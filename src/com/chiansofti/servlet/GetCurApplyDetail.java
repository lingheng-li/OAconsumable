package com.chiansofti.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.chiansofti.serviceImpl.CheckAndAcceptImpl;

/**
 * 2019年8月13日 @CH
 */
@WebServlet("/getCurApplyDetail")
public class GetCurApplyDetail extends HttpServlet{

    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
	// 尝试从详情表中获取购置计划数据
	String tablenum = req.getParameter("p");
	CheckAndAcceptImpl caa = new CheckAndAcceptImpl();
	Map<String, List<String>> curApply=caa.getCurApplyDetail(tablenum);
	System.out.println(curApply);
	res.setCharacterEncoding("utf-8");
	if(curApply.size()<1){
	    res.getWriter().print(0);
	}else{
	    JSONObject jsonObject = JSONObject.fromObject(curApply);
	    res.getWriter().print(jsonObject);	    
	}
    }
    
}

