package com.kenson.thread05.producercustomer2;

/**
 * @description: 共享资源 商品
 * @author: Kenson
 * @date: 2020/9/23
 */
public class Goods {
    private String brand;
    private String name;
    private boolean flag; // 默认值为false， 表示没有商品
    public Goods() {
    }

    public Goods(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
