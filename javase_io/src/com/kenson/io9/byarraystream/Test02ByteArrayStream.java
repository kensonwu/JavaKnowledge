package com.kenson.io9.byarraystream;

import sun.awt.geom.AreaOp;

import java.io.*;

/**
 * @description: 测试从文件获取数据并转为字节数组
 * 创建一个文件， 内容不用太大
 * 1. 文件 ---程序---- >字节数组
 * 1）、文件输入流
 * 2）、 字节数组输出流
 * 2.字节数组 ---程序---->  文件
 * 1）、字节数组输入流
 * 2）、文件输出流
 * @author: Kenson
 * @date: 2020/9/18
 */
public class Test02ByteArrayStream {

    public static void main(String[] args) {
        try {
            byte[] data = getBytesFromFile("javase_io/src/sourceFiles/dst.txt");
            writeBytesToFile(data, "javase_io/src/destFiles/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件 ---程序---- >字节数组
     *
     * @param srcPath
     * @return
     * @throws IOException
     */
    public static byte[] getBytesFromFile(String srcPath) throws IOException {
        // 建立联系
        File file = new File(srcPath);

        // 创建字节数组
        byte[] destArr;

        // 选择流， 输入流
        InputStream is = new BufferedInputStream(new FileInputStream(file));

        // 输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // 定义缓冲区
        byte[] flush = new byte[1024];

        // 读取长度
        int len = 0;

        // 循环读取
        while ((len = is.read()) != -1) {
            bos.write(flush, 0, len);
        }
        bos.flush();

        // 获取数据
        destArr = bos.toByteArray();
        bos.close();
        is.close();
        return destArr;
    }

    public static void writeBytesToFile(byte[] src, String destPath) throws IOException {
        // 建立连接， 目的地
        File file = new File(destPath);

        // 选择流
        // 字节数组输入流
        BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(src));
        // 文件输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        // 缓冲区
        byte[] flush = new byte[1024];
        // 读取长度
        int len = 0;
        while ((len = bis.read()) != -1) {
            bos.write(flush, 0, len);
        }

    }
}
