package com.kenson.generic1;

import com.kenson.bean.Student;

/**
 * @description: 通过此实例可以看到没有泛型时是多么麻烦的一件事情，
 * 因为很多时候需要进行类型判断然后再进行强制转换
 * @author: Kenson
 * @date: 2020/9/15
 */
public class NoGenericSampleApp {
    public static void main(String[] args) {
        Student stu = new Student();
        // 存入int类型的数 -- Integer -- Object
        stu.setJavaseName(80);
        // 获取出数据时处理转换异常
        Object name = stu.getJavaseName();
        if (name instanceof  Integer){
            // 类型强制转换
            Integer javaseScore = (Integer) name;
        }

    }
}
