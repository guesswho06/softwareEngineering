package model;

import model.exceptions.NoMoneyEx;

public interface BankingOperations {
    public void deposit(int nrAccount,double amount);
    public void withdraw(int nrAccount,double amount) throws NoMoneyEx;
    public void transfer(int nrAccountFrom,int nrAccountTo,double amount) throws NoMoneyEx;

}
