package com.java.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayPrograms {

	public static void main(String[] args) {
//		int arr[] = { 1, 2, 3, 2, 4, 5, 4, 4 };

//		int arr[] = new int[100];
//		for (int i = 0; i < arr.length; i++) {
//			if (i + 1 != 56)
//				arr[i] = i + 1;
//		}
//		findMissingNumber(arr);
//		int arr[] = {1, 2 , 3, 2, 4, 5, 4, 4};
//		findDuplicateNumber(arr);

//		checkIfArrayContainsANumber(arr, 2);
//		int arr[] = new int[] { -55, 32, 45, 98, 999, 82, 11, 9, 39, 50 };
//		findLargestAndSmallestNumber(arr);

		sortArray();
	}

	// 0s followed by 1s
	private static void sortArray() {
		// TODO Auto-generated method stub
		int[] arr = { 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 };

		int leftIndex = 0;
		int rightIndex = arr.length - 1;

		while (leftIndex < rightIndex) {

			while (arr[leftIndex] == 0 & leftIndex < rightIndex)
				leftIndex++;
			while (arr[rightIndex] == 1 & leftIndex < rightIndex)
				rightIndex--;

			while (arr[leftIndex] > arr[rightIndex]) {
				arr[leftIndex] = 0;
				arr[rightIndex] = 1;
				leftIndex++;
				rightIndex--;
			}

		}

		for(int i : arr) {
			System.out.print(i);
		}
		

	}

	// javarevisited.blogspot.com
	// How to find the missing number in integer array of 1 to 100
	private static void findMissingNumber(int[] arr) {

		int expectedSum = 100 * (100 + 1) / 2;
		int actualSum = 0;
		for (int i = 0; i < arr.length; i++) {
			actualSum = actualSum + arr[i];
		}
		System.out.println("missing number is " + (expectedSum - actualSum));

	}

	// How to find duplicate number on Integer array in Java
	private static void findDuplicateNumber(int[] arr) {

		Set s = new HashSet<Integer>();
		Set duplicateNumbers = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			boolean add = s.add(arr[i]);
			if (!add) {
				duplicateNumbers.add(arr[i]);
			}
		}

		System.out.println("Duplicate numbers are");
		duplicateNumbers.forEach(i -> System.out.println(i));
	}

	// How to check if array contains a number
	private static void checkIfArrayContainsANumber(int[] arr, int num) {

		// Linear search
		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				System.out.println("Yes number is present");
				break;
			}
		}

		// Binary Search
		Arrays.sort(arr);
		int result = Arrays.binarySearch(arr, num);
		if (result > 0)
			System.out.println("Yes number is present");

		// contains
		List<Integer> l = Arrays.asList(1, 3, 4, 8, 2, 3);
		if (l.contains(2))
			System.out.println("Yes number is present");

	}

	// How to find largest and smallest number in unsorted array
	private static void findLargestAndSmallestNumber(int arr[]) {

		int smallest = arr[0];
		int largest = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < smallest)
				smallest = arr[i];
			if (arr[i] > largest)
				largest = arr[i];
		}
		System.out.println("smallest number is : " + smallest);
		System.out.println("largest number is : " + largest);
	}

	// How to find all pairs on integer array whose sum is equal to given number
	private static void allPairsWhoseSumIsEqualToGivenNumber(int[] arr, int num) {

	}

	// How to find repeated numbers in an array if it contains multiple duplicates
	private static void findRepeatedNumbers(int[] arr) {
		// TODO Auto-generated method stub

	}

	// Write a program to remove duplicates from array in Java
	private static void removeDuplicates(int[] arr) {
		// TODO Auto-generated method stub

	}

	// How find the first repeating element in an array of integers
	private static void findFirstRepeatingElement(int[] arr) {
		// TODO Auto-generated method stub

	}

	// How to find first non-repeating element in array of integers
	private static void findFirstNonRepeatingElement(int[] arr) {
		// TODO Auto-generated method stub

	}

	// How to find top two numbers from an integer array
	private static void findTopTwoNumbers(int[] arr) {
		// TODO Auto-generated method stub

	}

	// How to reverse array in place
	private static int[] reverseArrayInPlace(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n / 2; i++) {
			int t = arr[i];
			arr[i] = arr[n - 1 - i];
			arr[n - 1 - i] = t;
		}
		return arr;
	}

	// Write Java program that checks if two arrays contain the same elements
	private static void checkif2ArraysHaveSameElements(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub

	}

	// How do you get the sum of all elements in an integer array
	private static void sumOfAllElementsInArray(int[] arr) {
		// TODO Auto-generated method stub

	}

	// How do you find the second largest number in an array
	private static void secondLargestNumberInArray(int[] arr) {
		// TODO Auto-generated method stub

	}

	// How do you shuffle an array
	private static void shuffleArray(int[] arr) {
		// TODO Auto-generated method stub

	}

}