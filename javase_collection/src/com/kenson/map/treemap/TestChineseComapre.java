package com.kenson.map.treemap;


import com.kenson.bean.Gender;
import com.kenson.bean.Person;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;

/**
 * @description: 本测试类主要是为了实现中文的排序的功能，中文排序涉及到区分语言环境的
 * 所以在排序的时候是需要设置语言的国家
 * @author: Kenson
 * @date: 2020/9/14
 */
public class TestChineseComapre {
    public static void main(String[] args) {
        TreeMap<String, Person> map = new TreeMap<String, Person>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        // 此时设置了语言区域，那么排序的顺序就是按照汉语拼音的顺序进行排序
                        Collator collator1 = Collator.getInstance(Locale.CHINA);
                        CollationKey key1 = collator1.getCollationKey(o1);
                        CollationKey key2 = collator1.getCollationKey(o2);
                        return key1.compareTo(key2);
                    }
                }
        );

        Person p1 = new Person("张三", 20, Gender.FEMALE);
        Person p2 = new Person("李四", 22, Gender.MALE);
        Person p3 = new Person("王五", 24, Gender.MALE);
        Person p4 = new Person("赵柳", 56, Gender.FEMALE);
        map.put(p1.getName(), p1);
        map.put(p2.getName(), p2);
        map.put(p3.getName(), p2);
        map.put(p4.getName(), p3);

        Set<String> mapKeys = map.keySet();
        for (String k : mapKeys) {
            System.out.println(k);
        }
    }
}
