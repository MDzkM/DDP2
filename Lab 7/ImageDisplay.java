import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//*************************************************************************
//	Demonstrates the use of Image and ImageView objects.
//*************************************************************************

public class ImageDisplay extends Application {
	
	//-----------------------------------------
	//	Displays an image centered in a window.
	//-----------------------------------------
	
	public void start(Stage primaryStage) {
		Image img = new Image("lab07_image/gull.jpg");
		ImageView imgView = new ImageView(img);
		
		StackPane pane = new StackPane(imgView);
		pane.setStyle("-fx-background-color: cornsilk");
		
		Scene scene = new Scene(pane, 500, 350);
		
		primaryStage.setTitle("Image Display");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
