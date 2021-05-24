package com.practice.demo;


class D extends A{
	public void funD() {
		System.out.println("You are in class D.");
	}
}
public class HierarchicalInheritence {
	public void Call() {
		D obj = new D();
		obj.funA();
		obj.funD();
	}
}
