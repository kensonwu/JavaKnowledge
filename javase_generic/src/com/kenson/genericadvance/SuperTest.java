package com.kenson.genericadvance;

import com.kenson.bean.Apple;
import com.kenson.bean.Fruit;
import com.kenson.bean.FujiApple;

import java.util.ArrayList;
import java.util.List;

/**
 * super: 泛型的上限， >= 即父类或自身
 *
 * @author wuchun
 */
public class SuperTest {
    public static void main(String[] args) {
        //>=即父类或自身
        List<Apple> list1 = new ArrayList<Apple>();
        test(list1);
        List<Fruit> list2 = new ArrayList<Fruit>();
        test(list2);
        List<Object> list3 = new ArrayList<Object>();
        test(list3);

        //规则
        List<? super Apple> list4 = new ArrayList<Apple>();
        test(list4);
        List<? super Fruit> list5 = new ArrayList<Fruit>();
        test(list5);
        List<? super FujiApple> list6 = new ArrayList<FujiApple>();
//		test(list6);	//不行
        List<?> list7 = new ArrayList<Object>();
//		test(list7);	//也不行


    }

    public static void test(List<? super Apple> list) {
        //不能添加父类对象
        list.add(new Apple());
        list.add(new FujiApple());
//		list.add(new Fruit());
    }
}
