# Lab 07

## Lebih Jauh dengan JavaFX

Baca seluruh dokumen ini dengan seksama, kalau perlu berkali-kali.  Banyak hal baru yang akan Anda pelajari.

Pada Lab06, kita telah mempelajari beberapa hal dasar tentang JavaFX. Pada Lab 07 ini, kita akan mempelajari
Color, Image, Event, dan Event handling.

## Color

Seperti dalam Python, warna dalam Java juga didefinisikan oleh tiga bilangan R,G,B (Red,Green,Blue). Tiap
bilangan RGB merepresentasikan kontribusi dari komponen warna ybs. Nilai RGB berkisar dari 0 sampai dengan

255. Sebuah warna direpresentasikan oleh sebuah object dari class Color. Class Color mempunyai method static
bernama rgb yang me-return object Color dengan menerima tiga parameter RGB. Contoh:

Color pink = Color.rgb(255,192,203); //Color.PINK

Tabel berikut ini memperlihatkan beberapa warna umum yang sudah predefined dari class Color:

## A) Menayangkan Citra (Image)

Object Image merepresentasikan sebuah citra (image) dan proses
loading-nya dari sebuah file atau URL. Format yang didukung adalah
JPEG, GIF dan PNG.
ImageView adalah node JavaFX untuk menayangkan sebuah object
image. Program berikut dimaksudkan untuk
menayangkan sebuah image di tengah-tengah window. Lengkapi
dengan mengikuti penjelasan di bawah.


package lab07_image;

import javafx.application...................................................
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//************************************************************************
// Demonstrates a the use of Image and ImageView objects.
//************************************************************************

public class ImageDisplay extends ...................................................
{
//--------------------------------------------------------------------
// Displays an image centered in a window.
//--------------------------------------------------------------------
public void start(................................. primaryStage)
{
Image img = new ...........................("lab07_image/gull.jpg");
ImageView imgView = new .................................(img);

StackPane pane = new StackPane(imgView);
pane.setStyle("-fx-background-color: cornsilk");

Scene scene = new Scene(..........................., 500, 350);

primaryStage.setTitle("Image Display");
primaryStage.setScene(..............................);
primaryStage..........................................;
}

public static void main(String[] args)
{
launch(.................................);
}
}

Program JavaFX ini tidak menggunakan object Group sebagai root node, tetapi menggunakan object StackPane.
Class StackPane adalah satu dari beberapa layout panes yang dalam API JavaFX. Sebuah layout pane adalah
sebuah container yang mengatur bagaimana controls (seperti button, text field dsb) diletakkan dan disajikan
secara visual. Sebuah layout pane akan menyesuaikan penampilan apabila diperlukan seperti kalau window di-
resize.

Node-node dalam sebuah StackPane di-stack (ditumpuk) satu di atas yang lain. Sebagai contoh, StackPane bisa
digunakan untuk overlay text di atas sebuah shape. Dalam contoh di atas, object ImageView adalah satu-satunya
node yang ditambahkan ke pane, sehingga ia hanya membuat posisi image tetap di tengah window. Layout pane
yang lain akan dipelajari nanti.


Method setStyle dari StackPane dipakai untuk menentukan background-color dari pane. Layout pane bisa punya
background color sendiri. Method setStyle itu menerima sebuah String yang menentukan style properties. Style
properties dalam JavaFX mengikuti CSS (Cascading Style Sheet) yang dipergunakan untuk mendefinisikan
tampilan (look) dari unsur-unsur HTML dalam sebuah Webpage. Nama style property JavaFX dimulai dengan
awalan "-fx-".

Parameter untuk constructor Image dapat berupa pathname terhadap direktori (folder) dari class ybs atau sebuah
URL. Sebagai contoh, statement berikut menentukan image dalam direktori gambar:

Image logo = new Image("gambar/logoUI.png");

atau image yang diperoleh dari sebuah URL:

Image logo = new Image("http://contoh.co.id/images/foto.jpg");

File "gull.jpg" yang dipakai dalam contoh di atas diberikan pada course-page di SCeLE.

## B) Event dan Event Handler

Program berikut menampilkan sebuah button "Klik Aku". Setiap kali di-klik, nilai counter di-update dan
ditayangkan. Lengkapi dengan mengikuti penjelasan di bawah.


**package** lab07_Counter;

**import** javafx.application.Application;
**import** javafx.event.ActionEvent;
**import** javafx.geometry.Pos;
**import** javafx.scene.Scene;
**import** javafx.scene.control.Button;
**import** javafx.scene.text.Text;
**import** javafx.scene.layout.FlowPane;
**import** javafx.stage.Stage;

//************************************************************************
// Demonstrates JavaFX buttons and event handlers.
//************************************************************************

**public class** PushCounter **extends** Application
{
**private int** ..........................................;
**private** Text .......................................;

//--------------------------------------------------------------------
// Presents a GUI containing a button and text that displays
// how many times the button is pushed.
//--------------------------------------------------------------------
**public void** start(Stage primaryStage)
{
count = 0;
countText = **new** Text("Jumlah klik: 0");

Button push = **new** Button("Klik Aku!");
push.setOnAction( **this** ::...........................................................................);

FlowPane pane = **new** FlowPane(........................, .................................);
pane.setAlignment(Pos. **_CENTER_** );
pane.setHgap(20);
pane.setStyle("-fx-background-color: cyan");

Scene scene = **new** Scene(..........................., 300, 100);

primaryStage.setTitle("Klik Counter");
primaryStage.setScene(...........................);
primaryStage.show();
}

//--------------------------------------------------------------------
// Updates the counter and text when the button is pushed.
//--------------------------------------------------------------------
**public void** processButtonPress(ActionEvent event)
{
countText.setText("Jumlah klik: " + ....................................);
}

**public static void** main(String[] args)
{
_launch_ (args);
}
}


## C) Cara lain untuk menentukan Event Handlers

Program sebelumnya menggunakan method reference (dengan operator ::) untuk menentukan event handler untuk
action event yang dihasilkan oleh object Button. Sekarang kita pelajari cara lain untuk mendefinisikan sebuah
event handler.

Sebuah event handler sebenarnya adalah sebuah object yang mengimplementasikan interface yang bernama
EventHandler. Sebuah interface terdiri dari sejumlah method yang harus diimplementasikan oleh suatu class.
Dalam kasus ini, interface EventHandler mengharuskan ada sebuah object yang mendefinisikan
(mengimplementasikan) sebuah method bernama handle untuk memproses event. Jadi pendekatan alternatif untuk
membuat sebuah event handler adalah mendefinisikan sebuah class lengkap yang mengimplementasikan interface
EventHandler. Class ini bisa berupa sebuah private inner class yang didefinisikan dalam class PushCounter itu.

private class ButtonHandler implements EventHandler<ActionEvent> {
public void handle(ActionEvent event) {
countText.setText("Jumlah klik: " + ..................);
}
}

Pemanggilan method setOnAction untuk button itu dapat menggunakan object dari ButtonHandler:

push.setOnAction(new ButtonHandler());

Sebagai pengganti class private yang terpisah ini, event handler dapat juga didefinisikan dengan menggunakan
lambda expression:


push.setOnAction( (event)-> {
countText.setText("Jumlah klik: " + ..................);
}
);

Dari tiga cara untuk mendefinisikan event handler, mana cara yang paling ringkas? Mana cara yang paling Anda
suka? Buat sebuah aplikasi sebagai pengembangan dari Bagian B, yang menayangkan tiga buah Button: Naik,
Reset, dan Turun; masing-masing untuk increment (+1), reset ke 0 dan decrement (- 1 ) nilai counter.
Penampilannya seperti berikut:

Masing-masing button harus menggunakan event-handler yang berbeda caranya, seperti dijelaskan di atas. Button
Naik menggunakan operator ::, button Reset menggunakan ekspresi lambda, button Turun menggunakan private
inner class.