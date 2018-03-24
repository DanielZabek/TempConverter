package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainWindowController {

	@FXML
	private ToggleGroup inputScale;
	@FXML
	private TextField inputField;
	@FXML
	private TextField outputField;
	@FXML
	private ToggleGroup outputScale;
	@FXML
	private RadioButton selectedRadioButton;
	@FXML
	private Label validationLabel;

	private String inputScaleType;
	private String outputScaleType;

	@FXML
	public void initialize() {
		selectedRadioButton = (RadioButton) inputScale.getSelectedToggle();
		inputScaleType = selectedRadioButton.getText();
		selectedRadioButton = (RadioButton) outputScale.getSelectedToggle();
		outputScaleType = selectedRadioButton.getText();

	}

	@FXML
	public void inputScaleAction(ActionEvent action) {
		selectedRadioButton = (RadioButton) inputScale.getSelectedToggle();
		inputScaleType = selectedRadioButton.getText();
		Convert(inputScaleType, outputScaleType);
	}

	@FXML
	public void outputScaleAction(ActionEvent action) {
		selectedRadioButton = (RadioButton) outputScale.getSelectedToggle();
		outputScaleType = selectedRadioButton.getText();
		Convert(inputScaleType, outputScaleType);
	}

	@FXML
	public void inputOnKeyTyped() {

		Convert(inputScaleType, outputScaleType);

	}

	public void Convert(String inputScaleType, String outputScaleType) {

		if (!inputField.getText().equals("")) {
			if (inputField.getText().matches("^-?[0-9]*\\.?[0-9]*$")) {

				double output = 0;
				double input = Double.parseDouble(inputField.getText());

				if (inputScaleType.equals("Celcius") && outputScaleType.equals("Fahrenheit")) {

					output = ((input * (9.0 / 5.0)) + 32);
					outputField.setText(String.valueOf((double) Math.round(output * 10) / 10) + " °F");

				} else if (inputScaleType.equals("Celcius") && outputScaleType.equals("Kelvin")) {

					output = input + 273;
					outputField.setText(String.valueOf((double) Math.round(output * 10) / 10) + " °K");

				} else if (inputScaleType.equals("Fahrenheit") && outputScaleType.equals("Celcius")) {

					output = ((input - 32) * (5.0 / 9.0));
					outputField.setText(String.valueOf((double) Math.round(output * 10) / 10) + " °C");

				} else if (inputScaleType.equals("Fahrenheit") && outputScaleType.equals("Kelvin")) {

					output = (((input - 32) * (5.0 / 9.0)) + 273);
					outputField.setText(String.valueOf((double) Math.round(output * 10) / 10) + " °K");

				} else if (inputScaleType.equals("Kelvin") && outputScaleType.equals("Celcius")) {

					output = input - 273;
					outputField.setText(String.valueOf((double) Math.round(output * 10) / 10) + " °C");

				} else if (inputScaleType.equals("Kelvin") && outputScaleType.equals("Fahrenheit")) {

					output = (((input - 273) * (9.0 / 5.0)) + 32);
					outputField.setText(String.valueOf((double) Math.round(output * 10) / 10) + " °F");

				} else {
					outputField.setText(String.valueOf(input));
				}

				validationLabel.setText("");
			} else {
				validationLabel.setText("Input value must be a decimal number");
			}
		} else {
			outputField.setText("");
			validationLabel.setText("");
		}

	}

}
