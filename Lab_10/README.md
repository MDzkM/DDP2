# Lab 10

## JavaFX Properties, Change Listeners, Sliders

Baca dokumen ini dengan seksama. Buat sebuah Eclipse project yang mencakup semua class (ada empat class) yang diperlukan untuk lab ini.

(A) JavaFX Properties

A JavaFX property is an object that holds a value, similar to a wrapper class object. But a property is observable, which means that the property value can be monitored and changed as needed. Many JavaFX classes store properties rather than regular instance data. For example, instead of storing an int value or an Integer object, a JavaFX class might store an IntegerProperty object. A key benefit to using properties is the concept of property binding. A property can be bound to another property, so that when the value of one property changes, the other is automaticcally updated. For example, the radius of the Circle class is represented by a DoubleProperty object, which could be bound to the property that represents the width of a Scene, so that the circle size changes automatically as the window is resized.

## The following program displays a small circle in the center of the scene, as well as two Text objects in the upper

## left corner that display the height and width of the scene. All of these elements are bound to the width and height

## of the scene such that, as the window (the scene) is resized, the position of the circle and the displayed text change

## automatically. Fill in the missing parts.

## The properties that represent the x and y coordinates of the circle's center are bound to the properties that

## represent the width and height of the scene, respectively. The x coordinate is always kept at one-half the value of

## the width property, and the y coordinate is kept at one-half of the height property. So the circle stays in the center

## of the window as the window is resized.

## The centerXProperty method returns the DoubleProperty object that represents the x coordinate of the circle's

## center. It is bound, using a call to the bind method of the property, to the property returned by the widthProperty

## method of the scene. That value is divided in half by a call to the divide method (properties are objects, so you

## can not use the regular arithmetic operators on them). A similar relationship is set up for the y coordinate and the

## height.

## The text displayed by a Text object is stored as a StringProperty object. In this program, two additional

## StringProperty objects are created to bind them to. Notice that a property can only be bound to another property.

## The text property displaying the width is bound to a string property containing "Lebar: " concatenated to the width

## of the scene. A similar relationship is set up for the height text.


#### package lab10_2019;

#### import javafx.application......................................................;

#### import javafx.beans.property.SimpleStringProperty;

#### import javafx.beans.property.StringProperty;

#### import javafx.scene.Group;

#### import javafx.scene.Scene;

#### import javafx.scene.paint.............................................;

#### import javafx.scene.shape.Circle;

#### import javafx.scene.text.Text;

#### import javafx.stage.Stage;

#### //************************************************************************

#### // Demonstrates the ability to bind one property to another.

#### //************************************************************************

#### public class ContohPropertyBinding extends ......................................................

#### {

#### //--------------------------------------------------------------------

#### // Displays the width and height of the scene, as well as a circle

#### // in the center of the scene. The scene is updated using property

#### // bindings as the window is resized.

#### //--------------------------------------------------------------------

#### public void start(Stage primaryStage)

#### {

#### Group root = new Group();

#### Scene scene = new Scene(root, 300, 200, Color. SKYBLUE );

#### Circle lingkaran = new Circle(50);

#### lingkaran.centerXProperty().bind(scene.widthProperty().divide(2));

#### lingkaran.centerYProperty()........................................................................................................................;

#### lingkaran.setFill(Color. BROWN );

#### StringProperty width = new SimpleStringProperty("Lebar: ");

#### StringProperty height = .........................................................................................................

#### Text widthText = new Text(20, 30, "");

#### widthText.textProperty().bind(width.concat(scene.widthProperty()));

#### Text heightText = new Text(20, 60, "");

#### heightText.textProperty()...........................................................................................................................;

#### root.getChildren().addAll(lingkaran, widthText, heightText);

#### primaryStage.setTitle("Contoh Property Binding");

#### primaryStage.setScene(scene);

#### primaryStage.show();

#### }

#### public static void main(String[] args)

#### {

#### launch (args);

#### }

#### }


### Note that no explicit event handlers were set up for this program. Property binding is taking care of all dynamic

### updates to the elements in the scene.

### However, it's important to recognize that a property binding cannot always be used in place of an event handler.

### Binding is used to keep data in sync, whereas an event handler is code executed when an event occurs to

### accomplish any desired effect. An event handler is, therefore, more versatile. Since we were only keeping data in

### sync in this program, property bindings were sufficient.

### (B)

### The following program is functionally equivalent to the ContohPropertyBinding program above, but uses a

### change listener instead of property binding. Fill in the missing parts.


**package** lab10_2019;
**import** javafx.application.Application;
**import** javafx.beans.value.ObservableValue;
**import** javafx.scene.Group;
**import** javafx.scene.Scene;
**import** javafx.scene.paint.Color;
**import** javafx.scene.shape.Circle;
**import** javafx.scene.text.Text;
**import** javafx.stage.Stage;
//************************************************************************
// Demonstrates the ability to respond to property changes using
// change listeners.
//************************************************************************
**public class** ContohChangeListener **extends** Application
{
**private** Scene scene;
**private** Circle ....................................;
**private** Text ........................................................................;
//--------------------------------------------------------------------
// Displays the width and height of the scene, as well as a circle
// in the center of the scene. The scene is updated using a change
// listener as the window is resized.
//--------------------------------------------------------------------
**public void** start(Stage primaryStage)
{
Group root = **new** Group();
scene = **new** Scene(root, 300, 200, Color. **_SKYBLUE_** );
scene.widthProperty().addListener( **this** ::processResize);
scene.heightProperty().addListener( **..................................................................** );
lingkaran = **new** Circle(50);
lingkaran.setCenterX(scene.getWidth() / 2);
lingkaran.setCenterY(scene.getHeight() / 2);
lingkaran.setFill(Color. **_ORANGE_** );
widthText = **new** Text(20, 30, "Lebar: " + scene.getWidth());
heightText = **new** Text(20, 60, "Tinggi: " + scene.getHeight());
root.getChildren().addAll(...................................., ...................................., ...........................);
primaryStage.setTitle("Contoh Change Listener");
primaryStage.setScene(scene);
primaryStage.show();
}
//--------------------------------------------------------------------
// Updates the position of the circle and the displayed width and
// height when the window is resized.
//--------------------------------------------------------------------
**public void** processResize(ObservableValue<? **extends** Number> property,
Object oldValue, Object newValue)
{
lingkaran.setCenterX(scene.getWidth() / 2);
...............................................................................................................
widthText.setText("Lebar: " + scene.getWidth());
...............................................................................................................
}
**public static void** main(String[] args)
{
_launch_ (args);
}
}

### In this version of the program, the scene, circle, and text objects are declared at the class level so that they can be

### accessed by the listener method. The same listener is used for changes in both the width and height of the scene.


### The new property value could have been obtained from the parameters to the listener method, but then we would

### have had to have a separate listener for the width and height (so we'd know which property to set) and there would

### have been a lot of casting involved. Instead, the method parameters are ignored and the new values are taken

### directly from the scene object.

## (C) Sliders

### A slider is a GUI control that allows the user to specify a numeric value within a bounded range. It's displayed as

### a track along which the slider knob can be dragged. A slider can be presented either vertically or horizontally and

### can have optional tick marks and labels indicating the range of values.

### The following program displays an ellipse and allows the user to control the shape of that ellipse using two

### sliders. The horizontal slider determines the value of the radius along the x axis of the ellipse and the vertical

### slider determines the value of the radius along the y axis. Fill in the missing parts.

### A slider is presented horizontally unless you explicitly set it to vertical using its setOrientation method. The

### setShowTickMarks and setShowTickLabels methods accept a boolean value and is used to set whether tick marks

### and tick labels should be displayed next to the slider bar. The setPadding method determines the spacing around

### the slider when it is displayed. The Slider class has additional methods that can be used to tailor the look and

### behavior of a slider.

### The changes made to the ellipse are done through property bindings as explained in Part (A). The property

### representing the x radius of the ellipse is bound (using the bind method) to the value of the horizontal slider.

### Likewise, the property representing the y radius of the ellipse is bound to the value of the vertical slider. If

### property binding is not used, the value of a slider can also be obtained explicitly using the getValue method, or a

### change listener can be set up to react to the slider movement.


##### package lab10_2019;

##### import javafx.application.Application;

##### import javafx.geometry.Insets;

##### import javafx.geometry.Orientation;

##### import javafx.scene.Scene;

##### import javafx.scene.control.Slider;

##### import javafx.scene.layout.........................................................;

##### import javafx.scene.paint.Color;

##### import javafx.scene.shape......................................................;

##### import javafx.stage.Stage;

##### //************************************************************************

##### // Demonstrates the use of slider controls and property binding.

##### //************************************************************************

##### public class EllipseSliders extends Application

##### {

##### private Ellipse ellipse;

##### private Slider xSlider, ySlider;

##### //--------------------------------------------------------------------

##### // Displays an ellipse with sliders that control the width and

##### // height of the ellipse.

##### //--------------------------------------------------------------------

##### public void start(Stage primaryStage)

##### {

##### ellipse = new Ellipse(250, 150, 150, 75);

##### ellipse.setFill(Color.SALMON);

##### //slider horizontal dengan nilai min 0, nilai max 200, dan nilai awal 150:

##### xSlider = new Slider(0, 200, 150);

##### xSlider.setShowTickMarks(true);

##### xSlider.setShowTickLabels(true);

##### xSlider.setPadding(new Insets(0, 20, 20, 80));

##### ellipse.radiusXProperty().bind(xSlider.valueProperty());

##### ySlider = new Slider(.........................................................);

##### ySlider.setOrientation(Orientation.VERTICAL);

##### ySlider.setShowTickMarks(...........................);

##### ySlider.setShowTickLabels(........................);

##### ySlider.setPadding(new Insets(20, 0, 0, 30));

##### ellipse.radiusYProperty().bind(.......................................................................................);

##### BorderPane pane = new BorderPane();

##### pane.setLeft(.................................);

##### pane.setBottom(xSlider);

##### pane.setCenter(ellipse);

##### pane.setStyle("-fx-background-color: white");

##### Scene scene = new Scene(pane, 500, 300);

##### primaryStage.setTitle("Ellipse Sliders");

##### primaryStage.setScene(scene);

##### primaryStage.show();

##### }

##### public static void main(String[] args)

##### {

##### ...............................................................;

##### }

##### }


## (D) Sliders with Change Listener

### Modifikasi program dari Bagian (C) dengan menggantikan penggunaan property bindings dengan penggunaan

### change listener.