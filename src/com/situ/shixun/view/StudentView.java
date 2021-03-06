package com.situ.shixun.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.situ.shixun.controller.StudentController;
import com.situ.shixun.pojo.Student;

public class StudentView {
	private StudentController studentController = new StudentController();

	public void showView() {
		while (true) {
			System.out.println("-------学生信息管理系统----------");
			System.out.println("【1】查询所有  【2】添加  【3】按条件查找  【4】修改 【5】删除  【0】退出");
			System.out.println("请选择");
			Scanner scanner = new Scanner(System.in);
			int selected = scanner.nextInt();
			if (selected == 0) {
				break;
			}

			switch (selected) {
			case 1:// 【1】查询所有
				findAll();
				break;
			case 2:// 【2】添加
				add();
				break;
			case 3:// 【3】按条件查找
				System.out.println("【1】根据名字查找  【2】根据年龄查找  【3】根据班级查找 ");
				int choose = scanner.nextInt();
				switch (choose) {
				case 1:// 【1】根据名字查找
					System.out.println("请输入要搜索的名字:");
					String nameSearch = scanner.next();
					boolean isSearchByNameFound = false;
					/*for (Student stu : list) {
						// 如果有叫这个名字的学生就打印学生信息
						if (stu.getName().equals(nameSearch)) {
							System.out.println(stu);
							isSearchByNameFound = true;
						}
					}*/
					if (isSearchByNameFound == false) {
						System.out.println("没有该姓名的学生.");
					}
					break;
				case 2:// 【2】根据年龄查找
					System.out.println("请输入要搜索的年龄:");
					int ageSearch = scanner.nextInt();
					boolean isSearchByAgeFound = false;
					/*for (Student stu : list) {
						// 如果有叫这个年龄的学生就打印学生信息
						if (stu.getAge() == ageSearch) {
							System.out.println(stu);
							isSearchByNameFound = true;
						}
					}*/
					if (isSearchByAgeFound == false) {
						System.out.println("没有该年龄的学生.");
					}
					break;
				case 3:// 【3】根据性别查找
					System.out.println("请输入要搜索的班级:");
					String genderSearch = scanner.next();
					boolean isSearchByGenderFound = false;
					/*for (Student stu : list) {
						// 如果有叫这个名字的学生就打印学生信息
						if (stu.getGender().equals(genderSearch)) {
							System.out.println(stu);
							isSearchByNameFound = true;
						}
					}*/
					if (isSearchByGenderFound == false) {
						System.out.println("没有该班级的学生.");
					}
					break;
				default:
					break;
				}
				break;
			case 4:// 【4】修改
				System.out.println("4");
				break;
			case 5:// 【5】删除
				System.out.println("4");
				break;

			default:
				break;
			}
		}
	}

	private void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("添加学生");
		System.out.println("请输入姓名:");
		String name = scanner.next();
		System.out.println("请输入年龄:");
		int age = scanner.nextInt();
		System.out.println("请输入性别：");
		String gender = scanner.next();
		System.out.println("请输入地址：");
		String address = scanner.next();
		boolean result = studentController.add(name, age, gender, address);
		if (result) {
			System.out.println("-----添加成功----");
		} else {
			System.out.println("-----添加失败----");
		}
	}

	private void findAll() {
		List<Student> list = studentController.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

	private static void addStudent(ArrayList<Student> list, Scanner scanner) {
		System.out.println("请输入姓名");
		String name = scanner.next();
		System.out.println("请输入年龄");
		int age = scanner.nextInt();

		// list.add(student);
	}

	/**
	 * 打印所有学生的信息
	 * 
	 * @param list
	 */
	private static void printStudentList(ArrayList<Student> list) {
		for (int i = 0; i < list.size(); i++) {
			Student student = list.get(i);
			System.out.println(student);
		}
	}

}
