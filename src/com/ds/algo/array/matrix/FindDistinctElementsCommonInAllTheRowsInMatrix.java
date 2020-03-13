package com.ds.algo.array.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDistinctElementsCommonInAllTheRowsInMatrix {

	private static void find(int mat[][]) {
		Set<Integer> set = new HashSet<>();

		for (int j = 0; j < mat.length; j++) {
			set.add(mat[0][j]);
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (!set.contains(mat[i][j])) {
					set.remove(mat[i][j]);
				}
			}
		}

		set.stream().forEach(val -> System.out.println(val + " "));
	}

	private static void find2(int mat[][]) {
		int n = mat.length;
		Map<Integer, Integer> map = new HashMap<>();

		for (int j = 0; j < mat.length; j++) {
			map.put(mat[0][j], 1);
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (map.containsKey(mat[i][j])) {
					map.put(mat[i][j], map.get(mat[i][j]) + 1);
				}
			}
		}
		map.entrySet().stream()
					.filter(keyValue -> keyValue.getValue() >= n)
					.forEach(keyValue -> System.out.print(keyValue.getKey() + " "));
	}

	public static void main(String[] args) {
		int mat[][] = { { 2, 1, 4, 3 }, { 1, 2, 3, 2 }, { 3, 6, 2, 3 }, { 5, 2, 5, 3 } };
		find2(mat);

		int mat2[][] = { { 12, 1, 14, 3, 16 }, { 14, 2, 1, 3, 35 }, { 14, 1, 14, 3, 11 }, { 14, 25, 3, 2, 1 },
				{ 1, 18, 3, 21, 14 } };
		find2(mat2);
	}

}
