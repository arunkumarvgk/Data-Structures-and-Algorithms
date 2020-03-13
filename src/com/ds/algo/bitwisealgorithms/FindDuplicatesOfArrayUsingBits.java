package com.ds.algo.bitwisealgorithms;

import sun.applet.Main;

public class FindDuplicatesOfArrayUsingBits {

	static int[] mainArr;

	// Constructor
	public FindDuplicatesOfArrayUsingBits(int n) 
    { 
        // Devide by 32. To store n bits, we need 
        // n/32 + 1 integers (Assuming int is stored 
        // using 32 bits) 
		mainArr = new int[(n>>5) + 1]; 
    }

	// Get value of a bit at given position
	boolean get(int pos) {
		// Divide by 32 to find position of
		// integer.
		int index = (pos >> 5);

		// Now find bit number in arr[index]
		int bitNo = (pos & 0x1F);

		// Find value of given bit number in
		// arr[index]
		return (mainArr[index] & (1 << bitNo)) != 0;
	}

	// Sets a bit at given position
	void set(int pos) {
		// Find index of bit position
		int index = (pos >> 5);

		// Set bit number in arr[index]
		int bitNo = (pos & 0x1F);
		mainArr[index] |= (1 << bitNo);
	}

	// Main function to print all Duplicates
	static void checkDuplicates(int[] arr) {
		// create a bit with 32000 bits
		FindDuplicatesOfArrayUsingBits ba = new FindDuplicatesOfArrayUsingBits(32000);

		// Traverse array elements
		for (int i = 0; i < arr.length; i++) {
			// Index in bit array
			int num = arr[i];

			// If num is already present in bit array
			if (ba.get(num))
				System.out.print(num + " ");

			// Else insert num
			else
				ba.set(num);
		}
		System.out.println(mainArr);
	}

	// Driver code
	public static void main(String[] args) throws java.lang.Exception {
		int[] arr = { 5, 5, 1, 1, 10, 12, 10, 9, 9, 0, 31, 32, 31, 32};
		checkDuplicates(arr);
	}
}
