package com.kenson.lambada02.lambada;

@FunctionalInterface
public interface MySum<T, R> {
    public R calVal(T t, R r);
}
