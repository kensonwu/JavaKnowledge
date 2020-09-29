package com.kenson.lambada04.methodref;

import com.kenson.lambada01.why.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

/**
 * @description: 方法引用
 * 什么是方法引用：若Lambada表达式有方法已经实现了，我们可以使用"方法引用"
 * 也可以理解为：方法引用是Lambada表达式的另一种表现形式
 * 方法引用主要三个语法格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * 注意事项：
 * 若Lambada体中，调用方法的参数列表和返回值类型要与函数式接口中定义的抽象方法的参数列表和返回值类型相同， 否则不能使用方法引用
 * 若Lambada体中, 参数列表中的第一个参数是实例方法调用者，而第二个参数是实例方法的参数时可以使用 "类::实例方法名" 来简化Lambada体
 * 构造器引用：
 * ClassName::new
 * 数组引用：
 * Type[]:new
 * @author: Kenson
 * @date: 2020/9/27
 */
public class TestMethodRef {

    // 对象::实例方法名
    @Test
    public void test() {
        PrintStream ps = System.out;
        Consumer<String> consumer = (x) -> ps.println(x);
        /**
         * 这是对象::实例方法名
         * 注意：Lambada体中的实现方法 的返回值类型 和参数个数与 接口的返回值类型和参数个数相同的话，
         * 那么我们就可以用对象::实例方法名这种形式来实现Lambada体
         */
        Consumer<String> con = ps::println;
    }

    @Test
    public void test2() {
        Employee emp = new Employee("张三", 18, 2000);
        Supplier<String> sup = () -> emp.getName();
        String empName = sup.get();
        System.out.println(empName);
        Supplier<Integer> sup1 = emp::getAge;
        System.out.println("-------------");
        Integer empAge = sup1.get();
        System.out.println(empAge);

        Supplier<Double> sup2 = emp::getSalary;
        Consumer<Double> con = System.out::println;
        Double empSalary = sup2.get();
        con.accept(empSalary);
    }

    // 类::静态方法名
    @Test
    public void test3() {
        /**
         * 比较两个Integer数的大小， 使用Lambada表达式, Lambada体中使用的是Integer的静态方法compare(int x, int y)
         * 我们发现Lambada体中的实现方法Integer.compare(num1, num2)是现成的一个方法，而且Integer.compare(num1, num2)方法的返回值以及参数与接口
         * Comparator中int compare(T o1, T o2) 方法的返回值和参数个数相同，所以我就有了另外一种方式来代替现在的(num1, num2) -> Integer.compare(num1, num2);
         * 这种书写方式 Integer的compare方法是一个静态方法，可以直接通过类.方法名来调用
         */
        Comparator<Integer> com = (num1, num2) -> Integer.compare(num1, num2);

        // 对上面代码的另一种书写方式
        Comparator<Integer> com1 = Integer::compareTo;//类::静态方法名
        int compareResult = com1.compare(1, 2);
        Consumer<Integer> consumer = System.out::println;// 这个写法与上面的写法同理
        consumer.accept(compareResult);
    }

    //类::实例方法名
    @Test
    public void test4() {
        // 需求：比较两字符串是否一样
        // 如果说第一个参数是这个方法的调用者，而第二个参数是实例方法的参数，那么可以使用 类::实例方法名 来简化代码。
        BiPredicate<String, String> biPre = (str1, str2) -> str1.equals(str2);// equals是实例方法

        //使用方法引用
        BiPredicate<String, String> bp = String::equals;
        boolean isSame = bp.test("abc", "acb");
        Consumer<Boolean> consumer = System.out::println;
        consumer.accept(isSame);
    }

    // 构造器引用：
    @Test
    public void test5() {
        Supplier<Employee> supplier1 = () -> new Employee();
        // 运用构造器引用
        Supplier<Employee> supplier2 = Employee::new;
        Employee employee = supplier2.get();//调用的无参构造器
        System.out.println(employee);
    }

    // 构造器引用：
    @Test
    public void test6() {
        Function<String, Employee> func1 = (name) -> new Employee(name);
        // 运用构造器引用
        Function<String, Employee> func2 = Employee::new;//调用的一个参数的构造器
        Employee employee = func2.apply("王二麻子");//调用的一个参数的构造器
        System.out.println(employee);
        System.out.println("--------------");
        BiFunction<String, Integer, Employee> bf = Employee::new;//调用2个参数的构造器
        Employee emp = bf.apply("范进", 39);
        System.out.println(emp);
    }

    // 数组引用：
    @Test
    public void test7() {
        // 返回一个x长度的字符数组
        Function<Integer, String[]> fun1 = (x) -> new String[x];
        String[] strs = fun1.apply(10);
        System.out.println(strs.length);
        // 数组引用
        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        strs2[0] = "100";
        Arrays.stream(strs2).forEach(System.out::println);
    }
}
