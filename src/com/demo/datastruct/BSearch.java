package com.demo.datastruct;

/**
 * ’€∞Î≤È’“
 * @author Entity
 *
 */
public class BSearch {

	public static void main(String[] args) {
		int a[]={1,4,7,9,10,10,11,22};
		System.out.println(search(a,0,a.length-1,4));
	}
	public static int search(int[] a,int low,int high,int k){
		
		while(low<=high){
			int mid=(low+high)/2;
			if(a[mid]==k)
				return mid;
			else if(a[mid]>k)
				high=mid-1;
			else
				low=mid+1;
		}
		return 0;
	}
}
