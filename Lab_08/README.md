# Lab 08

## Pemrograman Event-driven

Baca seluruh dokumen ini dengan seksama, kalau perlu berkali-kali.  Banyak hal baru yang akan Anda pelajari.

Dalam Lab 07, kita telah mempelajari beberapa hal dasar tentang Event dan Event handling. Dalam Lab 08 ini,
kita akan mendalami pemrograman event-driven yang berkaitan dengan mouse dan keyboard.

## A) Events dan Event Sources

Event adalah object yang dibuat oleh sebuah event-source. Firing an event artinya membuat sebuah event dan
mendelegasikan kepada suatu handler untuk meng-handle event tsb.

Apabila program Java berbasis GUI dijalankan, ia berinteraksi dengan user dan event yang timbul menentukan
pelaksanaan program. Inilah event-driven programming. Sebuah event merupakan sebuah signal yang dikirim ke
program bahwa sesuatu telah terjadi. Event ditimbulkan oleh tindakan user seperti mouse movements, mouse
clicks, dan keystrokes. Program dapat memilih untuk respond atau mengabaikan event.

Sebagai contoh, button adalah event-source untuk button clicking action event.

An event is an instance of an event class. The root class of the Java event classes is java.util.EventObject. The
root class of the JavaFX event classes is javafx.event.Event.

Sebuah event object mengandung segala properties yang berkaitan dengan event tsb. Source object dari sebuah
event dapat ditentukan dengan instance method getSource( ) dari class EventObject. Subclasses dari EventObject
dapat menangani tipe-tipe event tertentu, seperti action events, window events, mouse events, dan key events.
Pelajari Tabel berikut:


Seperti telah kita lihat sebelumnya, Java menggunakan model berbasis delegation untuk event handling: A source
object fires an event, and an event handler (or event listener) object interested in the event handles it. Ada dua hal
yang harus dipenuhi agar sebuah object dapat berlaku sebagai handler:

### Mouse Events

A MouseEvent is fired whenever a mouse button is pressed, released, clicked, moved, or dragged on a node or a
scene. The MouseEvent object captures the event, such as the number of clicks associated with it,
the location (the x- and y-coordinates) of the mouse cursor, or which mouse button was pressed.


## Layout Panes & Groups

JavaFX provides many types of panes for automatically laying out nodes in a desired
location and size.
Panes and groups are the containers for holding nodes. The Group class is often used to group
nodes and to perform transformation and scale as a group. JavaFX provides many types of
panes for organizing nodes in a container, as shown in the Table below.

Read the documentation for more details.

A Pane is usually used as a canvas for displaying shapes. Pane is the base class for all specialized panes. For
example, nodes are placed in the center of a StackPane. Each pane contains a list for holding nodes in the pane.
This list is an instance of ObservableList, which can be obtained using pane’s getChildren( ) method.
We can use add(node) to add an element to the list and addAll(node1, node2, ...) to add a variable number of
nodes.

Program berikut dimaksudkan untuk menayangkan sebuah teks dan dapat menggerakkannya dengan
menggunakan mouse. Teks lompat ke lokasi cursor dalam pane apabila mouse di-press. Teks bergerak
mengikuti cursor apabila cursor dalam teks dan mouse di-dragged. Lengkapi program sesuai comments.


**package** lab08_JavaFX_mouse;

**import** javafx.application.Application;
**import** javafx.scene.Scene;
**import** javafx.scene.layout.Pane;
**import** javafx.scene.paint.Color;
**import** javafx.scene.text.Text;
**import** javafx.stage.Stage;

**public class** MouseEventDemo **extends** ......................................................... {
@Override // Override the start method in the Application class
**public void** start(Stage primaryStage) {
// Create a pane and set its properties
Pane pane = **new** Pane();
Text text = **new** Text(20, 20, "JavaFX Programming is fun");
text.setFill(Color. **_BLUE_** );
pane.getChildren().add(....................................);
//handling the event when the mouse is pressed with the cursor on the
//text and dragged
text.setOnMouseDragged(event - >

.....................................................................

);


//handling the event when the mouse is pressed with the cursor somewhere
//on the pane and the text jumps to the location

#### ............................setOnMousePressed(

##### ......................................................

##### );

// Create a scene and place it in the stage
Scene scene = **new** Scene(pane, 300, 100);
primaryStage.setTitle("MouseEventDemo"); // Set the stage title
primaryStage.setScene(scene); // Place the scene in the stage
primaryStage...............................; // Display the stage
}

/**
* The main method is only needed for the IDE with limited
* JavaFX support. Not needed for running from the command line.
*/
**public static void** main(String[] args) {
_....................................................................._
}
}

### B) Working with Key Event

A KeyEvent is fired whenever a key is pressed, released, or typed on a node or a
scene. Key events enable the use of the keys to control and perform actions, or get input from the
keyboard. The KeyEvent object describes the nature of the event (namely, that a key has been
pressed, released, or typed) and the value of the key.

The key events: key pressed, key released, and key typed and their corresponding registration
methods for handlers are listed previously in Table on page 2.
The key pressed handler is invoked when a key is pressed, the key released handler is invoked when a key is
released, and the key typed handler is invoked when a Unicode character is entered. If a key does not have a
Unicode (e.g., function keys, modifier keys, action keys, arrow keys, and control keys), the key typed
handler will not be invoked.


Every key event has an associated code that is returned by the getCode( ) method in
KeyEvent. The key codes are constants defined in KeyCode. Table 15.2 lists some constants.
For the key-pressed and key-released events, getCode() returns the value as defined in the table, getText() returns
a string that describes the key code, and getCharacter() returns an empty string. For the
key-typed event, getCode() returns UNDEFINED and getCharacter() returns the Unicode
character or a sequence of characters associated with the key-typed event.

Program berikut dimaksudkan untuk menayangkan character yang diketik user. User dapat menggerakkan
character itu dengan menggunakan tombol keyboard: up-arrow, down-arrow, left-arrow, dan right-arrow.
Lengkapi program sesuai comments.

#### Program melakukan hal-hal berikut:

####  It creates a pane, creates a text, and places the text into the pane.

####  The text registers the handler for the key-pressed event. When a key is pressed, the handler is

#### invoked.

####  The program uses e.getCode() to obtain the key code and e.getText() to get the character for the

#### key. Note that for a nonprintable character such as a CTRL key or SHIFT key, e.getText()

#### returns an empty string.

####  When a non-arrow key is pressed, the character is displayed. When an arrow key is pressed, the

#### character moves in the direction indicated by the arrow key.


**package** lab08_JavaFX_key;

**import** javafx.application.Application;
**import** javafx.scene.Scene;
**import** javafx.scene.layout.Pane;
**import** javafx.scene.paint.Color;
**import** javafx.scene.text.*;
**import** javafx.stage.Stage;

**public class** CobaKeyEvent **extends** Application {
@Override // Override the start method in the Application class
**public void** start(................................. primaryStage) {
// Create a pane and set its properties
**final int** DELTA = 10;
Pane pane = **new** Pane();
Text text = **new** Text(20, 20, "A");
text.setFill(Color. **_ORANGE_** );
text.setFont(Font. _font_ ("Courier", FontWeight. **_BOLD_** , 20));
pane.getChildren().add(text);

// Create a scene and place the pane in the stage
Scene scene = **new** Scene(pane,300,150);
scene.setOnKeyPressed(e - > {
**switch** (e.getCode()) {
**case** **_DOWN_** : text.setY(text.getY() + DELTA); **break** ;
.................................................................................................................................
.................................................................................................................................
.................................................................................................................................
**default** :
**if** (e.getText().length() > 0)
text.setText(..............................................................................);
}
});
primaryStage.setTitle("Coba KeyEvent"); // Set the stage title
primaryStage.setScene(scene); // Place the scene in the stage
primaryStage.show(); // Display the stage

}

/**
* The main method is only needed for the IDE with limited
* JavaFX support. Not needed for running from the command line.
*/
**public static void** main(String[] args) {
_launch_ (args);
}
}