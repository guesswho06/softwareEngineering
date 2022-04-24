package controller;

import model.Bank;
import model.BankAccount;
import model.Owner;
import model.SavingAccount;
import model.exceptions.DatabaseConnEx;
import model.exceptions.NoMoneyEx;
import model.exceptions.NrAccountEx;
import model.offices.TaxOffice;

import java.util.ArrayList;

public class BussinesLogic {
    Bank bank;
    TaxOffice taxOffice;

    public BankAccount addNewBankAccount(Owner owner) {
        bank.setBankAccount(new BankAccount());
        bank.getBankAccount().setOwner(owner);
        taxOffice = new TaxOffice();
        taxOffice.update(bank.getBankAccount(), 0);
        bank.addObserverOffice(taxOffice);
        taxOffice = null;
        return bank.getBankAccount();
    }

    public SavingAccount addNewSavingAccount(Owner owner) {
        bank.setSavingAccount(new SavingAccount());
        bank.getSavingAccount().setOwner(owner);
        taxOffice = new TaxOffice();
        taxOffice.update(bank.getSavingAccount(), 0);
        bank.addObserverOffice(taxOffice);
        return bank.getSavingAccount();
    }

    public boolean deposit(int nrAccount, double amount) {
        taxOffice = new TaxOffice();
        try {
            if (amount > 10000) {
                System.out.println("More than 10,000 pln transactions");
                bank.notifyObserverOffice(bank.checkAccount(nrAccount));
                bank.deposit(nrAccount, amount);
                taxOffice.connectDatabase("sql11471924","VTpwArSUEr");//user name and pass write
                taxOffice.addTransaction(nrAccount,"deposit",amount);
                return true;
            } else {
                bank.deposit(nrAccount, amount);
                taxOffice.connectDatabase("sql11471924","VTpwArSUEr");//user name and pass write
                taxOffice.addTransaction(nrAccount,"deposit",amount);
                return true;
            }
        } catch (NrAccountEx | DatabaseConnEx e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean withdraw(int nrAccount, double amount) {
        taxOffice = new TaxOffice();
        try {
            if (amount > 10000) {
                System.out.println("More than 10,000 pln transactions");
                bank.notifyObserverOffice(bank.checkAccount(nrAccount));
                bank.withdraw(nrAccount, amount);
                taxOffice.connectDatabase("sql11471924","VTpwArSUEr");//user name and pass write
                taxOffice.addTransaction(nrAccount,"withdraw",amount);
                return true;
            } else {
                bank.withdraw(nrAccount, amount);
                taxOffice.connectDatabase("sql11471924","VTpwArSUEr");//user name and pass write
                taxOffice.addTransaction(nrAccount,"withdraw",amount);
                return true;
            }
        } catch (NoMoneyEx | NrAccountEx | DatabaseConnEx e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean transfer(int nrAccountFrom, int nrAccountTo, double amount) {
        taxOffice = new TaxOffice();
        try {
            if (amount > 10000) {
                System.out.println("More than 10,000 pln transactions");
                bank.notifyObserverOffice(bank.checkAccount(nrAccountFrom));
                bank.transfer(nrAccountFrom, nrAccountTo, amount);
                taxOffice.connectDatabase("sql11471924","VTpwArSUEr");//user name and pass write
                taxOffice.addTransaction(nrAccountFrom,nrAccountTo,"transfer",amount);
                return true;
            } else {
                bank.transfer(nrAccountFrom, nrAccountTo, amount);
                taxOffice.connectDatabase("sql11471924","VTpwArSUEr");//user name and pass write
                taxOffice.addTransaction(nrAccountFrom,nrAccountTo,"transfer",amount);
                return true;
            }
        } catch (NoMoneyEx | NrAccountEx | DatabaseConnEx e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList showTransaction(){
        ArrayList<String> stringArrayList;
        taxOffice = new TaxOffice();
        try {
            taxOffice.connectDatabase("sql11471924","VTpwArSUEr");//user name and pass write
            stringArrayList = bank.showTransaction();
            return stringArrayList;
        } catch (DatabaseConnEx e) {
            e.printStackTrace();
            return null;
        }

    }
    public void findTransaction(int nrTransactionId){
        bank.findTrasaction(nrTransactionId);
    }

    public void deleteTransaction(int nrTransactionId){
        bank.deleteTransaction(nrTransactionId);
    }

    public void notify(int nrAccount) {
        try {
            bank.notifyObserverOffice(bank.checkAccount(nrAccount));
        } catch (NrAccountEx e) {
            System.out.println(e.getMessage());
        }
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
