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
	
	
	//�����浵�� ��ȸ�ϱ�
	public ArrayList<Store> whereAllmeal(double x, double y) throws SQLException
	{
		
		double xa =x-0.1;
		double xb =x+0.1;
		double ya = y-0.1;
		double yb = y+0.1;
		rs = null; list = null;
		Mysql mysql = Mysql.getConnection();	//ȣ��	
		sql ="select ���θ��ּ�,�󰡾��ҹ�ȣ,��ȣ��,�浵,���� from ��ľ��� where �浵 between "+xa+" and "+
				xb+" and "+" ���� between "+
				ya+" and "+yb;
		mysql.sql(sql);
		rs = mysql.select();	

		list = new ArrayList<Store>();
		while(rs.next()) {
			String storeAddress = rs.getString("���θ��ּ�");
			String storeName = rs.getString("��ȣ��");
			Integer storeNumber =rs.getInt("�󰡾��ҹ�ȣ");
			double kDegree = rs.getDouble("�浵");
			double wDegree = rs.getDouble("����");
			//xy�� �� ��ġ
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


