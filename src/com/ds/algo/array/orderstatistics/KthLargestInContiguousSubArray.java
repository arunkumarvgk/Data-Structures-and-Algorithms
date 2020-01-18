package com.ds.algo.array.orderstatistics;

import java.util.PriorityQueue;

public class KthLargestInContiguousSubArray {

	private static void find(int arr[], int k) {
		int n = arr.length;
		int arr2[] = new int[(n * (n + 1) / 2)];
		int l = 0;
		for (int i = 0; i < n; i++) {
			int prev = 0;
			for (int j = i; j < n; j++) {
				prev += arr[j];
				arr2[l++] = prev;
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			// System.out.print(arr2[i] + " ");
		}
		System.out.println();
		quickSort(arr2, 0, arr2.length - 1);

		for (int i = 0; i < arr2.length; i++) {
			// System.out.print(arr2[i] + " ");
		}
		System.out.println();
		System.out.println(arr2[k - 1]);
	}

	private static void quickSort(int arr[], int l, int h) {
		if (l < h) {
			int piv = partition(arr, l, h);
			quickSort(arr, l, piv - 1);
			quickSort(arr, piv + 1, h);
		}
	}

	private static int partition(int arr[], int l, int h) {
		int piv = arr[l];
		int i = l + 1;

		for (int j = l + 1; j <= h; j++) {
			if (arr[j] > piv) {
				swap(arr, i, j);
				i++;
			}
		}

		swap(arr, l, i - 1);
		return i - 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void solve(int arr[], int k) {
		int n = arr.length;
		PriorityQueue<Integer> heap = new PriorityQueue<>(k);
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];

				if (heap.size() < k) {
					heap.add(sum);
				} else {
					if (sum > heap.peek()) {
						heap.poll();
						heap.add(sum);
					}
				}
			}
		}
		System.out.println(heap.peek());
	}

	public static void main(String[] args) {
		int arr[] = { 10, -10, 20, -40 };
		for (int i =1;  i <= 10; i++ ) {
			find(arr, i);
			solve(arr, i);
		}
		

	}

}
