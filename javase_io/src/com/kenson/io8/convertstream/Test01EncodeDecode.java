package com.kenson.io8.convertstream;

import java.io.UnsupportedEncodingException;

/**
 * @description: 什么是编码？ 什么解码？
 * @author: Kenson
 * @date: 2020/9/18
 */
public class Test01EncodeDecode {
    public static void main(String[] args) {
        testEncodeDecode();
        testEncodeDecodeLengthProblem();
    }

    /**
     * 测试编码、解码 与字符集之间的关系
     * 总体的原则就是： 编码与解码使用相同的字符集那么就不会出现乱码问题
     */
    public static void testEncodeDecode() {
        // 解码： byte --> char平台默认字符集 UTF-8
        String str = "中国";
        // 编码： char --> byte  平台默认字符集(UTF-8)
        byte[] data = str.getBytes();
        // 编码与解码字符集一致就不会乱码
        System.out.println(new String(data));

        // 使用指定字符集进行编码解码

        try {
            // 指定编码字符集
            // 编码 GBK
            data = str.getBytes("GBK");
            // 解码 UTF-8
            System.out.println(new String(data)); // 乱码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            // 指定编码字符集
            // 编码 GBK
            byte[] data2 = "中国人".getBytes("GBK");
            // 解码 GBK
            System.out.println(new String(data2, "GBK")); // 不乱码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void testEncodeDecodeLengthProblem() {
        String str = "成都";
        // 编码： UTF-8
        byte[] data = str.getBytes();
        System.out.println("编码后，字节数组的长度： " + data.length);
        // 乱码, 因为解码的长度不对,因为汉字在UTF-8中暂3位，如果只取4位则会出现乱码
        System.out.println(new String(data, 0 , 4));

        System.out.println(new String(data, 0 , data.length));
    }
}
