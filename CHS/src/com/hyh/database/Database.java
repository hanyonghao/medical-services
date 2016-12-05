package com.hyh.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hyh.config.Global;

public class Database {
	
	public static Connection getConnection(){
		Connection conn = null;
		// 数据库加载驱动程序
		try {
			Class.forName(Global.getConfig("jdbc.driver"));
			conn = DriverManager.getConnection(Global.getConfig("jdbc.url"), Global.getConfig("jdbc.username"), Global.getConfig("jdbc.password"));
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动类没找到！");
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败！");
		}
		return conn;
	}
}
