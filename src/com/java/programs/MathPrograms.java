package com.java.programs;

public class MathPrograms {

	public static int abc = 1;

	public static void main(String[] args) {

//		long startTime = System.currentTimeMillis();
//		System.out.println(biggestPrimeNumberUnderACertainNumber(4000000));
//		System.out.println(checkIfPrime(3999971));
//		long endTime = System.currentTimeMillis();
//		System.out.println("Time taken : " + (endTime - startTime));
		fibonacci(10);

	}

	// find the factorial of an integer
	private static int factorial(int n) {
		if (n <= 1)
			return 1;
		else {
			return n * factorial(n - 1);
		}
	}

	// Swap with temp
	private static void swap(int a, int b) {

		System.out.println(" a = " + a);
		System.out.println(" b = " + b);

		int temp = a;
		a = b;
		b = temp;

		System.out.println(" a = " + a);
		System.out.println(" b = " + b);

	}

	// swap two numbers without using a third variable
	private static void swapWithoutTemp(int a, int b) {

		System.out.println(" a = " + a);
		System.out.println(" b = " + b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println(" a = " + a);
		System.out.println(" b = " + b);

	}

	// find power of a number using recursion

	private static int power(int x, int n) {
		if (n <= 1)
			return x;
		else
			return x * power(x, n - 1);

	}

	// find power of a number without using recursion
	private static int powerBitmanipulation() {

		return 0;
	}

	// check if the given number is a prime number
	private static boolean checkIfPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0)
					return false;
			}
		}
		return true;

	}

	private static int biggestPrimeNumberUnderACertainNumber(int num) {
		for (int i = num; i >= 2; i--) {
			if (checkIfPrime(i))
				return i;
		}
		return -1;
	}

	// print a Fibonacci sequence using while loop
	private static void fibonacci(int n) {
		int firstTerm = 0;
		int secondTerm = 1;
		int count = 3;

		System.out.print(firstTerm + " " + secondTerm);
		while (count <= n) {
			int nextTerm = firstTerm + secondTerm;
			System.out.print(" " + nextTerm);
			firstTerm = secondTerm;
			secondTerm = nextTerm;
			count++;
		}
	}

	// find the sum of Fibonacci sequence using recursion
	private static int fibonacciRecursion(int n) {
		if (n == 0 || n == 1)
			return 0;
		else if (n == 2)
			return 1;
		else
			return n + fibonacciRecursion(n - 1);
	}

	// check if a list of integers contains only odd numbers
	private static void checkIfListOnlyContainsOddNumbers() {
		// TODO Auto-generated method stub

	}

}
