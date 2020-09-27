package com.kenson.lambada02.lambada;

import com.kenson.lambada01.why.Employee;
import org.junit.Test;
import sun.print.SunMinMaxPage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: Lambada表达式练习
 * 这种方式最明显的缺陷就是 每次要应用Lambada表达式时 都需要新建一个接口，其实 这些接口JDK已经内置，无需重复创建
 * @author: Kenson
 * @date: 2020/9/27
 */
public class LambadaExercise {
    List<Employee> emps = Arrays.asList(
            new Employee("zhangsan", 68, 5021.23),
            new Employee("lisi", 32, 7021.23),
            new Employee("wangwu", 20, 8021.23),
            new Employee("zhaoliu", 17, 9021.23),
            new Employee("jack", 49, 99021.23),
            new Employee("rose", 27, 10021.21),
            new Employee("tianqi", 55, 2021.23)
    );

    // 对于工信息进行定制化排序
    @Test
    public void test1() {
        Collections.sort(emps, (e1, e2) -> {
            // 年龄一样比姓名
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        // 查看结果
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void test2() {
        String convertStr = strHandler("this is small cat", str -> str.toUpperCase());// 转大写
        System.out.println(convertStr);
        System.out.println("------------");
        // 截取字符串
        String subStr = strHandler("Lambada表达式", str -> str.substring(7, str.length()));
        System.out.println(subStr);
    }

    // 对字符串进行处理
    public String strHandler(String str, MyUppercase upper) {
        return upper.getValue(str);
    }

    @Test
    public void test3() {
        Long sumVal = calValue(10L, 20L, (num1, num2) -> num1 + num2);
        System.out.println("两个Long型值的和为：" + sumVal);
        System.out.println("----------------------");
        Long mulVal = calValue(20L, 11L, (num1, num2) -> num1 * num2);
        System.out.println("两个Long型值的积为：" + mulVal);

    }

    //计算两个数运算值
    public Long calValue(Long num1, Long num2, MySum<Long, Long> sum) {
        return sum.calVal(num1, num2);
    }
}
