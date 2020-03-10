import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//************************************************************************
// Demonstrates the ability to respond to property changes using
// change listeners.
//************************************************************************

public class ContohChangeListener extends Application
{
	private Scene scene;
	private Circle lingkaran;
	private Text widthText, heightText;

	//--------------------------------------------------------------------
	// Displays the width and height of the scene, as well as a circle
	// in the center of the scene. The scene is updated using a change
	// listener as the window is resized.
	//--------------------------------------------------------------------
	public void start(Stage primaryStage)
	{
		Group root = new Group();

		scene = new Scene(root, 300, 200, Color.SKYBLUE);
		scene.widthProperty().addListener(this::processResize);
		scene.heightProperty().addListener(this::processResize);
		lingkaran = new Circle(50);
		lingkaran.setCenterX(scene.getWidth() / 2);
		lingkaran.setCenterY(scene.getHeight() / 2);
		lingkaran.setFill(Color.ORANGE);
		widthText = new Text(20, 30, "Lebar: " + scene.getWidth());
		heightText = new Text(20, 60, "Tinggi: " + scene.getHeight());

		root.getChildren().addAll(lingkaran, widthText, heightText);

		primaryStage.setTitle("Contoh Change Listener");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//--------------------------------------------------------------------
	// Updates the position of the circle and the displayed width and
	// height when the window is resized.
	//--------------------------------------------------------------------
	
	public void processResize(ObservableValue<? extends Number> property,
			Object oldValue, Object newValue)
	{
		lingkaran.setCenterX(scene.getWidth() / 2);
		lingkaran.setCenterY(scene.getHeight() / 2);
		widthText.setText("Lebar: " + scene.getWidth());
		heightText.setText("Tinggi: " + scene.getHeight());
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}