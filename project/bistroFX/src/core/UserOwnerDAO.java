package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import application.App;

public class UserOwnerDAO {

	private ResultSet rs;
	private String sql;
	ArrayList<UserOwner> list;
	UserOwner user;
	
	/*업주 회원가입 (insert만 있음)*/
	public UserOwnerDAO () {}
	
	public String registerO(String id, String pw, String name, int storeNumber) throws SQLException {
		
		boolean usableId = isUsableO(id);	//중복조회
		boolean usableStoreNum = isUsableNum(storeNumber);
		
		String message;
		if (usableId == true && usableStoreNum == true) {
			Mysql mysql = Mysql.getConnection();
			sql = "insert into 업주 values (?,?,?,now(), ?, (select 상호명 from 요식업소 where 상가업소번호=?))";
			mysql.psql(sql);
			mysql.setstring(1, id);
			mysql.setstring(2, pw);
			mysql.setstring(3, name);
			mysql.setint(4,storeNumber);
			mysql.setint(5,storeNumber);
			
			message = "사용가능, 가입되었습니다.";
		}	
		else message = "아이디 혹은 상가업소번호가 중복입니다.";
		
		return message;
	}
	
	/*아이디가 중복되지 않아 사용가능한가? -> true면 사용가능, false는 사용불가*/
	public boolean isUsableO(String id) throws SQLException {
		boolean rs_bool=false;
		Mysql mysql = Mysql.getConnection();
		sql = "select * from 업주 where 업주아이디=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
		
		rs.last();
		
		if(rs.getRow()==0) rs_bool = false;
		else rs_bool = true;
		
		return rs_bool;		
	}

	/*6. 가용한 storeNum인가? :업주 업장 하나만 가질수있다 */
	public boolean isUsableNum(int storeNum) throws SQLException {
		boolean rs_bool = false;
		Mysql mysql = Mysql.getConnection();
		sql = "select * from 업주 where 상가업소번호=?";
		mysql.setint(1,storeNum);
		rs = mysql.select2();
		
		rs.last();
		
		if (rs.getRow() == 0 ) rs_bool = false;
		else rs_bool = true;
	
		return rs_bool;
	}
}