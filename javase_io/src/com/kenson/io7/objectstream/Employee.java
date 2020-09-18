package com.kenson.io7.objectstream;

import java.io.Serializable;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/17
 */
public class Employee implements Serializable{
    private static final long serialVersionUID = 3534761077758406251L;
    private String name;
    private int age;
    private int empNo;

    public Employee() {
    }

    public Employee(String name, int age, int empNo) {
        this.name = name;
        this.age = age;
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", empNo=" + empNo +
                '}';
    }
}
