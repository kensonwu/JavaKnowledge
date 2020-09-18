package com.kenson.other.syncread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 制度设置
	 *  1.	emptyXXX()		空的不可变的集合
	 * 	  emptySet()
	 *    emptyList()
	 *    emptyMap()
	 *    emptyIterator()
	 *2. singletonXXX()	一个元素不可变的集合   
	 *   singletonList(T o)
	 *	  singletonMap(K key, V value)
	 *3. unmodifiableXXX()	不可变容器
	 *	unmodifiableList(List<? extends T> list)
	 *	unmodifiableMap(Map<? extends K,? extends V> m)
	 * 	unmodifiableSet(Set<? extends T> s)
	 *  unmodifiableSortedMap(SortedMap<K,? extends V> m)
	 *   	unmodifiableSortedSet(SortedSet<T> s)
 * @author wuchun
 *
 */
public class TestCollectionsReadOnly {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("a", "b");
		
		
		//只读控制
		Map<String, String> map2 = Collections.unmodifiableMap(map);
//		map2.put("c", "d");	//UnsupprotedOperationException
		System.out.println(map2.size());
		
		
		//一个元素的容器
		List<String> list = Collections.singletonList(new String());
		list.add("aaa");
		//list.add("bbb");   //只能包含一个元素的list
		
		
	}
	
	public static Set<String> oper(Set<String> set){
		//操作
		if (null == set) {
			return Collections.EMPTY_SET;	//外部获取避免NullPointerException
		}
		return set;
	}

}
