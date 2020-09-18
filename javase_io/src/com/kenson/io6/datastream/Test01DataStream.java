package com.kenson.io6.datastream;

import com.kenson.io.util.CloseStreamUtil;

import java.io.*;

/**
 * @description: DataInputStream和OutputStream
 * 1. 提供存取所有的Java基本数据类型数据(byte, short, char, int, double, long float)和String
 * 2. 他们是处理流，值针对字节流(二进制文件)
 * 3. 保留数据+类型
 * 作用： 在网络中传输相当方便，不用进行文件类型转换
 * 文件 -- FileInputStream -- BufferedInputStream -- DataInputStream -- data
 * data -- FileOutputStream -- BufferedOutputStream -- DataOutputStream -- 文件
 *
 * 1、	处理基本数据类型 +String 保留数据+类型
    输入流： DataInputStream   readXXX()
    输出流：DataOutputStream    WriteXxxx()
    java.io.EOFException : 没有读到相关的内容
 *
 * @author: Kenson
 * @date: 2020/9/17
 */
public class Test01DataStream {

    public static void main(String[] args) {
        // 测试写出方法
        write("javase_io/src/destFiles/dataoutput.txt");
        // 测试读取字节数据
        read("javase_io/src/destFiles/dataoutput.txt");

    }

    /**
     * 由于我们需要测试DataInputStream和OutputStream，
     * 他们只支持字节流，我们测试时磁盘无二进制数据所以先写出 后在读取
     *
     * @param destPath
     */
    public static void write(String destPath) {
        double point = 2.5;
        long num = 122L;
        String str = "保留数据类型";

        //1. 建立联系
        File dest = new File(destPath);
        DataOutputStream dos = null;
        //2. 选择流
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
            //3. 写出操作
            dos.writeDouble(point);
            dos.writeLong(num);
            dos.writeUTF(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseStreamUtil.closeAllStream(dos);
        }
    }

    public static void read(String srcPath) {
        //1. 建立连接
        File file = new File(srcPath);
        //2. 选择流
        DataInput di = null;
        try {
            di = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            //3. 读取， 读取顺序与写入顺序是一致的  FIFO的原则
            // 读取顺序不一致 会出现问题
            double point = di.readDouble();
            long num = di.readLong();
            String str = di.readUTF();
            System.out.println(point + "-" + num + "-" + str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
