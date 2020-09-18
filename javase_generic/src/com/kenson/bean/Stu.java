package com.kenson.bean;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/15
 */
public class Stu extends Person {
    private String stuNo;

    public Stu() {

    }
    public Stu(String stuNo) {
        this.stuNo = stuNo;
    }

    public Stu(String name, int age, String stuNo) {
        super(name, age);
        this.stuNo = stuNo;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    @Override
    public String toString() {
        return  super.toString() + "stuNo='" + stuNo;
    }
}
