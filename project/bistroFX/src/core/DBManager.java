package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBManager {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/bistreet";
	
	private final String ID = "root";
	private final String PW = "9390";
	
    Connection conn = null; 
	Statement state = null; 
	ResultSet rs = null;
	
	public DBManager() throws SQLException{ 
		
		System.out.println("try to connect DB...");

	    try{
				Class.forName(JDBC_DRIVER);
				System.out.println(">>");
				conn = DriverManager.getConnection(DB_URL, ID, PW);
				System.out.print("DB접속 ");
				if (conn!=null) System.out.print("성공");
				else System.out.print("실패");
				state = conn.createStatement();
	            
				String sql; //SQL문을 저장할 String
				sql = "SELECT 상호명 FROM 요식업소";
				rs = state.executeQuery(sql); //SQL문을 전달하여 실행
				
		    	System.out.println(" >> running...");
			
				    while(rs.next()){
						String store_name = rs.getString("상호명");
						System.out.println(store_name);
					}
					rs.close();
					state.close();
					conn.close();
				} catch(Exception e){
					System.out.println("예외발생");
							//예외 발생 시 처리부분

				}
	    
	    finally { //예외가 있든 없든 무조건 실행
					try{
						if(state!=null)
							state.close();
					}catch(SQLException ex1){
						//
					}
							
					try{
						if(conn!=null)
							conn.close();
					}catch(SQLException ex1){
						//
					}
				}
	}
	
	public void sql(String sql) throws SQLException {
		state = conn.prepareStatement(sql);
	}
	
//	public void set(int idx, String str) throws SQLException{
//		state.setString(idx, str);
//	}
//	
//	public ResultSet select() throws SQLException {
//		rs = state.executeQuery();
//		rsmd = rs.getMetaData();
//
//		return rs;
//	}	
//	
//	public ResultSetMetaData getMetaData() throws SQLException {
//		return rsmd;
//	}
//	
//	public int insert() throws SQLException {
//		return state.executeUpdate();
//	}
//	
//	public int update() throws SQLException {
//		return state.executeUpdate();
//	}
//	
//	public int delete() throws SQLException {
//		return state.executeUpdate();
//	}

	public void setAutoCommit(boolean v) throws SQLException {
		//conn.setAutoCommit(v);
	}

	public void commit() throws SQLException {
		//conn.commit();
	}

	public void rollback() throws SQLException {
		//conn.rollback();
	}

	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (state != null)
			state.close();
		if (conn != null)
			conn.close();
	}
}
