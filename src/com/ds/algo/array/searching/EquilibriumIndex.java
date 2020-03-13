package com.ds.algo.array.searching;

public class EquilibriumIndex {

	private static void find(int arr[]) {
		int n = arr.length;
		int ps = 0;
		int s = 0;

		for (int i = 0; i < n; i++) {
			s+=arr[i];
		}

		for (int i = 0; i < n; i++) {
			ps+=arr[i];
			
			if (s == ps) {
				System.out.println("Index is "+ i);
				break;
			}
			s-=arr[i];
		}
	}

	public static void main(String[] args) {
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };  
		find(arr);
	}

}
