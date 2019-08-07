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

import net.sf.json.JSONObject;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
	req.getRequestDispatcher("/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {
	EmpServiceImpl empServiceImpl = new EmpServiceImpl();
	req.setCharacterEncoding("utf-8");
	res.setCharacterEncoding("utf-8");
	res.setContentType("text/html;charset=utf-8");
	String empno = req.getParameter("empno");
	String pwd = req.getParameter("pwd");
	Emp emp = empServiceImpl.login(empno, pwd);
	if (emp != null) {
	    // req.setAttribute("emp", emp);
	    // JSONObject jsonObject=JSONObject.fromObject(emp);
	    // resp.getWriter().print(emp);
	    // req.getRequestDispatcher("index.jsp").forward(req, res);
	    HttpSession session = req.getSession();
	    session.setAttribute("userInfo", emp);
	    System.out.println(req.getContextPath());
	    res.sendRedirect(req.getContextPath() + "/Main.jsp");
	    // req.getRequestDispatcher("/Main.jsp").forward(req, res);
	} else {
	    req.setAttribute("error", "用户名或密码不对，请重新输入");
	    req.getRequestDispatcher("/Login.jsp").forward(req, res);
	}

    }
}
