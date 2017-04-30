package com.demo.datastruct;

/**
 * Ã°ÅÝÅÅÐò
 * @author Entity
 *
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		int a[]={12,2,45,1,7,32,9,45,8,1,5,124};
		sort(a);
		for(int tmp:a){
			System.out.print(tmp+" ");
		}
	}
	
	public static void sort(int[] a){
		
		for(int i=a.length-1;i>0;i--){
			boolean flag=false;
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					int tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
					flag=true;
				}
			}
			if(!flag)
				return;
		}
	}
}
