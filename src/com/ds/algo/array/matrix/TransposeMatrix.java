package com.ds.algo.array.matrix;

public class TransposeMatrix {

	private static void transposeSquare(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = i; j < mat[i].length; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		print(mat);
	}

	private static void transposeRectangle(int mat[][]) {
		int mat2[][] = new int[mat[0].length][mat.length];
		
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat2[i][j] = mat[j][i];
			}
		}
		print(mat2);
	}
	
	private static void print(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int mat2[][] = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };
		
		int mat3[][] = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 } };
		int mat4[][] = { { 1, 1, 1}, { 2, 2, 2 }, { 3, 3, 3}, { 4, 4, 4 } };
		transposeSquare(mat);
		transposeSquare(mat2);
		transposeRectangle(mat3);
		transposeRectangle(mat4);
	}

}
