package com.practice.demo;

class A {
	//final int a=10;
	
	public void funA() {
		//a=20;
		System.out.println("You are in class A.");
	}
	public  void test() {
		System.out.println("Hello Parent.");
	}
}
class B extends A{
	public void funB() {
		System.out.println("You are in class B.");
	}
	public void test() {
		super.test();
		System.out.println("Hello Child.");
	}
}
public class SingleLevelInheritence {
	public void Call() {
		B obj = new B();
//		obj.funA();
//		obj.funB();
		obj.test();
	}
}
