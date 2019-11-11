package com.ds.algo.array.rotation;

public class ArrayRotation {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int shiftBy = 2;
		int temp[] = new int[shiftBy];
		
		for (int i = 0; i < shiftBy; i++) {
			temp[i] = arr[i];
		}
		
		/*for (int i = 0; i < arr.length; i++) {
			if (i >= arr.length - shiftBy) {
				arr[i] = temp[shiftBy2++];
				continue;
			} 
			arr[i] = arr[i + shiftBy];
		}*/
		
		for (int i = 0; i < arr.length-shiftBy; i++) {
			arr[i] = arr[i + shiftBy];
		}
		
		for (int i = 0; i < temp.length; i++) {
			arr[arr.length-shiftBy+i] = temp[i];
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
