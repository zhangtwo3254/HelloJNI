package com.example.hellojni.util;

public class StringUtil {

	static {
		System.loadLibrary("StringUtil");
	}

	private int length;
	private String s;
	
	public native void init();

	public native static String getString();

	public native static String getString(String s);

	public int getLength() {
		return s.length();
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
