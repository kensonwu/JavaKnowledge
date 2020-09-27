package com.kenson.lambada03.fourbuiltininterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @description: Java8 四大核心接口
 * Consumer<T>: 消费型接口
 * void accept(T t);
 * Supplier<T>: 供给型接口
 * T get();
 * Function<T, R>: 函数型接口
 * R apply(T t);
 * Predicate<T>: 断言型接口
 * boolean test(T t);
 * @author: Kenson
 * @date: 2020/9/27
 */
public class FourBuiltInInterface {
    // Consumer<T> 消费性接口
    @Test
    public void test1() {
        happy(1000D, money -> System.out.println("肉包子打狗，有去无回， 消费了：" + money));
    }

    public void happy(Double money, Consumer<Double> con) {
        con.accept(money);
    }

    // Supplier<T> 供给型接口
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    // 需求： 产生指定个数的整数并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> numbs = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer val = supplier.get();
            numbs.add(val);
        }
        return numbs;
    }

    // Function<T, R> 函数型接口
    @Test
    public void test3() {
        // 截取字符串
        String subStr = strHandler("This is Function interface", (str) -> str.substring(2, str.length()));
        System.out.println(subStr);
        System.out.println("------------");
        // 转化大写
        String upperStr = strHandler("this is all lowercase", (str) -> str.toUpperCase());
        System.out.println(upperStr);

    }

    //需求： 用于处理字符串的方法
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    // Predicate<T>: 断言型接口
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Java", "Hotspot", "Python", "JavaScript", "Ruby", "C++", "Perl");
        List<String> strList = filterStr(list, (str) -> str.contains("a"));
        System.out.println(strList);
    }
    // 需求： 将满足条件的字符串放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        ArrayList<String> strList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }
}
