package com.ds.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ReconstructQueueu {
	public int[][] reconstructQueue2(int[][] people) {
		sortByHeight(people);
		int[][] result = new int[people.length][2];

		for (int i = 0; i < people.length; i++) {
			Arrays.fill(result[i], -1);
		}

		for (int i = 0; i < people.length; i++) {
			int h = people[i][0];
			int k = people[i][1];
			int v = 0;
			int t = k;
			while (t != 0) {
				if (result[v][0] == -1 || result[v][0] == h) {
					t--;
				}
				v++;
			}

			while (result[v][0] > -1) {
				v++;
			}

			result[v][0] = h;
			result[v][1] = k;
		}

		return result;
	}

	private void sortByHeight(int[][] people) {
		int n = people.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (people[i][0] < people[j][0]) {
					int h = people[i][0];
					int k = people[i][1];

					people[i][0] = people[j][0];
					people[i][1] = people[j][1];

					people[j][0] = h;
					people[j][1] = k;
				}
			}
		}
	}

	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		});

		ArrayList<int[]> res = new ArrayList<>();

		for (int[] person : people) {
			res.add(person[1], person);
		}

		return res.toArray(new int[people.length][2]);

	}

	public static void main(String[] args) {
		ReconstructQueueu rc = new ReconstructQueueu();
		int[][] val = new int[][] { { 7, 0 }, { 0, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		val = rc.reconstructQueue(val);

		for (int i = 0; i < val.length; i++) {
			System.out.println(val[i][0] + " " + val[i][1]);
		}
	}
}