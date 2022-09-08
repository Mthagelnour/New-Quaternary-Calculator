package edu.bsu.cs495.view;

import edu.bsu.cs495.Calculator;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {

    Calculator calculator = new Calculator();

    public TextField textField;

    public TextField savedNumbers;
    public String firstNumber;
    public String currentNumber = "";
    public String calculationType;


    public void updateTextField() {
        textField.setText(currentNumber);
    }

    public void addNumber(String number) {
        currentNumber += number;
        updateTextField();
    }

    public void clearTextField(ActionEvent event) {
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
        int firstNumberInt = Integer.parseInt(firstNumber);
        int secondNumberInt = Integer.parseInt(currentNumber);

        switch (calculationType) {
            case "+" -> {
                int result = calculator.add(firstNumberInt, secondNumberInt);
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + result);
                textField.setText(String.valueOf(result));
            }
            case "-" -> {
                //TODO Implement Subtraction
            }
            case "/" -> {
                //TODO Implement Division
            }
            case "*" -> {
              //TODO Implement Multiplication
            }
            case "√" -> {
                //TODO Implement Square Root
            }
            case "" -> {
                //TODO Implement Square
            }
        }
    }

    public void button0Clicked(ActionEvent event) {
        System.out.println("button 0 clicked");
        if(!currentNumber.equals("")){
            addNumber("0");
        }
    }

    public void button1Clicked(ActionEvent event) {
        System.out.println("button 1 clicked");
        addNumber("1");
    }

    public void button2Clicked(ActionEvent event) {
        System.out.println("button 2 clicked");
        addNumber("2");
    }

    public void button3Clicked(ActionEvent event) {
        System.out.println("button 3 clicked");
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
        calculationSetUp("√");
    }

    public void squaredAction(ActionEvent event) {
        calculationSetUp("x²");
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
