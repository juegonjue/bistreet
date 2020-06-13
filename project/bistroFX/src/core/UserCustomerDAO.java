package core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCustomerDAO {

	private ResultSet rs;
	private String sql;

	public UserCustomerDAO() {}
	
	/*1. 손님회원가입 --> 가입되었는지, 중복되었는지 알려줌*/
	public String registerC(String id, String pw, String name) throws SQLException {
		
		boolean usable = isUsableC(id);	//중복조회
		
		String message;
		if (usable == true) {
			Mysql mysql = Mysql.getConnection();
			sql = "insert into 회원 values (?,?,?,now())";
			mysql.psql(sql);
			mysql.setstring(1, id);
			mysql.setstring(2, pw);
			mysql.setstring(3, name);
			
			message = "사용가능, 가입되었습니다.";
		}	
		else message = "아이디가 중복입니다.";
		
		return message;
	}
	
	/*4. 아이디가 중복되지 않아 사용가능한가? -> true면 사용가능, false는 사용불가*/
	public boolean isUsableC(String id) throws SQLException {
		boolean rs_bool=false;
		Mysql mysql = Mysql.getConnection();
		sql = "select * from 회원 where 회원아이디=?";
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
