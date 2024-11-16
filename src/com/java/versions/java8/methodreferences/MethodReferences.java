package com.java.versions.java8.methodreferences;


interface Sayable {
	void say();
}

public class MethodReferences {

	 public static void saySomething(){  
	        System.out.println("Hello, this is static method.");  
	    } 
	 
	 public void saySomething2(){  
	        System.out.println("Hello, this is instance method.");  
	    } 
	 
	 public MethodReferences() {
		System.out.println("Hello, this is a constructor");
	}

	public static void main(String[] args) {

		 // Referring static method  
        Sayable sayable = MethodReferences::saySomething; 
        sayable.say();
        
        // Referring non-static method using reference  
        MethodReferences mr = new MethodReferences();
        Sayable sayable2 = mr :: saySomething2;
        sayable2.say();
        
        Sayable sayable3 = MethodReferences::new;
        sayable3.say();
		
	}

}
