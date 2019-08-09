package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chiansofti.util.JDBCUtil;

/**
 * 2019年8月8日 @CH
 */
public class CheckAndAcceptDao {
    public Map<String, List<String>> getApplyList() {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
	Map<String, List<String>> applyMap = new HashMap<>();
	String sql = "select * from consumable_apply where approval_status=0";
	try {
	    conn = JDBCUtil.getMySqlConn();
	    ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		List<String> list = new ArrayList<>();
		list.add(Integer.toString(rs.getInt("id")));
		list.add(rs.getString("tablenum"));
		list.add(rs.getString("empno"));
		String create_time = null;
		DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
		create_time = dateFormat.format(rs.getTimestamp("create_time"));
		list.add(create_time);
		list.add(rs.getString("consumable_code"));
		list.add(rs.getString("consumable_name"));
		list.add(Double.toString((rs.getDouble("consumable_price"))));
		list.add(Integer.toString(rs.getInt("consumable_number")));
		list.add(rs.getString("consumable_code"));
		list.add(Integer.toString(rs.getInt("approval_status")));
		applyMap.put(rs.getString("tablenum"), list);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    JDBCUtil.close(rs, ps, conn);
	}

	return applyMap;
    }
}
