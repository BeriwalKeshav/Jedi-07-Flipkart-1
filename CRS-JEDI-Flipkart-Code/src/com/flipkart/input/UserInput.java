/**
 * 
 */
package com.flipkart.input;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class UserInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Name : ");
		String Name = in.nextLine();
		
		System.out.println("Name : " + Name);
		in.close();

	}

}
