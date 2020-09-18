package com.kenson.io2.bytestream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test02FileOutputStream {
    public static void main(String[] args) {
        // 1. 建立File对象连接
        String distPath = "javase_io/src/distFiles/dest.txt";
        File file = new File(distPath);
        // 2. 选择流，选择OutputSteam, FileOutputStream
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(distPath, true);// tru为追加的方式，否则为覆盖
            // 定义要输入到问价你的内容,此处为模拟， 之后可能是从磁盘数据库或者去他程序获取数据源
            String str = "锄禾日当午，汗滴禾下土，一本小破书，一读一上午！";
            // 将字符串转为字节数组
            byte[] buff = str.getBytes();
            // 3. 写出到磁盘中
            outputStream.write(buff);
            // 强制刷出
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写出失败！");
        } finally {
        }
    }
}
