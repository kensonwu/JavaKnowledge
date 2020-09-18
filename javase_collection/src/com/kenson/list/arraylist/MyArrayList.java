package com.kenson.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 自己实现一个ArrayList帮助我们更好的理解ArrayList的底层结构
 * 通过自己实现ArrayList可以看到 ArrayList的底层实现是通过数组实现的
 * 那么ArrayList的优缺点是：
 * 优点：查询效率高
 * 缺点：增删改效率低
 * 
 * @author wuchun
 *
 */
public class MyArrayList {
	private Object[] elementData;
	private int size;

	// 定义构造器
	public MyArrayList() {
		this(10);
	}

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.elementData = new Object[initialCapacity];
	}

	public void add(Object object) {
		// Increase the capacity of array and copy the data of the array
		if (size == elementData.length) {
			Object[] newArray = new Object[size * 2 + 1];
			// Copy the array
			// System.arraycopy(elementData, 0, newArray, 0, elementData.length);	// 使用JDK自带的数组赋值函数进行数组复制
			
			// 或者自己实现数组的copy
			for (int i = 0; i < elementData.length; i++) {
				newArray[i] = elementData[i];
			}
			// 替换老的elementData
			elementData = newArray;
		}
		elementData[size++] = object;
	}

	public void add(int index, Object obj) {
		rangeCheck(index);
		ensureCapacity();	//数组扩容
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = obj;
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	public void remove(int index) {
		// 删除指定位置的对象
		rangeCheck(index);
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index, elementData, index, numMoved);
			elementData[size--] = null;
		}
	}

	public void remove(Object obj) {
		for (int i = 0; i < size; i++) {
			if (get(i).equals(obj)) { // 注意：底层调用的equals方法而不是==
				remove(i);
			}
		}
	}

	public Object set(int index, Object obj) {
		rangeCheck(index);

		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}

	private void rangeCheck(int index) {
		if (index >= size || index < 0)
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private void ensureCapacity() {
		// Increase the capacity of array and copy the data of the array
		if (size == elementData.length) {
			Object[] newArray = new Object[size * 2 + 1];
			// Copy the array
			// System.arraycopy(elementData, 0, newArray, 0,
			// elementData.length);
			// 或者自己实现数组的copy
			for (int i = 0; i < elementData.length; i++) {
				newArray[i] = elementData[i];
			}
		}
	}

	public static void main(String[] args) {
		MyArrayList myArrayList = new MyArrayList();
		myArrayList.add("aaa");
		myArrayList.add("bbb");
		myArrayList.add("ccc");
		myArrayList.add("ddd");
		myArrayList.add("eee");
		myArrayList.add("fff");
		myArrayList.add("hhh");
		myArrayList.add("iii");
		myArrayList.add("jjj");
		System.out.println(myArrayList.size());
		System.out.println(myArrayList.get(8));
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		list.add("fff");
		list.add("hhh");
		list.add("iii");
		list.add("jjj");
		
		System.out.println(Arrays.toString(list.toArray()));
		 
		System.out.println(list.add("fadafafda"));
	}

}
