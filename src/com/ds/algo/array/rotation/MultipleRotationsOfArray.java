package com.ds.algo.array.rotation;

public class MultipleRotationsOfArray {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9 };
		int rotations = 1;
		multipleRotations(arr, rotations, arr.length);
	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void multipleRotations(int[] arr, int rotations, int n) {
		for (int i = 0; i <= n/2; i++) {
			int j = (n - rotations + i) % n;
			swap(arr, j, i);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
