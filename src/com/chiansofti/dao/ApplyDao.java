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
	//��������ݲ������ݿⷽ��
	//����apply����
	public void connection(Apply apply) {
		try{
		conn=JDBCUtil.getMySqlConn();
		//�������
		String sql="insert into consumable_apply(tablenum,empno,create_time,consumable_code,consumable_name,consumable_price,consumable_number,courtyard_project,approval_status)values(?,?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setObject(1, apply.getTablenum());//�����
		ps.setObject(2, apply.getEmpno());//Ա�����
		ps.setObject(3, apply.getCreate_time());//������ʱ��
		ps.setObject(4, apply.getConsumable_code());//�׺�Ʒ����
		ps.setObject(5, apply.getConsumable_name());//�׺�Ʒ����
		ps.setObject(6, apply.getConsumable_price());//�׺�Ʒ�۸�
		ps.setObject(7, apply.getConsumable_number());//�׺�Ʒ����
		ps.setObject(8, apply.getCourtyard_project());//�Ƿ�ΪԺ����Ŀ
		ps.setObject(9, apply.getApproval_status());//����״̬
		ps.execute();	
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		JDBCUtil.close(rs, ps, conn);
	 }
   }
	//�����������ݺ��ѯ����
	//����emp�����õ�session����Ҫ��ֵ
	//�Ѳ�ѯ�������ݷ���list�з���һ��list���Ͷ���
	public List<Apply> select(Emp emp) {
		List<Apply> list=new ArrayList<Apply>();
		try {
			conn = JDBCUtil.getMySqlConn();
			//����Ȩ��power���жϣ���ͨԱ��ֻ�ܲ鿴�Լ������뵥��������߲��ž���鿴�����ŵ����뵥
			if(emp.getPower()==0){
				//���session�ڵ�Ա�����
				String empno=emp.getEmpno();
				ps= conn.prepareStatement("select * from consumable_apply where empno=? and approval_status=0");
				ps.setString(1, empno);
				rs = ps.executeQuery();
				while(rs.next()){
					//����apply���󣬽���ѯ�������ݷ��������
					Apply apply=new Apply();
					apply.setTablenum(rs.getString("tablenum"));//�����
					apply.setConsumable_name(rs.getString("consumable_name"));//�׺�Ʒ����
					apply.setConsumable_code(rs.getString("consumable_code"));//�׺�Ʒ����
					apply.setConsumable_price(rs.getBigDecimal("consumable_price"));//�׺�Ʒ�۸�
					//BigDecimal���ȸ��ߵĺ�������
					BigDecimal  consumable_price  = rs.getBigDecimal("consumable_price");
					apply.setConsumable_number(rs.getInt("consumable_number"));//�׺�Ʒ����
					//������ת��ΪBigDecimal���ͣ����м���
					int b=rs.getInt("consumable_number");
					BigDecimal consumable_number = new BigDecimal(b);
					//ǰ����ʾ���ܼ�Ϊ�����������ĳ˻���ʹ��BigDecimal���еķ���multiply()
					BigDecimal   totalPrice = consumable_price.multiply(consumable_number);
					apply.setTotalPrice(totalPrice);//�ܼ�
					list.add(apply);
				     }
				}else{
					//���session�ڵĲ��ű��
					String deptno=emp.getDeptno();
					ps= conn.prepareStatement("select * from consumable_apply  where  empno in (select empno  from emp where deptno =?) and approval_status=0");
					ps.setString(1, deptno);
					rs = ps.executeQuery();
					while(rs.next()){
						//����apply���󣬽���ѯ�������ݷ��������
						Apply apply=new Apply();
						apply.setTablenum(rs.getString("tablenum"));//�����
						apply.setConsumable_name(rs.getString("consumable_name"));//�׺�Ʒ����
						apply.setConsumable_code(rs.getString("consumable_code"));//�׺�Ʒ����
						apply.setConsumable_price(rs.getBigDecimal("consumable_price"));//�׺�Ʒ�۸�
						//BigDecimal���ȸ��ߵĺ�������
						BigDecimal  consumable_price  = rs.getBigDecimal("consumable_price");
						apply.setConsumable_number(rs.getInt("consumable_number"));//�׺�Ʒ����
						//������ת��ΪBigDecimal���ͣ����м���
						int b=rs.getInt("consumable_number");
						BigDecimal consumable_number = new BigDecimal(b);
						//ǰ����ʾ���ܼ�Ϊ�����������ĳ˻���ʹ��BigDecimal���еķ���multiply()
						BigDecimal   totalPrice = consumable_price.multiply(consumable_number);
						apply.setTotalPrice(totalPrice);//�ܼ�
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
	
	//�޸����״̬����
	public void updateApply(String tablenum) {
		try{
		conn=JDBCUtil.getMySqlConn();
		//�������
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
	
}
