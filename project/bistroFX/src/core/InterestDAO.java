package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InterestDAO {
	
	private ResultSet rs;		//resultSet
	private String sql;
	private ArrayList<Store> list;
	private int rs_cnt;			//�ݿ��� ���ڵ尳��, -1 ���Ͻ� �����Ѱ���
	
	public InterestDAO() {}
	
	/*�ش� ȸ���� ���� ��ϵ� �������*/
	public ArrayList<Store> selectInterest(String id) throws SQLException{
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();
		sql = "select ��ȣ��, ���θ��ּ� from ��ľ���, ���ɸ�� where ���ɸ��.�󰡾��ҹ�ȣ = ��ľ���.�󰡾��ҹ�ȣ and ���ɸ��.ȸ�����̵�=? and ���ɸ��.���ɿ���=1";
		mysql.psql(sql);
		mysql.setstring(1,id);
		rs = mysql.select2();
		
		list = new ArrayList<Store>();
		if (rs.isBeforeFirst()==true) {
			while(rs.next()) {
				String storename = rs.getString("��ȣ��");
				String storeaddress = rs.getString("���θ��ּ�");
				
				Store s = new Store(storename, storeaddress);
				list.add(s);
			}
		}
		return list;
	}
}
