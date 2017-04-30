package com.demo.datastruct;

import java.util.ArrayList;
import java.util.List;

import sun.security.util.Password;

/**
 * �㷨С����
 * @author Entity
 *
 */
public class ADemo {

	
	public static void main(String[] args) {
//		long l=232;
//		System.out.println(isPalindromeNumber(l));
		for(int i:decPrime(56))
			System.out.println(i);
		printNo(6,3);
	}
	/*
	 * 1.�жϻ�����
	 *	���������壺����������������������ȫһ�¡�����12321,232������
	 *	ʵ��˼·��ͷβָ��ֱ��ƶ��Ƚ��ַ��Ƿ���ͬ�����в�ͬ��ǻ�������
	 */
	public static boolean isPalindromeNumber(long l){
		char a[]=String.valueOf(l).toCharArray();
		int len=a.length/2;
		for(int i=0;i<len;i++){
			if(a[i]!=a[a.length-1-i])
				return false;
		}
		return true;
	} 
	/*
	 * 2.�ж�����
	 */
	public static boolean isLeapYear(int year){
		return ((year%4==0&&year%100!=0)||(year%400==0));
	}
	/*
	 * 3.�ж�һ�����Ƿ�Ϊ����
	 */
	public static boolean isPrimeNumber(int n){
		int n1=(int) Math.sqrt(n);
		for(int i=2;i<=n1;i++){
			if(n%i==0)
				return false;
		}
		return true;
		
	}
	/*
	 * 4.�ֽ�������
	 */
	public static Integer[] decPrime(int a){
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=2;i<=a;i++){
			while(a!=i){
				if(a%i!=0)
					break;
				list.add(Integer.valueOf(i));
				a=a/i;
			}
		}
		list.add(Integer.valueOf(a));
		return list.toArray(new Integer[list.size()]);
	}
	
	/*
	 * 5.��������м�ڵ�
	 */
	public static Nodee getMid(Nodee head){
		Nodee slow=head;
		Nodee quick=head;
		while(quick!=null&&quick.next!=null){
			slow=slow.next;
			quick=quick.next.next;
		}
		return slow;
	} 
	/*
	 * 6.�жϵ��������Ƿ��л�(����ͷβ������)
	 * ʵ��˼·��˼·���������һ�£���Ȼ�ǿ���ָ�룬��ָ����ٶ�����ָ�������������ָ�뵽��β�ڵ�ʱ��ָ��δ���������޻�����֮���л���
	 */
	public static boolean hasCycle(Nodee head){
		Nodee p1=head;
		Nodee p2=head;
		while(p1!=null&&p2!=null){
			p1=p1.next;
			p2=p2.next.next;
			if(p1==p2){
				return true;
			}
		}
		return false;
	}
	/*
	 * 7.n����Χ��һȦ��ʼ����������m����m�ı������˳�Ȧ��ʣ�µ��˼��������������ʣ�µ��˵�����˭��
	 */
	public static void printNo(int n,int m){
		boolean[] visited=new boolean[n]; 
		int idx=0;
		int code=1;
		int size=n;
		while(size>0){
			if(!visited[idx]){
				if(code==m){
					visited[idx]=true;
					System.out.println(idx);
					code=0;
					size--;
				}
				code++;
			}
			idx++;
			if(idx==n)
				idx=0;
		}
	}
	
}
class Nodee{
	int data;
	Nodee next;
}