package com.kenson.io2.bytestream;

import java.io.*;
import java.lang.reflect.Field;
import java.time.OffsetDateTime;

/**
 * @description: 拷贝文件以及拷贝文件夹的工具类
 * @author: Kenson
 * @date: 2020/9/16
 */
public class FileUtil {

    /**
     * @param srcPath  源文件地址
     * @param destPath 目标目录地址
     * @throws FileNotFoundException 文件未找到异常
     * @throws IOException           IOException
     */
    public static void copyFile(String srcPath, String destPath) throws FileNotFoundException, IOException {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        copyFile(srcFile, destFile);
    }

    /**
     * 功能： 拷贝文件
     *
     * @param srcFile  源文件
     * @param destFile 目标文件
     * @throws IOException           IO异常
     * @throws FileNotFoundException 文件未找到异常
     */
    public static void copyFile(File srcFile, File destFile) throws FileNotFoundException, IOException {
        if (!srcFile.isFile()) {
            throw new IOException("只能拷贝文件！");
        }
        // 如果dest为已经存在的文件夹，不能建立与文件夹同名的文件
        if (destFile.isDirectory()) {
            System.out.println("不能创建与同名文件的文件");
            throw new IOException(destFile.getAbsolutePath() + "不能创建与文件夹同名的文件");
        }

        // 选择流
        InputStream is = null;
        OutputStream os = null;
        // 使用缓冲流
        is = new BufferedInputStream(new FileInputStream(srcFile));
        if (!destFile.exists()){
            destFile.createNewFile();
        }
        os = new BufferedOutputStream(new FileOutputStream(destFile));
        // 拷贝， 读取 + 写出
        int len = 0;
        byte[] flush = new byte[1024];
        while (-1 != (len = is.read(flush))) {
            os.write(flush, 0, len);
        }
        // 强制刷出
        os.flush();

        // 关闭流
        os.close();
        is.close();
    }

    public static void copyDir(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        copyDir(src, dest);
    }

    /**
     * 拷贝文件下的所有文件
     *
     * @param src 源File对象
     * @param dest 目标File对象
     */
    public static void copyDir(File src, File dest) {
        if (src.isDirectory()) {
//            dest = new File(dest, src.getName());
            if (dest.getAbsolutePath().contains(src.getAbsolutePath())) {
                System.out.println("父目录不能拷贝到子目录中！");
            }
        }
        copyDirDetail(src, dest);
    }

    /**
     * 拷贝文件
     *
     * @param src
     * @param dest
     */
    private static void copyDirDetail(File src, File dest) {
        if (src.isFile()) {// 文件
            try {
                FileUtil.copyFile(src, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (src.isDirectory()) {// 文件夹
            if (!dest.exists()) {
                dest.mkdir();
            }
            for (File subFile : src.listFiles()) {
                copyDirDetail(subFile, new File(dest, subFile.getName()));
            }
        }
    }

}
