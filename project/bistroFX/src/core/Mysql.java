package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://172.30.1.20:3306/bistreet";
	private final String ID = "root";
	private final String PW = "9390";
	
	private static Mysql obj = null;
	private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private String sql = null;
    
	public Mysql() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println(">>");
			conn = DriverManager.getConnection(DB_URL, ID, PW);
			System.out.print("DB���� ");
			if (conn!=null) System.out.println("����");
			else System.out.println("����");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Mysql.getConnection() -> DB����
	public static Mysql getConnection() throws SQLException {
		if (Mysql.obj == null)
			Mysql.obj = new Mysql();
		System.out.println("getConnection : success");
		return Mysql.obj;
	}

	//.sql("sql�� �Է�")
	public void sql(String sql) throws SQLException {
		this.sql = sql;
		System.out.println("sql : success");
	}
	
	public ResultSet select() throws SQLException {
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		System.out.println("resultSet : success (����� ���� �� ���� �� �ݺ��� �� �ֽ��ϴ�)");
		return rs;
	}
	
	//����, ��ȯ���� �ݿ��� ���ڵ��
	public int insert() throws SQLException {
		return st.executeUpdate(sql);
	}
	
	//����, ��ȯ���� �ݿ��� ���ڵ��
	public int update() throws SQLException {
		return st.executeUpdate(sql);
	}

	//����, ��ȯ���� �ݿ��� ���ڵ��	
	public int delete() throws SQLException {
		return st.executeUpdate(sql);
	}
	
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();
	}
}
