package com.kenson.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标： 深入迭代器 迭代器： 为容器遍历而生
 * 途径： 使用了内部类|匿名内部类
 * 深入
 * 1、使用内部类 实现迭代器
 * 2、使用Iterator 实现foreach迭代
 * 3、加入末尾添加元素的方法
 * 
 * @author wuchun
 *
 */
public class DeepTestIterator {
	// Store the Array
	private String[] elem = new String[5];
	// The actual length of the array
	private int size = 0;

	public int size() {
		return size;
	}
	
	public void add(String element) {
		if (this.size==element.length()) {
			elem = Arrays.copyOf(elem, elem.length+5);
		}
		//Add element into Array
		elem[size]= element;
		size++;
	}

	private class MyIterator implements Iterator

	{
		// Iterator-- Pointer， Coursor
		private int coursor = -1;

		// Judge if there has next one element
		public boolean hasNext() {
			return coursor + 1 < size;
		}

		// Get the next one element
		public String next() {
			coursor++;
			return elem[coursor];
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

	}

	public Iterator iterator1() {
		return new MyIterator();
	}

	public Iterator iterator2() {
		class MyIterator implements Iterator

		{
			// Iterator-- Pointer， Coursor
			private int coursor = -1;

			// Judge if there has next one element
			public boolean hasNext() {
				return coursor + 1 < size;
			}

			// Get the next one element
			public String next() {
				coursor++;
				return elem[coursor];
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

		}
		;
		return new MyIterator();
	}

	public Iterator iterator3() {
		return new Iterator() { // 创建Iterator迭代器接口实现类的对象
			// Iterator-- Pointer， Coursor
			private int coursor = -1;

			// Judge if there has next one element
			public boolean hasNext() {
				return coursor + 1 < size;
			}

			// Get the next one element
			public String next() {
				coursor++;
				return elem[coursor];
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
		DeepTestIterator list = new DeepTestIterator();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		
		Iterator iterator = list.iterator1();
		while (iterator.hasNext()) { // First Judge then search
			System.out.println(iterator.next());
//			iterator.remove();
		}
		System.out.println(list.size());
	}

}
