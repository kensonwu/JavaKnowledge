package com.kenson.bean;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/15
 */
public class Teacher extends  Person {
    private String teachYear;
    public Teacher() {
    }
    public Teacher(String teachYear) {
        this.teachYear = teachYear;
    }

    public Teacher(String name, int age, String teachYear) {
        super(name, age);
        this.teachYear = teachYear;
    }

    public String getTeachYear() {
        return teachYear;
    }

    public void setTeachYear(String teachYear) {
        this.teachYear = teachYear;
    }

    @Override
    public String toString() {
        return super.toString() + "teachYear='" + teachYear;
    }
}
