package com.ds.algo.algorithms;

public class SquareRootDecomposition {

	static int blocks[];
	static int blockSize;
	static int noOfBlocks;

	private static int query0(int l, int r, int arr[]) {
		int sum = 0;

		while (l < r && l % blockSize != 0 && l != 0) {
			sum += arr[l];
			l++;
		}

		while (l + blockSize <= r) {
			System.out.println("--");
			sum += blocks[l / blockSize];
			l += blockSize;
		}

		while (l <= r) {
			sum += arr[l];
			l++;
		}

		return sum;
	}

	private static int query1(int l, int r, int arr[]) {
		int sum = 0;
		int i = l;
		int n = arr.length;
		while ((i + 1) % blockSize != 0 && i <= r) {
			sum = sum + arr[i];
			i++;
		}

		while ((i + blockSize) <= r) {
			int j = i / blockSize;
			sum = sum + blocks[j];
			i = i + blockSize;
		}

		while (i <= r) {
			sum = sum + arr[i];
			i++;
		}

		return sum;
	}

	private static int query(int l, int r, int arr[]) {
		int sum = 0;
		int startBlock = l / blockSize; // block of left index
		int endBlock = r / blockSize; // block of right index

		if (l > r) {
			return -1;
		}

		if (l == r) {
			return arr[l];
		}

		// If range is in same block
		if (startBlock == endBlock) {

			// If range is exactly one block i.e, if n is 9 then range 3 - 5 belongs to 1st
			// block completely
			// no need of for loop
			if (l % blockSize == 0 && (r + 1) % blockSize == 0) {
				return blocks[startBlock];
			}

			// If range is part of one block ie,, if 3-5 is a block then
			// this loop runs if range is 3-4
			for (int i = l; i <= r; i++) {
				sum = sum + arr[i];
			}
			return sum;
		}

		int start = (l % blockSize == 0) ? startBlock : startBlock + 1;
		int end = ((r + 1) % blockSize == 0) ? endBlock + 1 : endBlock;

		// For eg if there are 5 blocks 1,2,3,4,5
		// and startBlock is 1 and endBlock is 5
		// then we can simply take the sum of blocks 2+3+4
		// here we loop i from 2 to 5
		for (int i = start; i < end; i++) {
			sum = sum + blocks[i];
		}

		for (int i = l; i < start * blockSize; i++) {
			sum = sum + arr[i];
		}

		if (end == endBlock) {
			for (int i = endBlock * blockSize; i <= r; i++) {
				sum = sum + arr[i];
			}
		}

		return sum;
	}

	private static void buildBlocks(int arr[], int n) {
		int j = -1;
		for (int i = 0; i < n; i++) {
			if (i % blockSize == 0) {
				j++;
			}
			blocks[j] += arr[i];
		}

		for (int i = 0; i < blocks.length; i++) {
			System.out.print(blocks[i] + " ");
		}
		System.out.println();
	}

	private static void update(int index, int value, int arr[]) {
		int blockIndex = index / blockSize;
		blocks[blockIndex] -= arr[index];
		blocks[blockIndex] += value;
		arr[index] = value;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 4, 6, 1, 3, 5, 7, 10, 12, 1, 3, 5, 6, 8 };
		int n = arr.length;
		noOfBlocks = (int) Math.ceil(Math.sqrt(n));
		blocks = new int[noOfBlocks];
		blockSize = (int) Math.ceil((double) n / noOfBlocks);
		buildBlocks(arr, n);

		System.out.println(query(2, 8, arr));
		System.out.println(query(0, 6, arr));
		System.out.println(query(0, 7, arr));
		System.out.println(query(3, 5, arr));
		System.out.println(query(1, 6, arr));
		System.out.println(query(8, 8, arr));
		System.out.println(query(7, 8, arr));
		
		update(2, 12, arr);
		System.out.println("_________________________");
		System.out.println(query(2, 8, arr));
		System.out.println(query(0, 6, arr));
		System.out.println(query(0, 7, arr));
		System.out.println(query(3, 5, arr));
		System.out.println(query(1, 6, arr));
		System.out.println(query(8, 8, arr));
		System.out.println(query(7, 8, arr));

	}

}
