package com.hyh.test;

import com.hyh.annotation.EntityExcept;
import com.hyh.annotation.EntityTable;
import com.hyh.config.Global;
import com.hyh.entity.UserEntity;
import com.hyh.util.TextUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {
	
	public static void main(String[] args) throws SQLException{
		Connection connetion = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/chs?useUnicode=true&characterEncoding=utf-8";
		String userkey = "root";
		String password = "";
		// 数据库加载驱动程序
		try {
			Class.forName(driver);
			connetion = DriverManager.getConnection(url, userkey, password);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动类没找到！");
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败！");
		}

    }
}
