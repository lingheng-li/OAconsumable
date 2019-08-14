package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chiansofti.util.JDBCUtil;

/**
 * 2019年8月8日 @CH
 */
public class CheckAndAcceptDao {
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = null;

    public Map<String, List<String>> getApplyList(String deptno) {
	Map<String, List<String>> applyMap = new HashMap<>();

	String sql = "select * from consumable_apply ca where ca.approval_status != 2 and ca.empno in (select empno from emp where emp.deptno = ?)";

	try {
	    conn = JDBCUtil.getMySqlConn();
	    ps = conn.prepareStatement(sql);
	    ps.setObject(1, deptno);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		List<String> list = new ArrayList<>();
		String create_time = null;
		DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
		create_time = dateFormat.format(rs.getTimestamp("create_time"));

		// 0 暂时没用的id
		list.add(Integer.toString(rs.getInt("id")));
		// 1 表单编号
		list.add(rs.getString("tablenum"));
		// 2 申请人编号
		list.add(rs.getString("empno"));
		// 3 申请时间
		list.add(create_time);
		// 4 易耗品编码
		list.add(rs.getString("consumable_code"));
		// 5 易耗品名称
		list.add(rs.getString("consumable_name"));
		// 6 易耗品价格
		list.add(Double.toString((rs.getDouble("consumable_price"))));
		// 7 易耗品数量
		list.add(Integer.toString(rs.getInt("consumable_number")));
		// 8 审批状态
		list.add(Integer.toString(rs.getInt("approval_status")));
		// 9 验收人意见
		list.add(rs.getString("accepter_opinion"));
		// 10 部门负责人意见
		list.add(rs.getString("dept_opinion"));
		// 11 验收人编号
		list.add(rs.getString("accepter_no"));
		// 12 印章
		list.add(rs.getString("seal_status"));

		applyMap.put(rs.getString("tablenum"), list);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    JDBCUtil.close(rs, ps, conn);
	}

	return applyMap;
    }

    public void subCheck(String[][] data) {
	// 0 D2019-a101-1
	// 1 a123456 易耗品编号
	// 2 绿茶 易耗品名称
	// 3 1 数量
	// 4 12 不含税单价
	// 5 2 增值税
	// 6 张三 使用人
	// 7 仓库 存放点
	// 8 是 是否在用
	// 9 张三 采购人
	// 10 1 验收人意见
	// 11 a101 验收人编号
	// 12 1 权限 权限大于1才有后面的数据
	// 13 1 部门负责人意见
	// 14 OK 印章

	String sql_insert = "INSERT INTO consumables_detal"
		+ "(tablenum,consumable_code,consumable_num,tax_price,added_tax,address,emp_name,deptno,state,purchaser,accept_time) "
		+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	try {
	    conn = JDBCUtil.getMySqlConn();
	    String sql_changeAccepterOpinion = "UPDATE consumable_apply set approval_status = ?, accepter_opinion = ?,accepter_no = ?  where tablenum = ?";
	    String sql_changeDeptOpinion = "UPDATE consumable_apply set dept_opinion = ? where tablenum = ?";
	    String sql_changeSealStatus = "UPDATE consumable_apply set seal_status = ? where tablenum = ?";
	    for (int i = 0; i < data.length; i++) {
		// 验收人意见
		if (Integer.parseInt(data[i][10]) > 0) {
		    // 验收人同意
		    ps = conn.prepareStatement(sql_changeAccepterOpinion);
		    ps.setObject(1, 1);
		    ps.setObject(2, 1);
		    ps.setObject(3, data[i][11]);
		    ps.setObject(4, data[i][0]);
		    ps.execute();
		    // 判断权限，是否为部门负责人
		    if (Integer.parseInt(data[i][12]) > 0) {
			// 部门负责人意见
			if (Integer.parseInt(data[i][13]) > 0) {
			    // 部门负责人同意
			    ps = conn.prepareStatement(sql_changeDeptOpinion);
			    ps.setObject(1, 1);
			    ps.setObject(2, data[i][0]);
			    ps.execute();
			    // 判断是否有印章
			    if (data[i][14].equals("OK")) {
				// 验收人，部门负责人都同意，且有印章
				ps = conn
					.prepareStatement(sql_changeSealStatus);
				ps.setObject(1, "OK");
				ps.setObject(2, data[i][0]);
				ps.execute();

				ps = conn.prepareStatement(sql_insert);
				// 表单编号
				ps.setObject(1, data[i][0]);
				// 易耗品编号
				ps.setObject(2, data[i][1]);
				// 数量
				ps.setObject(3, Integer.parseInt(data[i][3]));
				// 不含税单价
				ps.setObject(4, Double.parseDouble(data[i][4]));
				// 增值税
				ps.setObject(5, Double.parseDouble(data[i][5]));
				// TODO 存放点仓库或者所使用者所在部门，根据是否有使用人来判断。
				ps.setObject(6, data[i][6].equals("") ? "仓库"
					: data[i][7]);
				// 使用人
				ps.setObject(7, data[i][6]);
				// 所属部门编号
				ps.setObject(8, data[i][7]);
				// 使用状态，根据是否有使用人判断
				ps.setObject(9, data[i][8].equals("是") ? 1 : 0);
				// 采购人
				ps.setObject(10, data[i][9]);
				// 采购时间
				Time t = new Time(new Date().getTime());
				ps.setObject(11, t);

				ps.execute();
			    } else {
				// 等待盖章
				ps = conn
					.prepareStatement(sql_changeSealStatus);
				ps.setObject(1, "NO");
				ps.setObject(2, data[i][0]);
				ps.execute();
			    }
			} else {
			    // 部门负责人不同意
			    ps = conn.prepareStatement(sql_changeDeptOpinion);
			    ps.setObject(1, 0);
			    ps.setObject(2, data[i][0]);
			    ps.execute();
			}
		    } else {
			// 当前用户不是部门负责人，则申请表单审批状态为审批中，等待有权限的用户审批

		    }
		} else {
		    // 验收人不通过，修改申请表为已审批，验收人意见为不同意
		    ps = conn.prepareStatement(sql_changeAccepterOpinion);
		    ps.setObject(1, 2);
		    ps.setObject(2, 0);
		    ps.setObject(3, data[i][11]);
		    ps.setObject(4, data[i][0]);
		    ps.execute();
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    JDBCUtil.close(rs, ps, conn);
	}

    }

    public Map<String, List<String>> getCurApplyDetail(String tablenum) {
	Map<String, List<String>> curApplyMap = new HashMap<>();
	String sql = "select * from consumables_detal cd where cd.tablenum = ? ";
	try {
	    conn = JDBCUtil.getMySqlConn();
	    ps = conn.prepareStatement(sql);
	    ps.setObject(1, tablenum);
	    rs = ps.executeQuery();
	    int i = 1;
	    while (rs.next()) {
		List<String> list = new ArrayList<>();
		String accept_time = null;
		DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
		// accept_time =
		// dateFormat.format(rs.getTimestamp("accept_time"));

		// 0 暂时没用的id
		list.add(Integer.toString(rs.getInt("id")));
		// 1 表单编号
		list.add(rs.getString("tablenum"));
		// 2 易耗品编号
		list.add(rs.getString("consumable_code"));
		// 3 易耗品数量
		list.add(Integer.toString(rs.getInt("consumable_num")));
		// 4 不含税单价
		list.add(Double.toString((rs.getDouble("tax_price"))));
		// 5 增值税
		list.add(Double.toString((rs.getDouble("added_tax"))));
		// 6 使用人
		list.add(rs.getString("emp_name"));
		// 7 采购人
		list.add(rs.getString("purchaser"));
		// 8 采购时间
		// list.add(accept_time);
		curApplyMap.put(tablenum + (i++), list);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    JDBCUtil.close(rs, ps, conn);
	}
	return curApplyMap;
    }

    public List<String> getCurApply(String tablenum) {
	List<String> list = new ArrayList<>();
	String sql = "select accepter_opinion,dept_opinion,accepter_no,seal_status from consumable_apply ca where ca.tablenum = ? ";
	try {
	    conn = JDBCUtil.getMySqlConn();
	    ps = conn.prepareStatement(sql);
	    ps.setObject(1, tablenum);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		// 0 验收人意见
		list.add(Integer.toString(rs.getInt("accepter_opinion")));
		// 1 部门负责人意见
		list.add(Integer.toString(rs.getInt("dept_opinion")));
		// 2 验收人编号
		list.add(rs.getString("accepter_no"));
		// 3 印章
		list.add(rs.getString("seal_status"));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    JDBCUtil.close(rs, ps, conn);
	}
	return list;
    }
}
