package com.ds.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {

	private static void stockSpan(int stock[]) {
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		int arr[] = new int[stock.length];
		arr[0] = 1;

		for (int i = 1; i < stock.length; i++) {
			while (!stack.isEmpty() && stock[stack.peek()] < stock[i]) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				arr[i] = i - stack.peek();
			} else {
				arr[i] = i;
			}
			stack.push(i);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		/*
		 * stockSpan(new int[] { 31, 27, 14, 21, 30, 22 }); stockSpan(new int[] { 100,
		 * 80, 60, 70, 60, 75, 85 }); stockSpan(new int[] { 100 });
		 */
		StockSpan span = new StockSpan();
		System.out.println(span.next(31));
		System.out.println(span.next(41));
		System.out.println(span.next(48));
		System.out.println(span.next(59));
		System.out.println(span.next(79));
	}

	List<Integer> stock = new ArrayList<>();
	Stack<Integer> stack = new Stack<>();

	StockSpan() {
		stack.push(0);
	}

	public int next(int price) {
		stock.add(price);
		if (stock.size() == 1) {
			return 1;
		}
		;
		return findStockSpanForDay();
	}

	private int findStockSpanForDay() {
		int retVal = 0;
		int counter = stock.size() - 1;
		while (!stack.isEmpty() && stock.get(stack.peek()) <= stock.get(counter)) {
			stack.pop();
		}

		if (!stack.isEmpty()) {
			retVal = counter - stack.peek();
		} else {
			retVal = counter + 1;
		}

		stack.push(counter);
		return retVal;
	}
}
