package com.demo.datastruct;
/**
 * ¿ìËÙÅÅĞò
 * @author Entity
 *
 */
public class QickSort {

	public static void main(String[] args) {
		int a[]={12,2,45,1,7,32,9,45,8,1,5,124,12,135};
		sort(a,0,a.length-1);
		for(int tmp:a){
			System.out.print(tmp+" ");
		}
	}
	public static void sort(int[] a,int l,int r){
		int i=l;
		int j=r;
		if(l<r){
			int tmp=a[l];
			while(i!=j){
				while(j>i&&a[j]>tmp)
					j--;
				if(j>i){
					a[i]=a[j];
					i++;
				}
				while(i<j&&a[i]<tmp)
					i++;
				if(i<j){
					a[j]=a[i];
					j--;
				}
			}
			a[i]=tmp;
			sort(a,l,i-1);
			sort(a,i+1,r);
		}
	}
}
