# Lab 01

## Pengenalan Java

Di DDP 1 kita telah belajar konsep-konsep dasar pemrograman dengan menggunakan bahasa **Python**. Di DDP 2 ini kita akan memperdalam pemahaman pemrograman kita dengan konsep-konsep yang menarik seperti Object Oriented Programming dengan menggunakan bahasa pemrograman **Java**. Pasti timbul pertanyaan di benak masing-masing, kenapa memakai **Java**? Kenapa tidak pakai **Python** saja? Singkatnya, **Java** mempunyai kelebihan yaitu kejelasan struktur dalam pemrogramannya, sehingga membuat mudah untuk memahami konsep _Object Oriented_. Selain itu, **Java** juga termasuk bahasa pemrograman yang paling populer di dunia. Bahasanya dapat digunakan untuk membuat banyak hal di berbagai platform. Patut untuk dipelajari bukan?

### Perbedaan Java dan Python

#### Interpreted vs. Compiled

**Python** merupakan salah satu _Interpreted Language_ , dimana saat program dijalankan, komputer akan mengeksekusi tiap instruksi satu per satu. Oleh karena itu kita bisa langsung menjalankan program **Python**. **Java** merupakan salah satu _Compiled Language_ , dimana setiap program harus diubah menjadi bahasa lain yang bisa dimengerti komputer, lalu setelah itu baru bisa dijalankan.

#### Struktur Kode

Perbedaan struktur kode **Python** dan **Java** cukup mencolok. Namun, pada dasarnya semua bahasa pemrograman memiliki tujuan yang sama, yaitu sebagai bahasa penghubung antara manusia yang membuat program dan komputer yang akan menjalan program. Sehingga, jika sudah memahami sebuah bahasa pemrograman, maka akan lebih mudah untuk memahami bahasa yang lain. Berikut perbedaan _syntax_ di **Python** dan **Java**:

##### ● Declaring & Assigning Variables

Variabel di **Python** bersifat dynamic , sehingga kita bisa memasukan nilai dengan tipe data apapun ke sebuah variabel dan kita bisa mengubah nilai variabel tersebut dengan tipe data yang berbeda. Variabel di **Java** bersifat static. Di **Java**, kita harus mendeklarasikan (memberi informasi) tipe data dari sebuah variabel secara eksplisit. Variabel tersebut juga hanya bisa diisi dengan nilai dengan tipe data yang sudah kita deklarasikan tadi.

**Python**

```
var1 = 3
var2 = 'Dek Depe'
var3 = True
var1 = False # bisa
```

**Java**
```
int var1 = 3 ;
String var2 = "Dek Depe" ;
boolean var3 = true;
var1 = false; // error, var1 bertipe int
```

Tipe data pada **Java** antara lain: ```int``` (bil. bulat), ```double``` (bil. pecahan), ```boolean``` (true/false), ```String``` (kalimat), ```char``` (satu huruf), dan masih banyak lagi yang akan kita pelajari nanti.

Catatan: Setiap instruksi pada **Java** harus diakhiri titik koma / semicolon ( ; ). Berbeda dengan **Python** yang setiap instruksinya dipisah oleh baris. (Ya, kita bisa menulis lebih dari satu instruksi pada baris yang sama -- tetapi tidak dianjurkan karena bisa membuat kode menjadi sulit dibaca oleh manusia.)

Catatan (2): String di **Java** wajib menggunakan tanda kutip ( “ ... ” ). Tidak seperti **Python** yang bisa menggunakan tanda kutip maupun apostrof ( ‘ ... ’ )

##### ● If-Else Conditions

Struktur kode If-Else pada **Python** dan **Java** kurang lebih sama. Perbedaannya adalah **Java** menggunakan **else if** sedangkan **Python** menggunakan **elif**.

**Python**
```
nilai = 78
huruf = ''
if (nilai > 85 ):
    huruf = 'A'
elif (nilai > 70 ):
    huruf = 'B'
elif (nilai > 55 ):
    huruf = 'C'
else :
    huruf = 'D'
print(huruf)
```

**Java**
```
int nilai = 78 ;
char huruf;
if (nilai > 85 ) {
    huruf = 'A' ;
} else if (nilai > 70 ) {
    huruf = 'B' ;
} else if (nilai > 55 ) {
    huruf = 'C' ;
} else {
    huruf = 'D' ;
}
System.out.println(huruf);
```

##### ● Input

Struktur input di **Java** memiliki bentuk yang lebih kompleks dibanding pada **Python**, yaitu dengan format seperti ini :

```
import java.util.Scanner;

    // some codes
    // ...
    Scanner input = new Scanner(System.in);
    String newVar = input.readline();
    System.out.println(newVar);
    // ...
```

Untuk menggunakan objek Scanner, yang harus dilakukan pertama kali adalah mengimport java.util.Scanner (akan dijelaskan nanti). Kemudian, kita mengimplementasikan objek _scanner_ untuk membaca input dan menyimpannya di variabel **newVar**. Pencetakan variabel **newVar** (line #3) berfungsi untuk menunjukkan bahwa benar data yang diinput tersimpan di variabel **newVar**. Perlu diingat bahwa nilai yang terbaca oleh Scanner dianggap sebagai data tipe String. Berikut perbandingan kembali antara input di **Python** dengan di **Java** :

**Python**
```
var = input();
```

**Java**
```
import java.util.Scanner;

    // some codes
    // ...
    Scanner input = new Scanner(System.in);
    String var = input.nextLine();
    // ...
```

##### ● While Loop

Struktur While-loop pada **Java** dan **Python** sama, yaitu dalam format while <kondisi>. Namun tidak seperti **Python**, kondisi di **Java** harus dibungkus dengan tanda kurung.

**Python**
```
# print angka 0 sampai 9
number = 0
while number < 10 :
    print(number)
    number += 1
```
**Java**
```
// print angka 0 sampai 9
int number = 0 ;
while (number < 10 ) {
    System.out.println(number);
    number++; // increment di Java, setara number += 1 di Python
}
```
### Membuat Program Java

Berikut adalah contoh program yang _wajib_ dibuat ketika pertama kali menggunakan suatu bahasa pemrograman. Apakah itu? Tentu saja program Hello World!

```
// disimpan dengan filename HelloWorld.java
public class HelloWorld {
    public static void main (String[] args) {
        System.out.println( "Hello, World!" );
    }
}
```

Hal pertama yang kita lakukan adalah membuat _file_ yang bernama **HelloWorld.java**. Ekstensi ```.java``` ini berguna untuk menunjukkan bahwa _file_ ini adalah suatu kode program yang dapat di-_compile_ oleh Java Compiler. Kemudian, kita membuat sebuah ```class```. Perhatikan bahwa nama ```class``` **HARUS** sama dengan nama _file_ dimana ```class``` tersebut dibuat. Lalu, kita membuat sebuah _method_ bernama ```main```. _Method_ ini berfungsi sebagai _entry-point_ (titik masuk) dari program Java sehingga saat program dijalankan, sistem akan langsung mencari fungsi ```main``` ini dan menjalankan kode yang ada didalamnya. ```System.out.println()``` digunakan untuk mencetak ke layar, seperti fungsi ```print()``` di Python. Untuk menjalankan program, pertama save _file_ terlebih dahulu, lalu buka Command Prompt di folder tempat menyimpan _file_ java tersebut dengan cara mengetik ```cmd``` di _address bar_ Windows Explorer tempat menyimpan _file_. Kita juga bisa membuka **Command Prompt** secara langsung dan menavigasikannya ke folder penyimpanan _file_ Java dengan menggunakan perintah ```cd [path direktori penyimpanan]```. Seperti telah disebutkan sebelumnya, Java adalah _compiled language_. Jadi, sebelum menjalankan program diharuskan meng-_compile_-nya terlebih dahulu, yaitu dengan perintah : ```javac [nama_file].java``` Langkah terakhir adalah menjalankan program yang sudah di-_compile_ dengan perintah : ```java [nama_file]``` (Perhatikan bahwa tidak ada ekstensi ```.java``` saat menjalankan program).

### Selamat, kamu sudah berhasil menjalankan program Hello World di Java!


## Tugas Lab

### Dari Ular Turun Ke Kopi

Setelah perpisahan yang haru dengan DDP1, Dek Depe akhirnya bertemu dengan teman barunya, yaitu DDP2! Kebetulan, kamu kali ini sekelas lagi dengan Dek Depe. Diam diam Tentu Dek Depe sangat senang karena kamu adalah orang yang baik hati dan sering membantunya. Sebelumnya, Dek Depe sangat senang membuat program menggunakan Python. Tetapi sekarang, ia harus membuat program dengan **Java**. Di suatu hari yang cerah, Dek Depe meminta kamu untuk bertemu dengannya di atap gedung baru. Kamu pun dengan senang hati menemui Dek Depe. Kemudian, di atap, Dek Depe sudah menunggu kamu. Kemudian dia menghampiri kamu dan berkata...

" ... "

" ... Bantu aku dong untuk menyelesaikan masalah ini!"

**Soal Lab** : _Buatlah tiga buah file Java yang bernama ```Usia.java```, ```Kabisat.java```, dan ```SimpleLog.java```, yang masing-masing memiliki satu class dengan mengikuti nama file yang telah ditentukan dan melakukan hal yang serupa dengan apa yang dikerjakan oleh potongan kode **Python** pada masing-masing spesifikasi di bawah. Dalam menuliskan kode **Java**, pergunakan tipe data yang sesuai dan perhatikan coding style yang benar (indentation, penamaan variabel, dll) dan jangan lupa untuk menambahkan komentar pada bagian-bagian penting di kode masing-masing._


### Spesifikasi Usia.java dalam Python

```
usia = 19
if (usia <= 10 ):
    print( "Orang berusia" , usia, "masih anak-anak" )
elif (usia <= 20 ):
    print( "Orang berusia" , usia, "sudah remaja" )
elif (usia <= 50 ):
    print( "Orang berusia" , usia, "sudah dewasa" )
else :
    print( "Orang berusia" , usia, "sudah tua" )
```
### Spesifikasi Kabisat.java dalam Python

```
year = input( "Silakan masukkan tahun lahir Anda" )
if (year% 400 == 0 ) :
    print( "Anda lahir di tahun kabisat." )
elif (year% 100 == 0 ) :
    print( "Anda tidak lahir di tahun kabisat." )
elif (year% 4 == 0 ) :
    print( "Anda lahir di tahun kabisat." )
else :
    print( "Anda tidak lahir di tahun kabisat." )
```
### Spesifikasi SimpleLog.java dalam Python

```
# Program ini akan mencetak logaritma dari suatu bilangan dibulatkan ke bawah
number = 100
base = 2
log = 0
number_before = number
while (number >= base):
    number /= base
    log += 1 # gunakan increment/decrement di Java
    print( "Logaritma basis " , base, " dari " , number_before, " adalah " , log)
```