package com.ds.algo.stack;

import java.util.Stack;

public class NextGreateElement {

	private static void NGE() {
		int arr[] = { 11, 13, 21, 3 };
		Stack<Integer> stack = new Stack<>();

		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (stack.peek() < arr[i]) {
				System.out.println(stack.pop() + " -> " + arr[i]);
			}
			stack.push(arr[i]);
		}

		while (!stack.empty()) {
			System.out.println(stack.pop() + " -> -1");
		}
	}

	private static void NGEsToRight() {
		int arr[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
		Stack<Integer> stack = new Stack<Integer>();

		int index = 5;

		for (int i = index; i < arr.length; i++) {
			if (stack.empty() && arr[index] < arr[i]) {
				stack.push(arr[i]);
				continue;
			}

			if (!stack.empty() && stack.peek() < arr[i]) {
				stack.push(arr[i]);
			}
		}

		System.out.println("No of NGE2 to right is :: " + stack.size());
	}
	
	private static void NGEsToRight2() {
		int arr[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
		Stack<Integer> stack = new Stack<Integer>();
		int index = 5;

		for (int i = index; i < arr.length; i++) {
			if (stack.empty() && arr[index] < arr[i]) {
				stack.push(arr[i]);
				continue;
			}

			if (!stack.empty() && stack.peek() < arr[i]) {
				stack.push(arr[i]);
			}
		}

		System.out.println("No of NGE2 to right is :: " + stack.size());
	}

	public static void main(String[] args) {
		NGE();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		NGEsToRight();
	}

}
