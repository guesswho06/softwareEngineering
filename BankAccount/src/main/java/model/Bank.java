package model;

import model.exceptions.NoMoneyEx;
import model.exceptions.NrAccountEx;
import model.observerPattern.Observable;
import model.observerPattern.ObserverOffice;
import model.offices.TaxOffice;

import java.util.ArrayList;

public class Bank implements Observable, BankingOperations {

    private final ArrayList<ObserverOffice> accounts;
    private BankAccount bankAccount;
    private SavingAccount savingAccount;
    private TaxOffice taxOffice;

    public Bank() {
        this.accounts = new ArrayList<ObserverOffice>();
    }

    @Override
    public void addObserverOffice(ObserverOffice o) {
        this.accounts.add(o);
    }

    @Override
    public void deleteObserverOffice(ObserverOffice o) {
        this.accounts.remove(o);
    }

    @Override
    public void notifyObserverOffice(ObserverOffice o) {
        ((TaxOffice) o).raport();
    }

    public ArrayList showTransaction(){
        ArrayList<String> stringArrayList ;
            TaxOffice taxOffice = new TaxOffice();
           stringArrayList = taxOffice.showTransaction();
           return stringArrayList;
    }

    public void findTrasaction(int nrTransactionId){
        TaxOffice taxOffice = new TaxOffice();
        taxOffice.findTransaction(nrTransactionId);
    }

    public void deleteTransaction(int nrTransactionId){
        TaxOffice taxOffice = new TaxOffice();
        taxOffice.deleteTransaction(nrTransactionId);
    }

    @Override
    public void deposit(int nrAccount, double amount) {
        try {
            this.checkAccount(nrAccount);
            taxOffice = (TaxOffice) this.accounts.get(nrAccount);
            taxOffice.getBankAccount().deposit(amount);
            this.accounts.get(nrAccount).update(taxOffice.getBankAccount(), taxOffice.getBankAccount().getBalance());
            taxOffice = null;
        } catch (NrAccountEx ex) {
            ex.getMessage();
        }

    }

    @Override
    public void withdraw(int nrAccount, double amount) throws NoMoneyEx {
        try {
            this.checkAccount(nrAccount);
            taxOffice = (TaxOffice) this.accounts.get(nrAccount);
            taxOffice.getBankAccount().withDraw(amount);
            this.accounts.get(nrAccount).update(taxOffice.getBankAccount(), taxOffice.getBankAccount().getBalance());
            taxOffice = null;
        } catch (NrAccountEx ex) {
            ex.getMessage();
        }

    }

    @Override
    public void transfer(int nrAccountFrom, int nrAccountTo, double amount) throws NoMoneyEx {
        this.withdraw(nrAccountFrom, amount);
        this.deposit(nrAccountTo, amount);
    }

    public ObserverOffice checkAccount(int nrAccount) throws NrAccountEx {
        try {
            return this.accounts.get(nrAccount);
        } catch (IndexOutOfBoundsException e) {
            throw new NrAccountEx("Account not found");
        }

    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }
}
