package view;

import controller.BussinesLogic;
import model.Owner;

public class Viewİnterface {
    BussinesLogic controller;
    boolean result;
    public void addBankAccount(String name, String surname) {
        Owner owner = new Owner(name, surname);
        controller.addNewBankAccount(owner);
        owner = null;
        System.out.println("Bank account added !");
    }

    public void addSavingAccount(String name, String surname) {
        Owner owner = new Owner(name, surname);
        controller.addNewSavingAccount(owner);
        owner = null;
        System.out.println("Saving account added !");
    }

    public void accountInformatıon(int nrAccount) {
        controller.notify(nrAccount);
    }


    public void deposit(int nrAccount, double amount) {
        result=controller.deposit(nrAccount, amount);
        if (result){
            System.out.println("DEPOSIT COMPLETED");
        }else{
            System.out.println("DEPOSIT FAILED");
        }
    }

    public void withdraw(int nrAccount, double amount) {
        result=controller.withdraw(nrAccount, amount);
        if (result){
            System.out.println("WITHDRAW COMPLETED");
        }else{
            System.out.println("WITHDRAW FAILED");
        }
    }

    public void transfer(int nrAccountFrom, int nrAccountTo, double amount) {
        result=controller.transfer(nrAccountFrom, nrAccountTo, amount);
        if (result){
            System.out.println("TRANSFER COMPLETED");
        }else{
            System.out.println("TRANSFER FAILED");
        }
    }

    public void setController(BussinesLogic controller) {
        this.controller = controller;
    }
}
//haptı şaptı kaptı kaçtı
