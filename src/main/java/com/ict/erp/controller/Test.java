package com.ict.erp.controller;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static <T> T getT(T t) {
		return t;
	}
	
	public static Object getT1(Object o) {
		return o;
	}
	
	public static <T extends String> T getT2(T t) { //T는 String 이라고 불리울 수 있는것만 넣을 수 있음
		return t;
	}
	
	public static void main(String[] args) {
		String str = getT(new String("abc"));
		Integer i = getT(new Integer(1));
		String str1 = (String) getT1(new String("abc"));
		Integer i1 = (Integer) getT1(new Integer(1));	//object는 좋지 않은 방법
		String str2 = getT2(new String("abc"));
		System.out.println(str+","+i);
		System.out.println(str1+","+i1);
		System.out.println(str2);
		
	}
}
