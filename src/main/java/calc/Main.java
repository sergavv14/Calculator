package calc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import calc.factory.MyOpFactory;
import calc.operations.Operation;

public final class Main extends Application {

	@FXML
	private TextField display;

	private Double left;
	private String selectedOperator;
	private boolean numberInputting;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");
		stage.setOnCloseRequest(x -> {
			Platform.exit();
		});
		stage.setResizable(false);
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("main.fxml"))));
		stage.show();
	}

	@FXML
	protected void handleOnAnyButtonClicked(ActionEvent evt) {

		Button button = (Button) evt.getSource();
		final String buttonText = button.getText();
		if (buttonText.equals("C") || buttonText.equals("AC")) {
			if (buttonText.equals("AC")) {
				left = 0.0;
			}
			selectedOperator = "";
			numberInputting = false;
			display.setText("0");
			return;
		}
		if (buttonText.matches("[0-9\\.]")) {
			if (!numberInputting) {
				numberInputting = true;
				display.clear();
			}
			display.appendText(buttonText);
			return;
		}
		if (!buttonText.equals("=") && buttonText.matches("[+-x/]")) {
			try {
				left = new Double(display.getText());
			}
			catch (NumberFormatException e) {
				System.err.println("Caught IOException: " + e.getMessage());
				display.setText("Ошибка! Укажите правильно все аргументы! Результат = 0");
			}
			selectedOperator = buttonText;
			display.appendText(selectedOperator);
			numberInputting = false;
			return;
		}
		if (buttonText.equals("=")) {
			Double right = 0.0;
			try {
				right = numberInputting ? new Double(display.getText()) : left;
			}
			catch (NumberFormatException e) {
				System.err.println("Caught IOException: " + e.getMessage());
				display.setText("Ошибка! Укажите правильно все аргументы! Результат = 0");
			}

			MyOpFactory Factory = new MyOpFactory();
			Operation Oper = Factory.getOplnstance(selectedOperator);
			if (Oper == null) {
				display.setText("Ошибка! Укажите правильно все аргументы! Результат = 0");
				return;
			}
			left = Oper.exec(left, right);
			display.setText(left.toString());
			numberInputting = false;
			return;
		}
	}

	public static void main(String args[]) {
		launch(args);
	}
}
