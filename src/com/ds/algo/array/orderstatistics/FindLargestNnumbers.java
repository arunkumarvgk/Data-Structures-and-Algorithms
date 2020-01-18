package com.ds.algo.array.orderstatistics;

public class FindLargestNnumbers {

	private static void find(int arr[], int k) {
		int largest[] = new int[k];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < largest.length; j++) {
				if (arr[i] > largest[j]) {
					for (int l = largest.length-1; l > j; l--) {
						largest[l] = largest[l-1];
					}
					largest[j] = arr[i];
					break;
				}
			}
		}
		
		for (int i = 0; i < largest.length; i++) {
			System.out.print(largest[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {12, 10, 24, 19, 34, 1};
		find(arr, 6);
	}

}
