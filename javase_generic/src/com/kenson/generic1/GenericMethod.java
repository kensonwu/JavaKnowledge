package com.kenson.generic1;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * @description: 在非泛型类中定义泛型方法：
 * 通过在方法的返回类型前面用<T>
 * @author: Kenson
 * @date: 2020/9/15
 */
public class GenericMethod {
    // 泛型方法
    public static <T> T test(T t) {
        System.out.println(t);
        return t;
    }

    public static <T extends List> void test(T t) {
        System.out.println(t);
        t.add("aaa");
    }

    // 用于释放资源
    public static <T extends Closeable> void test(T... streams) { // 三个点代表可变参数，与数组用法相似
        for (T temp : streams) {
            try {
                if (null != temp) {
                    temp.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
