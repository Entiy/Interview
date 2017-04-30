package com.demo;

public class Demo6 {

	public static void main(String[] args) {
		 S s=new S();
	     System.out.println(s.name);
	     s.say();
	}
	
}
class F{
	String name="father";
	static int a=1;
	static void say(){
		System.out.println("father");
	}
}
class S extends F{
	
}