package com.kenson.lambada01.why;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/27
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
