package com.kenson.map.weakhashmap;

import java.util.WeakHashMap;

/**
 * WeakHashMap 键为弱类型，gc运行被立即回收
 * @author wuchun
 *
 */
public class TestWeakHashMap {
	public static void main(String[] args) {
		WeakHashMap<String, String> map = new WeakHashMap<String, String>();
		//test data
		//常量池对象不会被回收
		map.put("a", "abc");
		map.put("b", "bcd");
		//gc运行已被回收
		map.put(new String("Don't be lazy"),"good");
		map.put(new String("Work hard"),"Come on");
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后：" + map.keySet());
	}
}
