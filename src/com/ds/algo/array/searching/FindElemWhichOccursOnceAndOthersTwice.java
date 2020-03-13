package com.ds.algo.array.searching;

public class FindElemWhichOccursOnceAndOthersTwice {

	private static void find(int arr[]) {
		int n = arr.length;
		int val = 0;
		for (int i = 0; i < n; i++) {
			val = val ^ arr[i];
		}
		System.out.println(val);
	}
	
	public static void main(String[] args) {
		find(new int[] {7,3,5,3,4,5,4});
		find(new int[] {7,1,1,1,1});
	}

}
