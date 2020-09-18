package com.kenson.bean;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/15
 */
public class ClassMate implements Comparable<ClassMate> {
    private String name;
    private int age;

    public ClassMate() {
    }

    public ClassMate(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(ClassMate mate) {
        int num = this.age - mate.getAge();
        int nameNum = num == 0 ? this.name.compareTo(mate.getName()) : num;
        return nameNum;
    }
}
