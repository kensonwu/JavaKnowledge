package com.kenson.generic1;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/15
 */
public class SelfDefineGenericApp {
    public static void main(String[] args) {
        // 自定义泛型类的使用 在声明时指定具体的使用类型 指定的类型不能是基本数据类型
        // SeflDefineGeneric<int> sdf = new SeflDefineGeneric<int>();
        SeflDefineGeneric<Integer> sdf = new SeflDefineGeneric<Integer>();
        // 安全： 类型检查
        sdf.setJavase(80);
        // 省心， 无需进行类型判断以及转换
        Integer javase = sdf.getJavase();
        System.out.println(javase);

    }
}
