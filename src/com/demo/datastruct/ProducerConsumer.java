package com.demo.datastruct;

import java.util.ArrayList;

public class ProducerConsumer {
	public static void main(String[] args) {
		Storage storage=new Storage();
		Consumer consumer=new Consumer(storage);
		Producer producer=new Producer(storage);

		Thread c1=new Thread(consumer);
		c1.setName("����������");
		Thread c2=new Thread(consumer);
		c2.setName("����������");
		Thread p1=new Thread(producer);
		p1.setName("����������");
		Thread p2=new Thread(producer);
		p2.setName("��������ʯ");

		c1.start();
		c2.start();
		p1.start();
		p2.start();
	}

}

class Producer implements Runnable {

	private Storage storage;

	public Producer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		storage.produce();
	}

}

class Consumer implements Runnable {

	private Storage storage;

	public Consumer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		storage.consume();;
	}

}

class Storage{
	
	private final static int MAX_VALUE=5;
	ArrayList<String> storage=new ArrayList<String>();
	public void produce(){
		synchronized (this) {
			while(storage.size()==MAX_VALUE){
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			System.out.println(Thread.currentThread().getName()+"������һ����Ʒ");
			storage.add("ƻ��");
			this.notifyAll();
		}
	}
	
	public void consume(){
		synchronized (this) {
			while(storage.size()==0){
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			System.out.println(Thread.currentThread().getName()+"������һ����Ʒ");
			storage.remove(storage.size()-1);
			this.notifyAll();
		}
	}

}