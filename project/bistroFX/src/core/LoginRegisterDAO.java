package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.App;

public class LoginRegisterDAO {
	
	private ResultSet rs;
	private String sql;
	private ArrayList<UserCustomer> list;
	private int rs_cnt;
	
	public LoginRegisterDAO() {}
	
	
	/*로그인 (select)유효*/
	public boolean login(String id, String pw) throws SQLException {	//업주, 회원 둘다 로그인되게 해야함
		Mysql mysql = Mysql.getConnection();
		sql = "select 업주아이디, 패스워드 from 업주 where 업주아이디 =?";
		mysql.psql(sql);
		mysql.setstring(1,id);
		rs = mysql.select2();
		
		rs.next();
		String ownerid = rs.getString("업주아이디");
		String ownerpw = rs.getString("패스워드");
		
		if (ownerid.equals(id) && ownerpw.equals(pw)) {
			
			App.logininfo.setIsLogin(true);
			App.logininfo.setId(id);
			App.logininfo.setType(2);
			
			System.out.println("아이디와 비밀번호가 일치합니다.");
			return true;
		}
		
		else {
			System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
			System.out.println(ownerid+" " +id);
			System.out.println(ownerpw+ " " +pw);
			return false;
		}
	}

	
}
