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
	String ownerid = App.logstate.getId();	//오너의 아이디 가져온다
	public UserOwnerDAO () {}
	
	/*업주정보화면 내용 중 아이디, 성명, 업소번호, 상호명*/
	public UserOwner selectUserOwner() throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//호출	
	
		sql = "select * from 업주 where 아이디="+ownerid;
		mysql.sql(sql);
		rs = mysql.select();
		
		while(rs.next())
		{
			String id = rs.getString("업주아이디");
			String name = rs.getString("성명");
			Integer storeNum = rs.getInt("상가업소번호");
			String storeName = rs.getString("상호명");
			
			user = new UserOwner(id, name, storeNum, storeName);
		}
		return user;
	}
	
	/*업주정보화면 내용 중 메뉴 및 가격*/
	
	
	/*업주정보화면 내용 중 도로명주소*/
}