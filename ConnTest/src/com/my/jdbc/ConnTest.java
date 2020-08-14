package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnTest {

	public static void main(String[] args) throws Exception {
		// register oracle thin driver  with DriverManager service
		// create jdbc driver class object

		/*
		 * oracle.jdbc.driver.OracleDriver driver = new
		 * oracle.jdbc.driver.OracleDriver(); // register jdbc driver
		 * DriverManager.registerDriver(driver);
		 */
		//load  jdbc driver class to register jdbc driver s/w with DriverManagerservice
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// establish the connection with db s/w
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");

		System.out.println("jdbc con obj class name::" + con.getClass());

		if (con == null) {
			System.out.println("connection is not established");
		} else {
			System.out.println("connection is established");

		}

	}

}
