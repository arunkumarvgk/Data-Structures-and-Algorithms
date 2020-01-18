package com.ds.algo.mainproblems;

import java.util.ArrayList;
import java.util.List;

public class CricketWeightsProblem {

	private static void calculate(List<Node> cricketers, List<Node> bats) {
		int cLength = cricketers.size();
		int bLength = bats.size();
		int arr[] = new int[bLength];
		int count = 1;

		for (int i = 0; i < cLength; i++) {
			boolean slotFound = false;
			for (int j = 0; j < bLength; j++) {
				if (cricketers.get(i).weight < bats.get(j).weight && cricketers.get(i).price >= bats.get(j).price) {
					if (arr[j] == 0) {
						arr[j] = count;
						slotFound = true;
						continue;
					}

					if (arr[j] != 0) {
						int slotTakenBy = arr[j];
						int tempCount = 0;
						for (int k = 0; k < bLength; k++) {
							if (arr[k] == slotTakenBy) {
								tempCount++;
							}
							
							if (tempCount > 1) {
								arr[j] = count;
								slotFound = true;
								break;
							}
						}
					}
				}
			}
			if (slotFound) {
				count++;
			}
			for (int j = 0; j < bLength; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}

		System.out.println("Max bats could be sold are " + (count - 1));
		System.out.println(".......................................................");
	}

	public static void main(String[] args) {
		List<Node> cricketers = new ArrayList<>();
		List<Node> bats = new ArrayList<>();
		input1(cricketers, bats);
		calculate(cricketers, bats);
		
		input2(cricketers, bats);
		calculate(cricketers, bats);
		
		input3(cricketers, bats);
		calculate(cricketers, bats);
	}

	private static void input1(List<Node> cricketers, List<Node> bats) {
		cricketers.clear();
		bats.clear();
		cricketers.add(new Node(5, 100));
		cricketers.add(new Node(7, 80));
		cricketers.add(new Node(10, 90));
		cricketers.add(new Node(6, 150));

		bats.add(new Node(8, 100));
		bats.add(new Node(10, 90));
		bats.add(new Node(11, 60));
		bats.add(new Node(9, 80));
	}
	
	private static void input2(List<Node> cricketers, List<Node> bats) {
		cricketers.clear();
		bats.clear();
		//original
		cricketers.add(new Node(5, 100));
		cricketers.add(new Node(7, 80));
		cricketers.add(new Node(10, 90));
		cricketers.add(new Node(6, 150));

		bats.add(new Node(8, 100));
		bats.add(new Node(10, 150));
		bats.add(new Node(9, 60));
		bats.add(new Node(7, 80));
	}
	
	private static void input3(List<Node> cricketers, List<Node> bats) {
		cricketers.clear();
		bats.clear();
		cricketers.add(new Node(5, 100));
		cricketers.add(new Node(5, 90));
		cricketers.add(new Node(10, 90));
		cricketers.add(new Node(6, 150));

		bats.add(new Node(8, 100));
		bats.add(new Node(10, 150));
		bats.add(new Node(11, 60));
		bats.add(new Node(9, 80));
	}
}

class Node {
	int weight;
	int price;

	Node(int weight, int price) {
		this.price = price;
		this.weight = weight;
	}
}
