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
import com.chiansofti.entity.TestConsumable;
import com.chiansofti.serviceImpl.AllocationServiceImpl;

//
@WebServlet("/InsertAllocationable")
public class InsertAllocationServlet extends HttpServlet{
	AllocationServiceImpl allocationServiceImpl =new AllocationServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String rdeptno = req.getParameter("rdeptno");
		String user[] = changToArrar(req.getParameter("users"));
		String list[]=changToArrar(req.getParameter("ids"));
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		allocationServiceImpl.insert(list,user,rdeptno,emp);
		resp.getWriter().print(1);
	}
	/**
	* 字符串编程数组
	* @return
	*/
	public static String[] changToArrar(String str){
		str = str.substring(1, str.length()-1);
		str = str.replace("\"", "");
		String[] str1 = str.split(",");
	    return str1;
	}
}
