package com.ds.recurssion;

public class Example1 {

	private static void print(int i) {
		int n =  i*i;
		if (i < 0) {
			return;
		}
		//System.out.print(i+" ");
		print(i-1);
		System.out.println(i+" - "+n +" ");
	}
	
	public static void main(String[] args) {
		print(5);
	}
}
