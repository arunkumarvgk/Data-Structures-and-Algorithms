package com.ds.algo.array.matrix;

import java.util.ArrayList;

public class MaximumNumberOf1s {

	private static void find(int mat[][]) {
		int n = mat.length;
		int m = mat[0].length;
		int i = 0;
		int j = n - 1;
		int max = 0;
		while (j >= 0) {
			if (mat[i][j] == 1) {
				j--;
				max = i;
			} else {
				if (i == n - 1) {
					break;
				}
				i++;
			}
		}

		System.out.println("Max number of 1s is in row " + (max) + " and max is: " + (m - j - 1));
	}

	private static int find(ArrayList<ArrayList<Integer>> A) {
		int i = 0;
		int j = A.size() - 1;
		int max = 0;
		while (j >= 0) {
			if (A.get(i).get(j) == 1) {
				j--;
				max = i;
			} else {
				if (i == A.size()-1) {
					break;
				}
				i++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		find(new int[][] { { 0, 0, 1 }, { 0, 0, 1 }, { 0, 1, 1 } });
		find(new int[][] { { 0, 0, 0, 0 }, { 0, 1, 1, 1 } });
		find(new int[][] { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } });
		find(new int[][] { { 0, 0, 1, 1, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 1 } });
	}

}
