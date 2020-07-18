package com.ds.algo.leetcode;

public class KadenesCircularSubarray {

	private static void maxSub2(int A[]) {
		int n = A.length;

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int newMax = kadenes(A, i);
			if (max < newMax) {
				max = newMax;
			}
		}

		System.out.println("Max " + max);
	}

	private static int kadenes(int[] A, int i) {
		int l = i;
		int n = A.length;
		int max = A[i];
		int maxTillNow = A[i];

		i = (i + 1) % n;
		while (l != i) {
			
			int val = A[i];
			maxTillNow = maxTillNow + val;

			if (max < maxTillNow) {
				max = maxTillNow;
			}

			if (maxTillNow < 0) {
				maxTillNow = 0;
			}
			i = (i + 1) % n;
		} 
		return max;
	}

	private static int maxSub3(int A[]) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		int maxTillNow = 0;
		int minTillNow = 0;
		
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) {
			sum +=A[i];
			maxTillNow = maxTillNow + A[i];
			minTillNow = minTillNow + A[i];
			
			if (maxTillNow > max) {
				max = maxTillNow;
			}
			
			if (minTillNow < min) {
				min = minTillNow;
			}
			
			if (maxTillNow < 0) {
				maxTillNow = 0;
			}
			
			if (minTillNow > 0) {
				minTillNow = 0;
			}
		}
		
		System.out.println(sum == min ? max :Math.max(max, (sum - min)));
		return Math.max(max, (sum - min));
	}
	
	private static int maxSub(int A[]) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int maxTillNow = 0;
		
		for (int i = 0; i < A.length; i++) {
			int neg = A[i] * -1;

			sum = sum + neg;
			
			maxTillNow = maxTillNow + neg;
			
			if (max < maxTillNow) {
				max = maxTillNow;
			}
			
			if (maxTillNow < 0) {
				maxTillNow = 0;
			}
		}
		
		System.out.println(-( sum - max ));
		return ( sum - max )* -1;
	}

	public static void main(String[] args) {
		maxSub(new int[] { 1, -2, 3, -2 });
		maxSub(new int[] { 5, -3, 5 });
		maxSub(new int[] { 3, -1, 2, -1 });
		maxSub(new int[] { 3, -2, 2, -3 });
		maxSub(new int[] { -2, -3, -1 });
	}

}
