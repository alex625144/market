package com.market.entity;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private Double money;

    public User(int id, String firstName, String lastName, Double money) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
