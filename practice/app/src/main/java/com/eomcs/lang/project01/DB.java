package com.eomcs.lang.project01;

import java.sql.*;

public class DB {
	
	Connection CN = null;
	Statement ST = null;
	ResultSet RS = null;
	PreparedStatement PST = null;
	
	String msg = "";
	
	public void DBbase() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			CN = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
			ST = CN.createStatement();			
		}catch (Exception e) {}
	}

}
