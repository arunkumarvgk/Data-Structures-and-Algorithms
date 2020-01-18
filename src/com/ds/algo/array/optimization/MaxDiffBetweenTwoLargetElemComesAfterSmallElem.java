package com.ds.algo.array.optimization;

public class MaxDiffBetweenTwoLargetElemComesAfterSmallElem {

	private static void find(int arr[]) {
		int min = arr[1] > arr[0] ? arr[0] : arr[1];
		int maxDiff = arr[1] - arr[0];
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i] - min) >= maxDiff) {
				maxDiff = arr[i] - min;
			} else {
				min = arr[i];
			}
		}
		
		System.out.println("MaxDiff :: "+maxDiff);
	}

	public static void main(String[] args) {
		find(new int[] {2, 3, 10, 6, 4, 8, 1});
		find(new int[] {7, 9, 5, 6, 3, 2});
	}

}
