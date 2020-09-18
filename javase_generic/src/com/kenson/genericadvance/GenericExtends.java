package com.kenson.genericadvance;

import com.kenson.bean.Person;
import com.kenson.bean.Stu;
import org.omg.CORBA.PERSIST_STORE;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/15
 */
public class GenericExtends {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("张三", 30);
        Person p2 = new Person("李四", 30);
        Person p3 = new Person("王五", 30);
        Person p4 = new Person("赵柳", 30);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        showCollectionEles(persons);

        List<Stu> stus = new ArrayList<>();
        Stu stu1 = new Stu("LiLei1", 20, "001");
        Stu stu2 = new Stu("LiLei2", 20, "001");
        Stu stu3 = new Stu("LiLei3", 20, "001");
        Stu stu4 = new Stu("LiLei4", 20, "001");
        stus.add(stu1);
        stus.add(stu2);
        stus.add(stu3);
        stus.add(stu4);
        // 如果不使用<? extends Person>将变异报错，Person以及Person的子类才能使用
        showCollectionEles(stus);

        System.out.println("==============================");
        showCollectionEles2(stus);
        showCollectionEles2(persons);
        List<Object> lists = new ArrayList<>();
        lists.add("abc");
        lists.add(123);
        lists.add(p1);
        lists.add(stu1);
        showCollectionEles2(lists);
    }

    // 泛型的上限
    public static void showCollectionEles(List<? extends Person> lists) { // Person以及Person的子类
        for (Person person : lists) {
            System.out.println(person);
        }
    }

    // 泛型的下限
    public static void showCollectionEles2(List<? super Stu> lists) { // Stu以及Stu的父类
        for (Object stu : lists) {
            System.out.println(stu);
        }
    }
}
