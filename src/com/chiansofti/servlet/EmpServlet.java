package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chiansofti.entity.Emp;
import com.chiansofti.serviceImpl.EmpServiceImpl;

@WebServlet("/Login")
public class EmpServlet extends HttpServlet{

	EmpServiceImpl empServiceImpl = new EmpServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String empno =req.getParameter("empno");
		String pwd = req.getParameter("pwd");
		Emp emp = empServiceImpl.login(empno, pwd);
		if(emp!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("emp", emp);
			req.setAttribute("emp", emp);
//			JSONObject jsonObject=JSONObject.fromObject(emp);
//			resp.getWriter().print(jsonObject);
			req.getRequestDispatcher("Main.jsp").forward(req, resp);
		}else {
			String error="员工编号或密码不正确";
			req.setAttribute("error", error);
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		
	}
}
