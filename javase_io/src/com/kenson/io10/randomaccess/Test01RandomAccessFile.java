package com.kenson.io10.randomaccess;

import com.kenson.io.util.CloseStreamUtil;
import com.kenson.io2.bytestream.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/18
 */
public class Test01RandomAccessFile {

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("javase_io/src/sourceFiles/ConvertFile.text"),"r");
        raf.seek(500);
        //定义缓冲大小
        byte[] flush = new byte[1024];
        //接受长度
        int len =0;
        while (-1 != (len=raf.read(flush))) {
            if(len>=200){
                System.out.println(new String(flush, 0, 200));
            }else{
                System.out.println(new String(flush, 0, len));
            }
        }

        CloseStreamUtil.closeAllStream(raf);
    }

}
