package com.dsa.bigo;

public class BigOSpace {

    public static void main(String[] args) {
        // Call all the methods to demonstrate different space complexities.
        constantSpace();
        linearSpace(10);
        quadraticSpace(5);
        logarithmicSpace(16);
        exponentialSpace(4);
    }

    // Constant Space Complexity O(1)
    public static void constantSpace() {
        // This method uses a constant amount of space
        // regardless of the input size.
        int constantArray[] = new int[10]; // space used is constant
        System.out.println("Constant space complexity.");
    }

    // Linear Space Complexity O(n)
    public static void linearSpace(int n) {
        // This method's space usage is linear with the size of the input.
        int linearArray[] = new int[n]; // space used is proportional to n
        System.out.println("Linear space complexity.");
    }

    // Quadratic Space Complexity O(n^2)
    public static void quadraticSpace(int n) {
        // This method uses space proportional to the square of the input size.
        int quadraticArray[][] = new int[n][n]; // space used is n^2
        System.out.println("Quadratic space complexity.");
    }

    // Logarithmic Space Complexity O(log n) - Example with recursive function
    public static void logarithmicSpace(int n) {
        // Logarithmic space complexity is rare but can be demonstrated with recursive algorithms
        // that divide the problem into smaller chunks.
        if (n <= 1) {
            System.out.println("Logarithmic space complexity.");
        } else {
            logarithmicSpace(n / 2);
        }
    }

    // Exponential Space Complexity O(2^n) - Example with generating power set
    public static void exponentialSpace(int n) {
        // Exponential space complexity occurs in algorithms like generating power sets,
        // where the size of the output is 2^n.
        int[] set = new int[n];
        generatePowerSet(set, 0);
        System.out.println("Exponential space complexity.");
    }

    private static void generatePowerSet(int[] set, int index) {
        if (index == set.length) {
            // Print the set
            for (int i = 0; i < set.length; i++) {
                System.out.print(set[i] + " ");
            }
            System.out.println();
            return;
        }
        // Include or exclude the current element
        set[index] = 0;
        generatePowerSet(set, index + 1);
        set[index] = 1;
        generatePowerSet(set, index + 1);
    }


}