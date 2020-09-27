package com.kenson.lambada01.why;

import org.junit.Test;

import java.util.*;

/**
 * @description: 测试Java8之前写代码的方式，以及了解我们为什么需要Lambada
 * @author: Kenson
 * @date: 2020/9/26
 */
public class TestLambada {

    /**
     * 回顾匿名内部类的写法
     * 可以从下面的函数中看到 代码比较多，而且比较繁杂， 其中最有用的代码的只有比较那一句，其他句我么你都不太关系
     * 所以正对这种情况可以使用Lambada表达式来解决这种问题
     */
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);

    }

    // Lambada表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> emps = Arrays.asList(
            new Employee("zhangsan", 18, 5021.23),
            new Employee("lisi", 20, 7021.23),
            new Employee("wangwu", 40, 8021.23),
            new Employee("zhaoliu", 37, 9021.23),
            new Employee("jack", 59, 99021.23),
            new Employee("rose", 42, 10021.21),
            new Employee("tianqi", 29, 2021.23)
    );


    @Test
    public void test3() {
        List<Employee> employeeList = filterEmployees(emps);
        for (Employee emp :
                employeeList) {
            System.out.println(emp);
        }
    }

    /**
     * 假设需求：
     * 获取公众当前员工大于35岁的员工信息
     */
    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> employeeList = new ArrayList<>();

        // java8之前
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                employeeList.add(emp);
            }
        }
        return employeeList;
    }

    @Test
    public void test4() {
        List<Employee> employeeList = filterEmployees(emps);
        for (Employee emp :
                employeeList) {
            System.out.println(emp);
        }
    }

    /**
     * 假设需求：
     * 获取公司当前员工工资大于5000的员工信息
     */
    public List<Employee> filterEmployeesSalary(List<Employee> list) {
        List<Employee> employeeList = new ArrayList<>();

        // java8之前
        for (Employee emp : list) {
            if (emp.getSalary() >= 5000) {
                employeeList.add(emp);
            }
        }
        return employeeList;
    }

    @Test
    public void test5() {
        List<Employee> employeeList = filterEmployee2(emps, new FilterEmployeeByAge());
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
        System.out.println("--------------------");
        List<Employee> employeeList1 = filterEmployee2(emps, new FilterEmployeeBySalary());
        for (Employee emp : employeeList1) {
            System.out.println(emp);
        }
    }

    /**
     * 通过上面的过滤可以看出大量的冗余代码，真正的核心代码只有判断的那一句
     * 所以出现大量冗余代码时我们就需要对代码进行优化：
     */
    // 优化方式一： 采用设计模式 策略设计模式
    // 这种方式还有有一个弊端，那就是每种策略都需要新家一个实现类， 而且每个实现类代码还很少
    public List<Employee> filterEmployee2(List<Employee> emps, MyPredicate<Employee> pre) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee emp : emps) {
            if (pre.test(emp)) {
                employeeList.add(emp);
            }
        }
        return employeeList;
    }

    // 优化方式二： 采用匿名类的方式
    @Test
    public void test6() {
        List<Employee> employeeList = filterEmployee2(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() >= 50;// 有用的代码只有这一句，可读性很差
            }
        });
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    // 优化方式三： 使用Lambada表达式
    @Test
    public void test7() {
        List<Employee> employeeList = filterEmployee2(emps, (x) -> x.getAge() >= 40);

        /*for (Employee emp : employeeList) {
            System.out.println(emp);
        }*/
        employeeList.forEach(System.out::println);
    }

    // 优化方式四：Stream API
    @Test
    public void test8() {
        emps.stream()
                .filter((e) -> e.getAge() >= 35)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("------------------------");
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
