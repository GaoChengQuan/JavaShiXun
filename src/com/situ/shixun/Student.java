package com.situ.shixun;

public class Student {
	private String name;
	private int age;
	private String className;
	
	public Student() {
	}
	
	public Student(String name, int age, String className) {
		super();
		this.name = name;
		this.age = age;
		this.className = className;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public void study() {
		System.out.println(name + "正在" + className + "学习");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", className=" + className + "]";
	}
	
}