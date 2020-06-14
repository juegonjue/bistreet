package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InterestDAO {
	
	private ResultSet rs;		//resultSet
	private String sql;
	private ArrayList<Store> list;
	private int rs_cnt;			//반영된 레코드개수, -1 리턴시 실패한것임
	
	public InterestDAO() {}
	
	/*해당 회원이 찜한 목록들 가지고옴*/
	public ArrayList<Store> selectInterest(String id) throws SQLException{
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();
		sql = "select 상호명, 도로명주소 from 요식업소, 관심목록 where 관심목록.상가업소번호 = 요식업소.상가업소번호 and 관심목록.회원아이디=? and 관심목록.관심여부=1";
		mysql.psql(sql);
		mysql.setstring(1,id);
		rs = mysql.select2();
		
		list = new ArrayList<Store>();
		if (rs.isBeforeFirst()==true) {
			while(rs.next()) {
				String storename = rs.getString("상호명");
				String storeaddress = rs.getString("도로명주소");
				
				Store s = new Store(storename, storeaddress);
				list.add(s);
			}
		}
		return list;
	}
}
