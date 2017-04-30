package com.demo.datastruct;
/**
 * 堆排序
 * @author Entity
 *
 */
public class HeapSort {

	
	public static void main(String[] args) {
		int a[]={12,2,45,1,7,32,9,45,8,1,5,124,12,135};
		sort(a);
		for(int tmp:a){
			System.out.print(tmp+" ");
		}
	}
	
	public static void sort(int[] a){
		
		//初始化一个堆
		for(int i=(a.length-1)/2;i>=1;--i)
			sift(a, i, a.length-1);
		for(int i=a.length-1;i>=2;i--){
			int tmp=a[1];
			a[1]=a[i];
			a[i]=tmp;
			sift(a,1,i-1);
		}
		
	}
	
	
	public static void sift(int[] a,int low,int high){
		
		int i=low;
		int j=2*i;
		int tmp=a[i];
		while(j<=high){
			if(j<high&&a[j]<a[j+1])
				j++;
			if(tmp<a[j]){
				a[i]=a[j];
				i=j;
				j=2*i;
			}
			else
				break;
		}
		a[i]=tmp;
	}
	
}
