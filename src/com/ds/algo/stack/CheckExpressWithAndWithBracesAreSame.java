package com.ds.algo.stack;

import java.util.Stack;

public class CheckExpressWithAndWithBracesAreSame {

	static int arr[] = new int[26];

	private static void check(String exp1, String exp2) {
		eval(exp1, true);
		eval(exp2, true);
		
		boolean matched = true;;
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				matched = false;
				break;
			}
		}
		
		if (matched) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static boolean adjSign(String exp, int index) {
		if (index == 0) {
			return true;
		}

		if (exp.charAt(index - 1) == '-') {
			return false;
		}

		return true;
	}

	private static void eval(String exp, boolean add) {
		Stack<Boolean> stack = new Stack<>();
		stack.push(true);

		for (int i = 0; i < exp.length(); i++) {
			char chr = exp.charAt(i);

			if (chr == '(') {
				if (adjSign(exp, i)) {
					stack.push(stack.peek());
				} else {
					stack.push(!stack.peek());
				}
			} else if (chr == ')') {
				stack.pop();
			} else {
				if (stack.peek()) {
					arr[chr - 'a'] += adjSign(exp, i) ? (add ? 1 : -1) : (add ? -1 : 1);
				} else {
					arr[chr - 'a'] += adjSign(exp, i) ? (add ? -1 : 1) : (add ? 1 : -1);
				}
			}
			i++;
		}
	}

	public static void main(String[] args) {
		check("-(a+b+c)", "-a-b-c");
	}

}
