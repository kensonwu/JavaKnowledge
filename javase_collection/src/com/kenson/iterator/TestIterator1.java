package com.kenson.iterator;

/**
 * 目标： 理解迭代器 迭代器： 为容器遍历而生
 * 
 * @author wuchun
 *
 */
public class TestIterator1 {
	// Strore the Array
	private String[] elem = { "a", "b", "c" };
	// The length of the array
	private int size = elem.length;

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
		//Move the array elements
//		System.arraycopy(elem, coursor+1, coursor, elem, this.size-coursor+1);
		//move array
		System.arraycopy(elem, coursor+1, elem, coursor, this.size-coursor+1);
		//the actual size -1
		this.size--;
		this.coursor--;
		
	}

	public static void main(String[] args) {
		TestIterator1 list = new TestIterator1();
		if (list.hasNext()) {
			System.out.println(list.next());
		}

		if (list.hasNext()) {
			System.out.println(list.next());
		}

		if (list.hasNext()) {
			System.out.println(list.next());
		}
		
		//First judge if has next
		if (list.hasNext()) {
			System.out.println(list.next());
		}

	}

}
