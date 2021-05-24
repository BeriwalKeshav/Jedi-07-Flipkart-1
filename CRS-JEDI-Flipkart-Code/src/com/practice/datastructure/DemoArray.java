/**
 * 
 */
package com.practice.datastructure;

import com.practice.bean.Customer;

/**
 * @author lenovo
 *
 */
public class DemoArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Datatype Array :-  
		
		int arrayOfInt[] = new int[] {2, 3, 5};
		
		// this is a basic loop to iterate the array.
	    for (int i = 0; i < arrayOfInt.length; i++) {
	        System.out.println("The " + i + " element has value  : " + arrayOfInt[i]);
	      }
	    
	   // java 8 for each loop
	    for(int i:	arrayOfInt)  
	    	System.out.println(i);
	    
	    // Most of the primitive type has to reformed in the form of wrapper classes.
	    /*
	     * for e.g. int -> Integer(wrapper class)
	     * 			float -> Float
	     * */
	    
	    
	    String names[] = new String[] {"Shakir", "Priyanka", "Sumeet"};
	       
	      for (int i = 0; i < names.length; i++) {
	         System.out.println("The " + i + " name is : " + names[i]);
	       }
	      
	      for(String str: names) {
	    	  System.out.println(str);
	      }
	      
	      /*
	       * Creating a custom class array
	       * */
	      Customer myCustomers[] = new Customer[] {new Customer(), new Customer(), new Customer()};
	      
	       myCustomers[0].setCustId(101);
	       myCustomers[0].setCustName("IBM");
	       myCustomers[0].setCustAddress("Address of 0th cust");
	       
	       myCustomers[1].setCustId(102);
	       myCustomers[1].setCustName("IBM -2 ");
	       myCustomers[1].setCustAddress("Address of 1st cust");
	       
	       myCustomers[2].setCustId(103);
	       myCustomers[2].setCustName("IBM - 3");
	       myCustomers[2].setCustAddress("Address of 2nd cust");
	       	
	       for (int i = 0; i < 3; i++) {	           
	         System.out.println("The id of " + i + " Customer is :" + myCustomers[i].getCustId() + " and name is : " + myCustomers[i].getCustName());
	        
	        }
	       
	       for(Customer cust:myCustomers) {
		         System.out.println("The id of " + " Customer is :" + cust.getCustId() + " and name is : " + cust.getCustName());

	       }

	      
	    


	}

}
