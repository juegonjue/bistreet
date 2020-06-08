package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.App;

public class MenuPriceDAO {
	
	private ResultSet rs;
	private String sql;
	private ArrayList<MenuPrice> list;
	public MenuPriceDAO() {}
	String ownerid = App.logstate.getId();	//오너의 아이디 가져온다
	
	
	public ArrayList<MenuPrice> selectAllMenuPrice() throws SQLException {
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "select 메뉴1,가격1,메뉴2,가격2,메뉴3,가격3 from 메뉴및가격,요식업소 where 메뉴및가격.상가업소번호=요식업소.상가업소번호;";
		mysql.sql(sql);
		rs = mysql.select();
		
		list = new ArrayList<MenuPrice>();
		while(rs.next()) {
			String menu1 = rs.getString("메뉴1");
			Integer price1 = rs.getInt("가격1");
			String menu2 = rs.getString("메뉴2");
			Integer price2 = rs.getInt("가격2");
			String menu3 = rs.getString("메뉴3");
			Integer price3 = rs.getInt("가격3");
			MenuPrice m = new MenuPrice(menu1, price1, menu2, price2, menu3, price3);
			list.add(m);
		}
		return list;
	}
	
	/*메뉴 및 가격 목록 수정*/
	public int updateMenuPrice() throws SQLException {
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "update ~~";	//여기 쿼리 수정
		mysql.sql(sql);
		return mysql.update();	//수정된 레코드 개수 반환
	}
	
	
	/*메뉴 및 가격 목록 삭제*/
	public int deleteMenuPrice() throws SQLException {
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "delete ~~";	//여기 쿼리 수정
		mysql.sql(sql);
		return mysql.delete();	//삭제된 레코드 개수 반환
	}
}
