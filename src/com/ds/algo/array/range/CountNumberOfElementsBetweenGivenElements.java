package com.ds.algo.array.range;

import java.util.Arrays;

public class CountNumberOfElementsBetweenGivenElements {

	private static int count(int elem1, int elem2, int arr[]) {
		Arrays.sort(arr);
		int upperIndex = upperBound(elem2, arr);
		int lowerIndex = lowerBound(elem1, arr);
		return upperIndex - lowerIndex + 1;
	}

	private static int lowerBound(int elem, int[] arr) {
		int l = 0;
		int h = arr.length - 1;

		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] >= elem) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return l;
	}

	private static int upperBound(int elem, int[] arr) {
		int l = 0;
		int h = arr.length - 1;

		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] <= elem) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		return h;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 4, 9, 10, 3 };
		System.out.println(count(1, 4, arr));
		System.out.println(count(9, 12, arr));
		System.out.println();
		
		arr = new int[]{3 ,5, 7, 6, 4, 9, 12, 4, 8};
		System.out.println(count(5, 4, arr));
		System.out.println();
		
		arr = new int[]{4, 6, 8, 3, 6, 2, 8, 9, 4};
		System.out.println(count(4, 4, arr));
		System.out.println(count(4, 10, arr));
		
	}

}
