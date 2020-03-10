import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static javafx.geometry.Pos.CENTER;
import javafx.scene.layout.VBox;

public class HelloWorldJavaFX extends Application {
	
	@Override
	
	public void start(Stage primaryStage) {
		Button btn = new Button();
		Text message = new Text();
		message.setFill(Color.DARKORANGE);
		message.setFont(Font.font ("Verdana", 20));
		btn.setText("Kliklah aku!");
		btn.setOnAction(event -> {
		message.setText("Hello World! ala JavaFX :)");
		});
		VBox root = new VBox(10,btn,message);
		root.setAlignment(CENTER);
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Hello World JavaFX"); // set title for application
		primaryStage.setScene(scene); // set scene to be showed on stage
		primaryStage.show();
		}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
