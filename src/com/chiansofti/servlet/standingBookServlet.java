package com.chiansofti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chiansofti.entity.ConsumablesDetal;
import com.chiansofti.service.StandingBookService;
import com.chiansofti.serviceImpl.StandingBookServiceImpl;

@WebServlet("/stangingbook")
public class standingBookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//设置编码
				req.setCharacterEncoding("utf-8");
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				
				/*StandingBookService sbs =new StandingBookServiceImpl();
				ConsumablesDetal consumablesDetal = sbs.searchStandingBook();
				req.setAttribute("", consumablesDetal);
				req.getRequestDispatcher("stangingbook.jsp").forward(req, resp);*/
				//调用server层
				StandingBookServiceImpl sbs = new StandingBookServiceImpl();
				List<ConsumablesDetal> cobj = sbs.searchStandingBook();
	
				//4.List转换成JSON数组
//				JSONArray jsonArray= JSONArray.fromObject(cobj);
//				req.setAttribute("cobj", jsonArray);
				req.setAttribute("cobj", cobj);
				req.getRequestDispatcher("stangingbook.jsp").forward(req, resp);
				
	}
}
