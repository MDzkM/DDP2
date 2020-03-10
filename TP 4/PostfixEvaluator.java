import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import java.util.Stack;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PostfixEvaluator extends Application {
	
	@Override
	public void start(Stage primaryStage) {

		// Initialize variables
		Text inFixMessage = new Text();
		Text postFixMessage = new Text();
		Text sumMessage = new Text();
		Text postFix = new Text();
		Text sum = new Text();
		TextField inFix = new TextField();
		
		inFixMessage.setText("Ekspresi inFix:");
		postFixMessage.setText("Ekspresi postFix:");
		sumMessage.setText("Nilai:");
		
		// Event handling on ENTER
		inFix.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				
				// Get the postFix format and the result
				try {
					getpostFix(inFix, postFix);
					getSum(postFix, sum);
				} 
				
				// Exception handling
				catch (Exception e) {
					postFix.setText("");
					sum.setText("Invalid Input");
				}

			}
			
		});
		
		// Initialize the GUI
		GridPane root = new GridPane();
		root.setBackground(new Background(new BackgroundFill(Color.INDIANRED,null,null)));
		root.setAlignment(Pos.CENTER);
		
		// Adding all the elements to the GridPane
		root.add(inFixMessage,0,0);
		root.add(postFixMessage,0,1);
		root.add(sumMessage,0,2);
		root.add(inFix,1,0);
		root.add(postFix,1,1);
		root.add(sum,1,2);
		
		// set the horizontal alignment
		GridPane.setHalignment(inFixMessage, HPos.RIGHT);
		GridPane.setHalignment(postFixMessage, HPos.RIGHT);
		GridPane.setHalignment(sumMessage, HPos.RIGHT);
		
		// set the gap
		root.setHgap(10);
		root.setVgap(10);
		
		// initialize Scene
		Scene scene = new Scene(root, 500, 500);
		
		// titling and displaying
		primaryStage.setTitle("inFix -> postFix Evaluator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// Checking number
	private boolean isNumber(char num) {
		return num >= '0' && num <= '9';
	}
	
	// Checking parentheses
	private boolean isParentheses(char par) {
		return par == '(' || par == ')';
	}
	
	// Checking operator
	private boolean isOperator(char op) {
		return op == '+' || op == '-' || op == '*' || op == '/' || op == '$';
	}
	
	private int getVal(char x) {
		if(x == '(' || x == ')') {
			return 4;
		}
		
		else if(x == '$') {
			return 3;
		}
		
		else if(x == '*' || x == '/') {
			return 2;
		}
		
		else {
			return 1;
		}
	}
	
	// Precedence check
	private boolean hasHigherPrecedence(char firstElement, char secondElement) {
		if(getVal(firstElement) > getVal(secondElement)) {
			return true;
		}
		else {
			return false;
		}
	}

	private void getpostFix(TextField inFix, Text postFix) throws Exception {
		Stack<Character> operator = new Stack<>();
		String inFixStr = inFix.getText();
		StringBuilder tempOutput = new StringBuilder();
		boolean num = false;
		
		for (int i=0; i< inFixStr.length(); i++) {
			
			if(isNumber(inFixStr.charAt(i))) {
				num = true;
				tempOutput.append(inFixStr.charAt(i));
				continue;
			}
			
			if (i==0) {
				throw new Exception("Invalid Input");
			}
			
			if (num) {
				tempOutput.append(" ");
				num = false;
			}

			if (inFixStr.charAt(i)==' ') {
				continue;
			}

			// Invalid input
			if (!isOperator(inFixStr.charAt(i)) && !isParentheses(inFixStr.charAt(i))) {
				throw new Exception("Invalid Input");
			}
			
			if (isOperator(inFixStr.charAt(i))) {
				while(!operator.empty() && operator.peek()!='(' && hasHigherPrecedence(operator.peek(),inFixStr.charAt(i))) {
					tempOutput.append(operator.peek() + " ");
					operator.pop();
				}
				operator.push(inFixStr.charAt(i));
			}
			
			else if(inFixStr.charAt(i)=='(') {
				operator.push(inFixStr.charAt(i));
			} 
			
			else {
				while(!operator.empty() && operator.peek()!='(') {
					tempOutput.append(operator.peek() + " ");
					operator.pop();
				}
				
				if(operator.empty()) throw new Exception("Invalid Input");
				operator.pop();
			}
		}
		
		if (num) {
			tempOutput.append(" ");
		}
		
		else {
			throw new Exception("Invalid Input");
		}
		
		while(!operator.empty()) {
			tempOutput.append(operator.pop() + " ");
		}
		
		// Set as output
		postFix.setText(tempOutput.toString());
	}
	
	// Get the result based on the postFix
	private void getSum(Text postFix, Text sum) throws Exception {
		String postFixStr = postFix.getText();
		Stack<Long> operand = new Stack<>();
		long result = 0;
		boolean num = false;
		String tmp = "";
		
		for (int i=0; i < postFixStr.length(); i++) {
			
			if (isNumber(postFixStr.charAt(i))) {
				num = true;
				tmp += postFixStr.charAt(i);
				continue;
			}
			
			if (num) {
				operand.push(Long.parseLong(tmp));
			}
			
			tmp = "";
			num = false;
			
			if (postFixStr.charAt(i)==' ') {
				continue;
			}
			
			if (!isOperator(postFixStr.charAt(i)) && !isNumber(postFixStr.charAt(i))) {
				throw new Exception("Invalid Input");
			}
			
			long firstTop = operand.pop();
			long secondTop = operand.pop();
			
			switch(postFixStr.charAt(i)) {
				case '$':
					result = (int) Math.pow(secondTop, firstTop);
					break;
				case '*':
					result = secondTop * firstTop;
					break;
				case '/':
					result = secondTop / firstTop;
					break;
				case '+':
					result = secondTop + firstTop;
					break;
				case '-':
					result = secondTop - firstTop;
					break;
			}
			
			operand.push(result);
		}
		
		// Set as output
		sum.setText(Long.toString(operand.peek()));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
