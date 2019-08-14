package com.chiansofti.servlet;
import com.chiansofti.entity.ChuZhiName;
import com.chiansofti.entity.Emp;
import com.chiansofti.entity.WasteObject;
import com.chiansofti.serviceImpl.ChuZhiNameimpl;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
      
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取传过来的值
        String name = req.getParameter("name");
        ChuZhiNameimpl chuzhinameimpl = new ChuZhiNameimpl();
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		List<WasteObject> list = chuzhinameimpl.rest(name);
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(JSONArray.fromObject(list));      
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
    }
}
