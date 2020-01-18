package com.ds.algo.array.orderstatistics;

import java.util.PriorityQueue;

public class KMaximumSubArraySums {

	private static void find(int arr[], int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
		int maxSumTillnow = arr[0];
		heap.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			maxSumTillnow = maxSumTillnow + arr[i];

			if (maxSumTillnow < 0 ) {
				maxSumTillnow = 0;
			}
			if (heap.size() < k) {
				heap.add(maxSumTillnow);
			} else {
				if (heap.peek() < maxSumTillnow) {
					heap.poll();
					heap.add(maxSumTillnow);
				}
			}
		}
		for (Integer i : heap) {
			System.out.print(i + " ");
		}
		//heap.stream().forEach(val -> System.out.print(val + " "));
		System.out.println();
	}

	public static void main(String[] args) {
		//find(new int[] { 4, -8, 9, -4, 1, -8, -1, 6 }, 4);
		find(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }, 3);
	}

}
