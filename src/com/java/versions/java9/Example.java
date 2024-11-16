package com.java.versions.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

interface Extra {

    default void test01() {
        printMsg();
    }

    //Private methods in interfaces are allowed now
    private static void printMsg(){
        System.out.println("Printing ----");
    }
}

public class Example {

    public static void main(String[] args) throws Exception {

        // Java 7 and 8
//        try (Resource resource = new Resource()) {
//            // use resource
//        }

// Java 9 improvement
        Resource resource = new Resource();
        try (resource) {
            // use resource
        }


    //The Stream API has been enhanced with new methods, such as takeWhile, dropWhile, and ofNullable.
        Stream.of(1, 2, 3, 2, 1)
                .takeWhile(n -> n < 3)
                .forEach(System.out::println); // Prints 1, 2

        Stream.of(1, 2, 3, 2, 1)
                .dropWhile(n -> n < 3)
                .forEach(System.out::println); // Prints 3, 2, 1
    }

    //Java 9 introduced convenient factory methods for creating immutable collections.
    List<String> immutableList = List.of("Java", "Kotlin", "Scala");
    Set<String> immutableSet = Set.of("Java", "Kotlin", "Scala");
    Map<String, Integer> immutableMap = Map.of("Java", 9, "Kotlin", 1);



}

class Resource implements AutoCloseable{

    public Resource (){

    }

    @Override
    public void close() throws Exception {

    }
}