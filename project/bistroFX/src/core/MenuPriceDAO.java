package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.App;

public class MenuPriceDAO {
	
	private ResultSet rs;
	private String sql;
	private ArrayList<MenuPrice> list;
	public MenuPriceDAO() {}
	String ownerid = App.logstate.getId();	//������ ���̵� �����´�
	
	
	public ArrayList<MenuPrice> selectAllMenuPrice() throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "select �޴�1,����1,�޴�2,����2,�޴�3,����3 from �޴��װ���,��ľ��� where �޴��װ���.�󰡾��ҹ�ȣ=��ľ���.�󰡾��ҹ�ȣ;";
		mysql.sql(sql);
		rs = mysql.select();
		
		list = new ArrayList<MenuPrice>();
		while(rs.next()) {
			String menu1 = rs.getString("�޴�1");
			Integer price1 = rs.getInt("����1");
			String menu2 = rs.getString("�޴�2");
			Integer price2 = rs.getInt("����2");
			String menu3 = rs.getString("�޴�3");
			Integer price3 = rs.getInt("����3");
			MenuPrice m = new MenuPrice(menu1, price1, menu2, price2, menu3, price3);
			list.add(m);
		}
		return list;
	}
	
	/*�޴� �� ���� ��� ����*/
	public int updateMenuPrice() throws SQLException {
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "update ~~";	//���� ���� ����
		mysql.sql(sql);
		return mysql.update();	//������ ���ڵ� ���� ��ȯ
	}
	
	
	/*�޴� �� ���� ��� ����*/
	public int deleteMenuPrice() throws SQLException {
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "delete ~~";	//���� ���� ����
		mysql.sql(sql);
		return mysql.delete();	//������ ���ڵ� ���� ��ȯ
	}
}
