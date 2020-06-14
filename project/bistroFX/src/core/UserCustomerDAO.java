package core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCustomerDAO {

	private ResultSet rs;
	private String sql;
	private int rs_cnt;
	
	public UserCustomerDAO() {}
	
	/* �մ�ȸ������ --> ���ԵǾ�����, �ߺ��Ǿ����� �˷���*/
	public boolean registerC(String id, String pw, String name) throws SQLException {
		
		boolean usable = isUsableC(id);	//�ߺ���ȸ
		
		if (usable == true) {
			Mysql mysql = Mysql.getConnection();
			sql = "insert into ȸ�� values (?,?,?,now())";
			mysql.psql(sql);
			mysql.setstring(1, id);
			mysql.setstring(2, pw);
			mysql.setstring(3, name);
			rs_cnt = mysql.update2();
			
			if (rs_cnt > 0) {
				System.out.println("��밡��, ���ԵǾ����ϴ�. "+rs_cnt);
				return true;
			}
			else {
				System.out.println("���̵� �ߺ��Դϴ�.");
				return false;
			}
		}	
		else return false;

	}
	
	/* ���̵� �ߺ����� �ʾ� ��밡���Ѱ�? -> true�� ��밡��, false�� ���Ұ�*/
	public boolean isUsableC(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select * from ȸ�� where ȸ�����̵�=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();

		if(rs.isBeforeFirst()==true){	//�켱 �մԿ��� �˻� -> �մԿ��� ������ false ������ ���ֿ��� �˻� -> ���ֿ��� ������ false ������ true
			return false;	//���̵� �ߺ�
		}
		else {	//
			sql = "select * from ���� where ���־��̵� = ?";
			mysql.psql(sql);
			mysql.setstring(1, id);
			rs = mysql.select2();
			
			if (rs.isBeforeFirst()==true) return false;
			else return true;
		}
	
	}
	
	/*�մ� ����*/
	public String selectCustomerName(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select ���� from ȸ�� where ȸ�����̵�=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		String customername;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			customername = rs.getString("����");
			return customername;
		}
		else return "(ã�� ����)";
	}
}
