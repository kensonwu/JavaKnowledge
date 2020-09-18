package com.kenson.io3.charstream;

import java.io.*;

/**
 * @description: 字符输入流
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test01FileReader {
    public static void main(String[] args) {

        //创建源
        File src = new File("./TestFiles/zipfiles.txt");
        //选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            //读取操作
            char[] flush = new char[120];
            int len = 0;
            while (-1 != (len = reader.read(flush))) {
                //字符数组转字符串
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("The file not exist!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to read the file!");
        } finally {
            Test03CopyTextFile.closeStream(reader);
        }

    }

}
