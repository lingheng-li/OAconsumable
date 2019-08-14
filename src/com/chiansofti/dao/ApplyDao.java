
package com.chiansofti.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.chiansofti.entity.Apply;
import com.chiansofti.entity.Emp;
import com.chiansofti.util.JDBCUtil;



public class ApplyDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//申请表数据插入数据库方法
	//传入apply对象
	public void connection(Apply apply) {
		try{
		conn=JDBCUtil.getMySqlConn();
		//插入语句
		String sql="insert into consumable_apply(tablenum,empno,create_time,consumable_code,consumable_name,consumable_price,consumable_number,courtyard_project,approval_status)values(?,?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setObject(1, apply.getTablenum());//表单编号
		ps.setObject(2, apply.getEmpno());//员工编号
		ps.setObject(3, apply.getCreate_time());//表单创建时间
		ps.setObject(4, apply.getConsumable_code());//易耗品编码
		ps.setObject(5, apply.getConsumable_name());//易耗品名称
		ps.setObject(6, apply.getConsumable_price());//易耗品价格
		ps.setObject(7, apply.getConsumable_number());//易耗品数量
		ps.setObject(8, apply.getCourtyard_project());//是否为院管项目
		ps.setObject(9, apply.getApproval_status());//审批状态
		ps.execute();	
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		JDBCUtil.close(rs, ps, conn);
	 }
   }
	//申请表插入数据后查询方法
	//传入emp对象，拿到session中想要的值
	//把查询到的数据放入list中返回一个list泛型对象
	public List<Apply> select(Emp emp) {
		List<Apply> list=new ArrayList<Apply>();
		try {
			conn = JDBCUtil.getMySqlConn();
			//根据权限power做判断，普通员工只能查看自己的申请单，经理或者部门经理查看本部门的申请单
			if(emp.getPower()==0){
				//获得session内的员工编号
				String empno=emp.getEmpno();
				ps= conn.prepareStatement("select * from consumable_apply where empno=? and approval_status in (0,2)");
				ps.setString(1, empno);
				rs = ps.executeQuery();
				while(rs.next()){
					//创建apply对象，将查询到的数据放入对象中
					Apply apply=new Apply();
					apply.setTablenum(rs.getString("tablenum"));//表单编号
					apply.setConsumable_name(rs.getString("consumable_name"));//易耗品名称
					apply.setConsumable_code(rs.getString("consumable_code"));//易耗品编码
					apply.setConsumable_price(rs.getBigDecimal("consumable_price"));//易耗品价格
					//BigDecimal精度跟高的函数类型
					BigDecimal  consumable_price  = rs.getBigDecimal("consumable_price");
					apply.setConsumable_number(rs.getInt("consumable_number"));//易耗品数量
					//把数量转换为BigDecimal类型，进行计算
					int b=rs.getInt("consumable_number");
					BigDecimal consumable_number = new BigDecimal(b);
					//前端显示的总价为单价与数量的乘积，使用BigDecimal特有的方法multiply()
					BigDecimal   totalPrice = consumable_price.multiply(consumable_number);
					apply.setTotalPrice(totalPrice);//总价
					int c=rs.getInt("approval_status");//审批状态
					if(c==0){
						apply.setApplystatus("未审批");//显示未审批状态
					}else{
						apply.setApplystatus("已驳回");//显示驳回状态
					}
					list.add(apply);
				     }
				}else{
					//获得session内的部门编号
					String deptno=emp.getDeptno();
					ps= conn.prepareStatement("select * from consumable_apply  where  empno in (select empno  from emp where deptno =?) and approval_status=0");
					ps.setString(1, deptno);
					rs = ps.executeQuery();
					while(rs.next()){
						//创建apply对象，将查询到的数据放入对象中
						Apply apply=new Apply();
						apply.setTablenum(rs.getString("tablenum"));//表单编号
						apply.setConsumable_name(rs.getString("consumable_name"));//易耗品名称
						apply.setConsumable_code(rs.getString("consumable_code"));//易耗品编码
						apply.setConsumable_price(rs.getBigDecimal("consumable_price"));//易耗品价格
						//BigDecimal精度跟高的函数类型
						BigDecimal  consumable_price  = rs.getBigDecimal("consumable_price");
						apply.setConsumable_number(rs.getInt("consumable_number"));//易耗品数量
						//把数量转换为BigDecimal类型，进行计算
						int b=rs.getInt("consumable_number");
						BigDecimal consumable_number = new BigDecimal(b);
						//前端显示的总价为单价与数量的乘积，使用BigDecimal特有的方法multiply()
						BigDecimal   totalPrice = consumable_price.multiply(consumable_number);
						apply.setTotalPrice(totalPrice);//总价
						list.add(apply);
					     }
		          } 
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
	}
	
	//修改审核状态方法
	public void updateApply(String tablenum) {
		try{
		conn=JDBCUtil.getMySqlConn();
		//插入语句
		String sql="update consumable_apply set approval_status=1 where tablenum=?";
		ps=conn.prepareStatement(sql);
		ps.setObject(1, tablenum);
		ps.execute();	
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		JDBCUtil.close(rs, ps, conn);
	 }
   }
	
	//修改审核状态方法
	public void updateApplystatus(String tablenum) {
		try{
		conn=JDBCUtil.getMySqlConn();
		//插入语句
		String sql="update consumable_apply set approval_status=2 where tablenum=?";
		ps=conn.prepareStatement(sql);
		ps.setObject(1, tablenum);
		ps.execute();	
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		JDBCUtil.close(rs, ps, conn);
	 }
   }
	
}