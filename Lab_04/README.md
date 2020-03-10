# Lab 04

## Membuat dan Menggunakan Array

### Bangun sebuah Eclipse project untuk tutorial ini. Apabila sudah selesai dan dapat dijalankan dengan

### benar dalam Eclipse, export seluruh project sebagai sebuah runnable JAR file supaya program bisa

### dijalankan di luar Eclipse.

### Dalam tutorial ini kita akan membuat dan menggunakan array untuk simulasi Galton Box (Game of

### Bean Machine).

### The Bean Machine (Galton box) adalah suatu alat eksperimen statistik yang diciptakan oleh ilmuwan

### Inggris: Sir Francis Galton. Alat ini terdiri dari sebuah board tegak yang diberi pasak-pasak kecil yang

### tersebar secara merata dan membentuk segitiga, seperti pada gambar berikut:

### Bean atau bola-bola kecil dijatuhkan dari lubang di atas board. Setiap kali bola menabrak sebuah

### pasak, bola tsb punya peluang 50% jatuh ke kiri atau ke kanan. Tumpukan bola akan terakumulasi dalam

### slot di dasar board.

### Sebagai contoh, lihatlah https://en.wikipedia.org/wiki/File:Galton_box.webm

### Lengkapi program di bawah ini yang dimaksudkan untuk simulasi Galton Box, dengan langkah-langkah

### berikut:

### 1) Minta user masukkan jumlah bola dan jumlah slot.

### 2) Buat path acak (random) yang menggambarkan jalur jatuhnya bola. Satu bola mendapat satu random

### path. Sebagai contoh, path untuk bagian (b) dalam gambar di atas dinyatakan oleh LLRRLLR dan path

### untuk bagian (c) adalah RLRRLRR. L = left, R = right.

### 3) Tayangkan tumpukan akhir dari semua bola dalam slot-slot sebagai sebuah histogram.


### Contoh eksekusi program:

### 1)

Masukkan jumlah bola: 10
Masukkan jumlah slot: 15
RRRRRLLRRRRLRR
RRLRRRRRLRRRRR
RLLLRLRRLRLLRL
RLLRLLLLRRLRRL
LLLRLRRRRRLRLR
LRRRLLLRRLRLRR
LRRRLLLLRRLRRR
LRRRRLRLRLRRLL
LLRLRLRLRLRLRR
RRRRLRRRRRLRLR
O
O
O O O
OOO OO
---------------

### 2)

Masukkan jumlah bola: 10
Masukkan jumlah slot: 15
RLLRRLRRLLRRRL
RRRRRRLLRLLLRL
RRLLRLLLRRRRRL
RLLRLRLRLRRLLL
RRLLLLLLLRRRLL
RLRLRLRRLLLLRR
RRRRLRRLLRLRRR
RRRRRLRLRLRLLR
RRRLRLRRRLLRRR
RLLLLLLLRLRRRL
O
O O O
OOOOOO

### ---------------


##### /**

GaltonBox.java
Ide program:
Buat sebuah array bernama slots. Each element in slots stores the number
of balls in a slot. Each ball falls randomly into a slot via a path.
The number of Rs in a path is the position of the slot where the ball falls.
For example, for the path LRLRLRR, the ball falls into slots[4] (because
there are 4 Rs), and for the path RRLLLLL, the ball falls into slots[2]
(because there are 2 Rs).
*/
package ddp2.lab04;
import java.util.Scanner;
public class GaltonBox {
public static void main(String[] args) {
Scanner input = **..................................................................**
System.out.print("Masukkan jumlah bola: ");
int numberOfBalls = input.nextInt();
System.out.print("Masukkan jumlah slot: ");
int numberOfSlots = **..................................................................**
int[] slots = new **..................................................................** ;
System.out.println();
for (int i = 0; i < numberOfBalls; i++) {
slots[ **.....................................................................** ]++;
}
printHistogram(slots);
}
/**
Return the slot position of the ball for a random path and
also print the path
*/
public static int onePath(int numberOfSlots) {
int position = 0;
for (int i = 0; i < numberOfSlots - 1; i++)
if (Math.random() < 0.5) {
System.out.print("L");
}
else {
System.out.print("R");
position++;
}
System.out.println();
return position;
}


##### /**

Print the histogram for the slots,
from top to bottom row by row
*/
public static void printHistogram(int[] slots) {
int maxSlotHeight = max( **...........................** );
System.out.println();
for (int h = maxSlotHeight; h > 0; h--) {
for (int i = 0; i < slots.length; i++)
if (slots[i] < h)
**......................................................** // Print nothing
else
**......................................................** // Print a ball
System.out.println();
}
for (int i = 0; i < slots.length; i++)
System.out.print("-");
System.out.println();
}
/**
Get the max element in slots
*/
public static int max(int[] slots) {
.
.
.
}
}