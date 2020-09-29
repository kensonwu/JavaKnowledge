package com.kenson.lambada05.streamapi;

import com.kenson.lambada01.why.Employee;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description: 测试Stream API
 * 一、Stream 的三个操作步骤：
 * 1. 创建Stream
 * 2. 中间操作
 * 3. 终止操作(终端操作)
 * @author: Kenson
 * @date: 2020/9/28
 */
public class TestStreamApi02 {
    // 中间操作
    List<Employee> emps = Arrays.asList(
            new Employee("zhangsan", 18, 5021.23),
            new Employee("lisi", 20, 7021.23),
            new Employee("wangwu", 40, 8021.23),
            new Employee("zhaoliu", 37, 9021.23),
            new Employee("jack", 59, 99021.23),
            new Employee("rose", 42, 10021.21),
            new Employee("rose", 42, 10021.21),
            new Employee("rose", 42, 10021.21),
            new Employee("rose", 42, 10021.21),
            new Employee("rose", 42, 10021.21),
            new Employee("tianqi", 29, 2021.23)
    );

    /**
     * 筛选与切片
     * filter -- 接收Lambada, 从流中排除某些元素
     * limit -- 截断流, 使其元素不超过给定数量
     * skip(n) -- 跳过元素,返回一个扔掉了前n个元素的流。若流中元素不足n个, 则返回一个空流。与limit(n)互补
     * distinct -- 筛选, 通过流所生成元素的hashCode()和equals()去除重复元素
     */
    // 内部迭代： 迭代器由Stream API完成
    @Test
    public void test1() {
        // 1. 创建流和中间操作 过滤
        // 惰性求值：多个中间操作可以连接起来形成一个流水线, 除非流水线触发终止操作，否则中间操作不会执行任何处理！
        // 而在终止操作时一次性全部处理。
        Stream<Employee> stream = emps.stream().filter((employee -> {
            System.out.println("这是中间操作！");
            return employee.getAge() > 40;
        }));
        // 终止操作: 一次性执行全部内容, 即"惰性求值"
        stream.forEach(System.out::println);
    }

    // 外部迭代
    @Test
    public void test2() {
        Iterator<Employee> iterator = emps.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // limit
    @Test
    public void test3() {
        emps.stream().filter((e) -> {
            System.out.println("短路");
            return e.getSalary() > 2000;
        }).limit(2).forEach(System.out::println);
    }

    // skip(n)
    @Test
    public void test4() {
        emps.stream().filter((e) -> {
            System.out.println("跳过！");
            return e.getAge() > 35;
        }).skip(2).forEach(System.out::println);
    }

    // distinct
    @Test
    public void test5() {
        emps.stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射
     * map -- 接收Lambada, 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatMap -- 接收一个函数作为参数, 然后把所有的流连成一个流
     */
    @Test
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map((x) -> x.toUpperCase()).forEach(System.out::println);
        System.out.println("-------------");
        //提取员工姓名
        emps.stream().map(Employee::getName).distinct().forEach(System.out::println);

        System.out.println("--------------");
        Stream<List<Character>> listStream = list.stream().map(TestStreamApi02::filterCharacter);
        listStream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("-----------------");
        // 使用flatMap
//        list.stream().flatMap(TestStreamApi02::filterCharacter);

    }

    // 把字符串中的不重复的字符放入到list中
    public static List<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            if (list != null && !list.contains(ch)) {
                list.add(ch);
            }
        }
        return list;
    }
}
