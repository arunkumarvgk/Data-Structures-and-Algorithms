package com.ds.algo.array.searching;

public class FindTheOnlyRepitativeElemInArr {

	private static void find(int arr[]) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		int expected = (n*(n-1))/2;
		System.out.println(sum-expected);
	}
	
	public static void main(String[] args) {
		find(new int[] {1,3,2,3,4});
	}

}
