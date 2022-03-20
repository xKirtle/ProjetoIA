package tests;

import graph_utils.*;
import search_algorithms.*;

import java.util.List;

public class SolutionBreadthDepth {
	public static void main(String[] args) {
		final int numberOfNodes = 11;
		Node[] nodes = new Node[numberOfNodes];
		for (int i = 1; i <= numberOfNodes; i++)
			nodes[i-1] = new Node(String.valueOf(i));

		Graph graph = new Graph();
		graph.addEdge(nodes[5], nodes[9]);
		graph.addEdge(nodes[9], nodes[3]);
		graph.addEdge(nodes[3], nodes[2]);
		graph.addEdge(nodes[3], nodes[7]);
		graph.addEdge(nodes[7], nodes[4]);
		graph.addEdge(nodes[7], nodes[2]); //??
		graph.addEdge(nodes[2], nodes[7]);
		graph.addEdge(nodes[2], nodes[8]);
		graph.addEdge(nodes[2], nodes[10]);
		graph.addEdge(nodes[4], nodes[10]);
		graph.addEdge(nodes[4], nodes[0]);
		graph.addEdge(nodes[4], nodes[1]);
		graph.addEdge(nodes[8], nodes[6]);
		graph.addEdge(nodes[8], nodes[10]);
		
		System.out.println("initial node: " + nodes[5].getLabel());
		System.out.println("final node: " + nodes[10].getLabel());
		
		System.out.println("-----BFS-----");
		BFS bfs = new BFS(graph);
		List<Node> BFSPath = bfs.startSearch(nodes[5], nodes[10]);
		bfs.printResult(BFSPath);

		System.out.println("-----DFS-----");
		DFS dfs = new DFS(graph);
		List<Node> DFSPath = dfs.startSearch(nodes[5], nodes[10]);
		dfs.printResult(DFSPath);
	}
}
