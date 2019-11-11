package com.ds.algo.array.rotation;

public class PairWithSumInsortedAndRotatedArray {

	public static void main(String[] args) {
		int arr[] = { 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5 };
		//int arr[] = { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int sum = 11;
		System.out.println(compute(arr, arr.length, sum));
	}

	private static int compute(int[] arr, int n, int sum) {
		int i;
		for (i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				break;
			}
		}

		int l = (i + 1) % n; // index of smallest number
								// could have been just i+1 but if array is not rotated
								// then 'l' should be 0 so if n = 12 then 'i' will be incremented in loop till
								// 11 if
								// not rotated (11+1) % 12 is equal to 0

		int r = i; // index of largest number

		System.out.println(r+" "+l);
		int count = 0;
		while (l != r) {
			if (arr[l] + arr[r] == sum) {
				System.out.println("Pair index " + l + ", " + r + " sum: " + arr[l] + ", " + arr[r]);
				count++;

				// Check if l crosses r
				if (l == (r - 1 + n) % n) {
					return count;
				}

				// move l forward suppose if n=7 and r=6
				// (6+1)%7 = 7%7 = 0.. takes to first element
				l = (l + 1) % n;
				// move backward suppose if n=7 and r=0
				// (0-1+7)%7 = 6%7 = 6 ie.. 6 is last element
				r = (r - 1 + n) % n;
			}

			if (arr[l] + arr[r] > sum) {
				r = r - 1 + n % n;
			} else {
				l = l + 1 % n;
			}
		}
		return 0;
	}

}
