package com.kenson.io05.bufferedstream;

import java.io.*;

/**
 * @description: 字节缓冲流
 * 为什么字节缓冲流速度很快？
 * 因为BufferedInputStream 中有一个8192的byte[]数组
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test01ByteBufferStream {

    public static void main(String[] args) {

    }


    /**
     * 文件的拷贝
     *
     * @param 源文件路径
     * @param 目标文件路径
     */
    public static void copyFile(String srcPath, String destPath) {
        //1.	建立联系，File对象， 源头和目的地
        File src = new File(srcPath);
        File dest = new File(destPath);
        if (!src.isFile()) {
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Only Copy file!!!");
            }
        }
        if (!dest.isFile()) {
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Only write a file!!!");
            }
        }
        //选择流， 文件输入流 InputStream， FileInputStream    文件输入流 OutputStream， FileOutputStream
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            os = new BufferedOutputStream(new FileOutputStream(dest));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //操作： 拷贝   循环读取+写出
        byte[] flush = new byte[1024];
        int len = 0; //实际读取的大小
        try {
            while (-1 != (len = is.read(flush))) {
                //写出
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Filed to close outputstream of the file.");
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Filed to close inputstream of the file.");
                }
            }
        }

    }

}
