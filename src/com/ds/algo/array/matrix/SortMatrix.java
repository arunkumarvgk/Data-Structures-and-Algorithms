package com.ds.algo.array.matrix;

public class SortMatrix {

	private static int[] partition(int mat[][], int l[], int h[]) {
		int s[] = selectNext(l, mat);
		int i = s[1];
		int ir = l[0];
		int piv = mat[l[0]][l[1]];

		int jr = l[0];
		int j = s[1];

		int val = Integer.parseInt(jr+""+j);
		int val1 = Integer.parseInt(h[0]+""+h[1]);
		while (val <= val1) {
			
			if (i == mat[ir].length) {
				i = 0;
				ir++;
			}
			if (j == mat[jr].length) {
				j = 0;
				jr++;
			}

			if (piv < mat[jr][j]) {
				swap(mat, jr, j, ir, i);
				i++;
			}
			j++;
			val = Integer.parseInt(jr+""+j);
		}
		
		int [] irr = {ir,i};
		irr = selectPrevious(irr, mat);
		swap(mat, irr[0], irr[1], l[0], l[1]);
		print(mat);
		return irr;
	}

	

	private static void quickSort(int mat[][], int l[], int h[]) {
		if (check(l, h)) {
			int pivPos[] = partition(mat, l, h);
			quickSort(mat, l, selectPrevious(pivPos, mat));
			quickSort(mat, selectNext(pivPos, mat), h);
		}
	}

	private static boolean check(int[] l, int[] h) {
		int first = Integer.parseInt((l[0] + "" + l[1]));
		int second = Integer.parseInt((h[0] + "" + h[1]));
		return first < second;
	}

	private static void swap(int[][] mat, int jr, int j, int ir, int i) {
		int temp = mat[jr][j];
		mat[jr][j] = mat[ir][i];
		mat[ir][i] = temp;
	}

	private static int[] selectPrevious(int cur[], int mat[][]) {
		int temp[] = { cur[0], cur[1] };
		int n = mat.length;
		int m = mat[temp[0]].length;

		if (temp[1] == 0 && temp[0] !=0) {
			temp[1] = m - 1;
			temp[0] = temp[0]--;
		} else {
			temp[1]--;
		}
		return temp;
	}

	private static int[] selectNext(int[] l, int[][] mat) {
		int temp[] = { l[0], l[1] };
		int n = mat.length;
		int m = mat[temp[0]].length;
		if (temp[1] == m - 1 && temp[0]!= n-1) {
			temp[1] = 0;
			temp[0] = temp[0]++;
		} else {
			temp[1]++;
		}
		return temp;
	}

	private static void print(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=================================================");
		
	}
	
	public static void main(String[] args) {
		int mat[][] = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
		int n = mat.length;
		int m = mat[0].length;
		int l[] = { 0, 0 };
		int h[] = { n - 1, m - 1 };
		quickSort(mat, l, h);

		//print(mat);
	}

}
