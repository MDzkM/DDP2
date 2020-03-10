import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;


public class SlidersWithChangeListeners extends Application 
{
	
	private Ellipse ellipse;
	private Slider xSlider, ySlider;
	
	//--------------------------------------------------------------------
	// Displays an ellipse with sliders that control the width and
	// height of the ellipse.
	//--------------------------------------------------------------------
	
	public void start(Stage primaryStage)
	{
		ellipse = new Ellipse(250, 150, 150, 75);
		ellipse.setFill(Color.SALMON);
	
		//slider horizontal dengan nilai min 0, nilai max 200, dan nilai awal 150:
		xSlider = new Slider(0, 200, 150);
		xSlider.setShowTickMarks(true);
		xSlider.setShowTickLabels(true);
		xSlider.setPadding(new Insets(0, 20, 20, 80));

		xSlider.valueProperty().addListener(this::processResize);
	
		ySlider = new Slider(0, 150, 75);
		ySlider.setOrientation(Orientation.VERTICAL);
		ySlider.setShowTickMarks(true);
		ySlider.setShowTickLabels(true);
		ySlider.setPadding(new Insets(20, 0, 0, 30));

		ySlider.valueProperty().addListener(this::processResize);
	
		BorderPane pane = new BorderPane();
		pane.setLeft(ySlider);
		pane.setBottom(xSlider);
		pane.setCenter(ellipse);
		pane.setStyle("-fx-background-color: white");
		Scene scene = new Scene(pane, 500, 300);
	
		primaryStage.setTitle("Ellipse Sliders");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void processResize(ObservableValue<? extends Number> property,
			Object oldValue, Object newValue)
	{
		ellipse.setRadiusX(xSlider.getValue());
		ellipse.setRadiusY(ySlider.getValue());
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
