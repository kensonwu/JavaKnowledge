package com.kenson.other.guava;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 函数式编程: 最大的好处就是： 解耦
 * 1. Predicate	位与	
 * 2. Fuction
 * 
 * 工具：Collections2.fiter()		过滤器
 * Collections2.transfer()		转换
 * Functions.compose	组合式函数编程
 * @author wuchun
 *
 */
		
public class TestGuavaPredicate {
	public static void main(String[] args) {
//		predicateTest();
//		functionTest();
		testFunctionCompose();
	}
	
	/**
	 * 过滤器
	 */
	public static void predicateTest(){
		//创建List 静态初始化
		List<String> list = Lists.newArrayList("moom", "son", "dad","refer");
		//找出回文 	palindrome back words mirror words
		//匿名内部类对象： 匿名内部类，同时创建类对象
		Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				return new StringBuilder(input).reverse().toString().equals(input);
			}
		});
		
		for (String temp : palindromeList) {
			System.out.println(temp);
		}
	}
	
	/**
	 * Function 
	 */
	public static void functionTest(){
		//类型转换
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(9000000000L);
		timeSet.add(9999999999999L);
		timeSet.add(200000000L);
		Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long, String>() {

			@Override
			public String apply(Long arg0) {
				return new SimpleDateFormat("yyyy-MM-dd").format(arg0);
			}
		});
		
		for (String temp : timeStrCol) {
			System.out.println(temp);
		}
	}
	
	/**
	 * 组合式函数编程
	 */
	
	public static void testFunctionCompose(){
		//组合式函数编程
		//需求： 确保容器中的字符串长度不超过5，后全部大写
		List<String> list = Lists.newArrayList("good","bad", "happniess","kenson");
		//确保容器中的字符串长度不超过5，超过截取
		Function<String, String> f1 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				return input.length()>5?input.substring(0, 5):input;
			}
		};
		
		//转大写
		Function<String, String> f2 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				return input.toUpperCase();
			}
		};
		
		//String str = f1(f2)
		Function<String, String> function = Functions.compose(f1, f2);
		Collection<String> resultCol = Collections2.transform(list, function);
		for (String temp : resultCol) {
			System.out.println(temp);
		}
	}

}
