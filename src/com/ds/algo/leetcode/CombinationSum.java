package com.ds.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < candidates.length; i++) {
			List<Integer> nl = new ArrayList<>();
			for (int j = 1; candidates[i] * j <= target; j++) {
				int req = target - (candidates[i] * j);
				if (req == 0) {
					for (int k = 0; k < j; k++) {
						nl.add(candidates[i]);
					}
				} else {
					for (int l = 0; l < candidates.length; l++) {
						if (candidates[l] == req && i != l) {
							for (int m = 0; m < j; m++) {
								nl.add(candidates[i]);
							}
							nl.add(candidates[l]);
						}
					}
				}
				list.add(nl);
				nl = new ArrayList<>();
			}
		}
		return list;
	}

	private static void call() {
		// List<List<Integer>> list = combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		// list.stream().forEach(l -> {
		// System.out.println(", ");
		// l.stream().forEach(v -> System.out.print(v + " "));
		// });

		System.out.println("-------------");
		List<List<Integer>> list2 = combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		list2.stream().forEach(l -> {
			System.out.println(", ");
			l.stream().forEach(v -> System.out.print(v + " "));
		});
	}

	public static void main(String[] args) {
		// call();
		cs3(new int[] { 2, 3, 5 }, 8);
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0)
			return res;
		helper(res, new ArrayList<>(), candidates, 0, target, 0);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int sum, int target,
			int index) {
		if (sum == target) {
			res.add(new ArrayList(tmp));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] + sum <= target) {
				tmp.add(candidates[i]);
				helper(res, tmp, candidates, sum + candidates[i], target, i);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

	private static void cs3(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp;
		for (int i = 0; i < candidates.length; i++) {
			temp = new ArrayList<Integer>();
			temp.add(candidates[i]);
			int sum = candidates[i];
			for (int j = i; j < candidates.length;) {
				if (sum == target) {
					add(res, temp);
					sum = sum - temp.remove(temp.size() - 1);
					j++;
					continue;
				}

				if (sum + candidates[j] <= target) {
					sum += candidates[j];
					temp.add(candidates[j]);
					continue;
				}

				if (sum + candidates[j] > target) {
					sum = sum - temp.remove(temp.size() - 1);
				}
				
				if ( temp.size() !=0 ) {
					//sum = sum - temp.remove(temp.size() - 1);
					j = i + 1;
				} else {
					j++;
				}
			}
		}

		res.stream().forEach(l -> {
			System.out.println();
			l.stream().forEach(v -> System.out.print(v + " "));
		});
	}

	private static void add(List<List<Integer>> res, List<Integer> temp) {
		if (temp.size() > 0) {
			List<Integer> a = new ArrayList<>();
			temp.stream().forEach(aa -> a.add(aa));
			res.add(a);
		}
	}
}
