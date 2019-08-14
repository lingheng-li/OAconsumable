package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chiansofti.entity.Emp;
import com.chiansofti.serviceImpl.AllocationServiceImpl;

@WebServlet("/saveAllocation")
public class SaveAllocationServlet extends HttpServlet{
	AllocationServiceImpl allocationServiceImpl =new AllocationServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		String state=req.getParameter("state");
		String allocationid = req.getParameter("id");
		int result=allocationServiceImpl.update(state, allocationid,emp);
		resp.getWriter().print(result);
	}

}
