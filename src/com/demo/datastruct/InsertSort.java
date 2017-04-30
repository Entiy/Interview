package com.demo.datastruct;
/**
 * ÷±Ω”≤Â»Î≈≈–Ú
 * @author Entity
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		
		int a[]={12,2,45,1,7,32,9,45,8};
		sort(a);
		for(int tmp:a){
			System.out.print(tmp+" ");
		}
			
	}
	public static void sort(int a[]){
		int len=a.length;
		int tmp;
		for(int i=1;i<len;i++){
			tmp=a[i];
			int j=i-1;
			while(j>=0&&a[j]>tmp){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=tmp;
		}
	}
}
