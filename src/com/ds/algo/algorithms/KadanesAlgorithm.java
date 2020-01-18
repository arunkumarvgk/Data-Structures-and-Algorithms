package com.ds.algo.algorithms;

public class KadanesAlgorithm {

	private static void kadanes(int arr[]) {
		int maxTillNow = arr[0];
		int max = arr[0];
		
		int s = 0; 
		int e = 0;
		
		for (int i = 1; i < arr.length; i++) {
			maxTillNow = arr[i] + maxTillNow;
			
			if (maxTillNow > max) {
				max = maxTillNow;
				e = i;
			}
			
			if (maxTillNow < 0) {
				s = i+1;
				maxTillNow = 0;
			}
			
		}
		
		System.out.println("Max is : "+max+" From "+s+" to "+e);
	}
	
	private static void kadanesLargestNegative(int arr[]) {
		int maxTillNow = arr[0];
		int max = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			maxTillNow = arr[i] + maxTillNow;
			
			if (maxTillNow < max) {
				max = maxTillNow;
			}
			
			if (maxTillNow > 0) {
				maxTillNow = 0;
			}
			
		}
		
		System.out.println("Min is : "+max);
	}
	
	private static void kadanes2(int arr[]) {
		int maxTillNow = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			maxTillNow = arr[i] + maxTillNow;
			if (maxTillNow > max) {
				max = maxTillNow;
			}
			
			if (maxTillNow < 0) {
				maxTillNow = 0;
			}
		}
		
		System.out.println("Max is : "+max);
	}
	
	private static void kadanesLargestNegative2(int arr[]) {
		int maxTillNow = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			maxTillNow = arr[i] + maxTillNow;
			if (maxTillNow < max) {
				max = maxTillNow;
			}
			
			if (maxTillNow > 0) {
				maxTillNow = 0;
			}
		}
		
		System.out.println("Min is : "+max);
	}
	
	public static void main(String[] args) {
		int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int arr2[] = {-9, -3, -7, -6, -4, -5, -3, -6};
		int arr3[] = {1, 4, 2, 6};
		int arr4[] = { 1, 9, -1, -2, 7, 3, -1, 2 };
		
		System.out.println("Pos and neg both largest");
		kadanes(arr);
		kadanes(arr2);
		kadanes(arr3);
		kadanes(arr4);
		
		System.out.println();
		System.out.println("Pos largest");
		kadanes2(arr);
		kadanes2(arr2);
		kadanes2(arr3);
		
		System.out.println();
		System.out.println("Pos and neg both smallest in rev");
		kadanesLargestNegative(arr);
		kadanesLargestNegative(arr2);
		kadanesLargestNegative(arr3);
		
		System.out.println();
		System.out.println("Neg smallest in rev");
		kadanesLargestNegative2(arr);
		kadanesLargestNegative2(arr2);
		kadanesLargestNegative2(arr3);
	}

}
