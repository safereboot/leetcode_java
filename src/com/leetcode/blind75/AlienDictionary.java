package com.leetcode.blind75;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author David
 
 Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

Examples:  

Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
Output: Order of characters is 'b', 'd', 'a', 'c'
Note that words are sorted and in the given language "baa" 
comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Input:  words[] = {"caa", "aaa", "aab"}
Output: Order of characters is 'c', 'a', 'b'
 
 */
public class AlienDictionary {

    public static void main(String[] args) {
        // Example usage
        String[] words1 = {"baa", "abcd", "abca", "cab", "cad"};
        String[] words2 = {"caa", "aaa", "aab"};

        System.out.println("Order for words1: " + findOrder(words1));
        System.out.println("Order for words2: " + findOrder(words2));
    }

    private static String findOrder(String[] words) {
        // TODO: Implement the logic to find the order of characters
        // Create a graph to represent character relationships
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        // Perform topological sort
        StringBuilder order = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        Set<Character> cycle = new HashSet<>();

        for (char c : graph.keySet()) {
            if (dfs(c, graph, visited, cycle, order)) {
                return ""; // Invalid order (cycle detected)
            }
        }

        return order.reverse().toString();
    }

    private static boolean dfs(char c, Map<Character, Set<Character>> graph, Set<Character> visited, Set<Character> cycle, StringBuilder order) {
        if (cycle.contains(c)) return true;
        if (visited.contains(c)) return false;

        cycle.add(c);
        visited.add(c);

        for (char neighbor : graph.get(c)) {
            if (dfs(neighbor, graph, visited, cycle, order)) return true;
        }

        cycle.remove(c);
        order.append(c);
        return false;
    }

}
