package com.chiansofti.servlet;

import com.chiansofti.dao.ChuZhiDao;
import com.chiansofti.entity.CZprincipal;
import com.chiansofti.entity.ChuZhiName;
import com.chiansofti.entity.Emp;
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

@WebServlet("/Tuihui")
public class CZtuihui extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String bianh = req.getParameter("bianh");
		System.out.println(bianh);
		ChuZhiDao chuzhidao = new ChuZhiDao();
		chuzhidao.tuihui(bianh);
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
