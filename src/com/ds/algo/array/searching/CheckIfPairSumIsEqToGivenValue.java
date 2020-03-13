package com.ds.algo.array.searching;

import java.util.HashSet;
import java.util.Set;

public class CheckIfPairSumIsEqToGivenValue {

	private static void check(int arr[], int sum) {
		Set<Integer> hashSet = new HashSet<>();
		
		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];
			if (hashSet.contains(temp)) {
				System.out.println("Pair is "+ arr[i]+" and "+ temp);
				break;
			}
			
			hashSet.add(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		check(new int[] { 1, 4, 45, 6, 10, 8 }, 16);

	}

}
