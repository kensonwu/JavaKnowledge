package com.kenson.io2.bytestream;

import java.io.File;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/16
 */
public class Test04CopyDir {
    public static void main(String[] args) {
        File src = new File("javase_io/src/sourceFiles/");
        File dest = new File("javase_io/src/Test/");
        FileUtil.copyDir(src,dest);
    }
}
