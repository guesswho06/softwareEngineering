package model;

import model.exceptions.NoMoneyEx;

public interface Account {
    public void deposit(double amount);
    public void withDraw(double amount) throws NoMoneyEx;
}
