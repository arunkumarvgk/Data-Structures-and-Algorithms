package com.ds.algo.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

class Node {
	private Integer id;

	Node(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

class Edge {
	private Node from;
	private Node to;

	Edge(Node from, Node to) {
		this.from = from;
		this.to = to;
	}

	public Node getFrom() {
		return from;
	}

	public void setFrom(Node from) {
		this.from = from;
	}

	public Node getTo() {
		return to;
	}

	public void setTo(Node to) {
		this.to = to;
	}

}

class Graph {
	private List<Node> nodes;
	private List<Edge> edges;

	Graph(List<Node> nodes, List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
}

public class TestGraph {

	private static void secondApproach() {
		List<Node> nodeList = new ArrayList<>();
		List<Edge> edgeList = new ArrayList<>();

		// Create
		create(nodeList, edgeList);

		Graph graph = new Graph(nodeList, edgeList);
		// Create Association
		Map<Integer, Set<Integer>> edgeAssociation = createMap(graph);
		printEdges(edgeAssociation);

		Set<Integer> filterNodes = new HashSet<>();
		filterNodes.add(2);
		filterNodes.add(5);

		// Merge
		Map<Integer, Set<Integer>> newEdgeAssociation = edgesAfterFilter(filterNodes, edgeAssociation);
		printEdges(newEdgeAssociation);

		// Bidirectional graph for identifying connected graph
		Map<Integer, Set<Integer>> biDirectionalEdgeAssociation = getBidirectionalGraph(newEdgeAssociation);
		printEdges(biDirectionalEdgeAssociation);

		// Get Connected graph
		Set<Integer> connectedNodes = getConnectedGraph(biDirectionalEdgeAssociation, 0);
		System.out.println("Nodes");
		connectedNodes.stream().forEach(val -> System.out.print(" " + val));

		printEdgesAfterFiltering(newEdgeAssociation, connectedNodes);
	}

	private static Set<Integer> getConnectedGraph(Map<Integer, Set<Integer>> biDirectionalEdgeAssociation,
			Integer root) {
		Set<Integer> connectedNodes = new HashSet<>();
		Stack<Integer> s = new Stack<>();
		s.add(root);
		while (!s.isEmpty()) {
			Integer poped = s.pop();
			connectedNodes.add(poped);
			if (biDirectionalEdgeAssociation.containsKey(poped)) {
				biDirectionalEdgeAssociation.get(poped).stream()
						.filter(val -> !connectedNodes.contains(val))
						.forEach(val -> s.add(val));
			}
		}
		return connectedNodes;
	}

	private static Map<Integer, Set<Integer>> getBidirectionalGraph(Map<Integer, Set<Integer>> newEdgeAssociation) {
		Map<Integer, Set<Integer>> biDirectionalEdgeAssociation = new HashMap<>();
		biDirectionalEdgeAssociation.putAll(newEdgeAssociation);

		for (Entry<Integer, Set<Integer>> entry : newEdgeAssociation.entrySet()) {
			Integer key = entry.getKey();
			Set<Integer> values = entry.getValue();

			for (Integer val : values) {
				if (biDirectionalEdgeAssociation.containsKey(val)) {
					Set<Integer> set = new HashSet<>();
					set.addAll(biDirectionalEdgeAssociation.get(key));
					if (!set.contains(key)) {
						set.add(key);
						biDirectionalEdgeAssociation.put(key, set);
					}
				}
			}
		}
		return biDirectionalEdgeAssociation;
	}

	private static void printEdges(Map<Integer, Set<Integer>> edgeAssociation) {
		System.out.println("===================================================");
		edgeAssociation.entrySet().stream().forEach(edge -> {
			System.out.print("Key " + edge.getKey() + " ::::::: ");
			edge.getValue().stream().forEach(value -> System.out.print(" -> " + value));
			System.out.println();
		});
	}

	private static void printEdgesAfterFiltering(Map<Integer, Set<Integer>> edgeAssociation,
			Set<Integer> connectedNodes) {
		System.out.println("===================================================");
		edgeAssociation.entrySet().stream().filter(edge -> connectedNodes.contains(edge.getKey())).forEach(edge -> {
			System.out.print("Key " + edge.getKey() + " ::::::: ");
			edge.getValue().stream().forEach(value -> System.out.print(" -> " + value));
			System.out.println();
		});
	}

	private static Map<Integer, Set<Integer>> edgesAfterFilter(Set<Integer> filterNodes,
			Map<Integer, Set<Integer>> edgeAssociation) {
		Map<Integer, Set<Integer>> newEdgeAssociation = new HashMap<>();

		for (Entry<Integer, Set<Integer>> entry : edgeAssociation.entrySet()) {
			Integer key = entry.getKey();
			if (!filterNodes.contains(key)) {
				Stack<Integer> s = new Stack<>();
				entry.getValue().stream().forEach(value -> s.add(value));
				while (!s.isEmpty()) {
					Integer poped = s.pop();

					if (!filterNodes.contains(poped)) {
						addEdge(newEdgeAssociation, key, poped);
					} else {
						if (edgeAssociation.get(poped) != null) {
							edgeAssociation.get(poped).stream().forEach(value -> s.add(value));
						}
					}
				}
			}
		}

		return newEdgeAssociation;
	}

	private static void addEdge(Map<Integer, Set<Integer>> newEdgeAssociation, Integer key, Integer val) {
		Set<Integer> list;
		if (newEdgeAssociation.containsKey(key)) {
			list = newEdgeAssociation.get(key);
			list.add(val);
		} else {
			list = new HashSet<>();
			list.add(val);
		}
		newEdgeAssociation.put(key, list);
	}

	private static Map<Integer, Set<Integer>> createMap(Graph graph) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		graph.getEdges().stream().forEach(edge -> {
			Set<Integer> list;
			Integer fromId = edge.getFrom().getId();
			if (map.containsKey(fromId)) {
				list = map.get(fromId);
				list.add(edge.getTo().getId());
			} else {
				list = new HashSet<>();
				list.add(edge.getTo().getId());
			}
			map.put(fromId, list);
		});
		return map;
	}

	public static void main(String[] args) {
		secondApproach();
		// MatrixApporach();
	}

	public static void create(List<Node> nodeList, List<Edge> edgeList) {
		Node a = new Node(0);
		Node b = new Node(1);
		Node c = new Node(2);
		Node d = new Node(3);
		Node e = new Node(4);
		Node f = new Node(5);
		Node g = new Node(6);
		Node h = new Node(7);
		Node i = new Node(8);
		Node j = new Node(9);

		nodeList.add(a);
		nodeList.add(b);
		nodeList.add(c);
		nodeList.add(d);
		nodeList.add(e);
		nodeList.add(f);
		nodeList.add(g);

		edgeList.add(new Edge(a, c));
		edgeList.add(new Edge(b, a));
		edgeList.add(new Edge(b, d));
		edgeList.add(new Edge(c, b));
		edgeList.add(new Edge(c, d));
		edgeList.add(new Edge(c, e));
		edgeList.add(new Edge(e, d));
		edgeList.add(new Edge(d, f));
		edgeList.add(new Edge(g, f));
		edgeList.add(new Edge(g, h));
		edgeList.add(new Edge(h, i));
		edgeList.add(new Edge(i, j));
	}

	private static void MatrixApporach() {
		List<Node> nodeList = new ArrayList<>();
		List<Edge> edgeList = new ArrayList<>();
		create(nodeList, edgeList);
		Graph graph = new Graph(nodeList, edgeList);
		List<Integer> filterNodes = new ArrayList<>();
		int arr[][] = createMatrix(graph);
		int arr2[][] = { { 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0, 0 } };
		System.out.println("=======Before Filter==================");
		printDependencies(arr, graph, filterNodes);
		printMatrix(arr, filterNodes);

		filterNodes.add(2);
		int modifiedMatrix[][] = filter(filterNodes, arr);
		System.out.println("\n\n");
		System.out.println("Filtering");
		filterNodes.stream().forEach(val -> System.out.print(val + " "));
		System.out.println("\n\n");
		System.out.println("=========After Filter================");
		printDependencies(modifiedMatrix, graph, filterNodes);
		printMatrix(modifiedMatrix, filterNodes);
	}

	private static int[][] filter(List<Integer> filterNodes, int arr[][]) {
		int length = arr.length;
		int temp[][] = arr.clone();
		for (int i = 0; i < length; i++) {

			if (filterNodes.contains(i)) {
				Arrays.fill(temp[i], 0);
				continue;
			}

			for (int j = 0; j < length; j++) {
				if (i == j) {
					continue;
				}

				if (filterNodes.contains(j) && arr[i][j] == 1) {
					temp[i] = getDependencies(j, arr[i], arr[j]);
				} else if (filterNodes.contains(j) && temp[i][j] == 1) {
					temp[i] = getDependencies(j, temp[i], temp[j]);
				}
			}
		}
		return temp;
	}

	private static int[] getDependencies(int colToBeRemoved, int original[], int toBeMergered[]) {
		int modified[] = original.clone();
		for (int i = 0; i < original.length; i++) {
			if (toBeMergered[i] == 1 && i > colToBeRemoved) {
				modified[i] = 1;
			}

			if (colToBeRemoved == i) {
				modified[i] = 0;
			}
		}
		return modified;
	}

	private static int[][] createMatrix(Graph graph) {
		int length = graph.getNodes().size();
		int arr[][] = new int[length][length];
		graph.getEdges().stream().forEach(edge -> arr[edge.getFrom().getId()][edge.getTo().getId()] = 1);
		return arr;
	}

	private static void printDependencies(int[][] modifiedMatrix, Graph graph, List<Integer> filterNodes) {
		System.out.println("Nodes Available");
		System.out.println("--------------------------");
		graph.getNodes().stream().filter(node -> !filterNodes.contains(node.getId())).forEach(node -> {
			System.out.print(node.getId() + "  ");
		});
		System.out.println();
		System.out.println("--------------------------");
		for (int i = 0; i < modifiedMatrix.length; i++) {
			System.out.print("From " + i + " ::");
			for (int j = 0; j < modifiedMatrix.length; j++) {
				if (modifiedMatrix[i][j] == 1) {
					System.out.print(" -> " + j);
				}
			}
			System.out.println();
		}
	}

	private static void printMatrix(int arr[][], List<Integer> nodesToBeFiltered) {
		System.out.println("--------------------------");
		System.out.println("Matrix");
		System.out.println("--------------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
