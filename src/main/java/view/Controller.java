package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    public TextField textField;

    public String savedNumber;
    public String firstNumber;
    public String currentNumber;
    public String calculationType;


    public void updateTextfield(){
        textField.setText(currentNumber);
    }

    public void addNumber(String number) {
        currentNumber += number;
        updateTextfield();
    }

    public void button0Clicked(ActionEvent event) {
        System.out.println("button 0 clicked");
        addNumber("0");
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

    public void calculate(ActionEvent event) {
        ;
    }

    public void clearTextField(ActionEvent event) {
        textField.clear();
    }

    public void addAction(ActionEvent event) {
        ;
    }

    public void minusAction(ActionEvent event) {
        ;
    }

    public void divideAction(ActionEvent event) {
        ;
    }

    public void multiplicationAction(ActionEvent event) {
        ;
    }

}
