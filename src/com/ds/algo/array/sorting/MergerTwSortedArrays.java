package com.ds.algo.array.sorting;

public class MergerTwSortedArrays {

	private static void sort(int arr[], int arr2[]) {
		int i = 0;

		for (int j = 0; j < arr2.length; j++) {
			while (arr[i] != -1) {
				i++;
			}
			arr[i] = arr2[j];
		}

		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	private static void sort2(int arr[], int arr2[]) {
		int n = arr.length;
		int m = arr2.length;
		int i = n - 1;
		int j = n - 1;

		// move all the value in m+n arr to the end
		for (; i >= 0; i--) {
			if (arr[i] != -1) {
				arr[j] = arr[i];
				j--;
			}
		}

		/*
		 * After moving 
		 * --------[2, -1, 7, -1, 2, 7, 10]
		 * ---------k-------------i--------
		 * --------[5,8,12,14]
		 * ---------j
		 * compare arr[i] > arr2[j] then move arr[i] to arr[k] i++,k++ else 
		 *  move arr2[j] to arr[k] j++,k++
		 */
		i = m;
		j = 0;
		int k = 0;
		while (k < n) {
			if (i < n && arr[i] < arr2[j]) {
				arr[k] = arr[i];
				i++;
			} else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}

		for (j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 2, -1, 7, -1, -1, 10, -1 };
		int arr2[] = { 5, 8, 12, 14 };
		sort2(arr, arr2);

		arr = new int[] { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		arr2 = new int[] { 5, 7, 9, 25 };
		sort2(arr, arr2);
	}

}
