package controllers;

public class Calculator {
	
	static int a;
	static int b;
	
	public Calculator() {
		
	}
	
	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int add() {
		return a+b;
	}
	
	public int substract() {
		return a-b;
	}

	public int multiply() {
		return a*b;
	}
	
	public int divide() {
		return a/b;
	}
	
	
}
