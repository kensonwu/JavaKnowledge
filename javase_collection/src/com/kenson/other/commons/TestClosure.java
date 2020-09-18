package com.kenson.other.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

/**
 * 函数式编程 Closure 闭包 封装特定的业务功能 
 * 1. Closure CollectionUtils.forAllDo(容器, 功能类);
 * 2. IfClosure			IfClosure.ifClosure(断言, 功能1, 功能2);
 * 3. WhileClosure		WhileClosure.whileClosure(断言, 功能1, 先执行的标识);
 * 4. ChainedClosure.chainedClosure(功能列表);
 * 
 * @author wuchun
 *
 */

public class TestClosure {
	public static void main(String[] args) {
//		basic();
//		ifClosure();
		whileClosure();
//		chainClosure();
	}

	/**
	 * Closure 基本操作
	 */
	public static void basic() {
		// 测试数据
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Kenson", 200));
		empList.add(new Employee("is", 1000));
		empList.add(new Employee("working", 20000));

		// 将所有员工的工资上涨 0.2

		// 使用闭包 业务功能
		Closure<Employee> cols = new Closure<Employee>() {

			@Override
			public void execute(Employee emp) {
				emp.setSalary(emp.getSalary() * 1.2);
			}
		};

		// 借助工具类
		CollectionUtils.forAllDo(empList, cols);

		// 操作后的数据， 使用迭代器遍历
		Iterator<Employee> it = empList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * 二选一操作 如果是打折商品进行9折， 否则满百减二十
	 */

	public static void ifClosure() {
		// 测试数据
		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList.add(new Goods("javase视频", 120, true));
		goodsList.add(new Goods("Android视频", 100, false));
		goodsList.add(new Goods("IOS视频", 80, false));

		// 满百减二十
		Closure<Goods> substract = new Closure<Goods>() {

			@Override
			public void execute(Goods goods) {
				if (goods.getPrice() >= 100) {
					goods.setPrice(goods.getPrice() - 20);
				}
			}
		};

		// 打折
		Closure<Goods> discount = new Closure<Goods>() {

			@Override
			public void execute(Goods goods) {
				if (goods.isDiscount()) {
					goods.setPrice(goods.getPrice() * 0.9);
				}
			}
		};

		// 判断
		Predicate<Goods> pre = new Predicate<Goods>() {

			@Override
			public boolean evaluate(Goods good) {
				return good.isDiscount();
			}

		};

		// 二选一
		Closure<Goods> ifClo = IfClosure.ifClosure(pre, discount, substract);
		
		//关联
		CollectionUtils.forAllDo(goodsList, ifClo);
		
		//查看操作后的数据
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}
	
	/**
	 * 确保所有员工工资都大于 10000， 如果已经超过的不再上涨
	 */
	public static void whileClosure(){
		// 测试数据
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Kenson", 200));
		empList.add(new Employee("is", 1000));
		empList.add(new Employee("working", 20000));

		// 将所有员工的工资上涨 0.2

		// 使用闭包 业务功能
		Closure<Employee> cols = new Closure<Employee>() {

			@Override
			public void execute(Employee emp) {
				emp.setSalary(emp.getSalary() * 1.2);
			}
		};
		
		//加入Predicate 判断
		Predicate<Employee> empPre = new Predicate<Employee>(){

			@Override
			public boolean evaluate(Employee emp) {
				return emp.getSalary() < 10000;
			}
			
		};
		
		//false表示while结构 先判断后执行  ， 如果为true 表示do..while 先执行后判断
		Closure<Employee> whileClo = WhileClosure.whileClosure(empPre, cols, false);

		// 借助工具类
		CollectionUtils.forAllDo(empList, whileClo);

		// 操作后的数据， 使用迭代器遍历
		Iterator<Employee> it = empList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 折上减 先打折商品， 进行9折， 满百再减二十
	 */

	public static void chainClosure() {
		// 测试数据
		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList.add(new Goods("javase视频", 1200, true));
		goodsList.add(new Goods("Android视频", 1000, false));
		goodsList.add(new Goods("IOS视频", 80, false));

		// 满百减二十
		Closure<Goods> substract = new Closure<Goods>() {

			@Override
			public void execute(Goods goods) {
				if (goods.getPrice() >= 100) {
					goods.setPrice(goods.getPrice() - 20);
				}
			}
		};

		// 打折
		Closure<Goods> discount = new Closure<Goods>() {

			@Override
			public void execute(Goods goods) {
				if (goods.isDiscount()) {
					goods.setPrice(goods.getPrice() * 0.9);
				}
			}
		};

		// 二选一
		Closure<Goods> chainClo = ChainedClosure.chainedClosure(discount, substract);
		
		//关联
		CollectionUtils.forAllDo(goodsList, chainClo);
		
		//查看操作后的数据
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}

}
