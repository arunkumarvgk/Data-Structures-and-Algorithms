package com.ds.algo.stack;

import java.util.Stack;

public class FormMinimumNumberUsingDsAndIs {

	private static void form(String exp) {
		Stack<Integer> stack = new Stack<>();
		String result = "";
		for (int i = 0; i <= exp.length(); i++) {
			stack.push(i+1);
			if (exp.length() == i || exp.charAt(i) == 'I') {
				while (!stack.empty()) {
					result+=stack.pop();
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		form("DIDI");
	}

}
