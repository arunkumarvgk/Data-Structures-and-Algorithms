package com.ds.algo.array.arrangement;

public class EvenGreaterThanOdd {

	static void rearrange(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			if ((i + 1) % 2 == 0) {
				if (arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			} else {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}

		for (int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();

		boolean flag = false;
		for (int k = 0; k < n-1; k= k+2) {
			if (arr[k] > arr[k+1]) {
				flag = true;
			}
		}
		
		if (!flag) {
			System.out.println("Failed");
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		rearrange(new int[] { 1, 2, 2, 1 });
		rearrange(new int[] { 1, 3, 2 });
		rearrange(new int[] { 1, 3, 2, 2, 5 });
		rearrange(new int[] {87, 78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 91, 60, 64, 27, 41, 27, 73, 37, 12, 69, 68, 30, 83, 31, 63, 24, 68, 36, 30, 3, 23, 59, 70, 68, 94, 57, 12, 43, 30, 74, 22, 20, 85, 38, 99, 25, 16, 71, 14, 27, 92, 81, 57, 74, 63, 71, 97, 82, 6, 26, 85, 28, 37, 6, 47, 30, 14, 58, 25, 96, 83, 46, 15, 68, 35, 65, 44, 51, 88, 9, 77, 79, 89});
	}

}
