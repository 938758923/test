package com.internousdev.template.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	//mysql接続に必要な情報
	private static String driverName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost/ecsite";

	private static String user="root";
	private static String password="mysql";

	public Connection getConnection(){
		Connection con=null;//初期化

		try{
			Class.forName(driverName);
			con=(Connection) DriverManager.getConnection(url,user,password);//mysqlへの接続準備完了
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;//mysqlに接続できたか情報を戻す
	}

}
