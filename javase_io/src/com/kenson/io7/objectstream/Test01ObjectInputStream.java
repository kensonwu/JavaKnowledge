package com.kenson.io7.objectstream;

import com.kenson.io.util.CloseStreamUtil;
import com.sun.deploy.util.StringUtils;

import java.awt.datatransfer.StringSelection;
import java.io.*;

/**
 * @description: DataInputStream和DataOutputStream
 * 作用： 将Java中对象的"内存状态"保存到磁盘上或者在网络中传递
 * 实际作用就是将堆中的对象序列化到磁盘中，以后使用时直接读取磁盘文件到内存中使用即可
 * 不是所有对象都可以序列化， 不能序列化的对象将抛出java.io.NotSerializableException
 * 不是所有的属性都需要序列化 transient
 * @author: Kenson
 * @date: 2020/9/17
 */
public class Test01ObjectInputStream {
    public static void main(String[] args) {
        serilize("javase_io/src/destFiles/objoupt.txt");
        readObjData("javase_io/src/destFiles/objoupt.txt");
    }

    /**
     * 将堆内存中的对象数据持久化到磁盘
     * 注意：对象需要实现Serializable
     *
     * @param destPath
     */
    public static void serilize(String destPath) {
        Employee emp = new Employee("kenson", 22, 1001);
        //1. 建立联系
        File file = new File(destPath);
        //2. 选择流
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            //3. 写出操作
            os.writeObject(emp);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseStreamUtil.closeAllStream(os);
        }
    }

    public static void readObjData(String srcPath) {
        //1. 建立连接
        File file = new File(srcPath);
        // 选择流
        ObjectInputStream is = null;
        try {
            is = new ObjectInputStream(new BufferedInputStream(new FileInputStream(srcPath)));
            //3. 读取
            Employee emp = (Employee) is.readObject();
            System.out.println(emp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            CloseStreamUtil.closeAllStream(is);
        }


    }
}
