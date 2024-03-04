package com.cogent.ecommercesalesreport.controller;

import com.cogent.ecommerce.model.Account;

public class UserSalesReportDTO {

    private Account account;

    private double totalPrice;

    private int totalPurchases;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPurchases() {
        return totalPurchases;
    }

    public void setTotalPurchases(int totalPurchases) {
        this.totalPurchases = totalPurchases;
    }
}
