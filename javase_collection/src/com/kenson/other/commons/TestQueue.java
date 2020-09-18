package com.kenson.other.commons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * Queue 队列
 * 1. 循环队列
 * 2. 不可改变队列（只读队列）
 * circular()
 * readOnly()
 * predicate()
 * @author wuchun
 *
 */
public class TestQueue {
	public static void main(String[] args) {
		circularQueue();
//		readOnlyQueue();
	}
	
	/**
	 * 循环队列
	 */
	public static void circularQueue(){
		CircularFifoQueue<String> que = new CircularFifoQueue<>(2);
		que.add("ab");
		que.add("cd");
		que.add("ef");
		for (int i = 0; i < que.size(); i++) {
			System.out.println(que.get(i));
		}
	}
	
	/**
	 * 只读队列
	 */
	public static void readOnlyQueue(){
		CircularFifoQueue<String> que = new CircularFifoQueue<>(2);
		que.add("ab");
		que.add("cd");
		que.add("ef");
		Queue<String> readOnlyQue = UnmodifiableQueue.unmodifiableQueue(que);
		readOnlyQue.add("Hi");
	}
	
	/**
	 * 断言
	 */
	public static void predicateQueue(){
		CircularFifoQueue<String> que = new CircularFifoQueue<>(2);
		que.add("ab");
		que.add("cd");
		que.add("ef");
		
		Predicate notNull = NotNullPredicate.INSTANCE;
		//包装成对应的队列
		Queue<String> 	que2 = PredicatedQueue.predicatedQueue(que, notNull);
		que.add(null);
	}
}
