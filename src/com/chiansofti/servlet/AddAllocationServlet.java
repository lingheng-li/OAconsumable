package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.chiansofti.entity.TestConsumable;
import com.chiansofti.serviceImpl.AllocationServiceImpl;

//用于调取调拨物品
@WebServlet("/AddAllocation")
public class AddAllocationServlet extends HttpServlet{
	
	AllocationServiceImpl allocationServiceImpl=new AllocationServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String code=req.getParameter("code");
		TestConsumable consumable =allocationServiceImpl.selectConsum(code);
		resp.setCharacterEncoding("utf-8");
		JSONObject jsonObject = JSONObject.fromObject(consumable);
		resp.getWriter().print(jsonObject);
	}
}
