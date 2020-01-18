package com.ds.algo.array.orderstatistics;

public class EquilibriumIndex {

	private static void equilibriumIndex(int arr[]) {
		int n = arr.length;
		int sum = 0;
		int leftSum = 0;
		boolean found = false;
		int  i =0;
		for (i = 0; i < n; i++) {
			sum+=arr[i];
		}
		
		for (i = 0; i < n; i++) {
			sum = sum - arr[i];
			
			if (leftSum == sum) {
				found = true;
				break;
			}
			
			leftSum = leftSum + arr[i];
		}
		
		if (found) {
			System.out.println("Index pos is: "+i);
		} else {
			System.out.println("Not found");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 }; 
		int arr2[] = {20, 50, 5, 10, 10, 10, 10, 10, 5, 5, 6, 4};
		int arr3[]= {1, 2, 1};
		
		equilibriumIndex(arr);
		equilibriumIndex(arr2);
		equilibriumIndex(arr3);
	}

}
