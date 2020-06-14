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
	
	/*업주회원가입 시 조건
	 * 1. 업주회원, 손님회원과 아이디가 일치하지 않아야 함
	 * 2. 상가업소번호가 중복되지 않아야 함
	 * 3. 등록 쏜다*/
	public UserOwnerDAO () {}
	
	/*회원가입*/
	public boolean registerO(String id, String pw, String name, int storeNumber) throws SQLException {
				
		boolean usableId = isUsableO(id);	//아이디 중복조회
		boolean usableStoreNum = isUsableNum(storeNumber);	//상가업소번호 중복조회
		
		if ((usableId && usableStoreNum) == true) {	//아이디가 중복이 아니고, 상가업소번호도 사용가능할때
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
				System.out.println("사용가능, 가입되었습니다. "+rs_cnt);
				return true;
			}
			else {
				System.out.println("가입 오류, 코드 재확인 요망");
				return false;
			}
		}	
		else {
			System.out.println("아이디 혹은 상가업소번호가 중복입니다."); 
			App.POPSTATE=4;
			return false;
			}	
	}
	
	/*아이디가 중복되지 않아 사용가능한가? ->리턴값이 true면 사용가능, false는 사용불가*/
	public boolean isUsableO(String id) throws SQLException {
		System.out.println("아이디 중복 확인");
		Mysql mysql = Mysql.getConnection();
		sql = "select * from 업주 where 업주아이디=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
		
		if(rs.isBeforeFirst()==true){	//우선 손님에서 검사 -> 손님에서 있으면 false 없으면 업주에서 검사 -> 업주에서 있으면 false 없으면 true
			return false;	//아이디 중복
		}
		else {	//
			sql = "select * from 회원 where 회원아이디 = ?";
			mysql.psql(sql);
			mysql.setstring(1, id);
			rs = mysql.select2();
			
			if (rs.isBeforeFirst()==true) return false;
			else return true;
		}
	}

	/* 가용한 storeNum인가? :업주는 업장 하나만 가질수있고, 업장은 업주 한명만 가질 수 있다 */
	public boolean isUsableNum(int storeNum) throws SQLException {
		System.out.println("업장 중복 확인");
		Mysql mysql = Mysql.getConnection();
		sql = "select * from 업주 where 상가업소번호=?";
		mysql.psql(sql);
		mysql.setint(1,storeNum);
		rs = mysql.select2();
		
		if (rs.isBeforeFirst()==true) return false;
		else return true;
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
	
	/*업주 성명*/
	public String selectownerName(String id) throws SQLException {
		Mysql mysql = Mysql.getConnection();
		sql = "select 성명 from 업주 where 업주아이디=?";
		mysql.psql(sql);
		mysql.setstring(1, id);
		rs = mysql.select2();
			
		String ownerName;
		if (rs.isBeforeFirst()==true) {
			rs.next();
			ownerName = rs.getString("성명");
			return ownerName;
		}
		else return "(찾지 못함)";
	}
}