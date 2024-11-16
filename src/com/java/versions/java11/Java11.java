package com.java.versions.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java11 {
    public static void main(String[] args) throws IOException {


        var multilineString = "This is\n \n a multiline\n string.";

// isBlank() - Checks if a string is empty or contains only white space.
        System.out.println(" ".isBlank()); // true

// lines() - Returns a stream of lines extracted from this string, separated by line terminators.
        multilineString.lines().forEach(System.out::println);

// strip(), stripLeading(), stripTrailing() - Strip out white space from the entire string, the beginning, or the end, respectively.
        System.out.println("   Hello Java 11!   ".strip()); // "Hello Java 11!"
        System.out.println("   Hello Java 11!   ".stripLeading()); // "Hello Java 11!   "
        System.out.println("   Hello Java 11!   ".stripTrailing()); // "   Hello Java 11!"

// repeat(int) - Repeats the string the number of times given by the int parameter.
        System.out.println("Java".repeat(3)); // JavaJavaJava


        var path = Paths.get("example.txt");

// WriteString
        Files.writeString(path, "Sample text for Java 11 Files.writeString method.");

// ReadString
        String fileContent = Files.readString(path);
        System.out.println(fileContent);

        var list = List.of("Java", "Kotlin", "Scala");

        //Collection to an Array
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array)); // [Java, Kotlin, Scala]

//Predicate.not()
        var list1 = List.of("Java", "", "Kotlin", " ", "Scala");

// Filter non-blank strings
        var nonBlank = list1.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        System.out.println(nonBlank); // [Java, Kotlin, Scala]


        //Local-Variable Syntax for Lambda
        var list2 = List.of(1, 2, 3);

// Using 'var' in lambda (need to specify the type if using 'var')
        list2.forEach((var number) -> System.out.println(number));


        //Standardized HTTP Client
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

//        With Java 11, you can directly run a single-file Java program without compiling it explicitly with javac
//        java HelloWorld.java
//        This assumes HelloWorld.java is a file in the current directory with a main method.
    }
}
