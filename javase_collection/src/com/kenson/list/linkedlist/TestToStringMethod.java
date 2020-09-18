package com.kenson.list.linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 8基本类型和包装类 、String类，其toString已做过重载，因此能够打印出值
// 自定义类（如下面的B及其子类），需要重载其toString方法，才能够打印出非默认的值
// 其中，Object类中toString的默认值是“包名.类名@哈希值”</span></strong>

public class TestToStringMethod {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 9, 4, 5);
		System.out.println(list1.toString()); // [1, 2, 9, 4, 5]

		List<String> list2 = Arrays.asList("abcd", "333", "fdsd", "3332dsdas");
		System.out.println(list2.toString()); // [abcd, 333, fdsd, 3332dsdas]

		List<B> list3 = Arrays.asList(new B(), new B1(), new B2(), new B3(), new B4(), new B5());
		System.out.println(list3.toString()); // [B@1cfe4b2, B1 , B2 , B3@1f2d08e, B4 , B5@b5c224]

		// 数组本身的toString方法未重载，只是简单继承了Object类的toString方法，其返回值是“包名.类名@哈希值”
		// 打印数组中的内容，使用的是Arrays.toString方法
		Integer[] arr1 = list1.toArray(new Integer[0]);
		System.out.println(arr1.toString()); // [Ljava.lang.Integer;@1e25b76
		System.out.println(Arrays.toString(arr1)); // [1, 2, 9, 4, 5]

		String[] arr2 = list2.toArray(new String[0]);
		System.out.println(arr2.toString()); // [Ljava.lang.String;@1a8dfcc
		System.out.println(Arrays.toString(arr2)); // [abcd, 333, fdsd,
													// 3332dsdas]

		B[] arr3 = list3.toArray(new B[0]);
		System.out.println(arr3.toString()); // [LB;@a30797
		System.out.println(Arrays.toString(arr3)); // [B@1cfe4b2, B1 , B2 , B3@1f2d08e, B4 , B5@b5c224]

		double[] arr4 = new double[] { 32, -32.32, -0.99, 43, 66 };
		System.out.println(arr4.toString()); // [D@774085
		System.out.println(Arrays.toString(arr4)); // [32.0, -32.32, -0.99,  43.0, 66.0]

		List<Integer> tmpLst = Arrays.asList(6, 40, 1, 3, 4, 5, 3, 1);
		Set<Integer> set1 = new HashSet<Integer>(tmpLst); // 自动去重
		System.out.println(set1.toString()); // [1, 3, 4, 5, 6, 40]

		List<String> tmpList2 = Arrays.asList("abc", "32eds", new String("abc"), "dsd", "abc", new String("abc"));
		Set<String> set2 = new HashSet<String>(tmpList2); // 按内容去重
		System.out.println(set2.toString()); // [abc, 32eds, dsd]

		B b1 = new B(), b2 = new B(), b3 = b1;
		List<B> tmpList3 = Arrays.asList(b1, b2, b3, new B3(), new B4(), new B());
		Set<B> set3 = new HashSet<B>(tmpList3); // 按变量的值去重
		System.out.println(set3.toString()); // [B@996db8, B3@1be847c, B4 ,B@2e1f26, B@163006a]

		Map<Integer, Double> map1 = new HashMap<Integer, Double>() {
			{
				put(5, 4.345);
				put(3, 0.3234);
				put(5, 43.2143);
				put(0, -99.0);
			}
		}; // key值相同，后放入的覆盖之前放入的
		System.out.println(map1.toString()); // {0=-99.0, 3=0.3234, 5=43.2143}

		Map<String, Integer> map2 = new HashMap<String, Integer>() {
			{
				put("abc", 0);
				put("123", 0);
				put("abc", 9);
				put("1230", 0);
				put("0123", 8888);
			}
		};
		System.out.println(map2.toString()); // {abc=9, 123=0, 1230=0, 0123=8888}

		Map<B, String> map3 = new HashMap<B, String>() {
			{
				put(new B(), "abc");
				put(new B1(), "abc");
				put(new B(), "abc");
				put(new B2(), "011");
				put(new B3(), "::LK");
				put(new B4(), "");
				put(new B5(), null);
				put(null, null);
			}
		};
		System.out.println(map3.toString()); // {null=null, B@12f65ce5=abc, B2 =011, B@106258e1=abc, B5@41616dd6=null,
												// B4 =, B3@24e5ddd0=::LK, B1 =abc}

	}
}

class B {

	/*
	 * @Override public boolean equals(Object obj) { B tmp = (B)obj; if (tmp ==
	 * this) { return true; } return false; }
	 * 
	 * @Override public int hashCode() { return super.hashCode();
	 * //如果hashcode相同，会去执行equals }
	 */
}

class B1 extends B {
	public String toString() {
		return "B1  ";
	}
}

class B2 extends B {
	public String toString() {
		return "B2  ";
	}
}

class B3 extends B {
}

class B4 extends B {
	public String toString() {
		return "B4  ";
	}
}

class B5 extends B {
}
