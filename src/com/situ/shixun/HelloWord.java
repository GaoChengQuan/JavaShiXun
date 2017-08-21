package com.situ.shixun;

import java.util.Scanner;

import org.junit.Test;

public class HelloWord {
	public static void main(String[] args) {
		char ch1 = '中';
		char ch = 'a';
		System.out.println(ch); 
		System.out.println(ch + 1); 
		System.out.println((char)(ch + 1)); 
		
		System.out.println(8/3);
		System.out.println(8%3);
		
		System.out.println(8 % 4);
	}
	
	@Test
	public void test1() {
		int num1 = 3;
		int num2 = 5;
		
		System.out.println("before: " + num1);
		System.out.println("before: " + num2);
		
		int temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("after: " + num1);
		System.out.println("after: " + num2);
	}
	
	/**
	 * 1、能被4整除，但是不能被100整除 &&
		||
		2、能被400整除
	 */
	@Test
	public void isLeapYear() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = scanner.nextInt();
		if (((year % 4 == 0) && (year % 100 != 0)) 
				|| (year % 400 == 0)) {
			System.out.println("是闰年：");
		} else {
			System.out.println("不是闰年");
		}
	}
	
	@Test
	public void test2() {
		int[] array = new int[3];
		array[0] = 2;
		array[1] = 4;
		array[2] = 1;
		//System.out.println(array.length);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
	
}
