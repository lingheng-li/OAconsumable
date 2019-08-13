package com.chiansofti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chiansofti.dao.EmpDao;
import com.chiansofti.entity.Allocation;
import com.chiansofti.serviceImpl.AllocationServiceImpl;

@WebServlet("/checkAllocation")
public class CheckAllocationServlet extends HttpServlet{
	AllocationServiceImpl allocationServiceImpl =new AllocationServiceImpl();
	EmpDao empdao =new EmpDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		List<Allocation> list=allocationServiceImpl.select(id);
		resp.setCharacterEncoding("utf-8");
		req.setAttribute("state", list.get(0).getState());
		int power = empdao.select(list.get(0).getDealer());
		req.setAttribute("power", power);
		req.setAttribute("list", list);
		req.getRequestDispatcher("CheckAllocation.jsp").forward(req, resp);
	}
}
