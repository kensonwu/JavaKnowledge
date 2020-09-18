package com.kenson.other.commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;


/**
 * 解耦，将业务处理与判断进行分离
 * 函数式编程Transformer 类型转化
 *  1、 new Transformer + 重写transform()方法
 *  2、 new SwitchTransformer
 *  3、 new SwitchTransformer(容器， 转换器)
 * 
 * 
 * @author wuchun
 *
 */

public class TestFunctionCoding {
	public static void main(String[] args) {
		inner();
		selfDefineTypeTrans();
	}

	/**
	 * 内置类型的转化
	 */
	public static void inner() {
		System.out.println("内置类型， 长整形时间日期，转成指定格式的字符串");
		// 类型转换器
		Transformer<Long, String> transformer = new Transformer<Long, String>() {

			@Override
			public String transform(Long input) {
				return new SimpleDateFormat("yyyy年MM月dd日").format(input);
			}
		};
		
		List<Long> list = new ArrayList<Long>();
		list.add(99999999L);
		list.add(100000000L);

		// 工具类
		Collection<String> result = CollectionUtils.collect(list, transformer);
		for (String string : result) {
			System.out.println(string);
		}
	}

	/**
	 * 自定义类型的转化
	 */
	public static void selfDefineTypeTrans() {
		System.out.println("=============自定义类型的转化=================");
		// 判别式
		Predicate<Employee> isLow = new Predicate<Employee>() {

			@Override
			public boolean evaluate(Employee object) {
				return object.getSalary() < 10000;
			}
		};

		Predicate<Employee> isHigh = new Predicate<Employee>() {

			@Override
			public boolean evaluate(Employee object) {
				return object.getSalary() >= 10000;
			}
		};

		Predicate[] pres = {  isLow, isHigh };
		
		//类型转换 -- 将Employee 转成level
		Transformer<Employee, Level> lowTrans = new Transformer<Employee, Level>() {

			@Override
			public Level transform(Employee input) {
				return new Level(input.getName(), "卖身中！");
			}
		};
		
		Transformer<Employee, Level> highTrans = new Transformer<Employee, Level>() {

			@Override
			public Level transform(Employee input) {
				return new Level(input.getName(), "养身中！");
			}
		};
		
		Transformer[] trans = {lowTrans,highTrans};
		
		//二者进行关联
		Transformer switchTrans = new SwitchTransformer(pres, trans, null);
		
		//create a list
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Ken", 2000));
		list.add(new Employee("Kenson", 1000000));
		
		//transform
		Collection<Level> collectList = CollectionUtils.collect(list, switchTrans);
		
		//遍历
		Iterator<Level> levelIt = collectList.iterator();
		while (levelIt.hasNext()) {
			System.out.println(levelIt.next());
		}
		
	}
}
