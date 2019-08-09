package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2019年8月7日 @CH
 */
@WebServlet("/checkAndAccept")
public class CheckAndAccept extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

	req.getRequestDispatcher("/OACheckAndAccept.jsp").forward(req, res);
    }
}

