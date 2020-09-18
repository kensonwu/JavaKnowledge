package com.kenson.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标：使用泛型可以操作多个类型 途径： 加入泛型
 * 
 * @author wuchun
 *
 */
public class TestFanxinArrayList<E> implements Iterable<E> {
	// Strore the Array
	private Object[] elem = new Object[5];
	// The actual length of the array
	private int size = 0;

	public int size() {
		return size;
	}

	public void add(E element) {
		if (this.size == elem.length) {
			elem = Arrays.copyOf(elem, elem.length + 5);
		}
		// Add element into Array
		elem[size] = element;
		size++;
	}

	public Iterator iterator() {
		return new Iterator() { // 创建Iterator迭代器接口实现类的对象
			// Iterator-- Pointer， Coursor
			private int coursor = -1;

			// Judge if there has next one element
			public boolean hasNext() {
				return coursor + 1 < size;
			}

			// Get the next one element
			public E next() {
				coursor++;
				return (E) elem[coursor];
			}

			// Remove the next one element
			public void remove() {
				// Move the array elements
				// System.arraycopy(elem, coursor+1, coursor, elem,
				// this.size-coursor+1);
				// move array
				System.arraycopy(elem, coursor + 1, elem, coursor, size - coursor + 1);
				// the actual size -1
				size--;
				coursor--;

			}
		};
	}

	public static void main(String[] args) {
		TestFanxinArrayList<Integer> list = new TestFanxinArrayList<>();
		list.add(1);
		list.add(2);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("--------------");

		TestFanxinArrayList<String> list1 = new TestFanxinArrayList<>();
		list1.add("ABC");
		list1.add("DEF");
		list1.add("121231321");
		for (String integer1 : list1) {
			System.out.println(integer1);
		}

		System.out.println("--------------");

		Iterator<String> it = list1.iterator();
		while (it.hasNext()) {
			String e = it.next();
			System.out.println(e);
		}
	}

}
