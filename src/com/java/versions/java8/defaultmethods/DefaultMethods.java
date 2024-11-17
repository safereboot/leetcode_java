package com.java.versions.java8.defaultmethods;

public class DefaultMethods implements GfG {

	public static void main(String[] args) {
		DefaultMethods obj = new DefaultMethods();

		// Calling Interface
		obj.display();

	}
	
	//This will override
//	@Override
//	public void display() {
//		// TODO Auto-generated method stub
//		System.out.println("Overriden");
//	}


}

interface GfG {

	default void display() {
		System.out.println("GEEKSFORGEEKS");
	}
}

//If there are two interfaces like this with same method names, overriding is necessary
interface GfG2 {

	default void display() {
		System.out.println("GEEKSFORGEEKS");
	}
}
