package com.kenson.io1.file;

import java.io.File;

/**
 * @description: 该测试类主要测试路径分隔符和文件分割符
 * 两个常用常量
 * 1. 路径分割符
 * 2. 文件分隔符	(\ Windows 平台使用) (/ 非Windows平台)
 * @author: Kenson
 * @date: 2020/9/16
 */
public class TestFile01Sperator {
    public static void main(String[] args) {
        //分号 ；
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

        //路径表示形式
        //第一种形式， 需要转义 不推荐使用
        String path = "C:\\Test\\1.jpg";
        //第二种形式 ，可以做到跨平台，如果是一个定值的话 不推荐使用
        path = "C:" + File.pathSeparator + "Test" + File.pathSeparator + "1.jpg";

        //第三种方式, 推荐使用， 因为在其他非Windows平台也可以使用
        path = "C:/Test/1.jpg";
    }
}
