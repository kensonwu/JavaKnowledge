package com.kenson.map.treemap;
/**
 * 员工实体类
 * @author wuchun
 *
 */

public class Worker implements Comparable<Worker> {
	//员工工种
	private String type;
	
	//工资
	private int salary;
	
	public Worker(){
		
	}

	public Worker(String type, int salary) {
		super();
		this.type = type;
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * 按工资升序
	 */
	@Override
	public int compareTo(Worker o) {
		return this.salary > o.salary ? 1: (this.salary == o.salary) ? 0 :-1 ;
	}
	
	@Override
	public String toString() {
		return "工种： " + this.type + "工资： " + this.salary + "\n";
	}
	
	
}
