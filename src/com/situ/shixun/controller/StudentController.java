package com.situ.shixun.controller;

import java.util.List;

import com.situ.shixun.pojo.Student;
import com.situ.shixun.service.IStudentService;
import com.situ.shixun.service.impl.StudentServiceImpl;

public class StudentController {
	private IStudentService studentService = new StudentServiceImpl();

	public List<Student> findAll() {
		return studentService.findAll();
	}

	public boolean add(String name, int age, String gender, String address) {
		Student student = new Student(name, age, gender, address);
		return studentService.add(student);
	}

}
