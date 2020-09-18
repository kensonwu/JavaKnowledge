package com.kenson.list.linkedlist;

/**
 * 用来表示一个节点
 * 
 * @author wuchun
 *
 */
public class Node {
	Node previous; // The previous node
	Object obj;
	Node next; // The next node

	public Node() {

	}

	public Node(Node previous, Object obj, Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Object getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
