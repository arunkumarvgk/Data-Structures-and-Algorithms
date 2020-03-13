package com.ds.algo.array.matrix;

public class MatrixMultiplication {

	private static void multiply(int a[][], int b[][]) {
		if (b.length == 0 || a.length == 0) {
			return;
		}
		int aRow = a.length;
		int aCol = a[0].length;
		int bRow = b.length;
		int bCol = b[0].length;

		if (aCol != bRow) {
			return;
		}
		int res[][] = new int[aRow][bCol];

		for (int i = 0; i < aRow; i++) {
			for (int j = 0; j < bCol; j++) {
				for (int k = 0; k < aCol; k++) {
					res[i][j] = a[i][k] * b[k][j] + res[i][j];
				}
			}
		}
		print(res);
	}

	private static void print(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("=================================");
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		multiply(a, b);

		int c[][] = { { 3, 4, 2 } };
		int d[][] = { { 13, 9, 7, 15 }, { 8, 7, 4, 6 }, { 6, 4, 0, 3 } };
		
		multiply(c, d);
	}

}
