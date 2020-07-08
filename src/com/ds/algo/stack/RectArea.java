package com.ds.algo.stack;

import java.util.Stack;

public class RectArea {

	private static int getMaxArea(int hist[], int n) {

		Stack<Integer> stack = new Stack<>();

		int i = 0;
		int maxArea = 0;
		int area = 0;
		
		while (i < n) {
			if (stack.empty() || hist[stack.peek()] <= hist[i]) {
				stack.push(i++);
			} else {
				// considering top as min element 
				// stack.peek() as left index and i as right index calc the width
				// and multiply it by min that is top
				int top = stack.pop();
				area = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
				
				if (maxArea < area) {
					maxArea = area;
				}
			}
		}
		
		while ( ! stack.empty()) {
			int top = stack.pop();
			area = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
			
			if (maxArea < area) {
				maxArea = area;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}
}