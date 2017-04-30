package com.demo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    
	
	 public static void main(String[] args){
	       Scanner in = new Scanner(System.in);
	       String doc=in.nextLine();
	       int m=in.nextInt();
	       int n=in.nextInt();
	       System.out.println(m+""+n);
	       String[] f=new String[m];
	       String[] c=new String[n];
	       int size=0;
	       String tmp;
	       int[] count=new int[n];
	       for(int i=0;i<m;i++){
	    	   tmp=in.nextLine();
	    	   for(int j=0;j<size;j++){
	    		   if(f[j].contains(tmp))
	    			   f[j]="";
	    		   if(tmp.contains(f[j])){
	    			   tmp="";
	    			   break;
	    		   }
	    	   }
	    	   size++;
	    	   f[i]=tmp;
	       }
	       for(int k=0;k<n;k++){
	    	   tmp=in.nextLine();
	    	   for(int z=0;z<m;z++){
	    		   if(f[k].contains(tmp)){
	    			   count[k]=0;
	    			   break;
	    		   }
	    	   }
	    	   c[k]=tmp;
	       }
	       for(int i=0;i<m;i++){
	    	   doc=doc.replaceAll(f[i]," ");
	       }
	       
	       for(int i=0;i<n;i++){
	    	   int tt=0;
	    	   if(count[i]!=0){
	    		   int t=doc.indexOf(c[i],tt);
	    		   while(t!=-1){
	    			   count[i]++;
	    			   tt+=c[i].length();
	    			   t=doc.indexOf(c[i],tt);
	    		   }
	    	   }
	       }
	       for(int a:count)
	    	   System.out.println(a);
	
	 }
	
}