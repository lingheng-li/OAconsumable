package com.chiansofti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.chiansofti.entity.Emp;
import com.chiansofti.serviceImpl.EmpServiceImpl;

/**
 * 2019年8月9日 @CH
 */
@WebServlet("/getUserList")
public class GetUserList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {
	EmpServiceImpl esi = new EmpServiceImpl();
	List<Emp> userList = esi.userList();
	System.out.println(userList);
	res.setCharacterEncoding("utf-8");
	JSONArray jsonArray = JSONArray.fromObject(userList);
	res.getWriter().print(jsonArray);
    }

}
