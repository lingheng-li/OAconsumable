package com.chiansofti.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chiansofti.entity.Allocation;
import com.chiansofti.entity.Emp;
import com.chiansofti.serviceImpl.AllocationServiceImpl;


@WebServlet("/showAllocation")
public class ShowAllocationServlet extends HttpServlet{
	AllocationServiceImpl allocationServiceImpl = new AllocationServiceImpl();
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			HttpSession session = req.getSession();
			Emp emp = (Emp) session.getAttribute("emp");
			if(emp!=null){
				List<Allocation> list =new ArrayList<>();
				list = allocationServiceImpl.select(emp);
				req.setAttribute("list", list);
				req.getRequestDispatcher("ShowAllocation.jsp").forward(req, resp);
			}else{
				resp.sendRedirect(req.getContextPath() + "/logOut");
			}
		}
}
