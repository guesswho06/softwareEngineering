package com.company;

import controller.BussinesLogic;
import model.Bank;
import view.Viewİnterface;


public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        BussinesLogic controller = new BussinesLogic();
        controller.setBank(bank);
        bank=null;
        Viewİnterface view = new Viewİnterface();
        view.setController(controller);
        controller=null;
    }
}

