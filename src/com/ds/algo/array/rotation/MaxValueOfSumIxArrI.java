package com.ds.algo.array.rotation;

public class MaxValueOfSumIxArrI {

	public static void main(String[] args) {
		//int arr[] = {1, 20, 2, 10};
		int arr[] = { 8,3,1,2 };
		System.out.println(compute(arr));
	}

	private static int compute(int[] arr) {
		int arrSum = 0;
		int curVal = 0;
		int maxVal = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arrSum += arr[i];
			curVal += (i * arr[i]);
		}

		
		maxVal = curVal;

		// arrSum = 33(1 + 20 + 2 + 10) and curVal = 54 (1*0 + 20*1 + 2*2 + 10*3)
		// j=1 , curVal = 54 + 33 - (4 * 10) = 47
		// j=2 , curVal = 47 + 33 - (4 * 2) = 72
		// j=3 , curVal = 72 + 33 - (4 * 20) = 25
		
		// Algo - 
        // Instead of rotating the array, we can derive sum of rotated array from current sum.
        // As all elements will be shifted to left except for first element
        // We need to subtract (sum of all element - first element) from total
        // Now the first element shifted to last index, so we need to add (first element * last index) to total
        // This will give us sum of rotated array.
		
		
		
		//x1 = x0 + sum - (n * arr[n-j])
		
		for (int j = 1; j < n; j++) {
			//curVal = curVal + arrSum -(n * arr[n-j]);
			curVal = curVal - (arrSum - arr[j-1]);
			curVal = curVal + (arr[j-1] * (n-1));
			if (curVal > maxVal) {
				maxVal = curVal;
			}
		}
		return maxVal;
	}

}
