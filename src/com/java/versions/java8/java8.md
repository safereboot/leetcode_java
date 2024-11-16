# Java 8

### **What are the significant advantages of Java 8?**

- Compact, readable, and reusable code.
- Less boilerplate code.
- Parallel operations and execution.
- Can be ported across operating systems.
- High stability.
- Stable environment.
- Adequate support

## Functional interfaces (SAM interface)

An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, static methods but can contain only one abstract method. It can also declare methods of object class.

Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces. It is a new feature in Java, which helps to achieve functional programming approach.

```java
@FunctionalInterface  
interface sayable{  
    void say(String msg);  
}  
public class FunctionalInterfaceExample implements sayable{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();  
        fie.say("Hello there");  
    }  
}
```

```java
@FunctionalInterface  
interface sayable{  
    void say(String msg);   // abstract method  
    // It can contain any number of Object class methods.  
    int hashCode();  
    String toString();  
    boolean equals(Object obj);  
}
```

The main benefit of using functional interfaces is that **they can be instantiated using lambda expressions rather than lengthy anonymous classes**.

Since a lambda function can only provide the implementation for 1 method it is mandatory for the functional interface to have ONLY one abstract method

## **Can a functional interface extend/inherit another interface?**

A functional interface cannot extend another interface with abstract methods as it will void the rule of one abstract method per functional interface

## Lambda expressions

Lambda expressions basically express instances of **[functional interfaces](https://www.geeksforgeeks.org/functional-interfaces-java/)** (An interface with single abstract method is called functional interface. An example is java.lang.Runnable). lambda expressions implement the only abstract function and therefore implement functional interfaces

Lambda expressions are added in Java 8 and provide below functionalities.

- Enable to treat functionality as a method argument, or code as data.
- A function that can be created without belonging to any class.
- A lambda expression can be passed around as if it was an object and executed on demand.

```java
// Java program to demonstrate lambda expressions
// to implement a user defined functional interface.

// A sample functional interface (An interface with
// single abstract method
interface FuncInterface
{
	// An abstract function
	void abstractFun(int x);

	// A non-abstract (or default) function
	default void normalFun()
	{
	System.out.println("Hello");
	}
}

class Test
{
	public static void main(String[] args)
	{
		// lambda expression to implement above
		// functional interface. This interface
		// by default implements abstractFun()
		FuncInterface fobj = (int x)->System.out.println(2*x);

		// This calls above lambda expression and prints 10.
		fobj.abstractFun(5);
	}
}
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/1442eaff-c54e-4c4b-8a2d-2850d868f9e3/f9698954-712f-4a9d-a49a-8afeac54d20c/Untitled.png)

Syntax:

```java
lambda operator -> body
```

      where lambda operator can be:

- **Zero parameter:**

    ```
    () -> System.out.println("Zero parameter lambda");
    ```

- **One parameter:**–

    ```
    (p) -> System.out.println("One parameter: " + p);
    ```


A Java program to demonstrate working of lambda expression with two arguments.

```java
// Java program to demonstrate working of lambda expressions
public class Test {
    // operation is implemented using lambda expressions
    interface FuncInter1 {
        int operation(int a, int b);
    }

    // sayMessage() is implemented using lambda expressions
    // above
    interface FuncInter2 {
        void sayMessage(String message);
    }

    // Performs FuncInter1's operation on 'a' and 'b'
    private int operate(int a, int b, FuncInter1 fobj) {
        return fobj.operation(a, b);
    }

    public static void main(String[] args) {
        // lambda expression for addition for two parameters
        // data type for x and y is optional.
        // This expression implements 'FuncInter1' interface
        FuncInter1 add = (int x, int y) -> x + y;

        // lambda expression multiplication for two parameters
        // This expression also implements 'FuncInter1' interface
        FuncInter1 multiply = (int x, int y) -> x * y;

        // Creating an object of Test to call operate using
        // different implementations using lambda Expressions
        Test tobj = new Test();

        // Add two numbers using lambda expression
        System.out.println("Addition is " +
                tobj.operate(6, 3, add));

        // Multiply two numbers using lambda expression
        System.out.println("Multiplication is " +
                tobj.operate(6, 3, multiply));

        // lambda expression for single parameter
        // This expression implements 'FuncInter2' interface
        FuncInter2 fobj = message -> System.out.println("Hello "
                + message);
        fobj.sayMessage("Geek");
    }
}
```

## Method references

Java provides a new feature called method reference in Java 8. Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.

You can refer to a method of a functional interface and later invoke the body of the method.

There are following types of method references in java:

1. Reference to a static method.

   Syntax:

   > ContainingClass::staticMethodName
   >

   If a Lambda expression is like:

    ```java
    interface Sayable{  
        void say();  
    }  
    public class MethodReference {  
        public static void saySomething(){  
            System.out.println("Hello, this is static method.");  
        }  
        public static void main(String[] args) {  
            // Referring static method  
            Sayable sayable = MethodReference::saySomething;  
            // Calling interface method  
            sayable.say();  
        }  
    }
    ```

2. Reference to an instance method.

   Syntax:

   > containingObject::instanceMethodName
   >

    ```java
    interface Sayable{  
        void say();  
    }  
    public class InstanceMethodReference {  
        public void saySomething(){  
            System.out.println("Hello, this is non-static method.");  
        }  
        public static void main(String[] args) {  
            InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object  
            // Referring non-static method using reference  
                Sayable sayable = methodReference::saySomething;  
            // Calling interface method  
                sayable.say();  
                // Referring non-static method using anonymous object  
                Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also  
                // Calling interface method  
                sayable2.say();  
        }  
    }
    ```

3. Reference to a constructor.

   Syntax:

   > ClassName::**new**
   >

    ```java
    interface Messageable{  
        Message getMessage(String msg);  
    }  
    class Message{  
        Message(String msg){  
            System.out.print(msg);  
        }  
    }  
    public class ConstructorReference {  
        public static void main(String[] args) {  
            Messageable hello = Message::new;  
            hello.getMessage("Hello");  
        }  
    }
    ```


## Stream API

Java provides a new additional package in Java 8 called java.util.stream.

A stream is an abstraction to express data processing queries in a declarative way.

This package consists of classes, interfaces and enum to allows functional-style operations on the elements.

- Stream does not store elements. It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.
- Stream is functional in nature. Operations performed on a stream does not modify it's source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
- Stream is lazy and evaluates code only when required.
- The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.

Components of the stream are:

- A data source
- Set of Intermediate Operations to process the data source
- Single Terminal Operation that produces the result

```java
import java.util.*;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));

				//Without Stream  
        List<Float> productPriceList = new ArrayList<Float>();  
        for(Product product: productsList){  
              
            // filtering data of list  
            if(product.price<30000){  
                productPriceList.add(product.price);    // adding price to a productPriceList  
            }  
        }  
        System.out.println(productPriceList);   // displaying data  

		//With Stream
		List<Float> productPriceList2 =productsList.stream()  
                                     .filter(p -> p.price > 30000)// filtering data  
                                     .map(p->p.price)        // fetching price  
                                     .collect(Collectors.toList()); // collecting as list  
        System.out.println(productPriceList2);
    }  
}
```

- **forEach**

Stream has provided a new method ‘forEach’ to iterate each element of the stream. The following code segment shows how to print 10 random numbers using forEach.

```java
Random random = new Random();
random.ints().limit(10).forEach(System.out::println);
```

- **map**

The ‘map’ method is used to map each element to its corresponding result. The following code segment prints unique squares of numbers using map.

```java
List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

//get list of unique squares
List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
```

- **filter**

The ‘filter’ method is used to eliminate elements based on a criteria. The following code segment prints a count of empty strings using filter.

```java
List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

//get count of empty string
int count = strings.stream().filter(string -> string.isEmpty()).count();
```

- **limit**

The ‘limit’ method is used to reduce the size of the stream. The following code segment shows how to print 10 random numbers using limit.

```java
Random random = new Random();
random.ints().limit(10).forEach(System.out::println);
```

- **sorted**

The ‘sorted’ method is used to sort the stream. The following code segment shows how to print 10 random numbers in a sorted order.

```java
Random random = new Random();
random.ints().limit(10).sorted().forEach(System.out::println);
```

- **Parallel Processing**

parallelStream is the alternative of stream for parallel processing. Take a look at the following code segment that prints a count of empty strings using parallelStream.

```java
List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

//get count of empty string
long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
```

It is very easy to switch between sequential and parallel streams.

- **Collectors**

Collectors are used to combine the result of processing on the elements of a stream. Collectors can be used to return a list or a string.

```java
List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

System.out.println("Filtered List: " + filtered);
String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
System.out.println("Merged String: " + mergedString);
```

## Default methods in interface

Java provides a facility to create default methods inside the interface. Methods which are defined inside the interface and tagged with default are known as default methods. These methods are non-abstract methods.

Default methods were introduced in Java 8 to have 'Backward Compatibility in case JDK modifies any interfaces. In case a new abstract method is added to the interface, all classes implementing the interface will break and will have to implement the new method. With default methods, there will not be any impact on the interface implementing classes. default methods can be overridden if needed in the implementation.

```java
interface Sayable{  
    // Default method   
    default void say(){  
        System.out.println("Hello, this is default method");  
    }  
    // Abstract method  
    void sayMore(String msg);  
}  
public class DefaultMethods implements Sayable{  
    public void sayMore(String msg){        // implementing abstract method   
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
        DefaultMethods dm = new DefaultMethods();  
        dm.say();   // calling default method  
        dm.sayMore("Work is worship");  // calling abstract method  
  
    }  
}
```

## Static methods in interface

You can also define static methods inside the interface. Static methods are used to define utility methods.

```java
interface Sayable{    
    // default method    
    default void say(){    
        System.out.println("Hello, this is default method");    
    }    
    // Abstract method    
    void sayMore(String msg);    
    // static method    
    static void sayLouder(String msg){    
        System.out.println(msg);    
    }    
}    
public class DefaultMethods implements Sayable{    
    public void sayMore(String msg){     // implementing abstract method    
        System.out.println(msg);    
    }    
    public static void main(String[] args) {    
        DefaultMethods dm = new DefaultMethods();    
        dm.say();                       // calling default method    
        dm.sayMore("Work is worship");      // calling abstract method    
        Sayable.sayLouder("Helloooo...");   // calling static method    
    }    
}
```

## **Optional class**

- Every Java Programmer is familiar with **[NullPointerException](https://www.geeksforgeeks.org/null-pointer-exception-in-java/)**. It can crash your code. And it is very hard to avoid it without using too many null checks.
- So, to overcome this, Java 8 has introduced a new class Optional in **java.util package**.
- It can help in writing a neat code without using too many null checks. By using Optional, we can specify alternate values to return or alternate code to run.
- This makes the code more readable because the facts which were hidden are now visible to the developer.

    ```java
    import java.util.Optional;
    
    public class Java8Tester {
    
       public static void main(String[] args) {
          Java8Tester java8Tester = new Java8Tester();
          Integer value1 = null;
          Integer value2 = Integer.valueOf(10);
    		
          //Optional.ofNullable - allows passed parameter to be null.
          Optional<Integer> a = Optional.ofNullable(value1);
    		
          //Optional.of - throws NullPointerException if passed parameter is null
          Optional<Integer> b = Optional.of(value2);
          System.out.println(java8Tester.sum(a,b));
       }
    	
       public Integer sum(Optional<Integer> a, Optional<Integer> b) {
          //Optional.isPresent - checks the value is present or not
    		
          System.out.println("First parameter is present: " + a.isPresent());
          System.out.println("Second parameter is present: " + b.isPresent());
    		
          //Optional.orElse - returns the value if present otherwise returns
          //the default value passed.
          Integer value1 = a.orElse(Integer.valueOf(0));
    		
          //Optional.get - gets the value, value should be present
          Integer value2 = b.get();
          return value1 + value2;
       }
    }
    
    Output:
    First parameter is present: false
    Second parameter is present: true
    10
    ```


## **What is MetaSpace? How does it differ from PermGen?**

!https://s3.ap-south-1.amazonaws.com/myinterviewtrainer-domestic/public_assets/assets/000/000/183/original/Java_8_MetaSpace.jpg?1615976965

**PermGen:** MetaData information of classes was stored in PremGen (Permanent-Generation) memory type before Java 8. PremGen is fixed in size and cannot be dynamically resized. It was a contiguous Java Heap Memory.

**MetaSpace:** Java 8 stores the MetaData of classes in native memory called 'MetaSpace'. It is not a contiguous Heap Memory and hence can be grown dynamically which helps to overcome the size constraints. This improves the garbage collection, auto-tuning, and de-allocation of metadata

## **What are some standard Java pre-defined functional interfaces?**

**Runnable:** use to execute the instances of a class over another thread with no arguments and no return value.

**Callable:** use to execute the instances of a class over another thread with no arguments and it either returns a value or throws an exception.

**Comparator:** use to sort different objects in a user-defined order

**Comparable:** use to sort objects in the natural sort order

## **What are the various categories of pre-defined function interfaces?**

**Function:** To transform arguments in returnable value.

**Predicate:** To perform a test and return a Boolean value.

**Consumer:** Accept arguments but do not return any values.

**Supplier:** Do not accept any arguments but return a value.

**Operator:** Perform a reduction type operation that accepts the same input types

## **What is a type inference?**

Type inference is available even in earlier versions of Java. It is used to infer the type of argument by the compiler at the compile time by looking at method invocation and corresponding declaration

## Notes

Map applies a function to each element of a list and returns a new list with the results.

**`flatMap`** is useful for transforming lists of data and flattening the resulting lists into a single list.

**`reduce`** is useful for performing a computation on a list and reducing it to a single value.

Both **`map`** and **`flatMap`** are useful for transforming lists of data, but **`flatMap`** is particularly useful when you want to apply a function that returns a list to each element of a list and then flatten the resulting list of lists.

Add more:

https://www.interviewbit.com/java-8-interview-questions/