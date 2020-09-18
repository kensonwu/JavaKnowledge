package com.kenson.io1.file;

import java.io.File;

/**
 * @description: 本测试用于测试用相对路径和绝对构建file对象
 * 相对路径与绝对路径构造file对象
 *1. 相对路径构造：
 * File(File parent, String child) ---> File("C:/BaiduNetdiskDownload", "1.jpg")
 * File(File parent, String child) ---> File(new File("C:/BaiduNetdiskDownload"), "1.jpg")
 * 2. 绝对路径
 * File(String name);
 * @author: Kenson
 * @date: 2020/9/16
 */
public class TestFile02Path {
    public static void main(String[] args) {

        String parentPath = "./";
        String name = "200.jpg";
        //相对路径构造
        File src = new File(parentPath, name);
        src = new File(new File(parentPath), name);

        //输出
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());

        //绝对路径
        src = new File("./1.jpg");
        System.out.println(src.getName());
        System.out.println(src.getPath());

        //没有盘符: 以user.dir构建
        src = new File("test.txt");
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());

        src = new File(".");
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());

    }
}
