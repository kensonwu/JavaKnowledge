package com.kenson.io3.charstream;

import java.io.*;

/**
 * @description: 纯文本的拷贝
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test03CopyTextFile {

    public static void main(String[] args) {
//        String srcPath = Test03CopyTextFile.class.getClassLoader().getResource("./sourceFiles/Chinese.txt").getPath();
//        System.out.println(srcPath);
//        String destPath = Test03CopyTextFile.class.getClassLoader().getResource("./destFiles/").getPath();
//        System.out.println(destPath);
//        String destFileName = new File(srcPath).getName();
//        File src = new File(srcPath);
//        File dest = new File(destPath, destFileName);
        //创建源	仅限于字符的纯文本
        File src = new File("javase_io/src/sourceFiles/Chinese.txt");
        File dest = new File("javase_io/src/destFiles/ChineseCopy.txt");
        //选择流
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(src);
            writer = new FileWriter(dest);
            //读取操作
            char[] flush = new char[120];
            int len = 0;
            while (-1 != (len = reader.read(flush))) {
                writer.write(flush, 0, len);
            }
            writer.flush();    //强制刷出
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("The file not exist!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to read the file!");
        } finally {
            try {
                if (null != writer) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            closeStream(reader);
        }
    }

    public static void closeStream(Reader reader) {
        if (null != reader) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to close the stream!");
            }
        }
    }
}
