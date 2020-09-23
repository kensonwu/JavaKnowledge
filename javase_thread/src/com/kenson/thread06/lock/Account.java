package com.kenson.thread06.lock;

/**
 * @description: 银行账户
 * @author: Kenson
 * @date: 2020/9/23
 */
public class Account {
    // 账户余额
    private int blance;
    // 账户名称
    private String name;

    public Account() {
    }

    public Account(int blance, String name) {
        this.blance = blance;
        this.name = name;
    }

    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
