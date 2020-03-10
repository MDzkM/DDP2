# Lab 02

## Fundamental Data Types, Scanner, Switch

Build a separate Eclipse project for each part of this tutorial.
Sebagai petunjuk, silakan pelajari slide "Membangun Program Java dalam Eclipse".
Program yang dibuat dalam Eclipse tentu saja bisa juga dijalankan tanpa Eclipse.

Part 1. There are four primitive types for integers: int, byte, short, and long. Associated with each
primitive type is a class with a similar name, so the primitive type int is associated with the class Integer, the
primitive type byte is associated with the class Byte, short is associated with the class Short, and long is
associated with the class Long.

These associated classes are sometimes called “wrapper classes”. The wrapper classes for integer types contain
constants that represent the maximum and minimum values that an integer of the given type can take on. For
example, in the wrapper class Integer, the constant Integer.MAX_VALUE represents the maximum integer
value that can be represented with an int variable.

In the API (Application Programming Interface) documentation, you can find the wrapper classes in the package
java.lang.

The program listed below prints the minimum and maximum values for the int primitive type. Modify the
program below so that it also prints the minimum and maximum values for byte, short, and long.

**package** ddp2.lab 02 .part1;

public class IntegerDemo
{
public static void main(String[] args)
{
System.out.println("Maximum int value: " + Integer.MAX_VALUE);
System.out.println("Minimum int value: " + Integer.MIN_VALUE);
}
}


Part 2. We often need to convert a value from a String to a primitive data type. For example, the program
below converts the String "12345" to an int using the static method parseInt that is contained in the
wrapper class Integer. A static method is a method that can be called without an object.

Here is a list of parsing methods in wrapper classes:

// These two methods are in the Byte class
public static byte parseByte(String s)
public static byte parseByte(String s, int radix)
// These two methods are in the Short class
public static short parseShort(String s)
public static short parseShort(String s, int radix)
// These two methods are in the Integer class
public static int parseInt(String s)
public static int parseInt(String s, int radix)
// These two methods are in the Long class
public static long parseLong(String s)
public static long parseLong(String s, int radix)
// These two methods are in the Float class
public static float parseFloat(String s)
public static float parseFloat(String s, int radix)
// These two methods are in the Double class
public static double parseDouble(String s)
public static double parseDouble(String s, int radix)

Complete the program below by filling in the code specified in the embedded comments.

**package** ddp2.lab 02 .part2;

public class StringConversion
{
public static void main(String[] args)
{
String value1 = "12345";
int intValue = Integer.parseInt(value1);
System.out.println("intValue = " + intValue);

String value2 = "12.345";
// Convert value2 to a double here
// Print the converted value

String value3 = "87654";
// Convert value3 to a long here
// Print the converted value

String value4 = "321";
// Convert value4 to a short here
// Print the converted value

String value5 = "-28";
// Convert value5 to a byte here
// Print the converted value

String value6 = "-45.237";
// Convert value6 to a float here
// Print the converted value


String value7 = "1ABC";
//Assume that value7 contains a hexadecimal number. Convert it
// to an int here
//Print the converted value

String value8 = "11001";
//Assume that value8 contains a binary number. Convert it
// to an int here
//Print the converted value

}
}


Part 3. Study and run the program below, which uses the statement **switch** :

//**********************************************************
// MyFactorial.java
//
// Print the factorial of a positive int <= 5
// using the switch statement
//**********************************************************

**package** ddp2.lab 02 .part3;

**import** java.util.Scanner;

public class MyFactorial
{
public static void main(String[] args)
{
Scanner inputkb = **new** Scanner(System. **_in_** );
System. **_out_** .println("Enter a positive integer <= 5:");
**int** n = inputkb.nextInt();
**var** result = 1; //Java can find out that **result** has type **int
switch** (n) {
**case** 5: result *= 5; break;
**case** 4: result *= 4; break;
**case** 3: result *= 3; break;
**case** 2: result *= 2; break;
**default** :
}
System. **_out_** .println(
(n>0 && n <= 5)?(n+"! = " + result):"out of range");
}
}

Some things to notice:

```
This program has bugs. The result is wrong.
The declaration var result = 1; is new in Java 10. A new identifier named var is available for local
variables with non-null initializers. Using this identifier, the type of the variable is inferred from the context.
```
Modify the program as follows:

1. Fix the bugs. It is supposed to compute the factorial.
2. Extend the program so that it can compute the factorial of integers up to 10.