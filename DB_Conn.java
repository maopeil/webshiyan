package conn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DB_Conn {
	private Connection conn=null;
	//private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	String driver="com.mysql.jdbc.Driver";
	String dbname="hrm";
	String url="jdbc:mysql://localhost:3306/"+dbname;
	String user="root";
	String password="123456";
	
	public DB_Conn() {//创建D_Conn对象时执行
		try {
			//数据库设置驱动程序类型(mysql)
			Class.forName(driver); 
			System.out.println("数据库驱动加载成功");
		}
		catch(java.lang.ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//
	private void getConn(){//连接数据库(mysql)
		try{
			conn=DriverManager.getConnection(url,user,password);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	//
	public void disConn(){//关闭数据库连接
		if(rs!=null){
			try{
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	//
	public ResultSet eQuery(String sql) {// 执行查询
		try {
			System.out.println("executeQuery(). sql = " + sql);
			PreparedStatement pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		} 
		catch(SQLException ex) { 
			ex.printStackTrace();
		}
		return rs;
	}
	/*	executeUpdate 的返回值是一个整数，指示受影响的行数（即更新计数）。-1表示sql语句执行失败
		executeUpdate用于执行 INSERT、UPDATE 或 DELETE 语句
		以及 SQL DDL（数据定义语言）语句，例如 CREATE TABLE 和 DROP TABLE。
		执行增、删、改语句的方法
	*/
	public int eUpdate(String sql) {
		int count = 0;
		getConn();
		try {
			Statement stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
		} 
		catch(SQLException ex) { 
			System.err.println(ex.getMessage());
			count=-1;
		}
		disConn();
		return count;
	}

}
