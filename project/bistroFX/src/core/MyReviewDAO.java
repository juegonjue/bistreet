package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyReviewDAO {

	private ResultSet rs;		//resultSet
	private String sql;
	private ArrayList<MyReview> list;
	
	public MyReviewDAO() {}
	
	/*회원이 내가 쓴 리뷰 가지고오는 기능*/
	public ArrayList<MyReview> selectCustomerReview(String cid) throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();
		sql = "select 상호명, 별점, 리뷰내용, 리뷰작성일시 from 리뷰, 요식업소 where 회원아이디=? and 리뷰.상가업소번호 = 요식업소.상가업소번호";
		mysql.psql(sql);
		mysql.setstring(1,cid);
		rs = mysql.select2();
		
		list = new ArrayList<MyReview>();
		
		while(rs.next()) {
			String storeName = rs.getString("상호명");
			Integer reviewStar = rs.getInt("별점");
			String reviewText = rs.getString("리뷰내용");
			String createDate = rs.getString("리뷰작성일시");
			
			MyReview mr = new MyReview(storeName, reviewStar, reviewText,createDate);
			list.add(mr);
		}
		return list;
	}
}
