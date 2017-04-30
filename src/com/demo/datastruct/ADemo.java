package com.demo.datastruct;

import java.util.ArrayList;
import java.util.List;

import sun.security.util.Password;

/**
 * 算法小例子
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
	 * 1.判断回文数
	 *	回文数定义：数从左向右与从右向左读完全一致。比如12321,232。。。
	 *	实现思路：头尾指针分别移动比较字符是否相同，若有不同则非回文数。
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
	 * 2.判断闰年
	 */
	public static boolean isLeapYear(int year){
		return ((year%4==0&&year%100!=0)||(year%400==0));
	}
	/*
	 * 3.判断一个数是否为质数
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
	 * 4.分解质因数
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
	 * 5.求链表的中间节点
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
	 * 6.判断单链表中是否有环(链表头尾不相连)
	 * 实现思路：思路与上题基本一致，仍然是快慢指针，快指针的速度是慢指针的两倍，若快指针到达尾节点时两指针未相遇，则无环，反之即有环。
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
	 * 7.n个人围成一圈开始报数，数到m或者m的倍数的人出圈，剩下的人继续报数，问最后剩下的人的人是谁？
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