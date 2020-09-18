package com.kenson.other.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.map.StaticBucketMap;



/**
 * 函数式编程之Predicate 断言
 * 封装条件或判别式 if...else替代
 * 1、 new EqualPredicate<类型>(值)
 * 	  EqualPredicate.equalPredicate(值)
 * 2、 NotNullPredicate.INSTANCE
 * 3. 唯一性判断 UniquePredicate.uniquePredicate()
 * 4、 自定义
 * 		new Predicate()	+ 重写evaluate()方法
 * 	PredicateUtils.allPredicate and  PredicateUtils.anyPredicate
 * PredicateXXX.predicatedXxx(容器， 判断)
 * 
 * @author wuchun
 *
 */
public class TestPredicate {

	public static void main(String[] args) {
		equal();
		compareNotNull();
		uniqueControl();
		selfDefineControl();
	}
	
	/**
	 * 比较相等判断
	 */
	public static void equal(){
		System.out.println("===========相等判断================");
		Predicate<String> pre = EqualPredicate.equalPredicate("kenson");
		boolean flag = pre.equals("kenso");
		System.out.println(flag);
	}
	
	/**
	 * 判断非空
	 */
	public static void compareNotNull(){
		System.out.println("===========非空判断================");
		//Predicate notNull = NotNullPredicate.INSTANCE;
		Predicate notNull = NotNullPredicate.notNullPredicate();
		//String string = "ken";	//判断结果为true
		//如果把string改成null， 那么结果就是false
		String string = null;	//判断结果为false
		System.out.println(notNull.evaluate(string));	//如果非空为true，否则为false
		
		
		//添加容器的值判断
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), notNull);
		list.add(1000L);
		//list.add(null);	//验证时报， 抛出异常：java.lang.IllegalArgumentException: Cannot add Object 'null' - Predicate 'org.apache.commons.collections4.functors.NotNullPredicate@14ae5a5' rejected it
	}
	
	/**
	 * 判断唯一
	 */
	public static void uniqueControl(){
		System.out.println("===========唯一性判断================");
		Predicate<Long> uniquePre = UniquePredicate.uniquePredicate();
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), uniquePre);
		list.add(100L);
		//list.add(100L);	//报错：java.lang.IllegalArgumentException　重复
	}
	
	/**
	 * 自定义的判断
	 */
	public static void selfDefineControl(){
		//判断长度 5 到20位
		 Predicate<String> selfPre = new Predicate<String>() {

			@Override
			public boolean evaluate(String object) {
				return object.length()>=5 && object.length()<=20;
			}
		};
		Predicate notNull = NotNullPredicate.INSTANCE;
		Predicate all = PredicateUtils.allPredicate(selfPre, notNull);
		List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), all);
		list.add("kenson");
		//list.add("");
		
	}
}
