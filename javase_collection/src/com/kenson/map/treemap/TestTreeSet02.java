package com.kenson.map.treemap;

import java.util.TreeSet;

public class TestTreeSet02 {
	public static void main(String[] args) {
		Worker worker1 = new Worker("CEO", 10000);
		Worker worker2 = new Worker("CFO", 5000);
		Worker worker3 = new Worker("Manager", 100);
		
		//存入TreeSet中
		TreeSet<Worker> employees = new TreeSet<Worker>();
		employees.add(worker1);
		employees.add(worker2);
		employees.add(worker3);
		System.out.println(employees);
	}
}
