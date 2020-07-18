package com.ds.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FrequencySort {

	static class Frequency {

		int count;
		char chr;

		public Frequency(int count, char chr) {
			this.count = count;
			this.chr = chr;
		}
	}

	public static void main(String[] args) {
		String s = "Aabb";
		List<Frequency> list = new ArrayList<>();

		int arr[] = new int[58];

		for (char c : s.toCharArray()) {
			arr[c - 'A']++;
		}

		for (int i = 0; i < 58; i++) {
			if (arr[i] > 0) {
				int val = i + 'A';

				list.add(new Frequency(arr[i], (char) val));
			}
		}

		Collections.sort(list, new Comparator<Frequency>() {
			public int compare(Frequency i1, Frequency i2) {
				return i2.count - i1.count;
			}
		});
		StringBuilder result = new StringBuilder();

		list.stream().forEach(val -> {
			for (int i = 0; i < val.count; i++) {
				result.append(val.chr);
			}
		});

		System.out.println(result.toString());

	}

}
