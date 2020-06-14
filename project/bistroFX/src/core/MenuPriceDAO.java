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
	String ownerid = App.logininfo.getId();	//오너의 아이디 가져온다
	
	/*오너아이디->상가업소번호->메뉴및가격*/
	public MenuPrice selectMenuPrice(String id) throws SQLException {
		rs = null;
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "select 메뉴1, 가격1, 메뉴2, 가격2, 메뉴3, 가격3 from 메뉴및가격, 업주 where 업주아이디 =? and 업주.상가업소번호 = 메뉴및가격.상가업소번호";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
		
		MenuPrice menuprice = null;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			String menu1 = rs.getString("메뉴1");
			Integer price1 = rs.getInt("가격1");
			String menu2 = rs.getString("메뉴2");
			Integer price2 = rs.getInt("가격2");
			String menu3 = rs.getString("메뉴3");
			Integer price3 = rs.getInt("가격3");
			menuprice = new MenuPrice(menu1, price1, menu2, price2, menu3, price3);
		}
		return menuprice;
	}
	
	/*메뉴 및 가격 목록 등록 및 수정, 삭제는 안함*/
	public int updateMenuPrice(int storenum, String menu1, int price1, String menu2, int price2, String menu3, int price3) throws SQLException {
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "update 메뉴및가격 set 메뉴1=?, 가격1=?, 메뉴2=?, 가격2=?, 메뉴3=?, 가격3=? where 상가업소번호 = ?";	//여기 쿼리 수정
		mysql.psql(sql);
		mysql.setstring(1, menu1);
		mysql.setint(2,price1);
		mysql.setstring(3, menu2);
		mysql.setint(4,price2);		
		mysql.setstring(5, menu3);
		mysql.setint(6,price3);
		mysql.setint(7, storenum);
		return mysql.update2();	//수정된 레코드 개수 반환
	}

}
