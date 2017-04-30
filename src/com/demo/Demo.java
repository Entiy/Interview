package com.demo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Demo {

	final int i;
	int friendly=1;
	public Demo(){
		i=1;
		System.out.println(friendly);
	}
	public static void main(String[] args) throws Exception {
//		Boolean flag = false;
//		if (flag = true) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");
//		}
//
//		System.out.println("当前JRE：" + System.getProperty("java.version"));
//		System.out.println("当前JVM的默认字符集：" + Charset.defaultCharset());
		Demo d=new Demo();
		String str= " 学 java ";
		System.out.println(str.getBytes().length);//-->9
		System.out.println(str.getBytes("GBK").length);//-->9
		System.out.println(str.getBytes("utf-8").length);//-->9
		
		System.out.println("指标".getBytes("unicode"));
//		Double a=1;//编译错误，因为Double是引用类型，1代表的是Inteager引用类型，引用类型不一样，当然不能赋值
//		Double a1=1d;//编译正确，可以在后面加D后缀。
//		Float b=111;//编译错误，因为Float是引用类型，111代表的是Inteager引用类型，引用类型不一样，当然不能赋值
//		Float b1=111f;//编译正确，可以在后面加F后缀。
//		Float b2=1.0;//编译错误，同样是double不能赋值float
		float a=1111111111;
		
		
	}
}
