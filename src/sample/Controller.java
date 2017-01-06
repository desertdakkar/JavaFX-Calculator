package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField textField;
    private String operator;
    private boolean numButtonClicked = true, operatorButtonClicked = true, equalsButtonClicked = false;
    private double number1, number2;

    Calculation calculation = new Calculation();

    private String getButtonText(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        String buttonText = button.getText();
        return buttonText;
    }

    private void setTextField(String value) {
        textField.setText(value);
    }

    private String getTextField() {
        return textField.getText();
    }

    public void numButtons(ActionEvent actionEvent) {
        if (numButtonClicked) {
            if (getButtonText(actionEvent).equals("0")) return;
            else {
                setTextField(getButtonText(actionEvent));
                numButtonClicked = false;
            }
        } else {
            if (getTextField().length() >= 16) return; else setTextField(getTextField() + getButtonText(actionEvent));
        }
    }

    public void operatorButtons(ActionEvent actionEvent) {
        if (operatorButtonClicked) {
            number1 = Double.parseDouble(getTextField());
            operator = getButtonText(actionEvent);
            setTextField(operator);
            numButtonClicked = true;
            operatorButtonClicked = false;
            equalsButtonClicked = true;
        }
    }

    public void equalsButton(ActionEvent actionEvent) {
        if (equalsButtonClicked) {
            if (getTextField().equals("/") || getTextField().equals("*") || getTextField().equals("-") || getTextField().equals("+")) {
                number2 = 0;
            } else {
                number2 = Double.parseDouble(getTextField());
            }
            String equals = String.valueOf(calculation.calc(number1,number2,operator));
            setTextField(equals);
            numButtonClicked = true;
            operatorButtonClicked = true;
            equalsButtonClicked = false;
        }
    }

    public void clearButton(ActionEvent actionEvent) {
        setTextField("0");
        numButtonClicked = true;
        operatorButtonClicked = true;
        equalsButtonClicked = false;
    }

}