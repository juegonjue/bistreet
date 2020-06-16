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
	
	/*�޴� �� ���� ��� ����, ������ ����*/
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

	/*�ش� �󰡾��ҹ�ȣ�� '�޴�'�� ������ �ִ°�?*/
	public boolean hasMenu(int storeNumber) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select * from �޴��װ��� where �󰡾��ҹ�ȣ=?";
		mysql.psql(sql);
		mysql.setint(1, storeNumber);
		rs = mysql.select2();
		
		if (rs.isBeforeFirst()==true) return true;	//������������ true��ȯ
		else return false;		//������ ������ false��ȯ 
	}
	
	/*�޴� �� ���� ��� -- ������ �޴� �� �����. */
	public int createMenuPrice(int storenum) throws SQLException {
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "insert into �޴��װ���(�󰡾��ҹ�ȣ, �޴�1, ����1, �޴�2, ����2, �޴�3, ����3) values (?,null,null,null,null,null,null)";	//���� ���� ����
		mysql.psql(sql);
		mysql.setint(1, storenum);

		return mysql.update2();	//������ ���ڵ� ���� ��ȯ
	}
	//�޴��� ������ ��ȸ
	public MenuPrice searchM(int storeNumber) throws SQLException
	{
		
		rs = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "select �޴�1, ����1, �޴�2, ����2, �޴�3, ����3 from �޴��װ��� where �󰡾��ҹ�ȣ ="+storeNumber;
		MenuPrice menuprice = null;
		if(hasMenu(storeNumber))
		{
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
			
		}else
		{
			if (rs.isBeforeFirst()!=true) {
				rs.next();
				String menu1 = "�޴���                           ";
				Integer price1 = 0;
				String menu2 = "����ֽ��ϴ�                    ";
				Integer price2 = 0;
				String menu3 = "���ִ��� �޴��� �߰����ּ���";
				Integer price3 = 0;
				menuprice = new MenuPrice(menu1, price1, menu2, price2, menu3, price3);
			}
			return menuprice;
		}
		
		
		
		
	}
}
