package org.example;

import controller.BussinesLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Bank;
import model.BankAccount;
import model.Owner;

import java.io.IOException;

public class UserTransaction {
    BussinesLogic controller ;
    BankAccount bankAccount;

    public UserTransaction(){
        controller = new BussinesLogic();
        controller.setBank(new Bank());
    }

    @FXML
    private Button addMenuBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Label addText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField surnameText;


    @FXML
    private Button deleteBtn;

    @FXML
    private TextField deleteText;

    @FXML
    void deleteUser(ActionEvent event) {

    }
    @FXML
    void addUser(ActionEvent event) {
        bankAccount = controller.addNewBankAccount(new Owner(this.nameText.getText(),this.surnameText.getText()));
        addText.setText(bankAccount.getOwner().toString()+" added");
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
