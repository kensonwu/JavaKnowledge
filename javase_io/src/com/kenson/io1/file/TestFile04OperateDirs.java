package com.kenson.io1.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @description: 操作目录
 * 操作目录
 * mkdir()	创建目录，必须确保父目录存在，如果不存在，创建失败
 * mkdirs()	创建目录，如果父目录存在，一同创建
 * list()文件 目录字符串形式
 * litFiles()
 * static listRoots() 跟路径
 * @author: Kenson
 * @date: 2020/9/16
 */
public class TestFile04OperateDirs {
    public static void main(String[] args) {
//        test1();
//        test2();
//        filterEndWithJavaFilesUnderFolders();
//        filterEndWithJavaFilesUnderAllFolders(new File("./javase_io/src"));
        filterEndWithJavaFilesUnderAllFolders(new File("C:/Study/Java/SecondJava300/SourceCode"));
    }

    public static void test1() {
        String path = "C:/OneTEAM/OneTEAMTools/IO/Test/Test";
        File file = new File(path);
        file.mkdirs();
    }

    public static void test2() {
//        String path = "C:/OneTEAM/OneTEAMTools/IO/TestFiles";
        String path = "C:/OneTEAM/Documents";
        File src = new File(path);    //文件夹
        if (src.isDirectory()) {    //存在且为目录
            System.out.println("=========子目录|文件名==============");
            String[] subNames = src.list();
            for (String string : subNames) {
                System.out.println(string);
            }

            System.out.println("=========子目录|文件File对象==============");
            File[] subFiles = src.listFiles();
            for (File temp : subFiles) {
                System.out.println(temp.getAbsolutePath());
            }
            System.out.println("=========子目录.java对象==============");
            //命令设计模式
            subFiles = src.listFiles(new FilenameFilter() {
                /**
                 * dir 代表 src
                 */
                @Override
                public boolean accept(File dir, String name) {
                    //System.out.println("dir代表那个路径呢？ 是不是src 呢？   "+ dir);
                    return new File(dir, name).isFile() && name.endsWith(".java");
                }
            });

            for (File temp : subFiles) {
                System.out.println(temp.getAbsolutePath());
            }
        }
    }

    /**
     * 筛选出一个目录下所有以java结尾的文件
     * 这是使用了FilenameFilter， 实际上 使用了命令设计模式
     */
    public static void filterEndWithJavaFilesUnderFolders() {
        String path = "./javase_io/src/com/kenson/io1/file";
        File src = new File(path);
        if (src.isDirectory()) {
            File[] subFiles = src.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    // dir代表 src
//                    System.out.println("accept 方法中的dir路径： " + dir);
                    return new File(dir, name).isFile() && name.endsWith(".java");
                }
            });
            for (File tempFile : subFiles) {
                System.out.println(tempFile.getAbsolutePath());
            }
        } else {
            System.out.println("路径不为文件夹！");
        }
    }

    /**
     * 筛选出一个目录下所有以java结尾的文件
     * 这是使用了FilenameFilter， 实际上 使用了命令设计模式
     */
    public static void filterEndWithJavaFilesUnderAllFolders(File file) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles.length != 0) {
                for (File tempFile : subFiles) {
                    filterEndWithJavaFilesUnderAllFolders(tempFile);
                }
            } else {
                System.out.println(file.getAbsolutePath() + "文件夹下没有文件");
            }
        } else {
            if (file.getName() != null && file.getName().endsWith("java"))
                System.out.println(file.getAbsolutePath() + file.getName());
        }
    }
}
