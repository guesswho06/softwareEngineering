package org.example;


import controller.BussinesLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BankAccount;

import java.io.IOException;
import java.util.Objects;

import static org.example.App.setRoot;

public class Login {
    BussinesLogic controller = new BussinesLogic();
    BankAccount bankAccount;
    @FXML
    private TextField nameText;

    @FXML
    private TextField surnameText;

    @FXML
    private Label bankText;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnDeposit;

    @FXML
    private Button btnFind;

    @FXML
    private Button btnShowSpecialTr;

    @FXML
    private Button btnShowTr;

    @FXML
    private Button btnTransfer;

    @FXML
    private Button btnWithdraw;

    @FXML
    private TextField userNameText;

    @FXML
    private TextField passwordText;

    @FXML
    private Label text;

    @FXML
    private Label addText;

    @FXML
    void connectDatabase(ActionEvent event) {
        if (Objects.equals(this.userNameText.getText(), "Emre") & Objects.equals(this.passwordText.getText(), "emre123")) {
            try {
                setRoot("bank.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void chooseAddTransaction(ActionEvent event) {
        try {
            setRoot("Add.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chooseDeleteTransaction(ActionEvent event) {
        try {
            setRoot("Delete.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chooseDepositTransaction(ActionEvent event) {
        try {
            setRoot("depositD.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chooseFindTransaction(ActionEvent event) {
        try {
            setRoot("Find.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chooseShowSpecialTransaction(ActionEvent event) {
        try {
            setRoot("showSpecialTransaction.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chooseShowTransaction(ActionEvent event) {
        try {
            setRoot("showTransaction.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chooseTransferTransaction(ActionEvent event) {
        try {
            App.setRoot("Transfer.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chooseWithdrawTransaction(ActionEvent event) {
        try {
            App.setRoot("Withdraw.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
