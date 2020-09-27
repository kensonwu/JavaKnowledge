package com.kenson.lambada01.why;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/27
 */
@FunctionalInterface
public interface MyPredicate<T> {
    // 对类型T的参数进行处理并返回boolean类型
    public boolean test(T t);
}
