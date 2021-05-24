/**
 * 
 */
package com.practice.client;

import com.practice.abstractdemo.DemoAbstract;
import com.practice.abstractdemo.DemoAccess;

/**
 * @author lenovo
 *
 */
public class AccessClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoAccess obj = new DemoAccess();
		System.out.println(obj.testAbstract()); 
		System.out.println(obj.testAccess());

	}

}
