package model.offices;

import model.BankAccount;
import model.SavingAccount;
import model.observerPattern.ObserverOffice;

public class TaxOffice implements ObserverOffice {
    private BankAccount bankAccount;
    private SavingAccount savingAccount;

    @Override
    public void update(BankAccount bankAccount, double amount) {
        this.bankAccount=bankAccount;
        this.bankAccount.setBalance(amount);
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    public void raport(){
        System.out.println(bankAccount);
    }

}
