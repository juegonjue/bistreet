package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.App;

public class LoginRegisterDAO {
	
	private ResultSet rs;
	private String sql;
	private ArrayList<UserCustomer> list;
	private int rs_cnt;
	
	public LoginRegisterDAO() {}
	
	
	/*�α��� (select)��ȿ*/
	public boolean login(String id, String pw) throws SQLException {	//����, ȸ�� �Ѵ� �α��εǰ� �ؾ���
		Mysql mysql = Mysql.getConnection();
		sql = "select ���־��̵�, �н����� from ���� where ���־��̵� =?";
		mysql.psql(sql);
		mysql.setstring(1,id);
		rs = mysql.select2();
		
		rs.next();
		String ownerid = rs.getString("���־��̵�");
		String ownerpw = rs.getString("�н�����");
		
		if (ownerid.equals(id) && ownerpw.equals(pw)) {
			
			App.logininfo.setIsLogin(true);
			App.logininfo.setId(id);
			App.logininfo.setType(2);
			
			System.out.println("���̵�� ��й�ȣ�� ��ġ�մϴ�.");
			return true;
		}
		
		else {
			System.out.println("���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			System.out.println(ownerid+" " +id);
			System.out.println(ownerpw+ " " +pw);
			return false;
		}
	}

	
}
