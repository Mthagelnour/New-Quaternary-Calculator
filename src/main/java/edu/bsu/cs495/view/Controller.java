package edu.bsu.cs495.view;

import edu.bsu.cs495.Calculator;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public Label numberType = new Label("Quaternary");

    Calculator calculator = new Calculator();

    public Button clearButton;
    public TextField textField;

    public TextField savedNumbers;
    public String firstNumber = "";
    public String currentNumber = "";
    public String calculationType;


    public void updateTextField() {
        textField.setText(currentNumber);
    }

    public void addNumber(String number) {
        currentNumber += number;
        updateTextField();
    }

    public void clearButton(ActionEvent event) {
        currentNumber = "";
        textField.setText("");
        savedNumbers.setText("");
    }

    public void clearTextField() {
        currentNumber = "";
        textField.setText("");
        savedNumbers.setText("");
    }

    public void calculationSetUp(String calculationType) {
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);

    }

    public void calculate(ActionEvent event) {
        int firstNumberInt = Integer.parseInt(String.valueOf(firstNumber));
        int secondNumberInt = Integer.parseInt(String.valueOf(currentNumber));

        switch (calculationType) {
            case "+" -> {
                int result = calculator.add(firstNumberInt, secondNumberInt);
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + result);
                textField.setText(String.valueOf(result));
            }
            case "-" -> {
                int result = calculator.subtract(firstNumberInt, secondNumberInt);
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + result);
                textField.setText(String.valueOf(result));
            }
            case "/" ->  {

                try {
                    int result = calculator.divide(firstNumberInt, secondNumberInt) ;
                    savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + result);
                    textField.setText(String.valueOf(result));

                } catch (ArithmeticException exception) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Number Cannot Be Divided by 0");
                    alert.show();
                }

            }
            case "*" -> {
                int result = calculator.multiply(firstNumberInt, secondNumberInt);
                savedNumbers.setText(firstNumber + " x " + currentNumber + " = " + result);
                textField.setText(String.valueOf(result));
            }
        }

    }

    public void button0Clicked(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("0");
        }

    }

    public void button1Clicked(ActionEvent event) {
            addNumber("1");

    }

    public void button2Clicked(ActionEvent event) {
            addNumber("2");

    }

    public void button3Clicked(ActionEvent event) {
            addNumber("3");

    }

    public void addAction(ActionEvent event) {
        calculationSetUp("+");
    }

    public void minusAction(ActionEvent event) {
        calculationSetUp("-");
    }

    public void divideAction(ActionEvent event) {
        calculationSetUp("/");
    }

    public void multiplicationAction(ActionEvent event) {
        calculationSetUp("*");
    }

    public void SquareRootAction(ActionEvent event) {
        calculationSetUp("sqrt()");
        int firstNumberInt = Integer.parseInt(String.valueOf(firstNumber));
        int result = calculator.squareRoot(firstNumberInt);
        savedNumbers.setText("sqrt(" + firstNumber + ")");
        textField.setText(String.valueOf(result));
    }

    public void squaredAction(ActionEvent event) {
        calculationSetUp("x");
        int firstNumberInt = Integer.parseInt(String.valueOf(firstNumber));
        int result = calculator.square(firstNumberInt);
        savedNumbers.setText(firstNumber + " x " + firstNumber);
        textField.setText(String.valueOf(result));
    }

    public void convertQuaternaryAction(ActionEvent event) {
        int result = calculator.toQuaternary(Integer.parseInt(textField.getText()));
        textField.setText(String.valueOf(result));
        numberType.setText("Quaternary");
    }

    public void convertDecimalAction(ActionEvent event) {

        int result = calculator.toDecimal(Integer.parseInt(textField.getText()));
        textField.setText(String.valueOf(result));
        numberType.setText("Decimal");

    }

}
