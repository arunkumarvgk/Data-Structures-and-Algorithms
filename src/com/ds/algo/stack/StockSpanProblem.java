package com.ds.algo.stack;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {

	private static void stockSpanProblem() {
		int prevDaySpan = 0;
		int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
		Stack<Integer> stack = new Stack<>();
		
		stack.push(100);
		System.out.println("100 -> 1");
		prevDaySpan = 1;
		
		for (int i = 1; i < arr.length; i++) {
			int count = 0;
			if (stack.peek() > arr[i]) {
				stack.push(arr[i]);
			} else {
				while (!stack.empty() && stack.peek() < arr[i]) {
					stack.pop();
					count++;
				}
			}
			if (count > 0) {
				prevDaySpan+=count;
				System.out.println(arr[i]+" -> "+prevDaySpan);
			} else {
				System.out.println(arr[i]+" -> 0");
			}
			
		}
	}

	private static void ssp() {
		int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
		Stack<Integer> stack = new Stack<>();
		int span[] = new int[arr.length];
		
		stack.push(0);
		span[0] = 1;
		
		for (int i = 1; i < arr.length; i++) {
			while (! stack.empty() && arr[i] >= arr[stack.peek()]) {
				stack.pop();
			}
			span[i] = i - stack.peek();
			stack.push(i);
		}
		HashMap l;
		List ll;
		
		for (int i = 0; i < span.length; i++) {
			System.out.println(arr[i]+" "+span[i]);
		}
	}
	public static void main(String[] args) {
		//stockSpanProblem();
		ssp();
	}

}
