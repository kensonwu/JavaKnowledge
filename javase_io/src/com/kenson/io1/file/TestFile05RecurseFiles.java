package com.kenson.io1.file;

import java.io.File;
import java.util.Arrays;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/16
 */
public class TestFile05RecurseFiles {

    public static void main(String[] args) {
        File file = new File("C:/Study/Java/IdeaWorkspace/javase_io");
//        recursePrintFileName(file);
        // 列出可用的文件系统根
        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
        for (File tmp : roots) {
//            recursePrintFileName(tmp); // 不要轻易打开此行 否则会执行很长时间
        }
    }

    public static void recursePrintFileName(File file) {
        if (null == file && !file.exists()) {
            return;
        }

        // 打印文件以及文件夹的绝对路径
        System.out.println(file.getAbsolutePath());

        if (file.isDirectory()) {
            for (File tmp : file.listFiles()) {
                recursePrintFileName(tmp);
            }
        }

    }
}
