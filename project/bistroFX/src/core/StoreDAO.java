package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreDAO {

	private ResultSet rs;
	private String sql;
	private ArrayList<Store> list;

	public StoreDAO() {}

	/*��ľ���_�Ļ���ȸ(��ü)*/ 
	public ArrayList<Store> selectAllMeal() throws SQLException {
		
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "select * from ��ľ��� where ��Ǿ����ߺз��ڵ� IN ('q01','q02','q03','q04','q05','q06','q07','q10','q13','q14')";
		mysql.sql(sql);
		rs = mysql.select();
		
		list = new ArrayList<Store>();
		while(rs.next()) {
			Integer storeNumber = rs.getInt("�󰡾��ҹ�ȣ");
			String storeName = rs.getString("��ȣ��");
			String storeLocation = rs.getString("������");
			String codeMedium = rs.getString("��Ǿ����ߺз��ڵ�");
			String codeSmall = rs.getString("��Ǿ����Һз��ڵ�");
			String storeAddress = rs.getString("���θ��ּ�");
			double kDegree = rs.getDouble("�浵");
			double wDegree = rs.getDouble("����");
			Store s = new Store(storeNumber,storeName,storeLocation,codeMedium,codeSmall,storeAddress,kDegree,wDegree);
			list.add(s);
		}		
		return list;
	}
	
	
	/*��ľ���_����Ʈ��ȸ(��ü) -> ��ü �ҷ��ͼ� �ѷ��ٶ� ����ϰ� , ���Ŀ� ui ��Ȳ ���� �䱸�ϴ°� �Ϻθ� ������� �����ϱ�. �ƴϸ� ������ ���� �ɸ�*/
	public ArrayList<Store> selectAllDessert() throws SQLException {
		
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "select * from ��ľ��� where ��Ǿ����ߺз��ڵ� IN ('q08','q12')";
		mysql.sql(sql);
		rs = mysql.select();	

		list = new ArrayList<Store>();
		while(rs.next()) {
			Integer storeNumber = rs.getInt("�󰡾��ҹ�ȣ");
			String storeName = rs.getString("��ȣ��");
			String storeLocation = rs.getString("������");
			String codeMedium = rs.getString("��Ǿ����ߺз��ڵ�");
			String codeSmall = rs.getString("��Ǿ����Һз��ڵ�");
			String storeAddress = rs.getString("���θ��ּ�");
			double kDegree = rs.getDouble("�浵");
			double wDegree = rs.getDouble("����");
			Store s = new Store(storeNumber,storeName,storeLocation,codeMedium,codeSmall,storeAddress,kDegree,wDegree);
			list.add(s);
		}
		return list;
	}
	
	
	/*��ľ���_������ȸ(��ü)*/ 
	public ArrayList<Store> selectAllBeer() throws SQLException {
		
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql = "select * from ��ľ��� where ��Ǿ����ߺз��ڵ�='q09'";
		mysql.sql(sql);
		rs = mysql.select();
		
		list = new ArrayList<Store>();
		while(rs.next()) {
			Integer storeNumber = rs.getInt("�󰡾��ҹ�ȣ");
			String storeName = rs.getString("��ȣ��");
			String storeLocation = rs.getString("������");
			String codeMedium = rs.getString("��Ǿ����ߺз��ڵ�");
			String codeSmall = rs.getString("��Ǿ����Һз��ڵ�");
			String storeAddress = rs.getString("���θ��ּ�");
			double kDegree = rs.getDouble("�浵");
			double wDegree = rs.getDouble("����");
			Store s = new Store(storeNumber,storeName,storeLocation,codeMedium,codeSmall,storeAddress,kDegree,wDegree);
			list.add(s);
		}
		return list;
	}
	
	 
}
