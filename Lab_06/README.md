# Lab 06

## Pengenalan JavaFX

Baca seluruh dokumen ini dengan seksama minimal 2 kali. Banyak hal baru yang akan Anda pelajari.

Dalam DDP1, Anda telah belajar membuat program Python berbasis GUI (Graphical User Interface) dengan
menggunakan library Tkinter. Dalam tutorial ini kita akan belajar tentang pemrograman berbasis GUI dalam
Java. Kita akan menggunakan library JavaFX.

## Sedikit Sejarah

#### AWT

Dalam versi-versi awal Java, pemrograman GUI dilakukan dengan menggunakan package yang disebut AWT (
Abstract Window Toolkit). AWT memberikan suatu sistem graphics dimana tiap komponen diasosiasikan dengan
komponen yang bersesuaian dalam native operating system, seperti Windows atau MacOS atau Linux. Jika kita
ingin membuat suatu graphical component (seperti button atau text field), maka komponen tsb akan diberikan
oleh OS (operating system) ybs., sehingga button atau text field itu akan tampak lokal menurut OS ybs.
Komponen grafik yang mengandalkan native OS akan menggunakan secara ekstensif sumber daya sistem; oleh
karena itu disebut sebagai heavyweight components.

Penggunaan sumber daya sistem yang besar dan perbedaan fungsional antar OS, membuat AWT tidak sukses.

Swing
AWT digantikan oleh package yang disebut Swing. Swing classes ditulis sebagian besar dalam Java sendiri dan
tidak mengandalkan komponen-komponen dari OS; oleh karena itu disebut sebagai lightweight components.
Tidak seperti AWT, komponen-komponen Swing tampak mirip pada semua OS yang mengimplementasikannya.
Tetapi look and feel dari Swing menjadi old-fashioned dibandingkan dengan GUI masa kini yang meliputi
multiple devices. Mulai Java 8, Swing mulai digantikan oleh technology GUI baru yang dikenal sebagai JavaFX.
Untuk sementara, Swing masih bisa dipergunakan, tetapi tidak akan dikembangkan lagi.

JavaFX
Program JavaFX disebut sebagai application. Dengan inheritance, class JavaFX meng-extend class Application.
Statement import berikut diperlukan:

import javafx.application.Application

JavaFX menggunakan metaphor teater: stage (panggung) dan scene (adegan).

Window top-level merupakan stage. Aplikasi JavaFX juga bisa dibuat untuk run dalam browser; di sini browser
adalah stage. Contents (isi graphics) dari stage disebut scene. Scene terdiri dari sejumlah node, yang tersusun
dalam struktur hirarkis yang dapat digambarkan dalam bentuk pohon (tree).


Jenis-jenis node
 Node biasanya berupa jenis komponen GUI yang memungkinkan interaksi dengan user, seperti: button,
text field, label, check box. Nodes jenis ini disebut controls.
 Node dapat juga berupa bentuk-bentuk grafik 2D atau 3D, seperti:
o Line(startX, startY, endX, endY)
o Rectangle(x, y, width, height)
o Circle(centerX, centerY, radius)
o Ellipse(centerX, centerY, radiusX, radiusY)
o Arc(centreX, centreY, radiusX, radiusY, startAngle, angleExtend)
 Node dapat juga berupa container. Container adalah komponen yang dapat menampung node lain. Tiap
container mengatur node-node-nya dalam cara tertentu, seperti: vertically, horizontally, in a grid, atau
stacked one on top of the other. Biasanya container tidak kelihatan, tetapi bisa saja diberi border. Yang
penting adalah bahwa container (parent) dapat mengandung container lain (children) sehingga kita dapat
membangun sebuah hirarki dalam sebuah scene. Top level node dalam sebuah scene disebut root node.

Pada contoh di atas, scene mempunyai root node berupa sebuah VBox— yaitu sebuah container yang mengatur
child nodes secara vertical. VBox tsb punya tiga anak yaitu sebuah TextField, sebuah Label dan sebuah HBox.
HBox adalah sebuah container yang mengatur child nodes secara horizontal. HBox dalam contoh tadi punya tiga
anak berupa Button.

JavaFX application dikendalikan oleh method:
void start(Stage stage)

dan dapat di-launch dengan main method:

public static void main(String[] args) {
launch(args);
}

Perhatikan bahwa method main itu memanggil method static launch dari application dan menyalurkan
argumennya.


### Bagian A: The SmileyFace Application

Kita akan membangun sebuah application yang menampilkan smiley face sbb.:

Walaupun applikasi ini masih sederhana, tanpa melibatkan interaksi user, applikasi ini memperlihatkan banyak konsep baru:

```
 bagaimana create a scene, add items to the scene, dan add the scene to a stage.
 2D graphical shapes, seperti circles, lines, ellipses, rectangles dan arcs. Kita menggambar circles untuk muka dan
mata, dan arc untuk mulut.
 bagaimana membuat text yang dapat dikonfigurasi dengan warna dan fonts.
```
Buat sebuah Eclipse project untuk program berikut:


**package** lab06_JavaFX_SmileyFace;

**import** javafx.application.Application;
**import** javafx.scene.Group;
**import** javafx.scene.Scene;
**import** javafx.scene.paint.Color;
**import** javafx.scene.shape.Arc;
**import** javafx.scene.shape.ArcType;
**import** javafx.scene.shape.Circle;
**import** javafx.scene.text.Font;
**import** javafx.scene.text.Text;
**import** javafx.stage.Stage;

**public class** SmileyFace **extends** Application
{
@Override
**public void** start(Stage stage)
{
// create and configure the main circle for the face
Circle face = **new** Circle(125, 125, 80);
face.setFill(Color. **_YELLOW_** );
face.setStroke(Color. **_RED_** );
// create and configure the circle for the right eye
Circle rightEye = **new** Circle(86, 100, 10);
rightEye.setFill(Color. **_CYAN_** );
rightEye.setStroke(Color. **_BLUE_** );
// create and configure the circle for the left eye
Circle leftEye = **........................................................................** ; //lengkapi
.......................................................................................; //lengkapi
.......................................................................................; //lengkapi
// create and configure a smiling mouth
Arc mouth = **new** Arc(125, 150, 45, 35, 0, - 180);
mouth.setFill(Color. **_YELLOW_** );
mouth.setStroke(Color. **_BLUE_** );
mouth.setType(ArcType. **_OPEN_** );
// create and configure the text
Text caption = **new** Text(80, 240, "Smiley Face");
caption.setFill(Color. **_BLUE_** );
caption.setFont(Font. _font_ ("Verdana", 15));
// create a group that holds all the features
Group root = **new** Group(face, rightEye, leftEye, mouth, caption);
// create and configure a new scene
Scene scene = **new** Scene(root, 250, 275, Color. **_BEIGE_** );
//add the scene to the stage, then set the title
stage.setScene(scene);
stage.setTitle("Smiley Face");
//show the stage
stage.show();
}
**public static void** main(String[] args)
{
_launch_ (args);
}
}


Penjelasan program

```
 Statement-statement import menunjukkan bahwa semua class yang dipakai berasal dari package javafx, yang punya
banyak subpackages termasuk scene dan stage.
```
```
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
```
```
 Perhatikan class header:
```
```
public class SmileyFace extends Application
```
```
Semua program JavaFX run sebagai application. Oleh sebab itu class kita diturunkan dari (meng-extend)
class Application. Application memerlukan kita mengimplementasikan method start dengan header:
```
```
public void start(Stage stage)
```
```
Apabila start dipanggil, ia otomatis dikirimi sebuah object dari class Stage, yang merupakan container
utama untuk GUI kita.
Hal pertama yang dilakukan method start itu adalah membuat dan mengatur object Circle untuk face:
```
Circle face = new Circle(125, 125, 80);
face.setFill(Color.YELLOW);
face.setStroke(Color.RED);

```
Parameter pertama dan kedua untuk constructor Circle adalah posisi x dan y dari pusat circle, yang diukur
(dalam satuan pixel) terhadap titik sudut kiri atas dari parent node. Parameter ketiga adalah jari-jari circle.
Kita memilih initial scene berukuran 250 x 275 , sehingga pusat circle yang cocok berada pada posisi
(125, 125), yang akan pas di tengah secara horizontal dan menyediakan cukup ruang vertikal untuk label.
```
```
Sistem koordinat Java mempunyai titik origin di sudut kiri atas dan semua koordinat yang visible adalah
positif, seperti dalam gambar berikut:
```
```
Dua method lain dari class Circle, yaitu setFill dan setStroke, dipakai untuk menentukan warna pengisian
dan warna goresan.
```

```
Selanjutnya dibuat object Circle untuk mata kiri dan mata kanan.
```
```
Mulut tersenyum dibuat dengan object Arc terbuka (bagian dari ellipse):
Arc mouth = new Arc(125, 150, 45, 35, 0, -180);
mouth.setFill(Color.YELLOW);
mouth.setStroke(Color.BLUE);
mouth.setType(ArcType.OPEN);
Lebar sudut -180 dibuat mulai dari sudut awal 0 bergerak dalam arah clockwise (sudut negatif).
```
```
Caption dibuat dengan class Text:
Text caption = new Text(80, 240, "Smiley Face");
caption.setFill(Color.BLUE);
caption.setFont(Font.font("Verdana", 15));
```
```
Komponen-komponen face ini telah lengkap dan perlu dikelompokkan menjadi satu group yang kompak.
Hal ini dicapai dengan menggunakan class Group. Object Group berlaku sebagai container tak tampak
yang dapat menjaga posisi setiap komponennya:
```
```
Group root = new Group(face, rightEye, leftEye, mouth, caption);
```
```
Berdasarkan convention, nama node pertama yang dimasukkan dalam scene disebut root. Scene dibuat
dengan statement seperti ini:
```
```
Scene scene = new Scene(root, 250, 275, Color.BEIGE);
```
```
Constructor Scene menerima parameter size (lebar dan tinggi) dari scene awal dan parameter warna
background.
```
```
Akhirnya scene dimasukkan ke stage, ditentukan judulnya dan dibuat visible dengan method show.
```
```
stage.setScene(scene);
stage.setTitle("Smiley Face");
stage.show();
```
### Bagian B: The Hello World Application

Aplikasi SmileyFace tidak melibatkan interaksi user. Program GUI biasanya memerlukan input dari user berupa
klik button, ketikan teks, dsb. Aplikasi Hello World berikut ini memperlihatkan input user lewat button dan cara
meng-handle-nya.


Buat sebuah Eclipse project untuk program berikut:

**package** lab06_JavaFX_HelloWorld;

**import** javafx.application.Application;
**import** javafx.scene.Scene;
**import** javafx.scene.control.Button;
**import** javafx.scene.paint.Color;
**import** javafx.scene.text.Text;
**import** javafx.scene.text.Font;
**import** javafx.stage.Stage;
**import static** javafx.geometry.Pos. **_CENTER_** ;
**import** javafx.scene.layout.VBox;

**public class** HelloWorldJavaFX **extends** Application {
@Override
**public void** start(Stage primaryStage) {
Button btn = **new** Button();
Text message = **new** Text();
message.setFill(Color. **_DARKORANGE_** );
message.setFont(Font. _font_ ("Verdana", 20 ));
btn.setText("Kliklah aku!");
btn.setOnAction(event - > {
message.setText("Hello World! ala JavaFX :)");
});

VBox root = **new** VBox(10,btn,message);
root.setAlignment( **_CENTER_** );
Scene scene = **new** Scene(root, 300, 250);
primaryStage.setTitle(.........................................................);
primaryStage.setScene(...........................);
primaryStage.show();
}
**public static void** main(String[] args) {
_......................................................_ ;
}
}


## Penjelasan program

- Seperti pada Bagian A, isi dari scene direpresentasikan sebagai suatu tree of nodes. Pada application
    ini, root node berupa sebuah VBox layout object, yang resizable oleh user. VBox dipakai di sini
    sebagai container yang mengatur isinya secara vertikal.
- Kita menambahkan button btn ke baris pertama, kemudian menambahkan text message ke baris
    kedua, dengan vertical space of 10 pixels:

```
VBox root = new VBox(10,btn,message);
root.setAlignment(CENTER);
```
- Button diberi text dan event handler untuk menampilkan message Hello World! ala JavaFX :)
    apabila button diklik.
- Event handler dibuat dengan menggunakan ekspresi lambda:

```
btn.setOnAction(event -> {
message.setText("Hello World! ala JavaFX :)");
});
```
- Setelah method Application.launch() dieksekusi, application masuk ke ready state dan method start()
    akan dimulai.

### Bagian C: The ChangingFace Application

Kerjakan bagian ini sebagai Tugas Pemrograman 2, dengan batas waktu pengumpulan satu minggu dari hari ini.
Gabungkan pengetahuan dari Bagian A dan Bagian B untuk membuat solusi untuk Bagian C yang dimaksudkan
untuk membangun sebuah aplikasi JavaFX yang dapat menayangkan bermacam ekspresi wajah (tersenyum,
cemberut, serius, tertawa) dengan klik button.

### ...