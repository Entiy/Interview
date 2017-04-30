package com.demo;


public class Demo2{
	
	public static void main(String[] args) throws CloneNotSupportedException {
	
		Test t=new Test();
		t.a=1;
		t.b=2;
		Test t1=(Test) t.clone();
		System.out.println(t);
		System.out.println(t1);
		System.out.println(t==t1);
		
		Son s = new Son(10,"Jack") ;  
        Father fa = new Father(40,"Tom",s) ;  
        Father clonedFa = (Father) fa.clone();
        
        System.out.println(fa);
        System.out.println(clonedFa);
        
        System.out.println(fa.getSon().toString());
        System.out.println(clonedFa.getSon().toString());
        
        System.out.println(fa!=clonedFa);  
        System.out.println(clonedFa.getClass()==fa.getClass());  
        System.out.println(clonedFa.equals(fa));  
  
        //now we change the fa's son name by the clonedFa's son name  
        clonedFa.getSon().setName("Jay");  
        System.out.println(fa.getSon().getName());  
	}
}
class Test implements Cloneable{
	int a;
	float b;
	public void say(String str){
		System.out.println(str);
	}
	
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

class Father implements Cloneable{  
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSon(Son son) {
		this.son = son;
	}

	private int age ;  
    private String name ;  
    private Son son ;  
  
    public Father(int age,String name,Son son){  
        this.age = age ;  
        this.name = name ;  
        this.son = son ;  
    }  
  
    public Son getSon(){  
        return this.son ;  
    }  
  
    protected Object clone()throws CloneNotSupportedException{ 
//    	Father fa=(Father) super.clone();
//    	fa.setSon((Son) fa.getSon().clone());
//        return fa;  
    	return super.clone();
    }  
}  
class Son implements Cloneable{  
    private int age ;  
    private String name ;  
  
    public Son(int age ,String name){  
        this.age = age ;  
        this.name = name ;  
    }  
  
    public void setName(String name){  
        this.name = name ;  
    }  
    public String getName(){  
        return this.name ;  
    }  
    
    protected Object clone() throws CloneNotSupportedException {
    	// TODO Auto-generated method stub
    	return super.clone();
    }
}  