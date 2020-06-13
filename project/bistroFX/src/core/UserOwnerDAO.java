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
	
	/*���� ȸ������ (insert�� ����)*/
	public UserOwnerDAO () {}
	
	public String registerO(String id, String pw, String name, int storeNumber) throws SQLException {
		
		boolean usableId = isUsableO(id);	//�ߺ���ȸ
		boolean usableStoreNum = isUsableNum(storeNumber);
		
		String message;
		if (usableId == true && usableStoreNum == true) {
			Mysql mysql = Mysql.getConnection();
			sql = "insert into ���� values (?,?,?,now(), ?, (select ��ȣ�� from ��ľ��� where �󰡾��ҹ�ȣ=?))";
			mysql.psql(sql);
			mysql.setstring(1, id);
			mysql.setstring(2, pw);
			mysql.setstring(3, name);
			mysql.setint(4,storeNumber);
			mysql.setint(5,storeNumber);
			
			message = "��밡��, ���ԵǾ����ϴ�.";
		}	
		else message = "���̵� Ȥ�� �󰡾��ҹ�ȣ�� �ߺ��Դϴ�.";
		
		return message;
	}
	
	/*���̵� �ߺ����� �ʾ� ��밡���Ѱ�? -> true�� ��밡��, false�� ���Ұ�*/
	public boolean isUsableO(String id) throws SQLException {
		boolean rs_bool=false;
		Mysql mysql = Mysql.getConnection();
		sql = "select * from ���� where ���־��̵�=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
		
		rs.last();
		
		if(rs.getRow()==0) rs_bool = false;
		else rs_bool = true;
		
		return rs_bool;		
	}

	/*6. ������ storeNum�ΰ�? :���� ���� �ϳ��� �������ִ� */
	public boolean isUsableNum(int storeNum) throws SQLException {
		boolean rs_bool = false;
		Mysql mysql = Mysql.getConnection();
		sql = "select * from ���� where �󰡾��ҹ�ȣ=?";
		mysql.setint(1,storeNum);
		rs = mysql.select2();
		
		rs.last();
		
		if (rs.getRow() == 0 ) rs_bool = false;
		else rs_bool = true;
	
		return rs_bool;
	}
}