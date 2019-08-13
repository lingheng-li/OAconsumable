package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chiansofti.serviceImpl.AllocationServiceImpl;

//调整到调拨单填写页面
@WebServlet("/Allocation")
public class AllocationServlet extends HttpServlet{
	AllocationServiceImpl allocationServiceImpl = new AllocationServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/Allocation.jsp").forward(req, resp);
	}
}
