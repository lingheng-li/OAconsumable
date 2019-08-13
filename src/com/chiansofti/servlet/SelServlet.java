package com.chiansofti.servlet;

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

@WebServlet("/SelListServlet")
public class SelServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.设置编码
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		ChuZhiNameimpl chuzhinameimpl = new ChuZhiNameimpl();
			List<CZprincipal> name = chuzhinameimpl.principal();
//			System.out.println(name.get(0).getName());
			resp.setCharacterEncoding("UTF-8");
			req.setAttribute("name", name);
			req.getRequestDispatcher("/ChuZhi.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
