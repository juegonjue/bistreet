package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreDAO {

	private ResultSet rs;
	private String sql;
	private ArrayList<Store> list;

	public StoreDAO() {}

	/*요식업소_식사조회(전체)*/ 
	public ArrayList<Store> selectAllMeal() throws SQLException {
		
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "select * from 요식업소 where 상권업종중분류코드 IN ('q01','q02','q03','q04','q05','q06','q07','q10','q13','q14')";
		mysql.sql(sql);
		rs = mysql.select();
		
		list = new ArrayList<Store>();
		while(rs.next()) {
			Integer storeNumber = rs.getInt("상가업소번호");
			String storeName = rs.getString("상호명");
			String storeLocation = rs.getString("지점명");
			String codeMedium = rs.getString("상권업종중분류코드");
			String codeSmall = rs.getString("상권업종소분류코드");
			String storeAddress = rs.getString("도로명주소");
			double kDegree = rs.getDouble("경도");
			double wDegree = rs.getDouble("위도");
			Store s = new Store(storeNumber,storeName,storeLocation,codeMedium,codeSmall,storeAddress,kDegree,wDegree);
			list.add(s);
		}		
		return list;
	}
	
	
	/*요식업소_디저트조회(전체) -> 전체 불러와서 뿌려줄때 깔끔하게 , 이후에 ui 상황 보고 요구하는것 일부만 들고오기로 수정하기. 아니면 과부하 씨게 걸림*/
	public ArrayList<Store> selectAllDessert() throws SQLException {
		
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "select * from 요식업소 where 상권업종중분류코드 IN ('q08','q12')";
		mysql.sql(sql);
		rs = mysql.select();	

		list = new ArrayList<Store>();
		while(rs.next()) {
			Integer storeNumber = rs.getInt("상가업소번호");
			String storeName = rs.getString("상호명");
			String storeLocation = rs.getString("지점명");
			String codeMedium = rs.getString("상권업종중분류코드");
			String codeSmall = rs.getString("상권업종소분류코드");
			String storeAddress = rs.getString("도로명주소");
			double kDegree = rs.getDouble("경도");
			double wDegree = rs.getDouble("위도");
			Store s = new Store(storeNumber,storeName,storeLocation,codeMedium,codeSmall,storeAddress,kDegree,wDegree);
			list.add(s);
		}
		return list;
	}
	
	
	/*요식업소_주점조회(전체)*/ 
	public ArrayList<Store> selectAllBeer() throws SQLException {
		
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//호출	
		sql = "select * from 요식업소 where 상권업종중분류코드='q09'";
		mysql.sql(sql);
		rs = mysql.select();
		
		list = new ArrayList<Store>();
		while(rs.next()) {
			Integer storeNumber = rs.getInt("상가업소번호");
			String storeName = rs.getString("상호명");
			String storeLocation = rs.getString("지점명");
			String codeMedium = rs.getString("상권업종중분류코드");
			String codeSmall = rs.getString("상권업종소분류코드");
			String storeAddress = rs.getString("도로명주소");
			double kDegree = rs.getDouble("경도");
			double wDegree = rs.getDouble("위도");
			Store s = new Store(storeNumber,storeName,storeLocation,codeMedium,codeSmall,storeAddress,kDegree,wDegree);
			list.add(s);
		}
		return list;
	}
	
	
	//위도경도로 조회하기
	public ArrayList<Store> whereAllmeal(double x, double y) throws SQLException
	{
		
		double xa =x-0.1;
		double xb =x+0.1;
		double ya = y-0.1;
		double yb = y+0.1;
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//호출	
		sql ="select 도로명주소,상가업소번호,상호명,경도,위도 from 요식업소 where 경도 between "+xa+" and "+
				xb+" and "+" 위도 between "+
				ya+" and "+yb;
		mysql.sql(sql);
		rs = mysql.select();	

		list = new ArrayList<Store>();
		while(rs.next()) {
			String storeAddress = rs.getString("도로명주소");
			String storeName = rs.getString("상호명");
			Integer storeNumber =rs.getInt("상가업소번호");
			double kDegree = rs.getDouble("경도");
			double wDegree = rs.getDouble("위도");
			//xy는 내 위치
			double disx = kDegree;
			double disy = wDegree;
			double theta = y - disy;
			double dist = Math.sin(Math.toRadians(x)) * Math.sin(Math.toRadians(disx))
					+ Math.cos(Math.toRadians(x)) * Math.cos(Math.toRadians(disx))
					* Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			dist = dist*1.609344;
			Store s = new Store(storeName,kDegree,wDegree,dist,storeAddress,storeNumber);
	
			list.add(s);
			
			
		}
		return list;
	}
	
	
	 
}


