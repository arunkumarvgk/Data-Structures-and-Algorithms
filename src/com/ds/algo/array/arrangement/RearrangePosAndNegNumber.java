package com.ds.algo.array.arrangement;

public class RearrangePosAndNegNumber {

	private static void rearrange(int arr[]) {
		int n = arr.length;
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				k = i + 1;
				while (true) {
					if (k >= n) {
						break;
					}
					
					if (arr[k] > 0) {
						swap(arr, i, k);
						break;
					}
					k++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = {1, -1, 3, 2, -7, -5, 11, 6 };
		rearrange(arr);
	}

}
