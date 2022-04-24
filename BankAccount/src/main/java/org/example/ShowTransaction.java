package org.example;

import controller.BussinesLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.Bank;

import java.io.IOException;
import java.util.ArrayList;

public class ShowTransaction {
    BussinesLogic controller = new BussinesLogic();
    Bank bank = new Bank();

    @FXML
    private Button showMenuBtn;

    @FXML
    private Button showBtn;

    @FXML
    private TextArea showText;


    public void showTransaction(){
        controller.setBank(bank);

        ArrayList<String> stringArrayList = controller.showTransaction();
        for (String tr:stringArrayList) {
            showText.setText(showText.getText()+"\n"+tr+"\n");
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
