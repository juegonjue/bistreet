package core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCustomerDAO {

	private ResultSet rs;
	private String sql;
	private int rs_cnt;
	
	public UserCustomerDAO() {}
	
	/* 손님회원가입 --> 가입되었는지, 중복되었는지 알려줌*/
	public boolean registerC(String id, String pw, String name) throws SQLException {
		
		boolean usable = isUsableC(id);	//중복조회
		
		if (usable == true) {
			Mysql mysql = Mysql.getConnection();
			sql = "insert into 회원 values (?,?,?,now())";
			mysql.psql(sql);
			mysql.setstring(1, id);
			mysql.setstring(2, pw);
			mysql.setstring(3, name);
			rs_cnt = mysql.update2();
			
			if (rs_cnt > 0) {
				System.out.println("사용가능, 가입되었습니다. "+rs_cnt);
				return true;
			}
			else {
				System.out.println("아이디가 중복입니다.");
				return false;
			}
		}	
		else return false;

	}
	
	/* 아이디가 중복되지 않아 사용가능한가? -> true면 사용가능, false는 사용불가*/
	public boolean isUsableC(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select * from 회원 where 회원아이디=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();

		if(rs.isBeforeFirst()==true){	//우선 손님에서 검사 -> 손님에서 있으면 false 없으면 업주에서 검사 -> 업주에서 있으면 false 없으면 true
			return false;	//아이디 중복
		}
		else {	//
			sql = "select * from 업주 where 업주아이디 = ?";
			mysql.psql(sql);
			mysql.setstring(1, id);
			rs = mysql.select2();
			
			if (rs.isBeforeFirst()==true) return false;
			else return true;
		}
	
	}
	
	/*손님 성명*/
	public String selectCustomerName(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select 성명 from 회원 where 회원아이디=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		String customername;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			customername = rs.getString("성명");
			return customername;
		}
		else return "(찾지 못함)";
	}
}
