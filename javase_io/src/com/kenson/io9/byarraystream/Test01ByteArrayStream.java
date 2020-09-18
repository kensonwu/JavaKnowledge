package com.kenson.io9.byarraystream;

import com.sun.jmx.snmp.agent.SnmpMibOid;

import java.io.*;

/**
 * @description: 字节数组输入流(ByteArrayInputStream)和输出流(ByteArrayOuputStream)
 * 1. 属于节点流
 * 2.组的长度有限，数据量不会太大
 * 3. 创建一个文件， 内容不用太大
 * 文件 ---程序---- >字节数组
 * 字节数组 ---程序---->  文件
 * @author: Kenson
 * @date: 2020/9/18
 */
public class Test01ByteArrayStream {
    public static void main(String[] args) {
        try {
            read(writeFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(byte[] src) throws IOException {
        // 数据源传入， 选择流
        InputStream bis = new BufferedInputStream(new ByteArrayInputStream(src));
        // 缓冲数组
        byte[] flush = new byte[1024];
        int len = 0;
        if(-1 != (len=bis.read(flush))){
            System.out.println(new String(flush,0,len));
        }
    }
    /**
     * 输出流 操作与文件输出流有些不同， 有新增方法， 不能使用多态
     * @return
     * @throws IOException
     */
    public static byte[] writeFile() throws IOException {
        // 定义字节数据
        byte[] destArr;
        // 选择流 不能使用多态 因为需要使用其扩展方法
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 写出
        String msg = "输入流的操作与文件输入流的操作一致";
        // 将数据转换成一个byte数组
        byte[] info = msg.getBytes();
        bos.write(info, 0, info.length);
        // 得到输出的数据
        destArr = bos.toByteArray();
        // 释放资源
        bos.close();

        return destArr;
    }
}
