package com.my.jdbc;

import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if (sc!=null) {
				System.out.println("Enter Employee no.");
				no=sc.nextInt();
			}
			
		} catch (Exception e) {
			
		}
	}

}
