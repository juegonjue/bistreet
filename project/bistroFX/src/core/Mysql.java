package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Mysql {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/bistreet?autoReconnect=true";
	private final String ID = "root";
	private final String PW = "password";
	
	private static Mysql obj = null;
	private Connection conn = null;
    private Statement st = null;
    private PreparedStatement pst = null;
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
	
	public void psql(String psql) throws SQLException 
	{
		pst = conn.prepareStatement(psql);
		System.out.println("sql : success");
	}
	
	public void setstring(int index, String data) throws SQLException {
		pst.setString(index, data);
	}
	
	public void setint(int index, int data) throws SQLException {
		pst.setInt(index, data);
	}
	
	public void setdouble(int index, double data)  throws SQLException {
		pst.setDouble(index, data);
	}
	
	public void settime(int index, LocalDateTime data)  throws SQLException {	//실행될지는 모르겠음. 이따 테스트
		pst.setObject(index, data);
	}
	

	public ResultSet select() throws SQLException {
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		System.out.println("resultSet : success (여러번 반복될 수 있습니다)");
		return rs;
	}
	
	public ResultSet select2() throws SQLException {
		rs = pst.executeQuery();
		System.out.println("resultSet : success (여러번 반복될 수 있습니다)");
		return rs;
	}
	
	
	//update() : Statement문장을 썼을 때, select문 이외에 update, insert, delete를 통합해 행한다.
	//반환값은 레코드 수
	public int update() throws SQLException {
		return st.executeUpdate(sql);
	}
	
	//update2() : preparedStatement 문장을 썼을 때 , select문 이외에 update, insert, delete를 통합해 행한다.
	public int update2() throws SQLException {
		return pst.executeUpdate();
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
