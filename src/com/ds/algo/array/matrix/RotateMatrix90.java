package com.ds.algo.array.matrix;

public class RotateMatrix90 {

	private static void rotate(int matrix[][], int n) {
		print(matrix);
		for (int i = 0; i < n / 2; i++) {
			int first = i;
			int last = n - i - 1;

			for (int j = first; j < last; j++) {
				int offset = j - first;

				// Save top
				int top = matrix[first][j];

				// top left = bottom left
				matrix[first][j] = matrix[last - offset][first];

				// bottom left = bottom right
				matrix[last - offset][first] = matrix[last][last - offset];

				// bottom right - top right
				matrix[last][last - offset] = matrix[j][last];

				// top right = top left
				matrix[j][last] = top;
			}
		}

		print(matrix);

	}

	private static void print(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int matrix2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate(matrix, 3);
		rotate(matrix2, 4);
	}
}
