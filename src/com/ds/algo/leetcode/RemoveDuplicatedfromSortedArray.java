package com.ds.algo.leetcode;

public class RemoveDuplicatedfromSortedArray {

	public static int removeDuplicates(int[] arr) {		
		int n = arr.length;
		int len = 1;
		if (n == 0) {
			return 0;
		}

		int i = 1;
		int l = 1;
		
		while (true) {

			if (l > n-1 || i == n) {
				break;
			}

			int j = i;
			int cur = arr[i];
			int prev = arr[i-1];
			
			if (cur != prev) {
				prev = cur;
				len++;
			} else {
				while (j < n - i) {
					arr[j] = arr[++j];
				}
				arr[j] = cur;
				i--;
			}
			i++;
			l++;
		}
		return len;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,2,3};//{ 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int len = removeDuplicates(arr);
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
