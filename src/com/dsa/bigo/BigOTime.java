package com.dsa.bigo;

public class BigOTime {


    public static void main(String[] args) {
        // Call all the methods to demonstrate different time complexities.
        constantComplexity(); // O(1)
        logarithmicComplexity(10); //O(log n)
        linearComplexity(10); // O(n)
        linearithmicComplexity(10);  //O(n log n)
        quadraticComplexity(5); //O(n^2)
        cubicComplexity(5); //O(n^3)
        exponentialComplexity(4); // O(2^n)
        factorialComplexity(4); // O(n!)
    }

    // Constant Time Complexity O(1)
    public static void constantComplexity() {
        // This method runs in constant time.
        // Its execution time does not depend on the input size.
        System.out.println("Constant time complexity.");
    }

    // Logarithmic Time Complexity O(log n)
    public static void logarithmicComplexity(int n) {
        // This method runs in logarithmic time.
        // The loop runs proportional to the log of the input size.
        for (int i = 1; i < n; i = i * 2) {
            System.out.println("Logarithmic time complexity: " + i);
        }
    }

    // Linear Time Complexity O(n)
    public static void linearComplexity(int n) {
        // This method runs in linear time.
        // The loop runs once for each element of the input.
        for (int i = 0; i < n; i++) {
            System.out.println("Linear time complexity: " + i);
        }
    }

    // Linearithmic Time Complexity O(n log n)
    public static void linearithmicComplexity(int n) {
        // This method demonstrates linearithmic time complexity.
        // Often seen in algorithms like mergesort.
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j = j * 2) {
                System.out.println("Linearithmic time complexity: " + i + ", " + j);
            }
        }
    }

    // Quadratic Time Complexity O(n^2)
    public static void quadraticComplexity(int n) {
        // This method runs in quadratic time.
        // The nested loops run n * n times.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Quadratic time complexity: " + i + ", " + j);
            }
        }
    }

    // Cubic Time Complexity O(n^3)
    public static void cubicComplexity(int n) {
        // This method runs in cubic time.
        // The nested loops run n * n * n times.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println("Cubic time complexity: " + i + ", " + j + ", " + k);
                }
            }
        }
    }

    // Exponential Time Complexity O(2^n)
    public static void exponentialComplexity(int n) {
        // This method demonstrates exponential time complexity.
        // It can be seen in algorithms like recursive calculation of Fibonacci numbers.
        if (n <= 1) {
            System.out.println("Exponential time complexity: " + n);
        } else {
            exponentialComplexity(n - 1);
            exponentialComplexity(n - 1);
        }
    }

    // Factorial Time Complexity O(n!)
    public static void factorialComplexity(int n) {
        // This method demonstrates factorial time complexity.
        // It is often seen in algorithms that generate all permutations of a given set.
        permute(new int[n], 0);
    }

    private static void permute(int[] arr, int k) {
        if (k == arr.length) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[k] = i;
                permute(arr, k + 1);
            }
        }
    }


}