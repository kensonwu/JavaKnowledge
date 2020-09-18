package com.kenson.genericadvance;


import com.kenson.bean.Apple;
import com.kenson.bean.Fruit;
import com.kenson.bean.FujiApple;
import com.kenson.bean.Pear;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: extends: 泛型的上限 <= 即子类
 * 1. 一般用于限制操作
 * 2. 不能使用在添加数据上面，一般是读取操作
 * @author: Kenson
 * @date: 2020/9/15
 */
public class GenericExtends2 {

    public static void main(String[] args) {
        // 创建对象， 只需要是 Fruit以及Fruit的子类 编译都不会报错
        FruitTest<Fruit> fruit1 = new FruitTest<Fruit>();
        FruitTest<Apple> fruit2 = new FruitTest<Apple>();
        FruitTest<Pear> fruit3 = new FruitTest<Pear>();
        FruitTest<FujiApple> fruit4 = new FruitTest<FujiApple>();

        ArrayList<Fruit> f1 = new ArrayList<>();
        addFruits(f1);
        List<Fruit> f2= new ArrayList<Fruit>();
        addFruits(f2);
        List<Apple> f3 = new ArrayList<Apple>();
        addFruits(f3);
        List<Pear> f4 = new ArrayList<Pear>();
        addFruits(f4);
        List<? extends Apple> f5 = new ArrayList<Apple>();
        addFruits(f5);
        // 这个问号等同于 ? extends Object
        // List<?> f6 = new ArrayList<Fruit>();
        // addFruits(f6); // 编译不通过
    }

    // 泛型方法
    // Fruit以及Fruit子类
    public static void addFruits(List<? extends Fruit> fruits) {
        // 无法进行添加Fruit以及Fruit的子类
        // fruits.add(new Fruit());
        // fruits.add(new Apple());
        // fruits.add(new Pear());
        // fruits.add(new FujiApple());

        // 可以添加null
        fruits.add(null);
    }
}
