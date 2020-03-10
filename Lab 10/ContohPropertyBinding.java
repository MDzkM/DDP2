import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//************************************************************************
// Demonstrates the ability to bind one property to another.
//************************************************************************

public class ContohPropertyBinding extends Application
{
	//--------------------------------------------------------------------
	// Displays the width and height of the scene, as well as a circle
	// in the center of the scene. The scene is updated using property
	// bindings as the window is resized.
	//--------------------------------------------------------------------
	
	public void start(Stage primaryStage)
	{
		Group root = new Group();
		Scene scene = new Scene(root, 300, 200, Color.SKYBLUE);
		Circle lingkaran = new Circle(50);
		lingkaran.centerXProperty().bind(scene.widthProperty().divide(2));
		lingkaran.centerYProperty().bind(scene.heightProperty().divide(2));
		lingkaran.setFill(Color.BROWN);

		StringProperty width = new SimpleStringProperty("Lebar: ");
		StringProperty height = new SimpleStringProperty("Tinggi: ");

		Text widthText = new Text(20, 30, "");
		widthText.textProperty().bind(width.concat(scene.widthProperty()));

		Text heightText = new Text(20, 60, "");
		heightText.textProperty().bind(height.concat(scene.heightProperty()));;
		root.getChildren().addAll(lingkaran, widthText, heightText);

		primaryStage.setTitle("Contoh Property Binding");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}