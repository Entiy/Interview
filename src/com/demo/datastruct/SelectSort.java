package com.demo.datastruct;
/**
 * —°‘Ò≈≈–Ú
 * @author Entity
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int a[]={12,2,45,1,7,32,9,45,8,1,5,124,12,135};
		sort(a);
		for(int tmp:a){
			System.out.print(tmp+" ");
		}
	}
	public static void sort(int[] a){
		for(int i=0;i<a.length;i++){
			int k=i;
			for(int j=i;j<a.length;j++)
				if(a[k]>a[j])
					k=j;
			int tmp=a[i];
			a[i]=a[k];
			a[k]=tmp;
		}
	}
}
