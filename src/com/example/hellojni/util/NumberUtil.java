package com.example.hellojni.util;

public class NumberUtil {

	static {
		System.loadLibrary("NumberUtil");
	}
	
	public native int add(int a, int b);
	
	public native int[] getNumbers(int count);
	
}
