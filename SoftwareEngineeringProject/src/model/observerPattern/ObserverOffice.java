package model.observerPattern;

import model.BankAccount;

public interface ObserverOffice {
    public void update(BankAccount bankAccount,double amount);
}
