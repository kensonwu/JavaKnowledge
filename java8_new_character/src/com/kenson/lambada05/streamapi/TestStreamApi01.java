package com.kenson.lambada05.streamapi;

import com.kenson.lambada01.why.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
public class TestStreamApi01 {
    // 创建Stream
    @Test
    public void test1() {
        // 1. 可以通过Collection系列集合提供的stream()（这只串行流）或parallelStream()（这是并行流）
        List<String> list = new ArrayList<>();
        //得到流
        Stream<String> stream1 = list.stream();

        // 2. 通过Arrays中的静态方法stream() 获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        // 3. 通过Stream类的静态方法Stream.of()
        Stream<String> stream3 = Stream.of("ken", "Nike", "addidas");

        // 4. 创建无限流
        // 4.1 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);
        // 4.2 生成
        Stream.generate(() ->Math.random()*100).limit(5).forEach(System.out::println);
    }
}
