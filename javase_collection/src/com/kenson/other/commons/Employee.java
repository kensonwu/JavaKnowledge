package com.kenson.other.commons;

public class Employee {
	
	private String name;
	private double salary;
	
	public Employee() {
		
	}
	
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "(码农： " + this.name + ", 敲砖钱:" + this.salary +")";
	}
	

}
