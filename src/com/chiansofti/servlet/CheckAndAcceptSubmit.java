package com.chiansofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chiansofti.serviceImpl.CheckAndAcceptImpl;

/**
 * 2019年8月12日 @CH
 */
@WebServlet("/subCheck")
public class CheckAndAcceptSubmit extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	// 真麻烦
	String datas = req.getParameter("datas");
	System.out.println(datas);

	datas = datas.replace('[', ' ');
	datas = datas.replace(']', ' ');
	datas = datas.replace('\"', ' ');
	datas = datas.trim();
	String[] dataArray = datas.split("\\|");
	for (int i = 0; i < dataArray.length; i++) {
	    dataArray[i] = dataArray[i].trim();
	    dataArray[i] = dataArray[i].substring(0, dataArray[i].length() - 1);
	}

	String[][] dataTrue = new String[dataArray.length][];
	for (int i = 0; i < dataArray.length; i++) {
	    dataTrue[i] = dataArray[i].split(",");
	}

	for (int i = 0; i < dataTrue.length; i++) {
	    for (int j = 0; j < dataTrue[i].length; j++) {
		dataTrue[i][j] = dataTrue[i][j].trim();
		if (dataTrue[i][0].equals("")) {
		    String[] temp = new String[dataTrue[i].length - 1];
		    System.arraycopy(dataTrue[i], 1, temp, 0,
			    dataTrue[i].length - 1);
		    dataTrue[i] = temp;
		    dataTrue[i][0] = dataTrue[i][0].trim();
		}
	    }
	}
	//[D2019-d101-1565661358870, 1, b22526, 维达抽纸, 23.0, 2.0, 李四, 使用人所在部门, 同意, 是, a101, 孙飒, 李四, 1, 1, 1, OK]
	CheckAndAcceptImpl caa = new CheckAndAcceptImpl();
	caa.subCheck(dataTrue);
	res.getWriter().print("1");
    }
}
