package com.ds.algo.array.arrangement;

public class ReverserArray {

	private static void reverse(int arr[]) {
		int start = 0;
		int end = arr.length-1;

		while (start < end) {
			int temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		reverse(new int[] {1,2,3,4,5,6,7,8,9,10});
		reverse(new int[] {1,2,3,4,9,10});
	}

}
