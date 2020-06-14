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
	String ownerid = App.logininfo.getId();	//������ ���̵� �����´�
	
	/*���ʾ��̵�->�󰡾��ҹ�ȣ->�޴��װ���*/
	public MenuPrice selectMenuPrice(String id) throws SQLException {
		rs = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "select �޴�1, ����1, �޴�2, ����2, �޴�3, ����3 from �޴��װ���, ���� where ���־��̵� =? and ����.�󰡾��ҹ�ȣ = �޴��װ���.�󰡾��ҹ�ȣ";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
		
		MenuPrice menuprice = null;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			String menu1 = rs.getString("�޴�1");
			Integer price1 = rs.getInt("����1");
			String menu2 = rs.getString("�޴�2");
			Integer price2 = rs.getInt("����2");
			String menu3 = rs.getString("�޴�3");
			Integer price3 = rs.getInt("����3");
			menuprice = new MenuPrice(menu1, price1, menu2, price2, menu3, price3);
		}
		return menuprice;
	}
	/*��ȯ�׽�Ʈ��*/
	public String menu1(String id) throws SQLException {
		rs = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "select �޴�1 from �޴��װ���, ���� where ���־��̵� =? and ����.�󰡾��ҹ�ȣ = �޴��װ���.�󰡾��ҹ�ȣ";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
		
		String menu1;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			menu1 = rs.getString("�޴�1");
			return menu1;
		}
		else return "(ã�� ����)";
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
		return mysql.update();	//������ ���ڵ� ���� ��ȯ
	}
}
