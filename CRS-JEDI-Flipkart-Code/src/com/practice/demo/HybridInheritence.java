package com.practice.demo;


class E extends B{
	public void funE() {
		System.out.println("You are in class E.");
	}
}
public class HybridInheritence {
	public void Call() {
		E obj = new E();
		obj.funA();
		obj.funB();
		obj.funE();
	}

}
