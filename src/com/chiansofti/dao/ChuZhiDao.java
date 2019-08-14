package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chiansofti.util.JDBCUtil;
import com.chiansofti.entity.CZprincipal;
import com.chiansofti.entity.ChuZhiName;
import com.chiansofti.entity.WasteObject;

public class ChuZhiDao {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
		public List<ChuZhiName> name(){
			
			List<ChuZhiName> list =new ArrayList<>();
			String sql = "SELECT consumable_name from consumable_apply a LEFT JOIN consumables_detal e on a.consumable_code = e.consumable_code where e.state = 1";
			try {
				conn=JDBCUtil.getMySqlConn();
				ps=conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					ChuZhiName cz = new ChuZhiName();
					cz.setName(rs.getString("consumable_name"));
					list.add(cz);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				JDBCUtil.close(rs, ps, conn);
			}
			for(int i = 0;i<list.size();i++){
				System.out.println(list.get(i));
			}
			return list;
			
		}
		public List<WasteObject> rest(String name){
			List<WasteObject> list =new ArrayList<>();
			conn=JDBCUtil.getMySqlConn();
			String sql = "SELECT a.consumable_code,e.consumable_num,a.consumable_price,a.tablenum,e.emp_name from consumable_apply a LEFT JOIN consumables_detal e on a.consumable_code = e.consumable_code where a.consumable_name=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setObject(1, name);
				rs=ps.executeQuery();
				while(rs.next()){
				WasteObject ws = new WasteObject();
				ws.setCode(rs.getString("consumable_code"));
				ws.setNumber(rs.getInt("consumable_num"));
				ws.setP_code(rs.getString("tablenum"));
				ws.setPrice(rs.getDouble("consumable_price"));
				ws.setUse_name(rs.getString("emp_name"));
				ws.setTotalPrice(ws.getNumber()*ws.getPrice());
				list.add(ws);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				JDBCUtil.close(rs, ps, conn);
			}
			return list;
			
		}
		public void subimt1(String bianh){
			conn=JDBCUtil.getMySqlConn();
			String sql = "UPDATE consumables_detal SET state=2 where consumable_code=? ";
			try {
				ps=conn.prepareStatement(sql);
				ps.setObject(1, bianh);
				int r = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				JDBCUtil.close(rs, ps, conn);
			}
		}
		public List<CZprincipal> principal(){
			List<CZprincipal> list =new ArrayList<>();
			String sql = "SELECT consumable_name,a.consumable_code,e.consumable_num,a.consumable_price,a.tablenum,e.emp_name,e.handle from consumable_apply a LEFT JOIN consumables_detal e on a.consumable_code = e.consumable_code where e.state = 3";
			try {
				conn=JDBCUtil.getMySqlConn();
				ps=conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					CZprincipal cz = new CZprincipal();
					cz.setName(rs.getString("consumable_name"));
					cz.setCode(rs.getString("consumable_code"));
					cz.setNumber(rs.getInt("consumable_num"));
					cz.setP_code(rs.getString("tablenum"));
					cz.setPrice(rs.getDouble("consumable_price"));
					cz.setUse_name(rs.getString("emp_name"));
					cz.setHandle(rs.getString("handle"));
					cz.setTotalPrice(cz.getNumber()*cz.getPrice());
					list.add(cz);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				JDBCUtil.close(rs, ps, conn);
			}
			for(int i = 0;i<list.size();i++){
				System.out.println(list.get(i));
			}
			return list;
			
		}
		public void subimt(String code, String name) {
			conn=JDBCUtil.getMySqlConn();
			String sql = "UPDATE consumables_detal SET handle=?,state=3 where consumable_code=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setObject(1, name);
				ps.setObject(2, code);
				int r = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				JDBCUtil.close(rs, ps, conn);
			}
		
		}
		public void tuihui(String bianh){
			conn=JDBCUtil.getMySqlConn();
			String sql = "UPDATE consumables_detal SET handle='',state=1 where consumable_code=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setObject(1, bianh);
				int r = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				JDBCUtil.close(rs, ps, conn);
			}
		}
}
