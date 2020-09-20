package com.kenson.thread01.staticproxy;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/20
 */
public class Client {
    public static void main(String[] args) {
        // 真实角色
        You you = new You();
        // 代理角色
        WeddingCompany company = new WeddingCompany(you);
        // 执行
        company.marry();
    }
}
