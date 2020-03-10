# Lab 05

### Bangun sebuah **Java** project untuk lab ini, yang akan terdiri dari dua buah class: MagicSquare dan

### TestMagicSquare. Export seluruh project sebagai sebuah runnable JAR file yang bisa dijalankan di luar

### Eclipse dengan mengambil argumen untuk method main dari command line.

### Lihat contoh pada akhir dokumen ini yang memberikan argumen "9" kepada method main:

### > java -jar magicSquare.jar 9

### Pemberian argumen untuk method main dapat dilakukan dalam Eclipse lewat "Run Configurations"

### dengan memilih menu: Run → Run Configurations → Arguments ...

### Contoh:


## Task Description:

### An n × n matrix that is filled with the numbers 1, 2, 3,... , n^2 is a magic square if the sum of the

### elements in each row, in each column, and in the two diagonals is the same value. For example,

Magic Square of size 5x5:
11 18 25 2 9
10 12 19 21 3
4 6 13 20 22
23 5 7 14 16
17 24 1 8 15
Diagonal sum: 65
Column sum: 65
Row sum: 65

### Following is an algorithm to construct magic n-by-n squares; it works only if n is odd. Place a 1 in the

### middle of the bottom row. After k has been placed in the (i, j) square, place k + 1 into the square to the

### right and down, wrapping around the borders. However, if the square to the right and down has already

### been filled, or if you are in the lower-right corner, then you must move to the square straight up instead.

### Write a program whose input from command line is an odd number n and whose output is the magic

### square of order n. Implement a class MagicSquare with a constructor that constructs the square and a

### toString method that returns a string representation of the square. In Java, the method toString will be

### automatically executed when an object is converted into a string. This string is then printed nicely on the

### screen.

## Program template:

## //MagicSquare.java

**package** ddp2.lab05;
/**
A magic square that is constructed by a the "right and down" algorithm.
*/
**public class** MagicSquare
{
**private int** [][] square;
**private int** size;
/**
Construct a MagicSquare object
(precondition: s is odd).
**@param** s the size of the square
*/
**public** MagicSquare( **int** s)
{
size = s;
square = **new int** [size][size];


//initialize the square
**for** ( **int** i = 0; i < size ; i++)
**for** ( **int** j = 0; j < size ; j++)
square[i][j] = 0;
**//your code here for filling in the square**
}
/**
Find the sum of the diagonal.
**@return** sum: the sum of the diagonal
*/
**public int** diagonalSum()
{
**int** sum = 0;
**// your code here
return** sum;
}
/**
Add the numbers in a column of the square.
**@param** i the column index
**@return** the sum of the column
*/
**public int** columnSum( **int** i)
{
**int** sum = 0;
**// your code here
return** sum;
}
/**
Add the numbers in a row of the square.
**@param** i the row index
**@return** the sum of the row
*/
**public int** rowSum( **int** i)
{
**int** sum = 0;
**// your code here
return** sum;
}


##### /**

Gets a string representation of the contents of this square.
**@return** a string represenation of the square
*/
**public** String toString()
{
String r = "";
**for** ( **int** i = 0; i < size ; i++)
{
**for** ( **int** j = 0; j < size ; j++)
r = r + String. _format_ ("%5d", square[i][j]);
r = r + "\n";
}
**return** r;
}
}

#### //TestMagicSquare.java

**package** ddp2.lab05;
**public class** TestMagicSquare {

#### public static void main(String[] args) {

#### int n = 0; //size of magic square

#### //Process input from command-line

#### if (args.length == 1) {

#### // your code here

#### }

#### else {

#### System. out .println("Usage: java -jar <jarFile> <odd size of square>");

#### System. exit (1);

#### }

#### //Create an object of MagicSquare

#### MagicSquare ms = new MagicSquare(n);

#### // Print the results

#### System. out .println("Magic Square of size " + n + "x" + n + ":\n\n" + ms +

#### "\nMain diagonal sum: " + ms.diagonalSum() +

#### "\nColumn sum: " + ms.columnSum(0) +

#### "\nRow sum: " + ms.rowSum(n-1) + "\n");

#### }

##### }


## Examples:

### 1)

### C:\Kuliah\DDP2_2019>java -jar magicSquare.jar 9

### Magic Square of size 9x9:

### 37 48 59 70 81 2 13 24 35

### 36 38 49 60 71 73 3 14 25

### 26 28 39 50 61 72 74 4 15

### 16 27 29 40 51 62 64 75 5

### 6 17 19 30 41 52 63 65 76

### 77 7 18 20 31 42 53 55 66

### 67 78 8 10 21 32 43 54 56

### 57 68 79 9 11 22 33 44 46

### 47 58 69 80 1 12 23 34 45

### Main diagonal sum: 369

### Column sum: 369

### Row sum: 369

### 2)

### C:\Kuliah\DDP2_2019>java -jar magicSquare.jar

### Usage: java -jar <jarFile> <size of square>

### 3)

### C:\Kuliah\DDP2_2019>java -jar magicSquare.jar 5

### Magic Square of size 5x5:

### 11 18 25 2 9

### 10 12 19 21 3

### 4 6 13 20 22

### 23 5 7 14 16

### 17 24 1 8 15

### Main diagonal sum: 65

### Column sum: 65

### Row sum: 65


