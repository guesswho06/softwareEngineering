package org.example;

import controller.BussinesLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Bank;

import java.io.IOException;

public class Transaction {
    BussinesLogic controller;
    Bank bank= new Bank();
    boolean result;

    public Transaction(){
        controller = new BussinesLogic();
        controller.setBank(new Bank());
    }

    @FXML
    private TextField accountIdText;

    @FXML
    private TextField amountText;

    @FXML
    private Button depositBtn;

    @FXML
    private Label depositText;

    @FXML
    private Button menuBtn;

    @FXML
    private Button menuBtnWD;

    @FXML
    private TextField withdrawAccountIdText;

    @FXML
    private TextField withdrawAmountText;

    @FXML
    private Button withdrawBtn;

    @FXML
    private Label withdrawText;

    @FXML
    private Button menuBtnTransfer;

    @FXML
    private TextField nrAccountFromText;

    @FXML
    private TextField nrAccountToText;

    @FXML
    private TextField transferAmountText;

    @FXML
    private Button transferBtn;

    @FXML
    private Label transferText;

    @FXML
    void deposit(ActionEvent event) {
        result = controller.deposit(Integer.parseInt(accountIdText.getText()), Double.parseDouble(amountText.getText()));
        if(result){
            depositText.setText("Transaction successful");
        }else{
            depositText.setText("Transaction failed");
        }
        System.out.println("jhsvbdfj");
    }

    @FXML
    void withdraw(ActionEvent event) {
        result = controller.withdraw(Integer.parseInt(withdrawAccountIdText.getText()), Double.parseDouble(withdrawAmountText.getText()));
        if(result){
            withdrawText.setText("Transaction successful");
        }else{
            withdrawText.setText("Transaction failed");
        }
    }

    @FXML
    void transfer(ActionEvent event) {
        result = controller.transfer(Integer.parseInt(nrAccountFromText.getText()),Integer.parseInt(nrAccountToText.getText()), Double.parseDouble(transferAmountText.getText()));
        if(result){
            transferText.setText("Transaction successful");
        }else{
            transferText.setText("Transaction failed");
        }
    }

    @FXML
    void menu(ActionEvent event) {
        try {
            App.setRoot("bank.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
