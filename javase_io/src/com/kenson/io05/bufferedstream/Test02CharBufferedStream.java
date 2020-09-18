package com.kenson.io05.bufferedstream;

import com.kenson.io3.charstream.Test03CopyTextFile;

import java.io.*;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test02CharBufferedStream {

    public static void main(String[] args) {
        //创建源	仅限于字符的纯文本
        File src = new File("./TestFiles/Demo03.java");
        File dest = new File("./TestFiles/charIO.txt");
        //选择流
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            writer = new BufferedWriter(new FileWriter(dest));
            //读取操作
			/*
			char[] flush = new char[120];
			int len = 0;
			while (-1 != (len=reader.read(flush))) {
				writer.write(flush, 0, len);
			}*/
            //新增方法
            String line = null;
            while (null != (line = reader.readLine())) {
                writer.write(line);
                //换行
                //writer.append("\r\n");
                writer.newLine();
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

            Test03CopyTextFile.closeStream(reader);
        }
    }

}
