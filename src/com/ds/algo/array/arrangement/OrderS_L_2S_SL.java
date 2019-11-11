package com.ds.algo.array.arrangement;

import java.util.Arrays;

public class OrderS_L_2S_SL {

	static void rearrange(int arr[]) {
		int i;
		int j;
		int n = arr.length;
		int temp[] = new int[n];
		int k = 0;
		Arrays.sort(arr); 
		for (i = 0, j = n - 1; j>=i; i++, j--) {
			
			temp[k++] = arr[i];
			if (k<n) {
				temp[k++] = arr[j];
			}
			
		}
		
		for (int r = 0; r < n; r++) {
			System.out.print(temp[r] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		rearrange(new int[] {5, 8, 1, 4, 2, 9, 3, 7, 6});
		rearrange(new int[] {1, 2, 3, 4});
		rearrange(new int[] {1, 4, 2, 3});
	}

}
