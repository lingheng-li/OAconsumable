package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chiansofti.service.ApplyService;
import com.chiansofti.serviceImpl.ApplyServiceImpl;
@WebServlet("/ApplyAuditServlet")
public class ApplyAuditServlet extends HttpServlet{
          @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp)
        		throws ServletException, IOException {
        	  String tablenum=req.getParameter("tablenumid");
        	  ApplyService applyService=new ApplyServiceImpl();
      		  applyService.updateApply(tablenum);
        	  resp.getWriter().print("hhh");
        }
}
