### **Introduction**

Big O Notation is a way to measure an algorithm’s efficiency. It measures the time it takes to run your function as the input grows. Or in other words, how well does the function scale, meaning the growth of runtime relative to input size.

There are two parts to measuring efficiency — time complexity and space complexity. Time complexity is a measure of how long the function takes to run in terms of its computational steps. Space complexity has to do with the amount of memory used by the function.

---

### ****Algorithm Analysis****

Analysis of efficiency of an algorithm can be performed at two different stages, before implementation and after implementation, as

- A priori analysis − This is defined as theoretical analysis of an algorithm. Efficiency of algorithm is measured by assuming that all other factors e.g. speed of processor, are constant and have no effect on implementation.
- A posterior analysis − This is defined as empirical analysis of an algorithm. The chosen algorithm is implemented using programming language. Next the chosen algorithm is executed on target computer machine. In this analysis, actual statistics like running time and space needed are collected.

Algorithm analysis is dealt with the execution or running time of various operations involved. Running time of an operation can be defined as number of computer instructions executed per operation

### **Algorithm Complexity**

Suppose X is treated as an algorithm and N is treated as the size of input data, the time and space implemented by the Algorithm X are the two main factors which determine the efficiency of X.

- Time Factor − The time is calculated or measured by counting the number of key operations such as comparisons in sorting algorithm.
- Space Factor − The space is calculated or measured by counting the maximum memory space required by the algorithm.

The complexity of an algorithm f(N) provides the running time and / or storage space needed by the algorithm with respect of N as the size of input data.

### ****Asymptotic Functions****

The term 'asymptotic' describes an expression where a variable exists whose value tends to infinity. In short, asymptotic functions are used to describe the behavior of algorithms as the input size grows indefinitely.

The purpose of asymptotic functions is to allow us to make predictions about the behavior of algorithms without having to actually run them on large inputs.

Using asymptotic notations, we analyze the complexities of an algorithm and its performance. Using the asymptotic notations, we determine and show the complexities after analyzing it.

Therefore, there are three types of asymptotic notations through which we can analyze the complexities of the algorithms:

- **Big O Notation (O):** It represents the **upper bound** of the runtime of an algorithm. Big O Notation's role is to calculate the longest time an algorithm can take for its execution, i.e., it is used for calculating the **worst-case time** complexity of an algorithm.
- **Omega Notation (Ω(n)):** It represents the **lower bound** of the runtime of an algorithm. It is used for calculating the best time an algorithm can take to complete its execution, i.e., it is used for measuring the **best case time** complexity of an algorithm.
- **Theta Notation (Θ(n)):** It carries the middle characteristics of both Big O and Omega notations as it represents the **lower and upper bound** of an algorithm. It is used for measuring the **average case time** complexity of an algorithm.

---

### **Advantages of Big O Notation**

1. Big-O notation allows you to compare the efficiency of different algorithms.
2. It helps you to choose the most efficient algorithm for a given problem.
3. It allows you to identify the most time-consuming parts of your code.
4. It helps you to focus your optimization efforts on the parts of your code that will have the biggest impact on performance.
5. It can lead to more efficient and performant code.
6. It can help you to make more informed decisions about which algorithms to use.
7. It helps in debugging code and figuring out reasons for slow performance, crashes, identifying parts of the code that are inefficient and identifying pain points.

---

### **List of Time complexity notations**

![Big+O+Notation+Summary+(1).jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e135c249-2e93-47ab-91fe-873c07e10c85/BigONotationSummary(1).jpg)

1. ****Constant Time Algorithms – *O(1)***

   How does this input size of an algorithm affect its running time? **Key to understanding Big O is understanding the rates at which things can grow.** The rate in question here is **time taken per input size.**

   Consider this simple piece of code:

    ```java
    int n = 1000;
    System.out.println("Hey - your input is: " + n);
    ```

   Clearly, it doesn't matter what *n* is, above. This piece of code takes a constant amount of time to run. It's not dependent on the size of n.

   Similarly:

    ```java
    int n = 1000;
    System.out.println("Hey - your input is: " + n);
    System.out.println("Hmm.. I'm doing more stuff with: " + n);
    System.out.println("And more: " + n);
    ```

   The above example is also constant time. Even if it takes 3 times as long to run, it *doesn't depend on the size of the input, n.* We denote constant time algorithms as follows: *O(1)*. Note that *O(2)*, *O(3)* or even *O(1000)* would mean the same thing.

   We don't care about exactly how long it takes to run, only that it takes constant time.
    
   ---

2. ****Logarithmic Time Algorithms – *O(log n)***

   Constant time algorithms are (asymptotically) the quickest. **Logarithmic time is the next quickest.** Unfortunately, they're a bit trickier to imagine.

   One common example of a logarithmic time algorithm is the [binary search](https://en.wikipedia.org/wiki/Binary_search_algorithm) algorithm. To see how to implement binary search in Java, [click here.](https://www.baeldung.com/java-binary-search)

   What is important here is that the **running time grows in proportion to the logarithm of the input (in this case, log to the base 2):**

    ```java
    for (int i = 1; i < n; i = i * 2){
        System.out.println("Hey - I'm busy looking at: " + i);
    }
    ```

   If *n* is 8, the output will be the following:

    ```java
    Hey - I'm busy looking at: 1
    Hey - I'm busy looking at: 2
    Hey - I'm busy looking at: 4
    ```

   Our simple algorithm ran log(8) = 3 times.
    
   ---

3. ****Linear Time Algorithms – *O(n)***

   After logarithmic time algorithms, we get the next fastest class: **linear time algorithms.**

   If we say something grows linearly, we mean that it grows directly proportional to the size of its inputs.

   Think of a simple for loop:

    ```java
    for (int i = 0; i < n; i++) {
        System.out.println("Hey - I'm busy looking at: " + i);
    }
    ```

   How many times does this for loop run? *n* times, of course! We don't know exactly how long it will take for this to run – and we don't worry about that.

   **What we do know is that the simple algorithm presented above will grow linearly with the size of its input.**

   We'd prefer a run time of *0.1n* than *(1000n + 1000)*, but both are still linear algorithms; they both grow directly in proportion to the size of their inputs.

   Again, if the algorithm was changed to the following:

    ```java
    for (int i = 0; i < n; i++) {
        System.out.println("Hey - I'm busy looking at: " + i);
        System.out.println("Hmm.. Let's have another look at: " + i);
        System.out.println("And another: " + i);
    }
    ```

   The runtime would still be linear in the size of its input, *n*. We denote linear algorithms as follows: *O(n)*.

   As with the constant time algorithms, we don't care about the specifics of the runtime. ***O(2n+1)* is the same as *O(n)***, as Big O Notation concerns itself with growth for input sizes.
    
   ---

4. ****N Log N Time Algorithms – *O(n log n)***

   ***n log n* is the next class of algorithms.** The running time grows in proportion to *n log n* of the input:

    ```java
    for (int i = 1; i <= n; i++){
    for(int j = 1; j < n; j = j * 2) {
            System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
        }
    }
    
    ```

   For example, if the *n* is 8, then this algorithm will run *8 * log(8) = 8 * 3 = 24* times. Whether we have strict inequality or not in the for loop is irrelevant for the sake of a Big O Notation.
    
   ---

5. ****Polynomial Time Algorithms – *O(n^p)***

   Next up we've got polynomial time algorithms. These algorithms are even slower than *n log n* algorithms.

   The term polynomial is a general term which contains quadratic *(n^2)*, cubic *(n^3)*, quartic *(n4)*, etc. functions. **What's important to know is that *O(n^2)* is faster than *O(n^3)* which is faster than *O(n^4)*, etc.**

   Let's have a look at a simple example of a quadratic time algorithm:

    ```java
    for (int i = 1; i <= n; i++) {
    for(int j = 1; j <= n; j++) {
            System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
        }
    }
    
    ```

   This algorithm will run *8^2 = 64* times. Note, if we were to nest another for loop, this would become an *O(n^3)* algorithm.
    
   ---

6. ****Exponential Time Algorithms – *O(*k^*n)***

   Now we are getting into dangerous territory; these algorithms grow in proportion to some factor exponentiated by the input size.

   For example, ***O(2^n)* algorithms double with every additional input.** So, if *n = 2*, these algorithms will run four times; if *n = 3*, they will run eight times (kind of like the opposite of logarithmic time algorithms).

   ***O(3^n)* algorithms triple with every additional input, *O(k^n)* algorithms will get k times bigger with every additional input.**

   Let's have a look at a simple example of an *O(2^n)* time algorithm:

    ```java
    for (int i = 1; i <= Math.pow(2, n); i++){
        System.out.println("Hey - I'm busy looking at: " + i);
    }
    ```

   This algorithm will run *2^8 = 256* times.
    
   ---

7. ****Factorial Time Algorithms – *O(n!)***

   In most cases, this is pretty much as bad as it'll get. This class of algorithms has a run time proportional to the [factorial](https://en.wikipedia.org/wiki/Factorial) of the input size.

   A classic example of this is solving the [traveling salesman](https://en.wikipedia.org/wiki/Travelling_salesman_problem) problem using a brute-force approach to solve it.

   An explanation of the solution to the traveling salesman problem is beyond the scope of this article.

   Instead, let's look at a simple *O(n!)* algorithm, as in the previous sections:

    ```java
    for (int i = 1; i <= factorial(n); i++){
        System.out.println("Hey - I'm busy looking at: " + i);
    }Copy
    ```

   where *factorial(n)* simply calculates n!. If n is 8, this algorithm will run *8! = 40320* times.
    
   ---


### **Examples of Time complexity**

As we know that the runtime performance of an algorithm depends on the input size of n. Let's see some mathematical examples for making the runtime analysis of an algorithm for different size of n:

- If input size is 20,
    - n = 20
    - log (20) = 2.996;
    - 20 = 20;
    - 20 log (20) = 59.9;
    - 20^2 = 400;
    - 2^20 = 1084576;
    - 20! = 2.432902 + 18^18;

- If input size is 10,
    - n = 10
    - log (10) = 1;
    - 10 = 10;
    - 10 log (10) = 10;
    - 10^2 = 100;
    - 2^10 = 1024;
    - 10! = 3628800;

---

### Tips for calculating Time Complexity

1. Identify the most dominant operation in the function. This is typically the operation that is performed most frequently, and has the greatest impact on the overall time complexity of the function.
2. Determine how the **number of times that this operation is performed** depends on the size of the input. For example, if the operation is performed once for each element in the input, the time complexity would be O(n), where n is the size of the input.
3. Drop constants and non-dominant terms. Constants refer to values that do not change based on the size of the input, and can be ignored when determining the time complexity. Non-dominant terms refer to operations that are performed less frequently than the dominant operation, and can also be ignored.
    1. In O(2n + 3), the "3" term is a constant.
    2. In O(n^2 + log n), the log n term is a non-dominant term.
    3. In O(n^3 + sqrt(n)), the sqrt(n) term is a non-dominant term.

---

### **Time complexities of data structures**

| Data structure | Access | Search | Insertion | Deletion |
| --- | --- | --- | --- | --- |
| Arrays | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) |
| Singly Linked List | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) |
| Circular Singly Linked List | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) |
| Doubly linked list | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) |
| Doubly Circular Linked List | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) |
| Stack | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) |
| Queue | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(n)
c. Worst case: O(n) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) | a. Best case: O(1)
b. Average case: O(1)
c. Worst case: O(1) |
| Hashtable | Best case: O(1)
Average case: O(1)
Worst case: O(n) | Best case: O(1)
Average case: O(1)
Worst case: O(n) | Best case: O(1)
Average case: O(1)
Worst case: O(n) | Best case: O(1)
Average case: O(1)
Worst case: O(n) |
| Tree | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) |
| Binary Tree | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) |
| Binary Search Tree | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(n) |
| AVL Tree (well balanced) | Best case: O(log n)
Average case: O(log n)
Worst case: O(log n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(log n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(log n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(log n) |
| Binary Heap | Best case: O(1)
Average case: O(1)
Worst case: O(1) | Best case: O(n)
Average case: O(n)
Worst case: O(n) | Best case: O(1)
Average case: O(log n)
Worst case: O(log n) | Best case: O(log n)
Average case: O(log n)
Worst case: O(log n) |
| Trie | Best case: O(m)
Average case: O(m)
Worst case: O(m) | Best case: O(m)
Average case: O(m)
Worst case: O(m) | Best case: O(m)
Average case: O(m)
Worst case: O(m) | Best case: O(m)
Average case: O(m)
Worst case: O(m) |

### **Time complexities of algorithms implemented using arrays**

| Algorithms | Best case | Average case | Worst case |
| --- | --- | --- | --- |
| Bubble sort | O(n) | O(n^2) | O(n^2) |
| Selection sort | O(n^2) | O(n^2) | O(n^2) |
| Insertion sort | O(n) | O(n^2) | O(n^2) |
| Bucket sort | O(n + k) | O(n + k) | O(n^2) |
| Merge sort | O(n * log(n)) | O(n * log(n)) | O(n * log(n)) |
| Quick sort | O(n * log(n)) | O(n * log(n)) | O(n^2) |
| Heap sort | O(n * log(n)) | O(n * log(n)) | O(n * log(n)) |
| Linear search | O(1) | O(n) | O(n) |
| Binary search | O(1) | O(log(n)) | O(log(n)) |
| Breadth first search | O(V + E) | O(V + E) | O(V + E) |
| Depth first search | O(V + E) | O(V + E) | O(V + E) |
| Topological sort | O(V + E) | O(V + E) | O(V + E) |
| Djikstra’s algorithm | O(E * log(V)) | O(E * log(V)) | O(E * log(V)) |
| Bellman-ford algorithm | O(V * E) | O(V * E) | O(V * E) |
| Floyd warshall algorithm | O(V^3) | O(V^3) | O(V^3) |
| Minimum spanning tree | O(E * log(E)) | O(E * log(E)) | O(E * log(E)) |
| Kruksal algorithm | O(E * log(E)) | O(E * log(E)) | O(E * log(E)) |

### **Space Complexity**

Space complexity is the amount of memory required by an algorithm to run to completion.

The purpose of analyzing the space complexity of an algorithm is to determine how much memory it will need in order to run, and to understand how the algorithm's memory usage will scale as the size of the input increases.

One of the main benefits of analyzing space complexity is that it can help identify algorithms that may not be suitable for use in certain situations because they require too much memory. For example, if an algorithm has a high space complexity, it may not be practical to use it on very large inputs because it would require an impractical amount of memory to run.

Another benefit of analyzing space complexity is that it can help us to understand the trade-offs between space and time complexity. In many cases, an algorithm that has a low time complexity (i.e. it runs quickly) may have a high space complexity, and vice versa. Understanding these trade-offs can help us to choose the right algorithm for a given situation.

### List of Space complexity notations

1. O(1) - Constant space complexity: the amount of memory required by the algorithm is independent of the size of the input.
2. O(n) - Linear space complexity: the amount of memory required by the algorithm is directly proportional to the size of the input.
3. O(n^2) - Quadratic space complexity: the amount of memory required by the algorithm is proportional to the square of the size of the input.
4. O(log n) - Logarithmic space complexity: the amount of memory required by the algorithm increases logarithmically with the size of the input.
5. O(n log n) - Linear logarithmic space complexity: the amount of memory required by the algorithm is proportional to the size of the input and the logarithm of the size of the input.
6. O(2^n) - Exponential space complexity: the amount of memory required by the algorithm increases exponentially with the size of the input.
7. O(n!) - Factorial space complexity: the amount of memory required by the algorithm is proportional to the factorial of the size of the input.

### Tips for calculating Space complexity

1. Focus on the variables created and used by the algorithm or data structure, and how much memory they take up.
2. Consider how the amount of memory used by the algorithm or data structure scales with the input size.
3. Remember that you can drop constants and constraints when calculating space complexity, just like with time complexity.
4. Pay attention to the data structures used by the algorithm, as these can have a significant impact on its space complexity.
5. Consider the worst-case scenario when calculating space complexity, as this will give you the upper bound on the amount of memory used by the algorithm.
6. Be careful not to count memory that is shared by multiple parts of the algorithm, as this will be counted multiple times and can lead to an overestimate of the space complexity.
7. When calculating space complexity, it's important to consider the worst-case scenario because this gives you the upper bound on the amount of memory that will be used by the algorithm or data structure. In other words, the space complexity in the worst-case scenario is the maximum amount of memory that the algorithm or data structure could possibly use, regardless of the input it receives.

### **Space complexities of data structures**

| Data structure | Access | Search | Insertion | Deletion |
| --- | --- | --- | --- | --- |
| Arrays | O(1) | O(n) | O(n) | O(n) |
| Singly Linked List | O(n) | O(n) | O(1) | O(1) |
| Circular Singly Linked List | O(n) | O(n) | O(1) | O(1) |
| Doubly linked list | O(n) | O(n) | O(1) | O(1) |
| Doubly Circular Linked List | O(n) | O(n) | O(1) | O(1) |
| Stack | O(n) | O(n) | O(1) | O(1) |
| Queue | O(n) | O(n) | O(1) | O(1) |
| Hashtable | O(1) | O(1) | O(1) | O(1) |
| Tree | O(n) | O(n) | O(n) | O(n) |
| Binary Tree | O(n) | O(n) | O(n) | O(n) |
| Binary Search Tree | O(n) | O(n) | O(n) | O(n) |
| AVL Tree | O(log(n)) | O(log(n)) | O(log(n)) | O(log(n)) |
| Binary Heap | O(n) | O(n) | O(log(n)) | O(log(n)) |
| Trie | O(m) | O(m) | O(m) | O(m) |

### **Space complexities of algorithms implemented using arrays**

| Algorithms | Worst case |
| --- | --- |
| Bubble sort | O(n^2) |
| Selection sort | O(n^2) |
| Insertion sort | O(n^2) |
| Bucket sort | O(n) |
| Merge sort | O(n log n) |
| Quick sort | O(n^2) |
| Heap sort | O(n log n) |
| Linear search | O(n) |
| Binary search | O(log n) |
| Breadth first search | O(n) |
| Depth first search | O(n) |
| Topological sort | O(n + m) |
| Djikstra’s algorithm | O(n^2) |
| Bellman-ford algorithm | O(n^2) |
| Floyd warshall algorithm | O(n^3) |
| Minimum spannin tree | O(n^2) |
| Kruksal algorithm | O(n log n) |

### **Interview questions:**

### **More Links:**

- [Plain english explanation - stack overflow](https://stackoverflow.com/a/487278)
- [Time Complexity](https://www.baeldung.com/java-algorithm-complexity#overview)
- [Space Complexity](https://www.baeldung.com/cs/space-complexity#intro)
- https://www.tutorialspoint.com/time-and-space-complexity-in-data-structure