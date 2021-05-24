package com.practice.demo;

class A2{
	public void funA2() {
		System.out.println("You are in class A2");
	}
}

class F extends A {
	public void funF() {
		System.out.println("you are in class F");
	}
}
public class MultipleInheritence {
	public void Call() {
		F obj = new F();
		obj.funA();
		obj.funF();
	}
}
