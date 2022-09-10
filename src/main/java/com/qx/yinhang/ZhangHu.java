package com.qx.yinhang;

public class ZhangHu {
    String User;
    String Password;
    int Balance;
    public ZhangHu() {
    }

    public ZhangHu(String user, String password, int balance) {
        User = user;
        Password = password;
        Balance = balance;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
