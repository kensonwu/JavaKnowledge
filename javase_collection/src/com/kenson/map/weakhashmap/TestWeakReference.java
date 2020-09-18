package com.kenson.map.weakhashmap;

import java.lang.ref.WeakReference;

/**
 * 引用的分类： 强，软，弱，虚， 这个分类都是根据运行GC的时候回收对象的次序而分的
 * 强与弱引用
 * @author wuchun
 *
 */
public class TestWeakReference {
	public static void main(String[] args) {
//		testStrongRef();
		testWeakRef();
	}
	
	public static void testStrongRef(){
		//存放在字符串常量池中，共享（不能回收）
				String string = "Kenson is handsome!";
				
				//弱引用管理对象
				WeakReference<String> wr = new WeakReference<String>(string);
				System.out.println("gc运行前：" + wr.get());
				//断开引用
				string = null;
				//通知回收
				System.gc();
				System.runFinalization();
				System.out.println("gc运行后：" + wr.get());
	}
	
	public static void testWeakRef(){
		//存放在字符串常量池中，共享（不能回收）
				String string = new String("Kenson is handsome!");
				
				//弱引用管理对象
				WeakReference<String> wr = new WeakReference<String>(string);
				System.out.println("gc运行前：" + wr.get());
				//断开引用
				string = null;
				//通知回收
				System.gc();
				System.runFinalization();
				//对象被回收了
				System.out.println("gc运行后：" + wr.get());
	}

}
