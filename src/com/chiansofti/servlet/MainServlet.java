package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chiansofti.entity.Emp;

/**
 * 2019年8月7日 @CH
 */
@WebServlet("/Main")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {
	// 获取session
	HttpSession session = req.getSession();
	// 获取session传过来的值
	Emp emp = (Emp) session.getAttribute("emp");
	if (emp == null) {
	    req.getRequestDispatcher("/Login.jsp").forward(req, res);
	} else {
	    req.getRequestDispatcher("/Main.jsp").forward(req, res);
	}
    }
}
