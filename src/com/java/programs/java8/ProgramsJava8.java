package com.java.programs.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProgramsJava8 {
    public static void main(String[] args) {

        //Iterate over HashMap using java 8
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Cherry", 2);

        map.forEach((key, value) -> System.out.println(key + " : " + value));

        //filters the map to only show entries with values greater than 2.
        map.entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));


        map.replaceAll((key, value) -> value * 2); // Doubles the value of each entry

        //Iterating over keys
        map.keySet().stream()
                .forEach(key -> System.out.println("Key: " + key));

        //Iterating over values
        map.values().stream()
                .forEach(value -> System.out.println("Value: " + value));

        //Sum all the digits of a string
        String numberString = "456";
        int sum = numberString.chars() // Create an IntStream
                .map(Character::getNumericValue) // Convert each char to a numeric value
                .sum(); // Sum all the numeric values


        //String array to String
        String[] stringArray = {"Java", "Python", "C++"};
        String result = Arrays.stream(stringArray)
                .collect(Collectors.joining(", "));

        //Int array to String
        int[] intArray = {1, 2, 3, 4, 5};
        String res = Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        //find first non-repeated character in a string
        String input = "swiss";
        Character firstNonRepeated = input.chars() // Creates an IntStream
                .mapToObj(c -> (char) c) // Converts IntStream to Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Collects characters and their counts into a LinkedHashMap
                .entrySet()
                .stream() // Streams the entry set of the map
                .filter(entry -> entry.getValue() == 1) // Filters for characters with a count of 1
                .map(Map.Entry::getKey) // Maps to the character
                .findFirst() // Finds the first character that matches the criteria
                .orElse(null); // Returns null if no character matches

        // Converting a List of Objects to a Map
        List<Person> people = List.of(
                new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(3, "Charlie")
        );

        Map<Integer, String> idToNameMap = people.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));


    }

}

    class Person {
        private final int id;
        private final String name;

        // Constructor
        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        // Setters, toString(), etc. (omitted for brevity)
    }
