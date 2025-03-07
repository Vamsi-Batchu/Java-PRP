public class Types_Var_Op {
    public static void main(String[] args) {
        // 🟢 Primitive Data Types
        byte smallNumber = 127;    // Range: -128 to 127
        short shortNumber = 32000; // Range: -32,768 to 32,767
        int integerNumber = 2147483647; // Most commonly used whole number type
        long largeNumber = 9223372036854775807L; // Long numbers (L is required)

        float decimalNumber = 3.14f;  // 6-7 decimal digits (f is required)
        double largeDecimal = 3.141592653589793; // 15-16 decimal digits

        char letter = 'A'; // Stores a single character
        boolean isJavaFun = true; // true or false values
        boolean isEasy = false;

        // 🟡 Non-Primitive Data Types
        String greeting = "Hello, Java!"; // String (Sequence of characters)

        int[] numbersArray = {10, 20, 30, 40, 50}; // Array (Stores multiple values)

        //Varibles to perform Operator
        int x = 10;
        int y = 5;


        // Printing all the values
        System.out.println("🔹 Primitive Data Types:");
        System.out.println("byte: " + smallNumber);
        System.out.println("short: " + shortNumber);
        System.out.println("int: " + integerNumber);
        System.out.println("long: " + largeNumber);
        System.out.println("float: " + decimalNumber);
        System.out.println("double: " + largeDecimal);
        System.out.println("char: " + letter);
        System.out.println("boolean: " + isJavaFun);

        System.out.println("\n🔹 Non-Primitive Data Types:");
        System.out.println("String: " + greeting);
        System.out.println("Array Element [1]: " + numbersArray[1]); // Accessing array element

        // Printing Arithmetic Operators
        System.out.println(x + y);  // Output: 15
        System.out.println(x - y);  // Output: 5
        System.out.println(x * y);  // Output: 50
        System.out.println(x / y);  // Output: 2
        System.out.println(x % y);  // Output: 0 (Remainder)

        // Comparison Operators
        System.out.println(x > y);  // false
        System.out.println(x < y);  // true
        System.out.println(x == y); // false

        // Logical Operators
        System.out.println(isJavaFun && isEasy);  // false
        System.out.println(isJavaFun || isEasy);  // true

    }
}
