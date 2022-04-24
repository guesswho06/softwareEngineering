package model;


import model.exceptions.NoMoneyEx;

public class BankAccount implements Account{
    private double balance;
    private Owner owner;

    @Override
    public String toString() {
        return "BankAccount: " + "owner= " + owner + " balance= " + balance;
    }

    @Override
    public void deposit(double amount) {
        this.balance +=amount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public void withDraw(double amount) throws NoMoneyEx {
            if(balance>=amount){
                balance-=amount;
            }else {
                throw new NoMoneyEx("you don't have a money !");
            }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
