package com.bridgelab;

public class EmployeePayRoll {
	int id;
	String name;
	double salary;

	public EmployeePayRoll(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return "id = " + id + ", name = " + name + ",salary =" + salary;
	}
}
