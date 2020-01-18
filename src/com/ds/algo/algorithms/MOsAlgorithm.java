package com.ds.algo.algorithms;

import java.util.Arrays;

public class MOsAlgorithm {

	static int blockSize;

	private static void mosAlgorithmSum(int arr[], Query queries[], int n, int q) {
		//Stream.of(queries).forEach(query -> System.out.println(query.l + ", " + query.r));
		
		int currL = 0;
		int currR = 0;
		
		int sum = 0;
		
		for (int i = 0; i < q; i++) {
			int l = queries[i].l;
			int r = queries[i].r;
			
			while (currL < l) {
				sum = sum - arr[currL];
				currL++;
			}
			
			while (currR <= r) {
				sum = sum + arr[currR];
				currR++;
			}
			
			while (currL > l) {
				sum = sum + arr[currL-1];
				currL--;
			}
			
			while (currR > r+1) {
				sum = sum - arr[currR-1];
				currR--;
			}
			
			System.out.println("Sum of no between index "+l+ " - "+r+" is "+sum);
		}
	}

	private static void mosAlgorithmUniqueDigits(int arr[], Query queries[], int n, int q) {
		
		//Stream.of(queries).forEach(query -> System.out.println(query.l + ", " + query.r));
		
		int currL = 0;
		int currR = -1;
		
		int freq[] = new int[10];
		int count = 0;
		for (int i = 0; i < q; i++) {
			int l = queries[i].l;
			int r = queries[i].r;
			
			while (currR < r) {
				currR++;
				freq[arr[currR]]++;
				if (freq[arr[currR]] == 1) {
					count++;
				}
			}
			
			while (currR > r) {
				freq[arr[currR]]--;
				if (freq[arr[currR]] == 0) {
					count--;
				}
				currR--;
			}
			
			while (currL < l) {
				freq[arr[currL]]--;
				if (freq[arr[currL]] == 0) {
					count--;
				}
				currL++;
			}
			
			while (currL > l) {
				freq[arr[currL]]++;
				if (freq[arr[currL]] == 1) {
					count++;
				}
				currL--;
			}
			
			System.out.print("Unique digits between "+l+ " - "+r+" is "+ count);
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 2, 3, 4, 1, 3, 5, 1, 5, 3, 5, 4, 0, 2, 2 };
		int n = arr.length;
		Query queries[] = { 
				new Query(0, 8), new Query(2, 5), new Query(2, 11), new Query(16, 17), new Query(13, 14), new Query(1, 17), new Query(17, 17) 
		};
		int q = queries.length;
		blockSize = (int) Math.sqrt(n);
		Arrays.sort(queries);
		mosAlgorithmSum(arr, queries, n, q);
		mosAlgorithmUniqueDigits(arr, queries, n, q);
	}

	static class Query implements Comparable<Query> {
		int l;
		int r;

		Query(int l, int r) {
			this.l = l;
			this.r = r;
		}

		@Override
		public int compareTo(Query query) {
			if (this.l / blockSize != query.l / blockSize) {
				return this.l / blockSize - query.l / blockSize;
			}
			return this.r - query.r;
		}
	}
}
