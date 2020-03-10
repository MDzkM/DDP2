# Lab 09

## Polymorphism and Sorting

Baca dokumen ini dengan seksama. Buat sebuah Eclipse project yang mencakup semua class yang diperlukan untuk lab ini.
File yang mengandung method main dapat dieksekusi sendiri-sendiri. (Klik tombol mouse tangan dalam daerah method main

- > Run As - > Java Application).

The file Sorting.java given below contains a Sorting class. This class implements the selection sort algorithm for sorting any
array of Comparable objects in ascending order.

The general strategy of selection sort is:

```
 Scan the entire list to find the smallest value. Exchange that value with the value in the first position of the list.
 Scan the rest of the list (all except the first value) to find the smallest value, then exchange it with the value in the
second position of the list.
 Scan the rest of the list (all except the first two values) to find the smallest value, then exchange it with the value in
the third position of the list.
 Continue this process for all except the last position in the list (which will end up containing the largest value).
 When the process is complete, the list is sorted.
```
For example, the sequence 3, 9, 6, 1, 2 will be sorted as follows:

The Comparable interface contains only one method, compareTo, which takes an object as a parameter and returns an integer.

public interface Comparable<T> {
int compareTo(T obj);
}

The intention of this interface is to provide a common mechanism for comparing one object to another. One object calls the
method and passes another as a parameter as follows:

```
if (obj1.compareTo(obj2) < 0)
System.out.println ("obj1 is less than obj2");
```
As specified by the documentation for the interface, the integer that is returned from the compareTo method should be
negative if obj1 is less than obj2, 0 if they are equal, and positive if obj1 is greater than obj2. It is up to the designer of each
class to decide what it means for one object of that class to be less than, equal to, or greater than another.

The Comparable interface is a generic interface. The generic type T is replaced by a concrete type when implementing this
interface. Many classes in the Java library implement Comparable to define a natural order for objects. The classes Byte,
Short, Integer, Long, Float, Double, Character, BigInteger, BigDecimal, Calendar, String, and Date all implement the
Comparable interface. For example, the Integer, BigInteger, String, and Date classes are defined as follows in the Java API:


Thus, numbers are comparable, strings are comparable, and so are dates. You can use the compareTo method to compare two
numbers, two strings, and two dates. For example, using jshell:

```
jshell> System.out.println(new Integer(3).compareTo(new Integer( 2 5)));
```
- 1
jshell> System.out.println("ABC".compareTo("ABE"));
- 2
jshell> java.util.Date date1 = new java.util.Date(2019, 1, 1);
jshell> java.util.Date date2 = new java.util.Date(2012, 1, 1);
jshell> System.out.println(date1.compareTo(date2));
1
jshell> date1 instanceof Comparable
true

The first println displays a negative value since 3 is less than 25. The second println displays a negative value since ABC is
less than ABE. The third println displays a positive value since date1 is greater than date2.

In this lab, you will use the completed Sorting class to sort several different types of objects.

1. The file Numbers.java reads in an array of integers, invokes the selection sort algorithm to sort them, and then prints
    the sorted array. Numbers.java still has errors. Change the program (as little as possible) so it will work correctly.
2. Write a program Strings.java, similar to Numbers.java, that reads in an array of String objects and sorts them. You
    may follow the solution pattern in Numbers.java.
3. The file Salesperson.java partially defines a class that represents a sales person. A sales person has a first name, last
    name, and a total number of sales. Complete the compareTo method in the Salesperson class. The comparison
    should be based on total sales; that is, return a negative number if the executing object has total sales less than the
    other object and return a positive number if the sales are greater. Use the name of the sales person to break a tie
    (alphabetical order).
4. The file WeeklySales.java contains a driver for testing the compareTo method and the sorting. Compile and run it.
    Make sure your compareTo method is correct. The sales staff should be listed in order of sales with the four people
    having the same number of sales in alphabetical order. The output should be:

```
Ranking of Sales for the Week
```
```
Trump, Don: 1570
Walter, Dick: 2800
Doe, Jim: 2850
Black, Jane: 3000
Jones, James: 3000
Jones, Jane: 3000
Smith, Walt: 3000
Duck, Daffy: 4935
Adams, Andy: 5000
Taylor, Harry: 7300
```

### //********************************************************************

// Sorting.java
//
// Demonstrates the selection sort algorithm with generic type T.
// >> **Lengkapi**
//********************************************************************
package lab09;

## public class Sorting<T>

## {

## //-----------------------------------------------------------------

## // Sorts the specified array of objects of type T using the

## // selection sort algorithm.

## //-----------------------------------------------------------------

## public void selectionSort(Comparable<T>[] list)

## {

## int min;

## Comparable<T> temp;

## for ( int index = 0; index < list.length-1; index++)

## {

## // Find the index of the smallest value

## min = index;

## for ( int scan = ........................; scan < ....................................; scan++)

## if (list[scan].compareTo((T)list[min]) < 0)

## min = scan;

## // Swap the values

## temp = ................................................;

## .....................................................................

## .....................................................................

## }

## }

## }


### // ******************************************************

// Numbers.java
//
// Apply selectionSort on an array of integers.
// >> **Perbaiki**
// ******************************************************
package lab09;

import java.util.Scanner;

public class Numbers
{
// --------------------------------------------
// Reads in an array of integers, sorts them,
// then prints them in sorted order.
// --------------------------------------------
public static void main (String[] args)
{
int[] intList;
int size;

Scanner scan = new Scanner(System.in);

System.out.print ("\nBerapa integer yang akan di-sort? ");
size = scan.nextInt();
intList = new int[size];

System.out.println ("\nKetik integer-integer yang akan di-sort ...");
for (int i = 0; i < size; i++)
intList[i] = scan.nextInt();

Sorting.selectionSort(intList);

System.out.println ("\nHasil dalam sorted order...");
for (int i = 0; i < size; i++)
System.out.print(intList[i] + " ");
System.out.println ();
}
}


### // *******************************************************

// Salesperson.java
//
// Represents a sales person who has a first name, last
// name, and total number of sales.
// >> **Perbaiki/lengkapi**
// *******************************************************

package lab09;

public class Salesperson implements Comparable
{
private String firstName, lastName;
private int totalSales;

### //------------------------------------------------------

// Constructor: Sets up the sales person object with
// the given data.
//------------------------------------------------------
public Salesperson (String first, String last, int sales)
{
firstName = first;
lastName = last;
totalSales = sales;
}

//-------------------------------------------
// Returns the sales person as a string.
//-------------------------------------------
public String toString()
{
return lastName + ", " + firstName + ": \t" + totalSales;
}

### //-------------------------------------------

// Returns true if the sales people have
// the same name.
//-------------------------------------------
public boolean equals (Object other)
{
return (lastName.equals(((Salesperson)other).getLastName()) &&
firstName.equals(((Salesperson)other).getFirstName()));
}

### //--------------------------------------------------

// Order is based on total sales with the name
// (last, then first) breaking a tie.
//--------------------------------------------------
public int compareTo(Object other)
{
int result;

//??

return result;
}


### //-------------------------

// First name accessor.
//-------------------------
public String getFirstName()
{
return firstName;
}

### //-------------------------

// Last name accessor.
//-------------------------
public String getLastName()
{
return lastName;
}

### //-------------------------

// Total sales accessor.
//-------------------------
public int getSales()
{
return totalSales;
}
}


### // *************************************************************

// WeeklySales.java
//
// Sorts the sales staff in order by sales.
// >> **Perbaiki**
// ************************************************************
package lab09;

public class WeeklySales
{
public static void main(String[] args)
{
Salesperson[] salesStaff = new Salesperson[10];

salesStaff[0] = new Salesperson("Jane", "Jones", 3000);
salesStaff[1] = new Salesperson("Daffy", "Duck", 4935);
salesStaff[2] = new Salesperson("James", "Jones", 3000);
salesStaff[3] = new Salesperson("Dick", "Walter", 2800);
salesStaff[4] = new Salesperson("Don", "Trump", 1570);
salesStaff[5] = new Salesperson("Jane", "Black", 3000);
salesStaff[6] = new Salesperson("Harry", "Taylor", 7300);
salesStaff[7] = new Salesperson("Andy", "Adams", 5000);
salesStaff[8] = new Salesperson("Jim", "Doe", 2850);
salesStaff[9] = new Salesperson("Walt", "Smith", 3000);

Sorting.selectionSort(salesStaff);

System.out.println ("\nRanking of Sales for the Week\n");

for (Salesperson s : salesStaff)
System.out.println (s);
}
}