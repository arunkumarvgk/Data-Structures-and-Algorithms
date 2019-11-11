package com.ds.algo.graph;

import java.util.LinkedList;

public class Graph {
	private int noOfVertices;
	private LinkedList<Integer> adjacencyListArray[];

	public Graph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		this.adjacencyListArray = new LinkedList[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			this.adjacencyListArray[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		this.adjacencyListArray[src].add(dest);
	}

	public void printGraph() {
		for (int i = 0; i < noOfVertices; i++) {
			LinkedList<Integer> list = adjacencyListArray[i];
			System.out.print("Node "+i+" :: ");
			list.stream().forEach(val -> System.out.print(" -> "+val));
			System.out.println();
		}
	}
}
