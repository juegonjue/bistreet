package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyReviewDAO {

	private ResultSet rs;		//resultSet
	private String sql;
	private ArrayList<MyReview> list;
	
	public MyReviewDAO() {}
	
	/*ȸ���� ���� �� ���� ��������� ���*/
	public ArrayList<MyReview> selectCustomerReview(String cid) throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();
		sql = "select ��ȣ��, ����, ���䳻��, �����ۼ��Ͻ� from ����, ��ľ��� where ȸ�����̵�=? and ����.�󰡾��ҹ�ȣ = ��ľ���.�󰡾��ҹ�ȣ";
		mysql.psql(sql);
		mysql.setstring(1,cid);
		rs = mysql.select2();
		
		list = new ArrayList<MyReview>();
		
		while(rs.next()) {
			String storeName = rs.getString("��ȣ��");
			Integer reviewStar = rs.getInt("����");
			String reviewText = rs.getString("���䳻��");
			String createDate = rs.getString("�����ۼ��Ͻ�");
			
			MyReview mr = new MyReview(storeName, reviewStar, reviewText,createDate);
			list.add(mr);
		}
		return list;
	}
}
