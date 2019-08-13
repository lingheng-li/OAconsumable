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

import net.sf.json.JSONArray;

import com.chiansofti.entity.Apply;
import com.chiansofti.entity.Emp;
import com.chiansofti.service.ApplyService;
import com.chiansofti.serviceImpl.ApplyServiceImpl;
@WebServlet("/ApplyFaceServlet")
public class ApplyFaceServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp)
        		throws ServletException, IOException {
        	//1.设置编码
    		req.setCharacterEncoding("utf-8");
    		resp.setCharacterEncoding("utf-8");
    		resp.setContentType("text/html;charset=utf-8");
    		
    		HttpSession session = req.getSession();
    		Emp emp = (Emp) session.getAttribute("emp");
    	    List<Apply> list=new ArrayList<Apply>();
    	    ApplyService applyService=new ApplyServiceImpl();
    	    list=applyService.select(emp);
			req.setAttribute("list", list);
			req.getRequestDispatcher("ReadOnlyAppaly.jsp").forward(req, resp);
        	
        }
}
