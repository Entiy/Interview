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
//		System.out.println("��ǰJRE��" + System.getProperty("java.version"));
//		System.out.println("��ǰJVM��Ĭ���ַ�����" + Charset.defaultCharset());
		Demo d=new Demo();
		String str= " ѧ java ";
		System.out.println(str.getBytes().length);//-->9
		System.out.println(str.getBytes("GBK").length);//-->9
		System.out.println(str.getBytes("utf-8").length);//-->9
		
		System.out.println("ָ��".getBytes("unicode"));
//		Double a=1;//���������ΪDouble���������ͣ�1�������Inteager�������ͣ��������Ͳ�һ������Ȼ���ܸ�ֵ
//		Double a1=1d;//������ȷ�������ں����D��׺��
//		Float b=111;//���������ΪFloat���������ͣ�111�������Inteager�������ͣ��������Ͳ�һ������Ȼ���ܸ�ֵ
//		Float b1=111f;//������ȷ�������ں����F��׺��
//		Float b2=1.0;//�������ͬ����double���ܸ�ֵfloat
		float a=1111111111;
		
		
	}
}
