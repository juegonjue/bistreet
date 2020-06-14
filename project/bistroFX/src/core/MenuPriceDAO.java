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
	
	/*�޴� �� ���� ��� ��� �� ����, ������ ����*/
	public int updateMenuPrice(int storenum, String menu1, int price1, String menu2, int price2, String menu3, int price3) throws SQLException {
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "update �޴��װ��� set �޴�1=?, ����1=?, �޴�2=?, ����2=?, �޴�3=?, ����3=? where �󰡾��ҹ�ȣ = ?";	//���� ���� ����
		mysql.psql(sql);
		mysql.setstring(1, menu1);
		mysql.setint(2,price1);
		mysql.setstring(3, menu2);
		mysql.setint(4,price2);		
		mysql.setstring(5, menu3);
		mysql.setint(6,price3);
		mysql.setint(7, storenum);
		return mysql.update2();	//������ ���ڵ� ���� ��ȯ
	}

}
