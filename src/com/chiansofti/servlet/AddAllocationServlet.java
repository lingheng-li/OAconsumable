package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.chiansofti.entity.ConsumablesDetal;
import com.chiansofti.entity.Emp;
import com.chiansofti.serviceImpl.AllocationServiceImpl;

//用于调取调拨物品
@WebServlet("/AddAllocation")
public class AddAllocationServlet extends HttpServlet{
	
	AllocationServiceImpl allocationServiceImpl=new AllocationServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("utf-8");
		Emp emp = (Emp) session.getAttribute("emp");
		String code=req.getParameter("code");
		ConsumablesDetal consumable =allocationServiceImpl.selectConsum(code,emp);
		resp.setCharacterEncoding("utf-8");
		JSONObject jsonObject = JSONObject.fromObject(consumable);
		resp.getWriter().print(jsonObject);
	}
}
