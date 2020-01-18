package test;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.asList(arr[1]));
		
		for (int i = 0; i < arr[0].length; i++) {
			System.out.println();
		}
	}

}
