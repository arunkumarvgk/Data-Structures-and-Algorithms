package com.ds.dynamicprogrammming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

	private static void lis(int arr[]) {
		int n = arr.length;

		int length[] = new int[n];
		int sequence[] = new int[n];

		Arrays.fill(sequence, -1);
		Arrays.fill(length, 1);

		int indexOfLastvalueInSS = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && (length[j] + 1) > length[i]) {
					length[i] = length[j] + 1;
					sequence[i] = j;
					if (length[i] > length[indexOfLastvalueInSS]) {
						indexOfLastvalueInSS = i;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(length[i] + " " + sequence[i]);
		}

		System.out.println("Length :: " + length[indexOfLastvalueInSS] + " Last index :: " + indexOfLastvalueInSS);

		while (indexOfLastvalueInSS != -1) {
			System.out.print(arr[indexOfLastvalueInSS] + " ");
			indexOfLastvalueInSS = sequence[indexOfLastvalueInSS];
		}
	}

	private static void lis2(int arr[]) {
		int n = arr.length;

		int indices[] = new int[n + 1];
		int sequence[] = new int[n];

		Arrays.fill(indices, -1);
		Arrays.fill(sequence, -1);

		int length = 0;
		for (int i = 0; i < n; i++) {
			// new index either to add/ replace the value
			int newLength = binarySearch(1, length, indices, arr, arr[i]);
			sequence[i] = indices[newLength - 1];
			indices[newLength] = i;
			length = Math.max(length, newLength);
		}

		int indexOfLastvalueInSS = indices[length];
		while (indexOfLastvalueInSS != -1) {
			System.out.print(arr[indexOfLastvalueInSS] + " ");
			indexOfLastvalueInSS = sequence[indexOfLastvalueInSS];
		}
		System.out.println();
	}

	private static int binarySearch(int s, int e, int[] indices, int[] arr, int val) {
		if (s > e) {
			return s;
		}
		int m = (s + e) / 2;

		if (arr[indices[m]] < val) {
			s = m + 1;
		} else {
			e = m - 1;
		}
		return binarySearch(s, e, indices, arr, val);
	}

	public static void longestIncreasingSubsequence(int[] arr) {
		int n = arr.length;

		int indices[] = new int[n + 1];
		int sequence[] = new int[n];

		
		Arrays.fill(indices, -1);
		Arrays.fill(sequence, -1);

		int length = 0;
		for (int i = 0; i < n; i++) {
			// new index either to add/ replace the value
			int newLength = binarySearch(1, length, indices, arr, arr[i]);
			sequence[i] = indices[newLength - 1];
			indices[newLength] = i;
			length = Math.max(length, newLength);
		}

		int indexOfLastvalueInSS = indices[length];
		int index = length;
		Integer resSeq[] = new Integer[index];
		while (indexOfLastvalueInSS != -1) {
			resSeq[--index] = arr[indexOfLastvalueInSS];
			indexOfLastvalueInSS = sequence[indexOfLastvalueInSS];
		}
		Arrays.asList(resSeq).stream().forEach(v -> System.out.print(v+" "));
		System.out.println();
	}

	/*private static void maximumSumIncreasingSubSequence(int arr[]) {
		List<Integer> list = longestIncreasingSubsequence(arr);
		System.out.println("sum "+list.stream().reduce((p, c) -> p+c).get());
	}*/
	public static void main(String[] args) {
		lis2(new int[] { 5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35 });
		longestIncreasingSubsequence(new int[] { 5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35 });
		
		lis2(new int[] {1, 101, 2, 3, 100, 4, 5});
		
		//maximumSumIncreasingSubSequence(new int[] { 5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35 });
		//maximumSumIncreasingSubSequence(new int[] {1, 101, 2, 3, 100, 4, 5});
	}

}
