import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEventDemo extends Application{
	
	@Override // Override the start method in the Application class
	
	public void start(Stage primaryStage) {
		
		// Create a pane and set its properties
		Pane pane = new Pane();
		Text text = new Text(20, 20, "JavaFX Programming is fun");
		text.setFill(Color.BLUE);
		pane.getChildren().add(text);
		
		// Handling the event when the mouse is pressed
		// with the cursor on the text and dragged
		text.setOnMouseDragged(event -> {
			text.setX(event.getSceneX());
			text.setY(event.getSceneY());
			});
		
		// Handling the event when the mouse is pressed with the cursor
		// somewhere on the pane and the text jumps to the location
		pane.setOnMousePressed(event -> {
			text.setX(event.getSceneX());
			text.setY(event.getSceneY());
			});
		
		//	Create a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 100);
		primaryStage.setTitle("MouseEventDemo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	
	public static void main(String[] args) {
		launch(args);
	}
}
