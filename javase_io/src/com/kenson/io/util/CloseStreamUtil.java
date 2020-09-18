package com.kenson.io.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @description: 泛型实现关闭各种流
 * @author: Kenson
 * @date: 2020/9/17
 */
public class CloseStreamUtil {

    /**
     * 工具类 关闭流 可变参数： ... 只能放在形参的最后位置, 处理方式与数组一致
     */
    public static void closeStream(Closeable... io) {
        realClose(io);

    }

    private static void realClose(Closeable[] io) {
        for (Closeable temp : io) {
            if (null != temp) {
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用泛型方法
     */
    public static <T extends Closeable> void closeAllStream(T... io) {
        realClose(io);
    }


}
