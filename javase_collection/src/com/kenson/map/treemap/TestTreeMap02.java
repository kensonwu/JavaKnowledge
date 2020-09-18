package com.kenson.map.treemap;

import java.util.TreeMap;

public class TestTreeMap02 {
	public static void main(String[] args) {
		Worker worker1 = new Worker("CEO", 10000);
		Worker worker2 = new Worker("CFO", 5000);
		Worker worker3 = new Worker("Manager", 100);
		
		//存入TreeMap中
		TreeMap<Worker,String> employees = new TreeMap<Worker, String>();
		employees.put(worker1, "Study");
		employees.put(worker2, "Study");
		employees.put(worker3, "Study");
		System.out.println(employees.keySet());
	}
}
