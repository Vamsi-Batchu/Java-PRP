This Repo is to add all the learnings and code snippets done in JAVA PRP 

# Java 5-Day Bootcamp: Detailed Curriculum

## Day 1: Java Basics & OOP Fundamentals

### Setup

* **Install JDK 17**: Download and install JDK 17 from the Oracle or OpenJDK site.
* **IDE Setup**: Set up IntelliJ IDEA / Eclipse / VS Code with Java support.

### Java Environment

* **JVM (Java Virtual Machine)**: Executes Java bytecode.
* **JDK (Java Development Kit)**: Contains tools for Java development.
* **JRE (Java Runtime Environment)**: Contains JVM and runtime libraries.

### Syntax and Language Fundamentals

* **Variables and Data Types**: int, float, char, boolean, etc.
* **Operators**: Arithmetic, Relational, Logical, etc.
* **Control Flow**: if-else, switch, for loop, while loop, do-while loop.

### Functions & Method Overloading

* Define methods using return types and parameters.
* Overloading allows methods with the same name but different signatures.

### OOP Basics

* **Classes and Objects**: Fundamental building blocks.
* **Encapsulation**: Using access modifiers and getters/setters to protect data.

### Hands-on

* Write a `Student` class with fields like `name`, `rollNo`, `marks`, and appropriate methods.

---

## Day 2: Advanced OOP & Collections

### OOP Concepts

* **Inheritance**: Allows class to inherit fields and methods from another class.
* **Method Overriding**: Subclass redefines a method of its superclass.
* **Polymorphism**: Ability to take many forms (compile-time and run-time).
* **Abstract Classes & Interfaces**: Abstract classes can have method definitions. Interfaces define method contracts.
* **Sealed Classes (Java 17)**: Restrict which classes can extend or implement them.

### Collections Framework

* **List**: Ordered collection (ArrayList, LinkedList).
* **Set**: Unordered collection with no duplicates (HashSet, TreeSet).
* **Map**: Key-value pairs (HashMap, TreeMap).

### Streams API

* Use `filter()`, `map()`, `reduce()`, `collect()` for functional-style operations on collections.


---

## Day 3: Exception Handling & Multithreading

### Exception Handling

* **try-catch-finally**: Basic block for exception handling.
* **throw & throws**: Throw exceptions manually and declare possible exceptions.
* **Custom Exceptions**: User-defined exceptions.

### Logging

* Use **SLF4J**, **Log4j** to log messages at different levels (INFO, WARN, ERROR).

### Multithreading

* **Thread class and Runnable interface**: For creating threads.
* **Executors**: Thread pools for managing multiple threads.
* **Virtual Threads (Java 17 Preview)**: Lightweight threads to scale concurrency.


---

## Day 4: File Handling & Functional Programming

### File Handling

* **Files API**: Read/write files using `Files.readAllLines()`, `Files.write()`.
* **BufferedReader**: Efficient way to read large files line by line.

### Functional Programming

* **Lambda Expressions**: Anonymous functions.
* **Functional Interfaces**: Interfaces with a single abstract method (`Predicate`, `Consumer`, `Function`, etc).
* **Pattern Matching for instanceof (Java 17)**: More concise instanceof checks.
* **Records (Java 14+)**: Immutable data classes with compact syntax.
* **Text Blocks (Java 15)**: Multiline string literals using `"""`.

---

## Day 5: Mini Project & Java 17 Best Practices

### Mini Project: Library Management System

* **Features**:

  * Add and remove books.
  * Borrow and return books.
  * Store book data in a file.
  * Use streams to filter/display available books.

### Java 17 Features Recap

* Sealed Classes
* Pattern Matching for `instanceof`
* Records
* Text Blocks
* Virtual Threads (Preview)

### Best Practices

* Follow naming conventions.
* Keep classes/methods small and focused.
* Use logging instead of `System.out.println()`.
* Handle exceptions gracefully.
* Follow SOLID principles.
* Write unit tests.

### Code Reviews & Debugging

* Use IDE breakpoints to debug.
* Perform code reviews for readability, structure, and performance.

---

This 5-day bootcamp is designed to provide a strong foundation in core Java, modern features introduced in recent versions, and hands-on experience with real-world scenarios.
