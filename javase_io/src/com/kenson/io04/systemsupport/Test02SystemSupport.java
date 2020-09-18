package com.kenson.io04.systemsupport;

import java.io.*;

/**
 * @description: 测试PrintStream流
 * @author: Kenson
 * @date: 2020/9/17
 */
public class Test02SystemSupport {

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("test01");
        PrintStream ps = System.out;
        ps.println(true);

        //输出到文件
        File src = new File("javase_io/src/sourceFiles/print.txt");
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
        ps.println("IO Stream is not so easy...");
        ps.close();
    }

}
