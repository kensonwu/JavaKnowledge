package com.kenson.io2.bytestream;

import java.io.*;

/**
 * @description: 通过字节流从磁盘读取数据
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test01FileInputStream {

    public static void main(String[] args) {
        // 1. 建立连接
//        String srcPath = "javase_io/src/sourceFiles/300.jpg";
        // 此处需要注意相对路径和绝对路径的区别
        String srcPath = "javase_io/src/sourceFiles/zipfiles.txt";
        File file = new File(srcPath);
        System.out.println(file.getAbsolutePath());

        //2. 选择流， 此处选择字节流(处理一切的流)
        InputStream inputStream = null;
        {
            try {
                inputStream = new FileInputStream(file);
                // 定义读取的长度
                int len = 0;
                // 定义缓存数组用于读取
                byte[] buffer = new byte[100];
                // 3. 使用缓冲数组不断循环读取，知道读取到文件末尾
                while (-1 != (len = inputStream.read(buffer))) {// 注意读取必须放在whilen内，否则会出现死循环
                    // 查看读取到的内容， 字节数组转换成String
                    String info = new String(buffer, 0, len);
                    System.out.println("每次读取到的内容为： " + info);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("释放资源");
                    }
                }
            }
        }
    }

}
