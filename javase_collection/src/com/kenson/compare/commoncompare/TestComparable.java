package com.kenson.compare.commoncompare;
/**
 * 内置引用数据类型的比较
 * @author wuchun
 *
 */
public class TestComparable {

	public static void main(String[] args) {
		Integer a;	//根据基本数据类型大小
		Character c ; //根据Unicode编码顺序
		String string1 = "abc";
		String string2 = "abcd1234";
		System.out.println(string1.compareTo(string2));
		String string3 = "aab";
		String string4 = "aac";
		System.out.println(string3.compareTo(string4));
		java.util.Date d;	//根据日期的长整形比较
	}

}
