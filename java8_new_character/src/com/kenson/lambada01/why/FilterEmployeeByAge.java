package com.kenson.lambada01.why;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/27
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee o) {
        return o.getAge() >= 35;
    }
}
