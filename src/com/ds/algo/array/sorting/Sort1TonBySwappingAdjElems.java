package com.ds.algo.array.sorting;

public class Sort1TonBySwappingAdjElems {

	private static void sort(int a[], int b[]) {
		boolean sorted = true;
		for (int i = 0; i < b.length;) {
			
			if (b[i] == 1 && (a[i] > a[i + 1])) {
				swap(a, i, i + 1);
			}
			
			i++;
		}

		for (int i = 0; i < a.length-1; i++) {
			if (a[i] > a[i+1]) {
				sorted = false;
				break;
			}
		}
		
		for (int i = 0; i < a.length-1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(sorted? "Yes": "No");
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		sort(new int[] { 1, 2, 5, 3, 4, 6 }, new int[] { 0, 1, 1, 1, 0 });
		sort(new int[] { 2, 3, 1, 4, 5, 6 }, new int[] { 0, 1, 1, 1, 1 });
	}
}
