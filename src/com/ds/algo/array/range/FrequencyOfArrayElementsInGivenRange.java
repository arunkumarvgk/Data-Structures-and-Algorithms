package com.ds.algo.array.range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfArrayElementsInGivenRange {

	static Map<Integer, List<Integer>> map = new HashMap<>();

	private static void addToMap(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.get(arr[i]).add(i+1);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i+1);
				map.put(arr[i], list);
			}
		}
	}
	
	private static void findFrequency(int l, int r, int element) {
		List<Integer> list = map.get(element);
		int count = 0;
		for (Integer i : list) {
			if (i >= l && i <= r) {
				count++;
			}
		}
		System.out.println("Frequency of element "+element+" btw "+l+" and "+r+" is: "+count);
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 8, 6, 9, 8, 6, 8, 2, 11};
		addToMap(arr);
		findFrequency(1, 6, 2);
		findFrequency(4, 9, 8);
	}

}
