package com.demo;

import java.util.concurrent.locks.ReentrantLock;

public class Demo5 {

	 private ReentrantLock lock = new ReentrantLock();  
	  
	    public void write() {  
	        lock.lock();  
	        try {  
	            long startTime = System.currentTimeMillis();  
	            System.out.println("��ʼ�����buffд�����ݡ�");  
	            for (;;)// ģ��Ҫ����ܳ�ʱ��      
	            {  
	                if (System.currentTimeMillis()  
	                        - startTime > Integer.MAX_VALUE) {  
	                    break;  
	                }  
	            }  
	            System.out.println("����д����");  
	        } finally {  
	            lock.unlock();  
	        }  
	    } 
	    public static void main(String[] args) {
			//new Demo5().write();
		}
}
