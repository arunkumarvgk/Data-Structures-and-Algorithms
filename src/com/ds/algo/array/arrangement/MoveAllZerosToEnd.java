package com.ds.algo.array.arrangement;

public class MoveAllZerosToEnd {

	static void move3(int arr[]) {
		int n = arr.length;
		int r = 0;
		for (int k = 0; k < n; k++) {
			if (arr[k] != 0) {
				int c = arr[r];
				arr[r] = arr[k];
				arr[k] = c;
				r++;
			}
		}
		
		for (int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}

	static void move2(int arr[]) {
		int n = arr.length;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				arr[j++] = arr[i];
			}
		}

		for (int i = j + 1; i < n; i++) {
			arr[i] = 0;
		}

		for (int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}

	static void move(int arr[]) {
		int n = arr.length;
		int j = n - 1;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				while (arr[j] == 0) {
					j--;
				}
				if (j <= i) {
					break;
				}
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		for (int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		move3(new int[] { 1, 2, 0, 4, 3, 0, 5, 0 });
		move3(new int[] { 1, 2, 0, 0, 0, 3, 6 });
	}

}
