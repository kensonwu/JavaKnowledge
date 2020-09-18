package com.kenson.generic1;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/15
 */
public class SeflDefineGeneric<T> {
    private T javase;
    // 不能使用在静态变量上
    // private static T javase;

    public SeflDefineGeneric() {
    }

    public SeflDefineGeneric(T javase) {
        this.javase = javase;
    }

    public T getJavase() {
        return javase;
    }

    public void setJavase(T javase) {
        this.javase = javase;
    }
}
