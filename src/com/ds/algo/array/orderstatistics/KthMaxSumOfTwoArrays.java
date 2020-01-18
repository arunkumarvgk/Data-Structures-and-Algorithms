package com.ds.algo.array.orderstatistics;

import java.util.PriorityQueue;

public class KthMaxSumOfTwoArrays {

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
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
	
	private static void quickSort(int arr[], int l, int h) {
		if (l < h) {
			int pivPos = partition(arr, l, h);
			quickSort(arr, l, pivPos - 1);
			quickSort(arr, pivPos + 1, h);
		}
	}
	

	private static void maxSum(int arr[], int arr2[], int k) {
		quickSort(arr, 0, arr.length-1);
		quickSort(arr, 0, arr.length-1);
		
		PriorityQueue<Integer> heap = new PriorityQueue<>(k);
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				sum = arr[i] + arr2[j];
				
				if (heap.size() < k) {
					heap.add(sum);
				} else {
					if (heap.peek() < sum) {
						heap.poll();
						heap.add(sum);
					}
				}
			}
		}
		
		heap.forEach(aa -> {
			System.out.print(aa+" ");
		});
	}
	
	public static void main(String[] args) {
		int arr[] = {4, 2, 5, 1};
		int arr2[] = {8, 0, 3, 5};
		maxSum(arr, arr2, 3);
	}

}
