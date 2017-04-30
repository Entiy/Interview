package com.demo;

import java.util.concurrent.locks.ReentrantLock;

public class Demo5 {

	 private ReentrantLock lock = new ReentrantLock();  
	  
	    public void write() {  
	        lock.lock();  
	        try {  
	            long startTime = System.currentTimeMillis();  
	            System.out.println("开始往这个buff写入数据…");  
	            for (;;)// 模拟要处理很长时间      
	            {  
	                if (System.currentTimeMillis()  
	                        - startTime > Integer.MAX_VALUE) {  
	                    break;  
	                }  
	            }  
	            System.out.println("终于写完了");  
	        } finally {  
	            lock.unlock();  
	        }  
	    } 
	    public static void main(String[] args) {
			//new Demo5().write();
		}
}
