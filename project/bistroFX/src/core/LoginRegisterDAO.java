package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.LoginInfo;
import application.App;

public class LoginRegisterDAO {
	
	private ResultSet rs;
	private String sql;
	private ArrayList<UserCustomer> list;
	private int rs_cnt;
	
	public LoginRegisterDAO() {}
	
	
	/*�α��� (select)��ȿ*/
	public String login(String id, String pw) throws SQLException {
		
		Mysql mysql = Mysql.getConnection();
		sql = "select ���־��̵�, �н����� from ���� where ���־��̵� =?";
		mysql.psql(sql);
		mysql.setstring(1,id);
		rs = mysql.select2();
				
		String ownerid = rs.getString("���־��̵�");
		String ownerpw = rs.getString("�н�����");
		
		if (ownerid == id && ownerpw == pw) {
			
			App.logininfo.setIsLogin(true);
			App.logininfo.setId(id);
			App.logininfo.setType(2);
			
			return "�α��� �Ϸ�";
		}
		else {
			return "���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
		}
	}

	
}
