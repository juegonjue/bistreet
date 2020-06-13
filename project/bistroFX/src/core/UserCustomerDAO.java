package core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCustomerDAO {

	private ResultSet rs;
	private String sql;

	public UserCustomerDAO() {}
	
	/*1. �մ�ȸ������ --> ���ԵǾ�����, �ߺ��Ǿ����� �˷���*/
	public String registerC(String id, String pw, String name) throws SQLException {
		
		boolean usable = isUsableC(id);	//�ߺ���ȸ
		
		String message;
		if (usable == true) {
			Mysql mysql = Mysql.getConnection();
			sql = "insert into ȸ�� values (?,?,?,now())";
			mysql.psql(sql);
			mysql.setstring(1, id);
			mysql.setstring(2, pw);
			mysql.setstring(3, name);
			
			message = "��밡��, ���ԵǾ����ϴ�.";
		}	
		else message = "���̵� �ߺ��Դϴ�.";
		
		return message;
	}
	
	/*4. ���̵� �ߺ����� �ʾ� ��밡���Ѱ�? -> true�� ��밡��, false�� ���Ұ�*/
	public boolean isUsableC(String id) throws SQLException {
		boolean rs_bool=false;
		Mysql mysql = Mysql.getConnection();
		sql = "select * from ȸ�� where ȸ�����̵�=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
		
		rs.last();
		if(rs.getRow()==0){
			rs_bool = false;
		}
		else rs_bool = true;
		return rs_bool;		
	}
}
