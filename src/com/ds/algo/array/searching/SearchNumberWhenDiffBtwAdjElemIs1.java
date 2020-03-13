package com.ds.algo.array.searching;

public class SearchNumberWhenDiffBtwAdjElemIs1 {

	private static void search(int arr[], int k) {
		int i = 0;
		while (i < arr.length) {
			int temp = arr[i];
			if (temp == k) {
				System.out.println("Found at index :: " + i);
				break;
			}
			i += Math.abs(k - temp);
		}
	}

	private static void search(int arr[], int k, int l) {
		int i = 0;
		while (i < arr.length) {
			int temp = arr[i];
			if (temp == k) {
				System.out.println("Found at index :: " + i);
				break;
			}
			i += Math.max(1, Math.abs(k - temp)/l);
		}
	}

	public static void main(String[] args) {
		search(new int[] { 8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3 }, 2);
		search(new int[] { 20, 40, 50, 70, 70, 60 }, 60, 20);
		search(new int[] { 2, 4, 5, 7, 7, 6 }, 6, 2);
		//System.out.println(Math.ceil(0.5));

	}

}
