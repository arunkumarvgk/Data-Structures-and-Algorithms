package com.ds.algo.stack;

import java.util.Stack;

public class DecodeStringEncodedAsCount {

	private static void decode(String exp) {
		Stack<Integer> countStack = new Stack<>();
		Stack<String> stack = new Stack<>();
		int i = 0;
		while (i < exp.length()) {
			int count = 0;
			if (Character.isDigit(exp.charAt(i))) {
				while (Character.isDigit(exp.charAt(i))) {
					count = count * 10 + exp.charAt(i) - '0';
					i++;
				}
				countStack.push(count);
				continue;
			} else if (exp.charAt(i) == '[') {
				if (i != 0 && ! Character.isDigit(exp.charAt(i-1))) {
					countStack.push(1);
				}
				stack.push("[");
			} else if (exp.charAt(i) == ']') {
				String temp = "";
				String result = "";
				if ( ! countStack.empty()) {
					count = countStack.pop();
				}
				
				while (! stack.empty() && stack.peek() != "[") {
					temp = stack.pop() + temp;
				}
				
				if (! stack.empty() && stack.peek() == "[") {
					stack.pop();
				}
				
				for (int j = 0; j < count; j++) {
					result += temp;
				}
				stack.push(result);
			} else {
				stack.push(exp.charAt(i)+"");
			}
			i++;
		}
		
		System.out.println(stack.peek());
	}

	public static void main(String[] args) {
		decode("2[a2[b]]");
		decode("3[b2[ca]]");
		decode("a");
	}

}
