package com.situ.shixun;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student("张三", 20, "1707");
		System.out.println(student);
		student.study();
	}
}
