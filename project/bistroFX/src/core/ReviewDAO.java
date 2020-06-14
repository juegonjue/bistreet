package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewDAO {

	private ResultSet rs;		//resultSet
	private String sql;
	private ArrayList<Review> list;
	private int rs_cnt;			//반영된 레코드개수, -1 리턴시 실패한것임
	
	public ReviewDAO() {}
	
	/*번호 기능								파라미터							리턴값					비고
	 * 1. 해당 상가업소번호에 대한 리뷰 조회	 		storeNumber 					ArrayList<Review>		업주 화면에서 조회, 삭제된 것은 보여주지 않음
	 * 2. 해당 상가업소번호에 대한 해당 회원의 리뷰 등록	(...)							void
	 * 3. 해당 상가업소번호에 대한 해당 회원의 리뷰 수정	storeNumber,user_id,reviewText	void
	 * 4. 해당 상가업소번호에 대한 해당 회원의 리뷰 삭제	storeNumber,user_id				void*/
	
	/*1. 해당 상가업소번호에 대한 리뷰 조회 : 회원아이디, 별점, 내용, 리뷰작성일시*/
	public ArrayList<Review> selectReview(int storeNumber) throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();
		sql = "select 회원아이디, 별점, 리뷰내용 from 리뷰 where 상가업소번호=?";
		mysql.psql(sql);
		mysql.setint(1,storeNumber);
		rs = mysql.select2();
		
		list = new ArrayList<Review>();
		
		while(rs.next()) {
			String userId = rs.getString("회원아이디");
			Integer reviewStar = rs.getInt("별점");
			String reviewText = rs.getString("리뷰내용");
			
			Review r = new Review(userId, reviewStar, reviewText);
			list.add(r);
		}
		return list;
	}
	
	/*2. 해당 상가업소번호에 대한 회원의 리뷰 등록*/
	public int createReview(String userId, int storeNumber, String reviewText, int reviewStar,
			LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "insert into 리뷰(회원아이디, 상가업소번호, 리뷰내용, 별점, 리뷰작성일시, 리뷰수정일시, 리뷰삭제일시) values (?, ?, ?, ?,now(), null, null)";
		mysql.psql(sql);
		mysql.setstring(1, userId);
		mysql.setint(2, storeNumber);
		mysql.setstring(3, reviewText);
		mysql.setint(4, reviewStar);
		rs_cnt = mysql.update2();
		return rs_cnt;
	}
	
	/*해당 회원이 쓴 리뷰 목록 : c_myinfo*/
	public ArrayList<Review> selectCustomerReview(String cid) throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();
		sql = "select 상가업소번호, 별점, 리뷰내용 from 리뷰, 요식업소 where 회원아이디=? and 리뷰.상가업소번호 = 요식업소.상가업소번호";
		mysql.psql(sql);
		mysql.setstring(1,cid);
		rs = mysql.select2();
		
		list = new ArrayList<Review>();
		
		while(rs.next()) {
			Integer storeNumber = rs.getInt("상가업소번호");
			Integer reviewStar = rs.getInt("별점");
			String reviewText = rs.getString("리뷰내용");
			//String createDate = (String) rs.getObject("리뷰작성일시");
			
			Review r = new Review(storeNumber, reviewStar, reviewText);
			list.add(r);
		}
		return list;
	}
}
