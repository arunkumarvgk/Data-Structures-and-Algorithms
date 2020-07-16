package com.ds.algo.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NearestCellWith1 {

	private static void find(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 1) {
					int count = 1;
					for (int j2 = j + 1; j2 < arr[i].length; j2++) {
						if (arr[i][j2] != 1) {
							count++;
						} else {
							break;
						}
					}
					arr[i][j] = count;
				} else {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void find2(int mat[][], int m, int n) {
		Queue<Integer> queue = new LinkedList<>();
		int dist[][] = new int[10][10];
		int newx[] = { -1, 0, 1, 0 };
		int newy[] = { 0, -1, 0, 1 };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = Integer.MAX_VALUE;

				if (mat[i][j] == 1) {
					// distance of '1' from itself is always 0
					dist[i][j] = 0;

					// make pair and push it in queue
					// queue.push(make_pair(i, j));
				}
			}
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } };
		int mat2[][] = findNearest1(mat);
		print(mat2);
	}

	private static void print(int[][] mat2) {
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2.length; j++) {
				System.out.print(mat2[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] findNearest1(int mat[][]) {
		int mat2[][] = new int[mat.length][mat[0].length];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					mat[i][j] = 0;
				} else {
					calc(mat, mat2, i, j);
				}
			}
		}
		return mat2;
	}

	private static int min(int a, int b) {
		return a > b ? a : b;
	}

	private static void calc(int[][] mat, int[][] mat2, int i, int j) {
		int r = mat.length;
		int c = mat[i].length;
		int val = Integer.MIN_VALUE;

		// Check left
		if (i < r && (j + 1) < c) {
			if (mat[i][j + 1] == 1) {
				mat2[i][j] = 1;
				return;
			}

			if (mat2[i][j + 1] != 0) {
				val = min(mat2[i][j + 1] + 1, val);
			}
		}

		if (i < r && j != 0 && (j - 1) < c) {
			if (mat[i][j - 1] == 1) {
				mat2[i][j] = 1;
				return;
			}

			if (mat2[i][j - 1] != 0) {
				val = min(mat2[i][j - 1] + 1, val);
			}
		}

		if ((i + 1) < r && j < c) {
			if (mat[i + 1][j] == 1) {
				mat2[i][j] = 1;
				return;
			}

			if (mat2[i + 1][j] != 0) {
				val = min(mat2[i + 1][j] + 1, val);
			}
		}

		if (i != 0 && (i - 1) < r && j < c) {
			if (mat[i - 1][j] == 1) {
				mat2[i][j] = 1;
				return;
			}

			if (mat2[i - 1][j] != 0) {
				val = min(mat2[i - 1][j] + 1, val);
			}
		}

		if (val != Integer.MIN_VALUE) {
			mat2[i][j] = val;
		}
	}

}
