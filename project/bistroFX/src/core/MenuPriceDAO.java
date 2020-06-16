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
	
	/*메뉴 및 가격 목록 수정, 삭제는 안함*/
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

	/*해당 상가업소번호는 '메뉴'를 가지고 있는가?*/
	public boolean hasMenu(int storeNumber) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select * from 메뉴및가격 where 상가업소번호=?";
		mysql.psql(sql);
		mysql.setint(1, storeNumber);
		rs = mysql.select2();
		
		if (rs.isBeforeFirst()==true) return true;	//가지고있으면 true반환
		else return false;		//정보가 없으면 false반환 
	}
	
	/*메뉴 및 가격 등록 -- 무조건 메뉴 다 써야함. */
	public int createMenuPrice(int storenum) throws SQLException {
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "insert into 메뉴및가격(상가업소번호, 메뉴1, 가격1, 메뉴2, 가격2, 메뉴3, 가격3) values (?,null,null,null,null,null,null)";	//여기 쿼리 수정
		mysql.psql(sql);
		mysql.setint(1, storenum);

		return mysql.update2();	//수정된 레코드 개수 반환
	}
	//메뉴가 있으면 조회
	public MenuPrice searchM(int storeNumber) throws SQLException
	{
		
		rs = null;
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "select 메뉴1, 가격1, 메뉴2, 가격2, 메뉴3, 가격3 from 메뉴및가격 where 상가업소번호 ="+storeNumber;
		MenuPrice menuprice = null;
		if(hasMenu(storeNumber))
		{
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
			
		}else
		{
			if (rs.isBeforeFirst()!=true) {
				rs.next();
				String menu1 = "메뉴가                           ";
				Integer price1 = 0;
				String menu2 = "비어있습니다                    ";
				Integer price2 = 0;
				String menu3 = "업주님이 메뉴를 추가해주세요";
				Integer price3 = 0;
				menuprice = new MenuPrice(menu1, price1, menu2, price2, menu3, price3);
			}
			return menuprice;
		}
		
		
		
		
	}
}
