package com.ds.algo.array.optimization;

public class MinDistanceBetweenTwoNumbers {

	private static void find(int arr[], int k, int l) {
		int min = Integer.MAX_VALUE;
		int count = Integer.MAX_VALUE;
		int elem = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] == k || arr[i] == l) && arr[i]!= elem) {
				elem = arr[i];
				if (min > count) {
					min = count;
				}
				count = 0;
			}
			count++;
		}
		System.out.println("Min Distance :: " + min);
	}

	public static void main(String[] args) {
		find(new int[] { 2, 5, 3, 5, 4, 4, 2, 3 }, 3, 2);
		find(new int[] { 3, 4, 5 }, 3, 5);
		find(new int[] { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, 3, 6);
		find(new int[] { 0, 1, 2 }, 0, 2);
		find(new int[] {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3}, 3, 6);
	}
}
