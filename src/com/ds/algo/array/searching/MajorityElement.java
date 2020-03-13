package com.ds.algo.array.searching;

public class MajorityElement {

	private static void find(int arr[]) {
		int majorityIndex = 0;
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[majorityIndex] == arr[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
		}

		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[majorityIndex] == arr[i]) {
				count++;
			}
		}

		if ((arr.length / 2) <= count) {
			System.out.println("Found :: " + arr[majorityIndex]);
		} else {
			System.out.println("Not found");
		}
	}

	public static void main(String[] args) {
		find(new int[] { 2, 2, 3, 5, 2, 2, 6 });
		find(new int[] { 2, 3, 7, 3, 4 });
		find(new int[] { 2, 3, 7, 3, 4, 3 });
		find(new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 });
		find(new int[] { 3, 2, 3, 2, 3, 6, 3, 4 });
	}

}
