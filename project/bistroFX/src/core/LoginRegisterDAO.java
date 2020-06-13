package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.LoginInfo;
import application.App;

public class LoginRegisterDAO {
	
	private ResultSet rs;
	private String sql;
	private ArrayList<UserCustomer> list;
	private int rs_cnt;
	
	public LoginRegisterDAO() {}
	
	
	/*로그인 (select)유효*/
	public String login(String id, String pw) throws SQLException {
		
		Mysql mysql = Mysql.getConnection();
		sql = "select 업주아이디, 패스워드 from 업주 where 업주아이디 =?";
		mysql.psql(sql);
		mysql.setstring(1,id);
		rs = mysql.select2();
				
		String ownerid = rs.getString("업주아이디");
		String ownerpw = rs.getString("패스워드");
		
		if (ownerid == id && ownerpw == pw) {
			
			App.logininfo.setIsLogin(true);
			App.logininfo.setId(id);
			App.logininfo.setType(2);
			
			return "로그인 완료";
		}
		else {
			return "아이디 혹은 비밀번호가 일치하지 않습니다.";
		}
	}

	
}
