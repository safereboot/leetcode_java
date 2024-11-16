# Java 11

- Java 10 was the last free Oracle JDK release that we could use commercially without a license. Starting with Java 11, there’s no free long-term support (LTS) from Oracle.

  **Thankfully, Oracle continues to provide [Open JDK](https://jdk.java.net/) releases, which we can download and use without charge**


1. **New String Methods**:
   Java 11 added a few useful methods to the **`String`** class.

    ```java
    javaCopy code
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
    
    ```

2. **New File Methods**:
   Java 11 introduced **`Files.writeString()`** and **`Files.readString()`** to write and read strings from files.

    ```java
    javaCopy code
    import java.nio.file.*;
    
    var path = Paths.get("example.txt");
    
    // WriteString
    Files.writeString(path, "Sample text for Java 11 Files.writeString method.");
    
    // ReadString
    String fileContent = Files.readString(path);
    System.out.println(fileContent);
    
    ```

3. **Collection to an Array**:
   This isn't new to Java 11, but you can convert a collection to an array using the **`toArray`** method.

    ```java
    javaCopy code
    import java.util.*;
    
    var list = List.of("Java", "Kotlin", "Scala");
    
    String[] array = list.toArray(new String[0]);
    System.out.println(Arrays.toString(array)); // [Java, Kotlin, Scala]
    
    ```

4. **The Not Predicate Method**:
   Java 11 introduced **`Predicate.not()`**, which is useful for method references in stream operations.

    ```java
    javaCopy code
    import java.util.function.Predicate;
    import java.util.stream.*;
    
    var list = List.of("Java", "", "Kotlin", " ", "Scala");
    
    // Filter non-blank strings
    var nonBlank = list.stream()
                       .filter(Predicate.not(String::isBlank))
                       .collect(Collectors.toList());
    System.out.println(nonBlank); // [Java, Kotlin, Scala]
    
    ```

5. **Local-Variable Syntax for Lambda**:
   Java 11 allows you to use the **`var`** keyword in lambda expressions for the parameters if you want to specify the type.

    ```java
    javaCopy code
    var list = List.of(1, 2, 3);
    
    // Using 'var' in lambda (need to specify the type if using 'var')
    list.forEach((var number) -> System.out.println(number));
    
    ```

6. **HTTP Client**:
   Java 11 standardized the HTTP Client API that was introduced in Java 9 as an incubator module.

    ```java
    javaCopy code
    import java.net.URI;
    import java.net.http.*;
    import java.net.http.HttpResponse.BodyHandlers;
    
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder()
                             .uri(URI.create("https://example.com"))
                             .build();
    
    client.sendAsync(request, BodyHandlers.ofString())
          .thenApply(HttpResponse::body)
          .thenAccept(System.out::println)
          .join();
    
    ```

7. **Nest-Based Access Control**:
   This feature enhances the Java programming model to allow classes that are logically part of the same code entity but are compiled to distinct class files to access each other's private members without the need for compilers to insert accessibility-broadening bridge methods. This is more of a JVM feature than something you would use in everyday Java code.
8. **Running Java Files**:
   With Java 11, you can directly run a single-file Java program without compiling it explicitly with **`javac`**.

    ```
    shCopy code
    java HelloWorld.java
    
    ```

   This assumes **`HelloWorld.java`** is a file in the current directory with a **`main`** method.