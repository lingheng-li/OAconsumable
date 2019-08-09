package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2019年8月8日 @CH
 */
@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	// 清空session中的信息
	req.getSession().removeAttribute("emp");
	// 重定向至login.jsp
	resp.sendRedirect(req.getContextPath() + "/Login.jsp");
    }
}
