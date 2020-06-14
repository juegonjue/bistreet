package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import application.App;

public class UserOwnerDAO {

	private ResultSet rs;	//�ݿ� resultset��ȯ
	private int rs_cnt;		//�ݿ����� ��ȯ
	private String sql;
	ArrayList<UserOwner> list;
	UserOwner user;
	
	/*���� ȸ������ (insert�� ����)*/
	
	/*����ȸ������ �� ����
	 * 1. ����ȸ��, �մ�ȸ���� ���̵� ��ġ���� �ʾƾ� ��
	 * 2. �󰡾��ҹ�ȣ�� �ߺ����� �ʾƾ� ��
	 * 3. ��� ���*/
	public UserOwnerDAO () {}
	
	/*ȸ������*/
	public boolean registerO(String id, String pw, String name, int storeNumber) throws SQLException {
				
		boolean usableId = isUsableO(id);	//���̵� �ߺ���ȸ
		boolean usableStoreNum = isUsableNum(storeNumber);	//�󰡾��ҹ�ȣ �ߺ���ȸ
		
		if ((usableId && usableStoreNum) == true) {	//���̵� �ߺ��� �ƴϰ�, �󰡾��ҹ�ȣ�� ��밡���Ҷ�
			Mysql mysql = Mysql.getConnection();
			sql = "insert into ���� values (?,?,?,now(), ?, (select ��ȣ�� from ��ľ��� where �󰡾��ҹ�ȣ=?))";
			mysql.psql(sql);
			mysql.setstring(1, id);
			mysql.setstring(2, pw);
			mysql.setstring(3, name);
			mysql.setint(4,storeNumber);
			mysql.setint(5,storeNumber);
			rs_cnt = mysql.update2();
			
			System.out.println(rs_cnt);
			
			if (rs_cnt>0) {
				System.out.println("��밡��, ���ԵǾ����ϴ�. "+rs_cnt);
				return true;
			}
			else {
				System.out.println("���� ����, �ڵ� ��Ȯ�� ���");
				return false;
			}
		}	
		else {
			System.out.println("���̵� Ȥ�� �󰡾��ҹ�ȣ�� �ߺ��Դϴ�."); 
			App.POPSTATE=4;
			return false;
			}	
	}
	
	/*���̵� �ߺ����� �ʾ� ��밡���Ѱ�? ->���ϰ��� true�� ��밡��, false�� ���Ұ�*/
	public boolean isUsableO(String id) throws SQLException {
		System.out.println("���̵� �ߺ� Ȯ��");
		Mysql mysql = Mysql.getConnection();
		sql = "select * from ���� where ���־��̵�=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
		
		if(rs.isBeforeFirst()==true){	//�켱 �մԿ��� �˻� -> �մԿ��� ������ false ������ ���ֿ��� �˻� -> ���ֿ��� ������ false ������ true
			return false;	//���̵� �ߺ�
		}
		else {	//
			sql = "select * from ȸ�� where ȸ�����̵� = ?";
			mysql.psql(sql);
			mysql.setstring(1, id);
			rs = mysql.select2();
			
			if (rs.isBeforeFirst()==true) return false;
			else return true;
		}
	}

	/* ������ storeNum�ΰ�? :���ִ� ���� �ϳ��� �������ְ�, ������ ���� �Ѹ� ���� �� �ִ� */
	public boolean isUsableNum(int storeNum) throws SQLException {
		System.out.println("���� �ߺ� Ȯ��");
		Mysql mysql = Mysql.getConnection();
		sql = "select * from ���� where �󰡾��ҹ�ȣ=?";
		mysql.psql(sql);
		mysql.setint(1,storeNum);
		rs = mysql.select2();
		
		if (rs.isBeforeFirst()==true) return false;
		else return true;
	}
	
	/*���� �����*/
	public String selectStoreName(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select ��ȣ�� from ���� where ���־��̵�=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		String storeName;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			storeName = rs.getString("��ȣ��");
			return storeName;
		}
		else return "(ã�� ����)";
	}
	
	
	/*���� �󰡾��ҹ�ȣ*/
	public int selectStoreNumber(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select �󰡾��ҹ�ȣ from ���� where ���־��̵�=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		Integer storeNumber;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			storeNumber = rs.getInt("�󰡾��ҹ�ȣ");
			return storeNumber;
		}
		else return -1;
	}
	
	
	/*���־��̵� -> �󰡾��ҹ�ȣ -> ���θ��ּ�*/
	public String selectStoreAddress(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select ���θ��ּ� from ��ľ���, ���� where ���־��̵�=? and ��ľ���.�󰡾��ҹ�ȣ = ����.�󰡾��ҹ�ȣ";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		String storeAddress;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			storeAddress = rs.getString("���θ��ּ�");
			return storeAddress;
		}
		else return "(ã�� ����)";
	}
	
	/*���� ����*/
	public String selectownerName(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select ���� from ���� where ���־��̵�=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		String ownerName;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			ownerName = rs.getString("����");
			return ownerName;
		}
		else return "(ã�� ����)";
	}
}