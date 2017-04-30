package com.demo.datastruct;
/**
 * 折半插入排序
 * 适用于记录数比较多的场景
 * @author Entity
 *
 */
public class BInsertSort {

	public static void main(String[] args) {
		int a[]={12,2,45,1,7,32,9,45,8};
		sort(a);
		for(int tmp:a){
			System.out.print(tmp+" ");
		}
	}
	public static void sort(int[] a){
		int tmp,low,high,mid;
		for(int i=1;i<a.length;i++){
			tmp=a[i];
			low=0;
			high=i-1;
			while(high>=low){
				mid=(low+high)/2;
				if(tmp>a[mid])
					low=mid+1;
				else
					high=mid-1;
			}
			for(int j=i;j>low;j--)
				a[j]=a[j-1];
			a[low]=tmp;
		}
	}
}
