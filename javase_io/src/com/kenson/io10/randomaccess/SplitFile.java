package com.kenson.io10.randomaccess;


import com.kenson.io.util.CloseStreamUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
    //文件的路径
    private String filePath;
    //文件名
    private String fileName;
    //文件大小
    private long length;
    //块数
    private int size;
    //每块的大小
    private long blockSize;

    //分割后的存放目录
    private String destBlockPath;

    //每块的名称
    private List<String> blockPath;

    public SplitFile() {
        blockPath = new ArrayList<>();
    }

    public SplitFile(String filePath, String destBlockPath) {
        this(filePath, destBlockPath, 1024);
    }

    public SplitFile(String filePath, String destBlockPath, long blockSize) {
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        this.destBlockPath = destBlockPath;
        init();
    }

    /**
     * 初始化 计算块数 文件名
     */
    public void init() {
        File src;
        //健壮性
        if (null == filePath || !((src = new File(filePath)).exists())) {
            return;
        }

        if (src.isDirectory()) {
            System.out.println("Can not split the folder!");
            return;
        }

        //文件名
        this.fileName = src.getName();

        //计算块数、实际大小、与每块大小
        this.length = src.length();
        System.out.println("文件总长度： " + length + "字节");
        //修正每块大小
        if (this.blockSize > length) {
            this.blockSize = length;
        }

        //确定块数
        size = (int) Math.ceil(length * 1.0 / this.blockSize);

        //确定文件路径
        initPathName();
    }

    private void initPathName() {
        for (int i = 0; i < size; i++) {
            this.blockPath.add(destBlockPath + "/" + this.fileName + ".part" + i);
            //this.blockPath.add(this.fileName + ".part" + i);
        }
    }

    /**
     * 文件分割
     * 0）、确定第几块
     * 1、起始位置
     * 2、实际大小
     */
    public void split() {
        //起始点
        int beginPos = 0;
        //每块实际大小
        long actualBlockSize = this.blockSize;

        //计算所有块的大小、 位置、 索引
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {    //最后一块
                actualBlockSize = this.length - beginPos;
            }
            splitDetail(i, beginPos, actualBlockSize);
            beginPos += actualBlockSize; //本次的终点,下一次的起点
        }
    }

    /**
     * 文件的分割， 输入 输出
     * 文件拷贝
     */
    private void splitDetail(int idx, long beginPos, long actualBlockSize) {
        //1、创建撒源
        File src = new File(this.filePath);    //源文件
        File dest = new File(this.blockPath.get(idx));    //目标文件

        //2、选择流
        RandomAccessFile raf = null;    //输入流
        BufferedOutputStream bos = null;    //输出流
        try {
            raf = new RandomAccessFile(src, "r");
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            //读取文件
            raf.seek(beginPos);
            //缓冲区
            byte[] flush = new byte[1024];
            //接受长度
            int len = 0;
            while (-1 != (len = raf.read(flush))) {
                if (actualBlockSize - len >= 0) {//查看是否足够
                    //写出
                    bos.write(flush, 0, len);
                    actualBlockSize -= len;    //剩余量
                } else {
                    //写出最后一次的剩余量
                    bos.write(flush, 0, (int) actualBlockSize);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseStreamUtil.closeStream(bos, raf);
        }

    }


    /**
     * 文件合并
     *
     * @param destPath 分割文件存放目录
     */
    public void merge(String destPath) {
        // 创建源
        File dest = new File(destPath);
        // 选择流
        BufferedOutputStream bos = null; // 输出流
        SequenceInputStream sis = null;    // 输入流
        // 创建一个容器
        Vector<InputStream> vi = new Vector<>();

        try {
            for (int i = 0; i < blockPath.size(); i++) {
                vi.add(new BufferedInputStream(new FileInputStream(this.blockPath.get(i))));
            }
            bos = new BufferedOutputStream(new FileOutputStream(dest, true));
            sis = new SequenceInputStream(vi.elements());
            // 缓冲区
            byte[] flush = new byte[1024];
            // 接受长度
            int len = 0;

            while (-1 != (len = sis.read(flush))) {
                bos.write(flush, 0, len);
            }

            bos.flush();
            CloseStreamUtil.closeStream(sis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseStreamUtil.closeStream(bos);
        }
    }

    /**
     * 文件合并
     *
     * @param destPath 分割文件存放目录
     */
    public void mergeFile(String destPath) {
        // 创建源
        File dest = new File(destPath);
        // 选择流
        BufferedOutputStream bos = null; // 输出流
        BufferedInputStream bis = null;  //输入流
        try {
            bos = new BufferedOutputStream(new FileOutputStream(dest, true));
            for (int i = 0; i < blockPath.size(); i++) {
                bis = new BufferedInputStream(new FileInputStream(this.blockPath.get(i)));

                //缓冲区
                byte[] flush = new byte[1024];
                //接受长度
                int len = 0;

                while (-1 != (len = bis.read(flush))) {
                    bos.write(flush, 0, len);
                }

                bos.flush();
                CloseStreamUtil.closeStream(bis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseStreamUtil.closeStream(bos);
        }
    }


    public static void main(String[] args) {
        SplitFile split = new SplitFile("C:/OneTEAM/OneTEAMTools/IO/TestFiles/Demo03.java", "C:/OneTEAM/OneTEAMTools/IO/TestFiles/test", 500);
        System.out.println(split.size);
        //split.split();
        split.merge("C:/OneTEAM/OneTEAMTools/IO/TestFiles/merge/test1.java");
    }

}
