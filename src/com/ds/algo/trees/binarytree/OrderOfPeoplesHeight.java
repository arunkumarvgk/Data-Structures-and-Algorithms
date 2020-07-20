package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OrderOfPeoplesHeight {

	private void order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int index = 0;
		int max = 0;
		for (int i: infronts) {
			ArrayList<Integer> list = new ArrayList<>();
			if (map.containsKey(i)) {
				list = map.get(i);
			}
			list.add(heights.get(index));
			map.put(i, list);
			if (max < i) {
				max = i;
			}
		}
		
		for (Entry<Integer, ArrayList<Integer>>  m: map.entrySet()) {
			Collections.sort(m.getValue());
		}
		
		Arrays.asList(new int[] {1,2,3});
		ArrayList<Integer> list2 = new ArrayList<>();
		
		int l = 0;
		while (true) {
			if (map.containsKey(l)) {
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
