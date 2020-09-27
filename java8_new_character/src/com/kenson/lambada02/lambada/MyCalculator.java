package com.kenson.lambada02.lambada;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/27
 */
@FunctionalInterface
public interface MyCalculator<T> {
    public T getValue(T t);
}
