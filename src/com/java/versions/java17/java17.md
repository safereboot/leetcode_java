# Java 17

1. **Sealed Classes** (JEP 409):
   Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them.

    ```java
    
    public sealed class Shape permits Circle, Square {
        //...
    }
    
    public final class Circle extends Shape {
        //...
    }
    
    public non-sealed class Square extends Shape {
        //...
    }
    ```

2. **Pattern Matching for switch** (JEP 406):
   This feature allows you to use pattern matching in **`switch`** expressions and statements, reducing boilerplate.

    ```java
    
    Object obj = "Hello";
    switch (obj) {
        case String s -> System.out.println(s.toUpperCase());
        case Integer i -> System.out.println(Math.pow(i, 2));
        default -> System.out.println("Unknown type");
    }
    
    ```

3. **New macOS Rendering Pipeline** (JEP 382):
   A new rendering pipeline for macOS, using the Apple Metal API as an alternative to the existing pipeline that uses the deprecated OpenGL API.
4. **Foreign Function & Memory API (Incubator)** (JEP 412):
   Introduces an API to allow Java programs to interoperate with code and data outside of the Java runtime.
5. **Pattern Matching for instanceof** (JEP 394):
   Enhances the Java programming language with pattern matching for the **`instanceof`** operator.

    ```java
    
    if (obj instanceof String s) {
        // can use s directly here
        System.out.println(s.toUpperCase());
    }
    ```

6. **Record Classes** (JEP 395):
   Record classes are a special kind of class in Java that are a transparent carrier for immutable data.

    ```java
    
    public record Point(int x, int y) { }
    
    ```

7. **Strongly Encapsulate JDK Internals** (JEP 403):
   Strong encapsulation of all internal elements of the JDK, except for critical internal APIs such as **`sun.misc.Unsafe`**.
8. **Deprecate the Applet API for Removal** (JEP 398):
   Marks the Applet API as deprecated for removal.
9. **Remove the Remote Method Invocation (RMI) Activation System** (JEP 407):
   Removes the RMI Activation system while preserving the rest of RMI.
10. **Deprecate the Security Manager for Removal** (JEP 411):
    Deprecates the Security Manager for removal in a future release.
11. **New Interfaces for Pseudo-Random Number Generators** (JEP 356):
    Adds new interfaces and implementations for pseudorandom number generators (PRNGs).
12. **Restore Always-Strict Floating-Point Semantics** (JEP 306):
    Restores the default floating-point operations to "strict" semantics.
13. **Deprecate the Security Manager for Removal** (JEP 411):
    Deprecates the Security Manager for removal in a future release.
14. **Context-Specific Deserialization Filters** (JEP 415):
    Enhances the ObjectInputStream class to allow per-stream deserialization filters.

    ```java
    ObjectInputFilter filter = ObjectInputFilter.Config.createFilter("java.base/*;!*");
    ObjectInputStream ois = new ObjectInputStream(bais);
    ois.setObjectInputFilter(filter);
    ```

15. **Vector API (Incubator)** (JEP 338):
    Provides a mechanism to express vector computations that compile at runtime to optimal vector instructions on supported CPU architectures, thus achieving performance superior to equivalent scalar computations.