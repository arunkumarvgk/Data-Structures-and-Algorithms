package com.ds.algo.array.orderstatistics;

public class KthSmallestLargest {

	private static int partition(int arr[], int l, int h) {
		int i = l + 1;
		int piv = arr[l];

		for (int j = l + 1; j <= h; j++) {
			if (piv > arr[j]) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, l, i - 1);
		return i - 1;
	}

	private static int KthSmallest(int arr[], int l, int h, int k) {
		if (k > 0 && k <= h - l + 1) {
			
			//Partition algorithm gives you the index of sorted element
			// and if this index matches the given k then we just return arr[k]
			int pivPos = partition(arr, l, h);
			
			if (pivPos-l == k-1) {
				return arr[pivPos];
			}
			
			if(pivPos-l > k-1) {
				return KthSmallest(arr, l, pivPos-1, k);
			} else {
				return KthSmallest(arr, pivPos+1, h, k-pivPos+l-1);
			}
		}
		
		return -1;
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = {12, 3, 5, 7, 4, 19, 26}; 
		for (int k=1;k<= arr.length;k++) {
			System.out.println( k+" largest element is " + KthSmallest(arr, 0, arr.length - 1, k) );
		}
        
	}

}
