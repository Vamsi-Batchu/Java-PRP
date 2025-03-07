# Day 1: Java Basics & OOP Fundamentals

## Understanding how Java works

Jave Code is execution happens in three main steps:

### 🛠 JDK (Java Development Kit)
The JDK is the full package needed to write, compile, and execute Java programs.
It includes:
- JRE (Java Runtime Environment) – Needed to run Java applications.
- Compiler (javac) – Converts source code (.java) into bytecode (.class).
- Debugger, Documentation tools, and Libraries.

### 🔥 JRE (Java Runtime Environment)
Provides the runtime libraries and supports the execution of Java programs.
Contains the JVM (Java Virtual Machine) and the Java Class Library (JCL).

### 🏗 JVM (Java Virtual Machine)
The JVM executes Java bytecode and converts it into machine-specific instructions.
It handles memory management, garbage collection, and security.
Java is platform-independent because the same bytecode runs on different operating systems through their respective JVM implementations


## Summary for Understanding JAVA Ecosystem. (How JDK, JRE, and JVM Work Together)

- You write code in Java (JDK).
- The Java compiler (javac) converts it into bytecode (JRE).
- The JVM interprets and runs the bytecode on the target machine.


## Basics

### Run a Hello World Program and know the syntax

```
// Java Program to demonstrate the
// syntax of the main() function

class Example {
    public static void main(String[] args)
    {
        System.out.println("Hello World");
    }
}
```

Class: Defines the structure of objects (data + behavior).
Object: A real-world instance of a class

A class is a template, and objects are the actual data stored in memory.
Multiple objects of a class can interact with each other.

## Data Types: 

There are two types of data types: 

- __Primitive Data Type__: such as boolean, char, int, short, byte, long, float, and double. The Boolean with uppercase B is a wrapper class for the primitive data type boolean in Java.
- __Non-Primitive Data Type or Object Data type__: such as String, Array, etc


## Variables

Variables are the containers for storing the data values or you can also call it a memory location name for the data. Every variable has a:

- Data Type – The kind of data that it can hold. For example, int, string, float, char, etc.
- Variable Name – To identify the variable uniquely within the scope.
- Value – The data assigned to the variable.


### **There are three types of variables in Java – Local, Instance, and Static.**


datatype: In Java, a data type define the type of data that a variable can hold. 

data_name: Name was given to the variable. 

value: the value that is going to be assigned to the varaible (data_name)

```
// Declaring float variable
float simpleInterest; 

// Declaring and initializing integer variable
int time = 10, speed = 20; 

// Declaring and initializing character variable
char var = 'h'; 

```


## Operators

# Java Operators

## 1. Compound Assignment Operators

| Operator | Expression | Equivalent To | Meaning |
|----------|------------|---------------|---------|
| `%=`    | `x %= 3`   | `x = x % 3`   | Remainder when `x` is divided by `3` |
| `&=`    | `x &= 3`   | `x = x & 3`   | Bitwise AND with `3` |
| `|=`    | `x |= 3`   | `x = x | 3`   | Bitwise OR with `3` |
| `^=`    | `x ^= 3`   | `x = x ^ 3`   | Bitwise XOR with `3` |
| `>>=`   | `x >>= 3`  | `x = x >> 3`  | Right shift by `3` (divides by `2^3 = 8`) |
| `<<=`   | `x <<= 3`  | `x = x << 3`  | Left shift by `3` (multiplies by `2^3 = 8`) |

---

## 2. Arithmetic Assignment Operators

| Operator | Expression | Equivalent To | Meaning |
|----------|------------|---------------|---------|
| `=`     | `x = 5`   | `x = 5`       | Assigns `5` to `x` |
| `+=`    | `x += 3`  | `x = x + 3`   | Adds `3` to `x` |
| `-=`    | `x -= 3`  | `x = x - 3`   | Subtracts `3` from `x` |
| `*=`    | `x *= 3`  | `x = x * 3`   | Multiplies `x` by `3` |
| `/=`    | `x /= 3`  | `x = x / 3`   | Divides `x` by `3` (integer or floating-point) |

---

## 3. Arithmetic Operators

| Operator | Meaning | Example (`x = 10, y = 3`) | Result |
|----------|---------|-----------------|--------|
| `+`      | Addition | `x + y` | `13` |
| `-`      | Subtraction | `x - y` | `7` |
| `*`      | Multiplication | `x * y` | `30` |
| `/`      | Division | `x / y` | `3` (integer division) |
| `%`      | Modulus (Remainder) | `x % y` | `1` |

---

## 4. Unary Operators

| Operator | Meaning | Example (`x = 5`) | Result |
|----------|----------|--------------------|--------|
| `+`      | Positive (default behavior) | `+x` | `5` |
| `-`      | Negative | `-x` | `-5` |
| `++`     | Increment (adds 1) | `x++` or `++x` | `6` |
| `--`     | Decrement (subtracts 1) | `x--` or `--x` | `4` |



## Methods

Java has five main types of methods:

- Predefined Methods (Built-in Methods) – Methods that come with Java (e.g., Math.sqrt(), System.out.println()).
- User-Defined Methods – Methods that you create yourself.
- Parameterized Methods – Methods that take input values (parameters).
- Method Overloading – Multiple methods with the same name but different parameters.
- Static vs. Non-Static Methods – Difference between methods that belong to the class (static) vs. instance (non-static).

**Differences:** Static Method can only access the static methods or varaibles where as Instance methods can access both Static and Instance members

### Static Method
A static method can created using the static keyword. Static methods are shared among all objects of the class. It can be called without creating an object of the class, referenced by the class name itself or reference to the Object of that class. 

```java
// Demonstration of the static method  
import java.io.*;

class Methods {
  
  // static method 
  public static void greet(){
    
    System.out.println("Hello World!");
  }
    public static void main (String[] args) {
      
       // calling the method directily
       greet();
      
        // calling the method 
        // using the class name
        Methods.greet();  
    }
}

```


### Instance Method

Instance methods are the methods that require an object of its class to be created before it can be called

```java
// Demonstrating the in use of instance method
import java.io.*;

class Test {
    String n = "";

    // Instance method 
    public void test(String n) { 
      this.n = n; 
    }
}

class Geeks {
    public static void main(String[] args) {

        // create an instance of the class
        Test t = new Test();

        // calling an instance method 
        // in the class 'Geeks'
        t.test("GeeksforGeeks");
        System.out.println(t.n);
    }
}
```


### A Simple Example to explain Static and Insatnce Methods

```java
public class StaticVsNonStatic {
    // Static Method
    static void staticMethod() {
        System.out.println("This is a static method.");
    }

    // Non-Static Method
    void nonStaticMethod() {
        System.out.println("This is a non-static method.");
    }

    public static void main(String[] args) {
        // Calling the static method directly
        staticMethod();

        // Creating an object to call the non-static method
        StaticVsNonStatic obj = new StaticVsNonStatic();
        obj.nonStaticMethod();
    }
}
```


#### Output

```bash
This is a static method.
This is a non-static method.
```


# JAVA OOPS Concepts

**Major OOPs Concepts**: Class, Objects, Encapsulation, Inheritance, Polymorphism, Abstraction.

## Encapsulation:

- The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. It allows implementation details to be hidden while exposing a public interface for interaction.

## Inheritance

- It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.

## Polymorphism:

- Polymorphism means "many forms", A person can have different characteristics at the same time. Like a man at the same time is a father, a husband, and an employee. So the same person possesses different behaviors in different situations. This is called polymorphism..

## Abstraction:

- Abstraction in Java is the process of hiding the implementation details and only showing the essential functionality or features to the use

We can Achieve abstraction in two Ways: 

- One is using Abstraction classes and the other is Interfaces.

## Interfaces

- Like abstract classes, interfaces cannot be used to create objects (in the example above, it is not possible to create an "Animal" object in the MyMainClass)
- Interface methods do not have a body - the body is provided by the "implement" class
- Java does not support "multiple inheritance" (a class can only inherit from one superclass). However, it can be achieved with interfaces, because the class can implement multiple interfaces.




## Sealed Classes:

A sealed class is a technique that limits the number of classes that can inherit the given class. This means that only the classes designated by the programmer can inherit from that particular class, thereby restricting access to it. when a class is declared sealed, the programmer must specify the list of classes that can inherit it



# Collection frameWorks

**What is Collection in Java?**
- A Collection represents a single unit of objects, i.e., a group.

**What is a framework in Java?**
- A framework provides a ready-made structure of classes and interfaces for building software applications efficiently.


**What is Collection framework ?**
- The Collection framework represents a unified architecture for storing and manipulating a group of objects.