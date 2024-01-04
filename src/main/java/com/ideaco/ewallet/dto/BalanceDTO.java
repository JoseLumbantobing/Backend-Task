package com.ideaco.ewallet.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BalanceDTO {
    private int userId;
    private int balance;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
