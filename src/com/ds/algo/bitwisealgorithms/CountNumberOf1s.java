package com.ds.algo.bitwisealgorithms;

public class CountNumberOf1s {

	public static void main(String[] args) {
		int num = 14;
		int count = 0;
		while (num != 0) {
			count += num & 1;
			num = num >> 1;
		}
		System.out.println(count);
	}

}
