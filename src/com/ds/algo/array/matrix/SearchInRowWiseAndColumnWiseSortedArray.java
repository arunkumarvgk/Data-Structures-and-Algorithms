package com.ds.algo.array.matrix;

public class SearchInRowWiseAndColumnWiseSortedArray {

	private static void search(int mat[][], int elem) {
		int n = mat.length - 1;
		int m = mat[0].length - 1;
		int i = 0;
		int j = m;
		boolean found = false;
		while (j > 0 && i < n) {
			if (mat[i][j] == elem) {
				found = true;
				System.out.println("Found at [" + i + "][" + j+"]");
				break;
			} else if (mat[i][j] > elem) {
				j--;
			} else {
				i++;
			}
		}

		if (!found) {
			System.out.println("Not found");
		}
	}

	public static void main(String[] args) {
		search(new int[][] { { 10, 20, 30, 40 }, { 12, 22, 33, 45 }, { 14, 24, 44, 47 }, { 16, 26, 46, 50 } }, 24);
	}

}
