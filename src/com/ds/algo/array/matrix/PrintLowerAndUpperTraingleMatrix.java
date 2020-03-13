package com.ds.algo.array.matrix;

public class PrintLowerAndUpperTraingleMatrix {

	private static void upperBound(int mat[][]) {
		int n = mat.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j >= i) {
					System.out.print(mat[i][j] + " ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

	private static void lowerBound(int mat[][]) {
		int n = mat.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j <= i) {
					System.out.print(mat[i][j] + " ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		upperBound(mat);
		System.out.println("========================================");
		lowerBound(mat);
	}

}
