package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import application.App;

public class UserOwnerDAO {

	private ResultSet rs;
	private String sql;
	ArrayList<UserOwner> list;
	UserOwner user;
	String ownerid = App.logstate.getId();	//������ ���̵� �����´�
	public UserOwnerDAO () {}
	
	/*��������ȭ�� ���� �� ���̵�, ����, ���ҹ�ȣ, ��ȣ��*/
	public UserOwner selectUserOwner() throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
	
		sql = "select * from ���� where ���̵�="+ownerid;
		mysql.sql(sql);
		rs = mysql.select();
		
		while(rs.next())
		{
			String id = rs.getString("���־��̵�");
			String name = rs.getString("����");
			Integer storeNum = rs.getInt("�󰡾��ҹ�ȣ");
			String storeName = rs.getString("��ȣ��");
			
			user = new UserOwner(id, name, storeNum, storeName);
		}
		return user;
	}
	
	/*��������ȭ�� ���� �� �޴� �� ����*/
	
	
	/*��������ȭ�� ���� �� ���θ��ּ�*/
}