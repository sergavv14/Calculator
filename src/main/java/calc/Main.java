package calc;

import calc.reader.DataReader;
import calc.reader.ReadFromConsole;
import calc.reader.ReadFromFile;
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

import java.util.Scanner;

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


	// STATIC MAIN
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Boolean isExit = false;

		while (!isExit) {
		    System.out.println("");
			System.out.println("Меню:");
			System.out.println("1 - Калькулятор с интерфейсом;");
			System.out.println("2 - Калькулятор ввод аргументов с консоли;");
			System.out.println("3 - Калькулятор ввод аргументов с файла(запись результата в этот же файл);");
			System.out.println("0 - Выход;");
            System.out.println("--------------------------------");

			String next = scanner.next();
			int choice = Integer.parseInt(next);
			switch (choice){
				case 0:{
					isExit = true;
					System.out.println("!!! STOP !!!");
					break;
				}
				case 1:{
					launch(args);
					break;
				}
				case 2:{
					DataReader dataReader = new ReadFromConsole();
					dataReader.run();
					break;
				}
				case 3:{
					DataReader dataReader = new ReadFromFile();
					dataReader.run();
					break;
				}
			}

		}

	}
}
