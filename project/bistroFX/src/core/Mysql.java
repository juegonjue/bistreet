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
			System.out.print("DB접속 ");
			if (conn!=null) System.out.println("성공");
			else System.out.println("실패");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Mysql.getConnection() -> DB연결
	public static Mysql getConnection() throws SQLException {
		if (Mysql.obj == null)
			Mysql.obj = new Mysql();
		System.out.println("getConnection : success");
		return Mysql.obj;
	}

	//.sql("sql문 입력")
	public void sql(String sql) throws SQLException {
		this.sql = sql;
		System.out.println("sql : success");
	}
	
	public ResultSet select() throws SQLException {
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		System.out.println("resultSet : success (결과가 많을 시 여러 번 반복될 수 있습니다)");
		return rs;
	}
	
	//삽입, 반환값은 반영된 레코드수
	public int insert() throws SQLException {
		return st.executeUpdate(sql);
	}
	
	//수정, 반환값은 반영된 레코드수
	public int update() throws SQLException {
		return st.executeUpdate(sql);
	}

	//삭제, 반환값은 반영된 레코드수	
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
