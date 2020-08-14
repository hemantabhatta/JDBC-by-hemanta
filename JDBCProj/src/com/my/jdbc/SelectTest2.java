package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {
		Scanner sc = null;// local variable decl at top of method definitation
		String desg1 = null, desg2 = null, desg3 = null;
		String cond = null;
		Connection con = null;
		Statement st = null;
		String query = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter desg1");
				desg1 = sc.next().toUpperCase();// gives CLERK
				System.out.println("Enter desg2");
				desg2 = sc.next().toUpperCase();// gives SALESMAN
				System.out.println("Enter desg3");
				desg3 = sc.next().toUpperCase();// gives MANAGER
			} // if
			// convert input values as the required for SQL query
			// ('CLERK','SALESMAN','MANAGER')
			cond = "('" + desg1 + "','" + desg2 + "','" + desg3 + "')";
			System.out.println(cond);

			// register jdbc driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");

			// create statement obj
			if (con != null) {// to avoid NPE
				st = con.createStatement();

				// prepare SQL Query
				// SQL> SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE JOB IN
				// ('clerk','SALESMAN','MANAGER') order by job desc;
				query = "SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE  JOB IN " + cond + " ORDER BY JOB DESC";
				System.out.println(query);

				// send and execute SQL Query in Db s/w
				if (st != null) {
					rs = st.executeQuery(query);
				}
				// process the ResultSet object
				if (rs != null) {
					while (rs.next()) {
						flag = true;
						System.out.println(
								rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3) + " " + rs.getString(4));

					} // while
					if (flag) {
						System.out.println("Records displayed");
					} else {
						System.out.println("No Records found");
					} // if else
				} // if
			} // if NPE for con
		} /* try */ catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc objs
			/*
			 * try { **** Bad code to close JDBC objs **** if (rs!=null && st!=null &&
			 * con!=null) { rs.close(); st.close(); con.close(); }//if } catch (SQLException
			 * se) { se.printStackTrace(); }
			 */
			// **** Good code to close JDBC objs ****
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception se) {
				se.printStackTrace();
			}
		} // finally

	}// main

}// class
