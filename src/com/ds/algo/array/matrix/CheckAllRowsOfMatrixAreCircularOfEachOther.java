package com.ds.algo.array.matrix;

public class CheckAllRowsOfMatrixAreCircularOfEachOther {

	private static void find(int mat[][]) {
		int n = mat.length;
		boolean isCircular = true;
		for (int i = 1; i < n; i++) {
			int j = 0;
			while (j < n) {
				if (mat[i][0] == mat[0][j]) {
					break;
				}
				j++;
			}

			for (int k = 0; k < n; k++) {
				if (mat[i][k] == mat[0][j % n]) {
					j++;
				} else {
					isCircular = false;
					break;
				}
			}

			if (!isCircular) {
				break;
			}
		}

		System.out.println(" Circluar " + isCircular);
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 3, 1, 2 }, { 3, 2, 1 } };
		int mat2[][] = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };
		find(mat);
		find(mat2);
	}

}
