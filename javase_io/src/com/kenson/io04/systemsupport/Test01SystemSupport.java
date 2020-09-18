package com.kenson.io04.systemsupport;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 * @description: 测试IO流对System的支持
 * 三个常量
 * 1、 System.in  输入流 键盘输入
 * 2、 System.out 输出流 控制台输出
 * 3、 System.err
 * ===>重定向
 * setIn()
 * setOut()
 * setErr()
 * @author: Kenson
 * @date: 2020/9/17
 */
public class Test01SystemSupport {
    public static void main(String[] args) {
        test1();
        try {
            test2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            test3();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void test1() {
        System.out.println("test");
        System.err.print("err");
        PrintStream out = System.out;
        out.println(new Date()); // 打印流会默认调用对象的toString()方法
    }

    public static void test2() throws FileNotFoundException {
        InputStream is = System.in;
        is = new BufferedInputStream(new FileInputStream("javase_io/src/sourceFiles/print.txt"));
        Scanner sc = new Scanner(is);
        System.out.println("请输入...");
        System.out.println(sc.nextLine());
        System.out.println("-----------------");
        while (sc.hasNext()){
            System.out.println(sc.next());
        }
    }

    /**
     * 重定向，可以把控制台的数据输出到文件中
     * @throws FileNotFoundException
     */
    public static void test3() throws FileNotFoundException{
        System.setOut(new PrintStream(new FileOutputStream("javase_io/src/sourceFiles/print.txt"), true));
        System.out.println("Redirect the output stream to file"); //控制台 --->文件

        //回控制台
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true));
        System.out.println("back to standard ouput");
    }
}
