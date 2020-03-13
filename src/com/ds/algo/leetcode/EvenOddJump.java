package com.ds.algo.leetcode;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/odd-even-jump
public class EvenOddJump {
	
	private static void evenOddJump(int arr[]) {
		int n = arr.length;
		int goodToStartAtIndex = 1;
		boolean[] higher = new boolean[n];
		boolean[] lower = new boolean[n];

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(arr[n - 1], n - 1);
		higher[n - 1] = true;
		lower[n - 1] = true;

		for (int i = n - 2; i >= 0; i--) {
			Map.Entry<Integer, Integer> higherKV = treeMap.ceilingEntry(arr[i]);
			Map.Entry<Integer, Integer> lowerKV = treeMap.floorEntry(arr[i]);

			if (higherKV != null) {
				higher[i] = lower[higherKV.getValue()];
			}

			if (lowerKV != null) {
				lower[i] = higher[lowerKV.getValue()];
			}

			if (higher[i]) {
				goodToStartAtIndex++;
			}

			treeMap.put(arr[i], i);
		}

		System.out.println("Max start points " + goodToStartAtIndex);
	}

	public static void main(String[] args) {
		evenOddJump(new int[] { 10, 13, 12, 14, 15 });
	}

}
