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
import javafx.scene.control.Button;
import static javafx.geometry.Pos.CENTER;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class ChangingFace extends Application {
	
	@Override
	
	public void start(Stage primaryStage) {
		
		// Create a text
		Text message = new Text();
		message.setFill(Color.DARKORANGE);
		message.setFont(Font.font ("Verdana", 20));
		message.setText("Changing Face");
		
		// Create a face
		Face face = new Face();

		// Create a smiling face button
		Button btnMouthSmile = new Button();
		btnMouthSmile.setText("Smile");
		btnMouthSmile.setMinWidth(50);
		btnMouthSmile.setOnAction(event -> {
			face.mouthSmile();
		});
		
		// Create a laughing face button
		Button btnMouthLaugh = new Button();
		btnMouthLaugh.setText("Laugh");
		btnMouthLaugh.setMinWidth(50);
		btnMouthLaugh.setOnAction(event -> {
			face.mouthLaugh();
		});
		
		// Create a serious face button
		Button btnMouthSerious = new Button();
		btnMouthSerious.setText("Serious");
		btnMouthSerious.setMinWidth(50);
		btnMouthSerious.setOnAction(event -> {
			face.mouthSerious();
		});
		
		// Create a sad face button
		Button btnMouthSad = new Button();
		btnMouthSad.setMinWidth(50);
		btnMouthSad.setText("Sad");
		btnMouthSad.setOnAction(event -> {
			face.mouthSad();
		});

		
		// Make mouth buttons horizontally centered
		HBox BtnBox = new HBox(10, btnMouthSmile, btnMouthLaugh, btnMouthSerious, btnMouthSad);
		BtnBox.setAlignment(CENTER);
		
		// Make nodes vertically centered
		VBox root = new VBox(10, BtnBox, face.getGroup(), message);
		root.setAlignment(CENTER);
		
		// Create a scene
		Scene scene = new Scene(root, 300, 265);
		
		// Show application
		primaryStage.setTitle("Changing Face");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private class Face {
		private Circle face, leftEye, rightEye;
		private Arc mouth;
		private Group root;
		
		public Face() {
			// create and configure the main circle for the face
			face = new Circle(125, 125, 80);
			face.setFill(Color.YELLOW);
			face.setStroke(Color.RED);	
			
			// create and configure a normal right eye
			rightEye = new Circle(86, 100, 10);
			rightEye.setFill(Color.CYAN);
			rightEye.setStroke(Color.BLUE);
			
			// create and configure a normal left eye
			leftEye = new Circle(161, 100, 10);
			leftEye.setFill(Color.CYAN);
			leftEye.setStroke(Color.BLUE);
			
			// create and configure a smiling mouth
			mouth = new Arc(125, 150, 42, 35, 0, -180);
			mouth.setFill(Color.YELLOW);
			mouth.setStroke(Color.BLUE);
			mouth.setType(ArcType.OPEN);
			
			// create a group that holds all the features
			root = new Group(face, rightEye, leftEye, mouth);
		}

		public void mouthSmile() {
			// configure a smiling face
			mouth.setType(ArcType.OPEN);
			mouth.setRadiusY(35);
			mouth.setLength(-180);
		    mouth.setFill(Color.TRANSPARENT);
		}
		
		public void mouthLaugh() {
			// configure a laughing face
			mouth.setType(ArcType.ROUND);
			mouth.setRadiusY(35);
			mouth.setLength(-180);
			mouth.setFill(Color.AZURE);
		}
		
		public void mouthSerious() {
			// configure a flat face
			mouth.setType(ArcType.OPEN);
			mouth.setRadiusY(0);
			mouth.setLength(180);
		    mouth.setFill(Color.TRANSPARENT);
		}
		
		public void mouthSad() {
			// configure a sad face
			mouth.setType(ArcType.OPEN);
			mouth.setRadiusY(35);
			mouth.setLength(180);
		    mouth.setFill(Color.TRANSPARENT);
		}
		
		public Group getGroup() {
			return root;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
