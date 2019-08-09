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
 * 2019年8月8日 @CH
 */
@WebServlet("/getApplyList")
public class GetApplyListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {
	// 获取购置计划表数据
	CheckAndAcceptImpl caa = new CheckAndAcceptImpl();
	Map<String, List<String>> applyMap = caa.getApplyList();
	res.setCharacterEncoding("utf-8");
	JSONObject jsonObject = JSONObject.fromObject(applyMap);
	res.getWriter().print(jsonObject);
    }
}
