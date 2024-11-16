package com.java.versions.java8.functionalinterfaces;

//Has a single abstract method but it can have default or static methods 
@FunctionalInterface
interface Multiply {
	int calculate(int x);

	// A non-abstract (or default) function in Functional Interface
	default void normalFun() {
		System.out.println("In default method");
	}

	// A static method in Functional Interface
	static void testM() {
		System.out.println("In static method");
	}
}

public class FunctionalInterfaces implements Multiply {

	public static void main(String[] args) {
		int a = 5;

		// lambda expression to define the calculate method
		Multiply m = (int x) -> x * x;

		// Can be anonymously overridden as per needs
		Multiply m2 = (int x) -> x * x * x;

		// parameter passed and return type must be
		// same as defined in the prototype
		int ans = m2.calculate(a);
		System.out.println(ans);

		FunctionalInterfaces f = new FunctionalInterfaces();
		f.normalFun();
		Multiply.testM();

	}

	@Override
	public int calculate(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
