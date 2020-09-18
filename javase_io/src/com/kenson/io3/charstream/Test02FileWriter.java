package com.kenson.io3.charstream;

import java.io.*;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test02FileWriter {
    public static void main(String[] args) {
        //创建源
        File dest = new File("./TestFiles/charIO.txt");
        //选择流
        Writer writer = null;
        try {
            writer = new FileWriter(dest);
            //写出
            String msString = "锄禾日当午\r\n码农真辛苦\r\n一本小破书\r\n一读一上午\r\n";
            writer.write(msString);
            writer.append("床前明月光");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != writer) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
