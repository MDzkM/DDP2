import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PushCounterNG extends Application {
	private int count;
	private Text countText;
	
	//--------------------------------------------------------------------
	//	Presents a GUI containing a button and text that displays
	//	how many times the button is pushed.
	//--------------------------------------------------------------------
	
	public void start(Stage primaryStage) {
		count = 0;
		countText = new Text("Nilai: 0");
		
		Button naik = new Button("Naik");
		naik.setOnAction(this::processButtonPress);
		
		Button reset = new Button("Reset");
		reset.setOnAction((event)-> {count = 0; countText.setText("Nilai: " + count);});
		
		Button turun = new Button("Turun");
		turun.setOnAction(new ButtonHandler());
		
		VBox box = new VBox(naik, reset, turun);
		
		FlowPane pane = new FlowPane(box, countText);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);
		pane.setStyle("-fx-background-color: cyan");
		
		Scene scene = new Scene(pane, 300, 100);
		
		primaryStage.setTitle("Klik Counter");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void processButtonPress(ActionEvent event) {
		countText.setText("Nilai:" + (++count));
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			countText.setText("Nilai: " + (--count));
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
