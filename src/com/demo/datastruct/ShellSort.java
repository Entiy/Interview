package com.demo.datastruct;

/**
 * Ï£¶ûÅÅÐò
 * 
 * @author Entity
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int a[]={12,2,45,1,7,32,9,45,8,1,5,124};
		sort(a);
		for(int tmp:a){
			System.out.print(tmp+" ");
		}
	}

	public static void sort(int[] a) {
		int inc=a.length/2;
		while(inc>=1){
			for(int i=0;i<inc;i++) {
				for(int j=i+inc;j<a.length;j+=inc){
					int tmp=a[j];
					int k=j-inc;
					while(k>=0&&a[k]>tmp){
						a[k+inc]=a[k];
						k=k-inc;
					}
					a[k+inc]=tmp;
				}
			}
			inc=inc/2;
		}
	}
}
