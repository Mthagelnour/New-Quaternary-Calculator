package edu.bsu.cs495.view;

import edu.bsu.cs495.Calculator;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {


    Calculator calculator = new Calculator();

    public Button clearButton;
    public TextField textField;

    public TextField savedNumbers;
    public int firstNumber;
    public int currentNumber;
    public String calculationType;


    public void updateTextField() {
        textField.setText(String.valueOf(currentNumber));
    }

    public void addNumber(int number) {
        currentNumber += number;
        updateTextField();
    }

    public void clearTextField(ActionEvent event) {
        currentNumber = 0;
        textField.setText("");
        savedNumbers.setText("");
    }

    public void calculationSetUp(String calculationType) {
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = 0;
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
            case "sqrt()" -> {
                int result = calculator.squareRoot(firstNumberInt);
                savedNumbers.setText("sqrt(" + firstNumber + ")");
                textField.setText(String.valueOf(result));
            }
            case "x" -> {
                int result = calculator.square(firstNumberInt);
                savedNumbers.setText(firstNumber + " x " + firstNumber);
                textField.setText(String.valueOf(result));
            }
        }

    }

    public void button0Clicked(ActionEvent event) {
        addNumber(0);
    }

    public void button1Clicked(ActionEvent event) {
        addNumber(1);
    }

    public void button2Clicked(ActionEvent event) {
        addNumber(2);
    }

    public void button3Clicked(ActionEvent event) {
        addNumber(3);
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
    }

    public void squaredAction(ActionEvent event) {
        calculationSetUp("x");
    }

    public void convertDecimalAction(ActionEvent event) {
        int result = calculator.toDecimal(Integer.parseInt(textField.getText()));
        textField.setText(String.valueOf(result));

    }

    public void convertQuaternaryAction(ActionEvent event) {
        Calculator calculator = new Calculator();
        int result = calculator.toQuaternary(Integer.parseInt(textField.getText()));
        textField.setText(String.valueOf(result));
    }
}
