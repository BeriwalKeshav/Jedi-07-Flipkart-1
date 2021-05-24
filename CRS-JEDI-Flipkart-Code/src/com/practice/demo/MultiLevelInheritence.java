package com.practice.demo;

class C extends B{
	public void funC() {
		System.out.println("You are in class C.");
	}
}

public class MultiLevelInheritence {
	public void Call() {
		C obj = new C();
		obj.funA();
		obj.funB();
		obj.funC();
	}

}
