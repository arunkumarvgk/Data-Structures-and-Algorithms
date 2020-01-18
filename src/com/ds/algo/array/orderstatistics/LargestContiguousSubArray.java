package com.ds.algo.array.orderstatistics;

public class LargestContiguousSubArray {

	private static void method1(int arr[]) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (max < sum) {
					max = sum;
				}
			}
		}

		System.out.println("Max is : " + max);
	}

	public static void main(String[] args) {
		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int arr2[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int arr3[] = {4, -1, 2, 1};
		method1(arr);
		method1(arr2);
		method1(arr3);
	}

}
