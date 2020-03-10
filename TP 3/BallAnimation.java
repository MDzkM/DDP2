import javafx.application.Application;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.animation.PathTransition;
import javafx.util.Duration;

public class BallAnimation extends Application {
	
	@Override // Override the start method in the Application class
	
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		
		// Create arrow for x and y axis
		Arrow xAxis = new Arrow(25.0, 175.0, 775.0, 175.0);
		Arrow yAxis = new Arrow(400.0, 50.0, 400.0, 300.0);
		
		Group xAxisArrow = xAxis.getGroup();
		Group yAxisArrow = yAxis.getGroup();
		
		// Create a cosine graph
		Polyline cosineCurve = new Polyline();
		cosineCurve.setStroke(Color.RED);
		cosineCurve.setStrokeWidth(1.75);
		
		for (double x = 60.0; x <= 740.0; x += 1.0) {
			cosineCurve.getPoints().add(Double.valueOf(x));
			double y = -80 * Math.cos(4 * Math.PI * (x - 25.0)/375.0 - 4 * Math.PI) + 175.0;
			cosineCurve.getPoints().add(Double.valueOf(y));
		}
		
		// Create a circle
		Circle circle = new Circle(125, 100, 15);
		circle.setFill(Color.GREEN);
		circle.setStroke(Color.GREEN);
		
		// Place objects inside pane
		pane.getChildren().addAll(xAxisArrow, yAxisArrow, cosineCurve, circle);
		writeOverlay(pane);
		
		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(6000));
		pt.setPath(cosineCurve);
		pt.setNode(circle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play(); // Start animation
		
		// Add event handler when the mouse is clicked
		pane.setOnMouseClicked(new EventHandler<Event>() {
			private boolean isPlaying = true; // to toggle between pause and play
			
			@Override
			public void handle(Event arg0) {
				if (isPlaying)
					pt.pause();
				else
					pt.play();
				isPlaying ^= true; // set current state
			}
		});
		
		// Create a scene which contains pane and place it in the stage
		Scene scene = new Scene(pane, 800, 350);
		primaryStage.setTitle("TP 03: Animasi Bola pada Kurva"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	private class Arrow extends Group {
		// Draw an arrow on a specified position and put it into a group
		private Group group = new Group();
		
		public Arrow(double startX, double startY, double endX, double endY) {
			if (startX == endX) {
				Line verticalLine = new Line(startX, startY, endX, endY);
				Line arrowHeadLeft = new Line(startX + 375.0, startY + 125.0 , endX + 350.0, endY - 140.0);
				Line arrowHeadRight = new Line(startX + 375.0, startY + 125.0 , endX + 350.0, endY - 110.0);
				group.getChildren().addAll(verticalLine, arrowHeadLeft, arrowHeadRight);
			}
			else {
				Line horizontalLine = new Line(startX, startY, endX, endY);
				Line arrowHeadUp = new Line(startX + 375.0, startY - 125.0 , endX - 390.0, endY - 100.0);
				Line arrowHeadDown = new Line(startX + 375.0, startY - 125.0 , endX - 360.0, endY - 100.0);
				group.getChildren().addAll(horizontalLine, arrowHeadUp, arrowHeadDown);
			}
		}
		
		public Group getGroup() {
			return group;
		}
	}

	// Write the text overlay on a specified position and put it into the pane
	public void writeOverlay(Pane pane) {
	
		// Write -k*PI, 0, and k*PI
		for (int i = 0; i < 7; ++i) {
			if (i < 3) {
				Text text = new Text(105 + i*95, 200, (i-3 == -1 ? "-" : "" + (i-3)) + "\u03C0");
				pane.getChildren().add(text);	
			}
			
			else if (i == 3) {
				Text text = new Text(408, 200, "0");
				pane.getChildren().add(text);	
			}
			
			else if (i > 3) {
				Text text = new Text(488 + (i-3)*91, 200, (i-2 == 1 ? "" : "" + (i-2)) + "\u03C0");
				pane.getChildren().add(text);
			}
		}
		
		// Write x and y
		for (int i = 0; i < 2; ++i) {
			if (i == 0) {
				// Write X
				Text text = new Text(765, 130, "X");
				pane.getChildren().add(text);
			}
			
			else {
				// Write Y
				Text text = new Text(432, 57, "Y");
				pane.getChildren().add(text);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
