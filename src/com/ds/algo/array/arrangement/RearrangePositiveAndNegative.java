package com.ds.algo.array.arrangement;

public class RearrangePositiveAndNegative {

	private static void rearrange(int arr[]) {
		int i =-1, temp;
		int n = arr.length;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		for (int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
		
		int pos = i+1;
		int neg = 0;
		
		while(pos < n && neg < pos && arr[neg] < 0) {	
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++; neg+=2;
		}
		
		for (int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		rearrange(new int[] { -1, 2, -3, 4, 5, 6, -7, 8, 9 });
		System.out.println("==========");
		rearrange(new int[] {-1,-1,-1,2,2});
		System.out.println("==========");
		rearrange(new int[] {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8});
		System.out.println("==========");
		rearrange(new int[] {1, 2, 3, -4, -1, 4});
	}

}
