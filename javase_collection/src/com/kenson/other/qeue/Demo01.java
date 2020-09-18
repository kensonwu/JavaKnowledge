package com.kenson.other.qeue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列模拟银行存款业务
 * @author wuchun
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Queue<Request>	queue = new ArrayDeque<Request>();
		//模拟排队情况
		for (int i = 0; i < 10; i++) {
			final int num = i;
			queue.offer(new Request(){	//匿名内部类
				@Override
				public void deposit() {
					System.out.println("第" + (num+1) + "个人，办理存款业务，存款额度为： " + Math.random());
				}
				
			});
		}
		
		dealWith(queue);
	}
	
	//处理存款业务
	public static void dealWith(Queue<Request> que){
		Request req = null;
		while (null != (req=que.poll())) {
			req.deposit();
		}
	}
}



interface Request{
	//存款
	void deposit();
}