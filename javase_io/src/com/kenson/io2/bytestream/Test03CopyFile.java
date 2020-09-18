package com.kenson.io2.bytestream;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import java.io.*;

/**
 * @description: 文件拷贝 程序为桥梁
 * 1.	建立联系，File对象， 源头和目的地
    2.	选择流， 文件输入流 InputStream， FileInputStream    文件输入流 OutputStream， FileOutputStream
    3.	操作： 拷贝   ：
    byte[]  flush = new byte[1024] +read+读取大小
    int len = 0;
    while(-1 != (len= 输入流.read(flush))){
        输出流.write(flush,0, len);
    }
    输出流.flush
    4.	释放资源：关闭两个流
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test03CopyFile {
    public static void main(String[] args) {
        String srcPath = "javase_io/src/sourceFiles/300.jpg";
        String destPath = "javase_io/src/distFiles/300.jpg";
        copyFile(srcPath, destPath);
    }

    /**
     *
     * @param srcPath 源文件路径
     * @param destPath 目标文件路径
     */
    public static void copyFile(String srcPath, String destPath){
        // 1. 建立联系
        File  src = new File(srcPath);
        File  dest = new File(destPath);

        // 程序健壮性
        if (!src.isFile()){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("只能拷贝文件！");
            }
        }

        if (!dest.exists()){
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建文件失败！");
            }
            if (!dest.isFile()) {
                try {
                    throw new  IOException();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("只能写文件!");
                }
            }
        }

        //选择流， 文件输入流 InputStream， FileInputStream    文件输入流 OutputStream， FileOutputStream
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int len = 0;
            // 操作：拷贝 读取+写出
            while (-1 != (len = is.read(buffer))){
                // 写出
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
