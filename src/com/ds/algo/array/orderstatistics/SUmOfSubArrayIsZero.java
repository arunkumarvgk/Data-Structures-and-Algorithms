package com.ds.algo.array.orderstatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SUmOfSubArrayIsZero {

	private static void find(int arr[]) {
		Set<Integer> set = new HashSet<>();
		set.add(arr[0]);
		int sum = arr[0];
		boolean found = false;
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			if (set.contains(sum)) {
				found = true;
			} else {
				set.add(sum);
			}
		}

		if (found) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
	}

	private static void printAllSubArrays(int arr[]) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		int sum = arr[0];
		hashMap.put(sum, 0);
		
		for (int i = 1; i < arr.length; i++) {
			sum+=arr[i];
			
			if (hashMap.containsKey(sum)) {
				for( int j = hashMap.get(sum)+1; j <= i ; j++) {
					System.out.print(arr[j]+" ");
				}
				System.out.println("");
			}
			
			if (sum == 0) {
				for( int j = 0; j <= i ; j++) {
					System.out.print(arr[j]+" ");
				}
				System.out.println("");
			}
			
			hashMap.put(sum, i);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 4, 2, -3, 1, 6 };
		int[] arr2 = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
		find(arr);
		printAllSubArrays(arr);
		find(arr2);
		printAllSubArrays(arr2);
	}

}
