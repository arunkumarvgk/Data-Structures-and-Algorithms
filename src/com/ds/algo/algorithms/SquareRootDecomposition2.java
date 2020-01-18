package com.ds.algo.algorithms;

import java.util.Arrays;

public class SquareRootDecomposition2 {

	int[] ARR;
	long[] SUM;
	int sqrt;

	public static void main(String args[]) {
		int[] arr =  { 5, -2, 6, 8, -4, 7, 10, -4, 12 };
		SquareRootDecomposition2 sqrtd = new SquareRootDecomposition2(arr);
		System.out.println(sqrtd);
		System.out.print("\nOperation 1: Sum of all elements in range (1, 7): ");
		System.out.println(sqrtd.rangeSum(7, 8));
		System.out.println("\nOperation 2: Insert number at location ARR[4]:");
		sqrtd.update(4, 6);
		System.out.println(sqrtd);
	}

	public SquareRootDecomposition2(int[] input) {
		this.sqrt = (int) Math.ceil(Math.sqrt(input.length));
		this.ARR = new int[sqrt * sqrt];
		this.SUM = new long[sqrt];
		System.arraycopy(input, 0, ARR, 0, input.length);
		for (int i = 0; i < ARR.length; i++)
			SUM[i / sqrt] += ARR[i];
	}

	void update(int loc, int newValue) {
		int oldValue = ARR[loc];
		ARR[loc] = newValue;
		int block = loc / sqrt;
		SUM[block] = SUM[block] - oldValue + newValue;
	}

	long rangeSum(int startIndex, int endIndex) {
		int result = 0;
		int startBlock = startIndex / sqrt;
		int endBlock = endIndex / sqrt;
		for (int i = startBlock + 1; i < endBlock; i++)
			result += SUM[i];
		for (int i = startIndex; i < (startBlock + 1) * sqrt; i++)
			result += ARR[i];
		for (int i = endBlock * sqrt; i <= endIndex; i++)
			result += ARR[i];
		return result;
	}

	public String toString() {
		String str = "\nDetails: \nSquare Root: " + sqrt + "\nArray: " + Arrays.toString(ARR) + "\nBlock Sum: "
				+ Arrays.toString(SUM);
		return str;
	}

}