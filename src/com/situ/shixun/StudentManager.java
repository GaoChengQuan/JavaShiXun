package com.situ.shixun;

import java.util.Scanner;

public class StudentManager {
	public static void main(String[] args) {
		while (true) {
			System.out.println("-----学生管理系统----");
			System.out.println("所有学生信息：1");
			System.out.println("添加学生信息：2");
			System.out.println("查询学生信息：3");
			System.out.println("删除学习信息：4");
			System.out.println("退出：0");
			Scanner scanner = new Scanner(System.in);
			int selected = scanner.nextInt();
			if (selected == 0) {
				break;
			}
			
			switch (selected) {
			case 1://所有学生信息
				System.out.println("1");
				break;
			case 2://添加学生信息
				System.out.println("请输入姓名");
				break;
			case 3:
				System.out.println("3");
				break;
			case 4:
				System.out.println("4");
				break;

			default:
				break;
			}
		}
		
		
		
	}
}
