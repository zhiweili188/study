package com.bird.example.discovery;

import java.util.concurrent.TimeUnit;

public class HelloWorld {

	private String name;

	public void sayName() {
		System.out.println(name);
	}

	public void sleep() {  
	        try {  
	            System.out.println("我要睡一会...");  
	            TimeUnit.SECONDS.sleep(2);//沉睡两秒  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	    }

	
}
