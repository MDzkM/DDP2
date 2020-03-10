import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class CobaKeyEvent extends Application{

	@Override // Override the start method in the Application class
	
	public void start(Stage primaryStage) {
		
		// Create a pane and set its properties
		final int DELTA = 10;
		Pane pane = new Pane();
		Text text = new Text(20, 20, "A");
		text.setFill(Color.ORANGE);
		text.setFont(Font.font("Courier", FontWeight.BOLD, 20));
		pane.getChildren().add(text);
		
		// Create a scene and place the pane in the stage
		Scene scene = new Scene(pane, 300, 150);
		scene.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case DOWN: text.setY(text.getY() + DELTA); break;
			case UP: text.setY(text.getY() - DELTA); break;
			case RIGHT: text.setX(text.getX() + DELTA); break;
			case LEFT: text.setX(text.getX() - DELTA); break;
			default:
				if (e.getText().length() > 0)
					text.setText(e.getText());
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
