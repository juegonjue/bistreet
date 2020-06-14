package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewDAO {

	private ResultSet rs;		//resultSet
	private String sql;
	private ArrayList<Review> list;
	private int rs_cnt;			//�ݿ��� ���ڵ尳��, -1 ���Ͻ� �����Ѱ���
	
	public ReviewDAO() {}
	
	/*��ȣ ���								�Ķ����							���ϰ�					���
	 * 1. �ش� �󰡾��ҹ�ȣ�� ���� ���� ��ȸ	 		storeNumber 					ArrayList<Review>		���� ȭ�鿡�� ��ȸ, ������ ���� �������� ����
	 * 2. �ش� �󰡾��ҹ�ȣ�� ���� �ش� ȸ���� ���� ���	(...)							void
	 * 3. �ش� �󰡾��ҹ�ȣ�� ���� �ش� ȸ���� ���� ����	storeNumber,user_id,reviewText	void
	 * 4. �ش� �󰡾��ҹ�ȣ�� ���� �ش� ȸ���� ���� ����	storeNumber,user_id				void*/
	
	/*1. �ش� �󰡾��ҹ�ȣ�� ���� ���� ��ȸ : ȸ�����̵�, ����, ����, �����ۼ��Ͻ�*/
	public ArrayList<Review> selectReview(int storeNumber) throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();
		sql = "select ȸ�����̵�, ����, ���䳻�� from ���� where �󰡾��ҹ�ȣ=?";
		mysql.psql(sql);
		mysql.setint(1,storeNumber);
		rs = mysql.select2();
		
		list = new ArrayList<Review>();
		
		while(rs.next()) {
			String userId = rs.getString("ȸ�����̵�");
			Integer reviewStar = rs.getInt("����");
			String reviewText = rs.getString("���䳻��");
			
			Review r = new Review(userId, reviewStar, reviewText);
			list.add(r);
		}
		return list;
	}
	
	/*2. �ش� �󰡾��ҹ�ȣ�� ���� ȸ���� ���� ���*/
	public int createReview(String userId, int storeNumber, String reviewText, int reviewStar,
			LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "insert into ����(ȸ�����̵�, �󰡾��ҹ�ȣ, ���䳻��, ����, �����ۼ��Ͻ�, ��������Ͻ�, ��������Ͻ�) values (?, ?, ?, ?,now(), null, null)";
		mysql.psql(sql);
		mysql.setstring(1, userId);
		mysql.setint(2, storeNumber);
		mysql.setstring(3, reviewText);
		mysql.setint(4, reviewStar);
		rs_cnt = mysql.update2();
		return rs_cnt;
	}
	
	/*�ش� ȸ���� �� ���� ��� : c_myinfo*/
	public ArrayList<Review> selectCustomerReview(String cid) throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();
		sql = "select �󰡾��ҹ�ȣ, ����, ���䳻�� from ����, ��ľ��� where ȸ�����̵�=? and ����.�󰡾��ҹ�ȣ = ��ľ���.�󰡾��ҹ�ȣ";
		mysql.psql(sql);
		mysql.setstring(1,cid);
		rs = mysql.select2();
		
		list = new ArrayList<Review>();
		
		while(rs.next()) {
			Integer storeNumber = rs.getInt("�󰡾��ҹ�ȣ");
			Integer reviewStar = rs.getInt("����");
			String reviewText = rs.getString("���䳻��");
			//String createDate = (String) rs.getObject("�����ۼ��Ͻ�");
			
			Review r = new Review(storeNumber, reviewStar, reviewText);
			list.add(r);
		}
		return list;
	}
}
