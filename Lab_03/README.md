# Lab 03

## Counting Characters with Loops and Switch Statement; Runnable JAR

Bangun sebuah Eclipse project untuk tutorial ini. Apabila sudah selesai dan dapat dijalankan dengan
benar dalam Eclipse, export seluruh project sebagai sebuah runnable JAR file supaya program bisa
dijalankan di luar Eclipse. Pelajari Slide 5a yang berisi tutorial ringkas tentang bagaimana membuat
runnable JAR file. Oleh karena program ini berbasis GUI, maka runnable JAR file ybs dapat juga
dieksekusi dengan double-clicking.

The file CountChars.java at the end of this document contains the skeleton of a program to read in a
string (a sentence or phrase) and count the number of blank spaces, each vowel (a, e, i, o, u in lower case
or upper case), consonants (lower case or upper case) and the rest in the string. It needs a loop to go
through the string character by character and count the characters. Since we know how many characters
there are (the length of the string) we use a count controlled loop, i.e. a for loop is especially well-suited
for this.

1. Add the for loop to the program. Inside the for loop you need to access each individual character; the
    charAt method of the String class lets you do that. The assignment statement

ch = phrase.charAt(i);

```
assigns the variable ch (type char) the character that is in index i of the String phrase. In your for
loop you can use an assignment similar to this (replace i with your loop control variable if you use
something other than i).
```
2. You need to declare and initialize seven counting variables countA, countE, countI, countO,
countU, countSpace, countConsonant, countOther. You have to use a switch statement. The cases
will be based on the value of the ch variable. The switch starts as follows; complete it.

switch (ch)
{
case 'a':
case 'A': countA++;
break;

case .....................

default: ..................
}

```
Note that this switch uses the "fall through" feature of switch statements. If ch is an 'a' the first case
matches and the switch continues execution until it encounters the break hence the countA variable
would be incremented for each 'a' or 'A'.
```
3. Add statements to print out all of the counts.


4. Use the method showInputDialog and the method showMessageDialog from the class
    javax.swing.JOptionPane.

5. Test your program on several phrases to make sure it is correct.

6. It would be nice to have the program let the user keep entering phrases rather than having to restart it
every time. To do this we need another loop surrounding the current code. That is, the current loop
will be nested inside the new loop. Add an outer while loop that will continue to execute as long as
the user does NOT enter the phrase quit. Note that all of the initializations for the counts should be
inside the while loop (that is we want the counts to start over for each new phrase entered by the
user). Be sure to go through the program and properly indent your code; with nested loops the inner
loop should be indented. You can use Eclipse Source commands for arranging your code.


// **********************************************************
// CountChars.java
//
// This program reads in strings (phrases) and counts the
// number of blank characters, vowels, consonants,and other
// characters in the phrase.
// **********************************************************

**package ddp2.lab03;**

**import** javax.swing.JOptionPane;

**public class** CountChars {

**public static void** main(String[] args) {
String phrase; // a string of characters

**...........................** // other variables

// Read in a string and find its length

phrase = JOptionPane. _showInputDialog_ ( **null** ,
"Enter a sentence or phrase, quit to end:\n",
"Character Counter", JOptionPane. **_PLAIN_MESSAGE_** );

**while** (...............................................................) {
length = phrase.length();

// Initialize counts
countSpace = 0;
...................................................

// a for loop to go through the string character by character
// and count them by category
**for** ( **................................................** ) {

............................................................

}

// Print the results

JOptionPane. _showMessageDialog_ ( **null** ,
"Space: " + countSpace + "\nA: " + countA + "\nE: " +
countE + "\nI: " + countI + "\nO: " + countO +
"\nU: " + countU + "\nConsonants: " + countConsonants +
"\nOthers: " + countOther + "\nThe input was: \n" +
phrase, "Totals", JOptionPane. **_PLAIN_MESSAGE_** );

//Get phrase for next time
phrase = JOptionPane. _showInputDialog_ ( **null** ,
"Enter a sentence or phrase, quit to end:\n",
"Character Counter", JOptionPane. **_PLAIN_MESSAGE_** );
}
}}