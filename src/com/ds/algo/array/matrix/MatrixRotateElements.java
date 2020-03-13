package com.ds.algo.array.matrix;

public class MatrixRotateElements {

	private static void rotateMatrix180(int[][] mat) {
		int n = mat.length;
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n; j++) {
				int temp =  mat[i][j];
				mat[i][j] = mat[n-i-1][n-j-1]; 
				mat[n-i-1][n-j-1] = temp;
			}
		}
		
		if(n%2 == 1) {
			int m = n/2;
			for (int i = 0; i < m; i++) {
				int temp = mat[m][i];
				mat[m][i] = mat[m][n-i-1];
				mat[m][n-i-1] = temp;
			}
		}
		
		print(mat);
	}

	private static void rotate(int matrix[][]) {
		int row = matrix.length;
		if (row == 0) {
			return;
		}
		int col = matrix[0].length;

		int top = 0;
		int bottom = row - 1;
		int left = 0;
		int right = col - 1;

		while (left <= right && top <= bottom) {
			int temp;
			if (left == right) {
				temp = matrix[bottom - 1][right];
			} else {
				temp = matrix[top][left];
			}

			for (int i = top; i < bottom; i++) {
				matrix[i][top] = matrix[i + 1][top];
			}

			for (int i = left; i < right; i++) {
				matrix[bottom][i] = matrix[bottom][i + 1];
			}

			for (int i = bottom; i > top; i--) {
				matrix[i][right] = matrix[i - 1][right];
			}

			for (int i = right; i > left; i--) {
				matrix[left][i] = matrix[left][i - 1];
			}

			if (left < right || top < bottom) {
				if (left == right) {
					matrix[bottom][right] = temp;
				} else {
					matrix[top][left + 1] = temp;
				}
			}

			top++;
			bottom--;
			left++;
			right--;
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
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int matrix2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int matrix3[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int matrix4[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int matrix5[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 },
				{ 21, 22, 23, 24 } };
//		rotate(matrix);
//		rotate(matrix2);
//		rotate(matrix3);
//		rotate(matrix4);
//		rotate(matrix5);
		
		rotateMatrix180(matrix);
		rotateMatrix180(matrix2);
	}

}
