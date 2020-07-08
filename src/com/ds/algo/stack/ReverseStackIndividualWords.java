package com.ds.algo.stack;

import java.util.Stack;

public class ReverseStackIndividualWords {

	private static void rev() {
		String h = "Hello World";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < h.length(); i++) {
			char c = h.charAt(i);

			if (c != ' ') {
				stack.push(c);
			} else {
				while (!stack.empty()) {
					System.out.print(stack.pop());
				}
				System.out.print(" ");
			}
		}

		while (!stack.empty()) {
			System.out.print(stack.pop());
		}
	}

	public static void main(String[] args) {
		rev();
	}

}
