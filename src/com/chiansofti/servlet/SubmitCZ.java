package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
   
import com.chiansofti.dao.ChuZhiDao;
import com.chiansofti.entity.Emp;

@WebServlet("/Sub")
public class SubmitCZ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		// 2.接收前台请求的数据
		if (emp.getPower() == 0) {
			String[] code = changToArrar(req.getParameter("name"));
			String[] name = changToArrar(req.getParameter("code"));
			System.out.println(name[1]);
			System.out.println(code[1]);
			ChuZhiDao chuzhidao = new ChuZhiDao();
			for(int i =1 ;i<code.length;i++){
			chuzhidao.subimt(name[i], code[i]);
			}
		}else {
			String bianh = req.getParameter("bianh");
			System.out.println(bianh);
			ChuZhiDao chuzhidao = new ChuZhiDao();
			chuzhidao.subimt1(bianh);
		}
		req.getRequestDispatcher("/Main.jsp").forward(req, resp);
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
