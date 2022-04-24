package controller;

import model.Bank;
import model.BankAccount;
import model.Owner;
import model.SavingAccount;
import model.exceptions.NoMoneyEx;
import model.exceptions.NrAccountEx;
import model.offices.TaxOffice;

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
        try {
            if (amount > 10000) {
                System.out.println("More than 10,000 pln transactions");

                    bank.notifyObserverOffice(bank.checkAccount(nrAccount));
                bank.checkAccount(nrAccount);
                bank.deposit(nrAccount, amount);
                return true;
            } else {
                bank.checkAccount(nrAccount);
                bank.deposit(nrAccount, amount);
                return true;
            }
        }catch (NrAccountEx e) {
            System.out.println(e.getMessage());
            return false;
        }


    }

    public boolean withdraw(int nrAccount, double amount) {
        try {
            if (amount > 10000) {
                System.out.println("More than 10,000 pln transactions");
                bank.notifyObserverOffice(bank.checkAccount(nrAccount));
                bank.withdraw(nrAccount, amount);
                return true;
            } else {
                bank.checkAccount(nrAccount);
                bank.withdraw(nrAccount, amount);
                return true;
            }
        }  catch (NrAccountEx e) {
            System.out.println(e.getMessage());
            return false;
        }catch (NoMoneyEx noMoneyEx) {
            System.out.println(noMoneyEx.getMessage());
            return false;
        }
    }

    public boolean transfer(int nrAccountFrom, int nrAccountTo, double amount) {
        try {
            if (amount > 10000) {
                System.out.println("More than 10,000 pln transactions");
                bank.notifyObserverOffice(bank.checkAccount(nrAccountFrom));
                bank.transfer(nrAccountFrom, nrAccountTo, amount);
                return true;
            } else {
                bank.checkAccount(nrAccountFrom);
                bank.transfer(nrAccountFrom, nrAccountTo, amount);
                return true;
            }
        }  catch (NrAccountEx e) {
            System.out.println(e.getMessage());
            return false;
        }catch (NoMoneyEx noMoneyEx) {
            System.out.println(noMoneyEx.getMessage());
            return false;
        }
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
