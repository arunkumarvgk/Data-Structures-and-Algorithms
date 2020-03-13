package com.ds.algo.array.matrix;

public class SpiralMatrix {

	private static void printSpiral(int matrix[][], int row, int col) {
		int top = 0;
		int bottom =  matrix.length-1;
		int left = 0;
		int right = matrix[0].length - 1;

		int dir = 0;
		while (top <= bottom && left <= right) {
			if (dir == 0) {
				for (int i = left; i <= right; i++) {
					System.out.print(matrix[top][i] + " ");
				}
				top++;
			}

			if (dir == 1) {
				for (int i = top; i <= bottom; i++) {
					System.out.print(matrix[i][right] + " ");
				}
				right--;
			}

			if (dir == 2) {
				for (int i = right; i >= left; i--) {
					System.out.print(matrix[bottom][i] + " ");
				}
				bottom--;
			}

			if (dir == 3) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(matrix[i][left] + " ");
				}
				left++;
			}

			dir = (dir + 1) % 4;
		}
		System.out.println();
		System.out.println("------------------------------------------");
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int matrix2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int matrix3[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		//printSpiral(matrix, 3, 3);
		//printSpiral(matrix2, 4, 4);
		printSpiral(matrix3, 4, 3);
	}

}
