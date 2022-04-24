package model.offices;

import model.BankAccount;
import model.SavingAccount;
import model.exceptions.DatabaseConnEx;
import model.observerPattern.ObserverOffice;

import java.sql.*;
import java.util.ArrayList;

public class TaxOffice implements ObserverOffice {
    private BankAccount bankAccount;
    private SavingAccount savingAccount;
    private static Connection conn;
    private static int counter = 1;
    private static Statement statement;
    ResultSet resultSet;

    @Override
    public void update(BankAccount bankAccount, double amount) {
        this.bankAccount=bankAccount;
        this.bankAccount.setBalance(amount);
    }

    public boolean findTransaction(int nrTransactionId){
        boolean result=false;
        try {
            String sqlSelect = "select * from transaction";
            resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()) {
                if (resultSet.getInt("transaction_id") == nrTransactionId) {
                    System.out.println(resultSet.getInt("transaction_id") + " " + resultSet.getInt("account_id") +
                            " " + resultSet.getString("transaction_type") + " " + resultSet.getDouble("amount"));

                    result=true;
                    break;
                }
            }
            String sqlSelect1 = "select * from transaction_transfer";
            resultSet = statement.executeQuery(sqlSelect1);
            while (resultSet.next()) {
                if (resultSet.getInt("transaction_id") == nrTransactionId) {
                    System.out.println(resultSet.getInt("transaction_id") + " " + resultSet.getInt("account_from_id") +
                            " " + resultSet.getInt("account_to_id") + " " + resultSet.getString("transaction_type") +
                            " " + resultSet.getDouble("amount"));
                    result=true;
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Connection connectDatabase(String userName, String password) throws DatabaseConnEx {
        String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11471924";
        String login = userName;
        String pass = password;
        try {
            conn = DriverManager.getConnection(url, login, pass);
            statement= conn.createStatement();
            return conn;
        } catch (Exception e) {
            throw new DatabaseConnEx("database connection failed");
        }
    }

    public void addTransaction(int nrAccountFrom, int nrAccountTo, String transactionType, double amount) {
        String sqlInsert = "INSERT INTO transaction_transfer VALUES ("+counter+",\"" + nrAccountFrom + "\",\""+nrAccountTo+"\",\""+transactionType+"\","+amount+")";
        try {
            statement.executeUpdate(sqlInsert);
            counter++;
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void addTransaction(int nrAccount, String transactionType, double amount) {
        String sqlInsert = "INSERT INTO transaction VALUES ("+counter+",\"" + nrAccount + "\",\""+transactionType+"\","+amount+")";
        try {
            statement.executeUpdate(sqlInsert);
            counter++;
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void deleteTransaction(int nrTransactionId){
        if(this.findTransaction(nrTransactionId)){
            String sqlDelete = "DELETE FROM transaction_transfer WHERE transaction_id = "+nrTransactionId;
            try {
                statement.executeUpdate(sqlDelete);
                sqlDelete = "DELETE FROM transaction WHERE transaction_id = "+nrTransactionId;
                System.out.println(sqlDelete);
                statement.executeUpdate(sqlDelete);
                System.out.println("delete Transaction successful");
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }



    public ArrayList showTransaction(){
        ArrayList<String> stringArrayList = new ArrayList<>();
        try {
            String sqlSelect = "select * from transaction";
            resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                stringArrayList.add(resultSet.getInt("transaction_id")+" "+resultSet.getInt("account_id")+
                        " "+resultSet.getString("transaction_type")+" "+resultSet.getDouble("amount"));
            }
            sqlSelect = "select * from transaction_transfer";
            resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
               stringArrayList.add(resultSet.getInt("transaction_id")+" "+resultSet.getInt("account_from_id")+
                       " "+resultSet.getInt("account_to_id")+" "+resultSet.getString("transaction_type")+" "
                       +resultSet.getDouble("amount"));
            }
            return stringArrayList;
        } catch (SQLException e) {
            e.getMessage();
            return null;
        }

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
