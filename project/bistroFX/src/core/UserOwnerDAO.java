package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import application.App;

public class UserOwnerDAO {

	private ResultSet rs;	//반영 resultset반환
	private int rs_cnt;		//반영갯수 반환
	private String sql;
	ArrayList<UserOwner> list;
	UserOwner user;
	
	/*업주 회원가입 (insert만 있음)*/
	public UserOwnerDAO () {}
	
	public boolean registerO(String id, String pw, String name, int storeNumber) throws SQLException {
				
		boolean usableId = isUsableO(id);	//중복조회
		boolean usableStoreNum = isUsableNum(storeNumber);
		
		if (usableId == true && usableStoreNum == true) {
			Mysql mysql = Mysql.getConnection();
			sql = "insert into 업주 values (?,?,?,now(), ?, (select 상호명 from 요식업소 where 상가업소번호=?))";
			mysql.psql(sql);
			mysql.setstring(1, id);
			mysql.setstring(2, pw);
			mysql.setstring(3, name);
			mysql.setint(4,storeNumber);
			mysql.setint(5,storeNumber);
			rs_cnt = mysql.update2();
			
			System.out.println(rs_cnt);
			
			if (rs_cnt>0) {
				System.out.println("사용가능, 가입되었습니다.");
				return true;
			}
			else {
				System.out.println("가입 오류, 코드 재확인 요망");
				return false;
			}
		}	
		else {
			System.out.println("아이디 혹은 상가업소번호가 중복입니다."); 
			return false;
			}	
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
		//boolean rs_bool = false;
		Mysql mysql = Mysql.getConnection();
		sql = "select * from 업주 where 상가업소번호=?";
		mysql.psql(sql);
		mysql.setint(1,storeNum);
		rs = mysql.select2();
		
		rs.last();
		
		if (rs.getRow() > 0 ) return false;	//업장을 가진 업주가 이미 존재 --> 불가
		else if (rs.getRow() == -1) {
			System.out.println("찾지 못함");
			return false;
		}
		else return true;					//업장을 가진 업주가 없음 --> 가용

	}
	
	/*업주 업장명*/
	public String selectStoreName(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select 상호명 from 업주 where 업주아이디=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		String storeName;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			storeName = rs.getString("상호명");
			return storeName;
		}
		else return "(찾지 못함)";
	}
	
	
	/*업주 상가업소번호*/
	public int selectStoreNumber(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select 상가업소번호 from 업주 where 업주아이디=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		Integer storeNumber;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			storeNumber = rs.getInt("상가업소번호");
			return storeNumber;
		}
		else return -1;
	}
	
	
	/*업주아이디 -> 상가업소번호 -> 도로명주소*/
	public String selectStoreAddress(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select 도로명주소 from 요식업소, 업주 where 업주아이디=? and 요식업소.상가업소번호 = 업주.상가업소번호";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		String storeAddress;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			storeAddress = rs.getString("도로명주소");
			return storeAddress;
		}
		else return "(찾지 못함)";
	}
}