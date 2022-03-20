package tests;

import graph_utils.*;
import search_algorithms.*;

import java.util.List;

public class SolutionAstar {
	public static void main(String[] args) {
		//Heurística é definida pela menor distância ao nó final
		final int numberOfNodes = 11;
		Node[] nodes = new Node[numberOfNodes];
		int[] nodeHeuristic = new int[] {2, 2, 1, 2, 1, 4, 2, 2, 1, 3, 0};
		for (int i = 1; i <= numberOfNodes; i++)
			nodes[i-1] = new Node(String.valueOf(i), nodeHeuristic[i-1]);

		Graph graph = new Graph();
		graph.addEdge(nodes[5], nodes[9], 1);
		graph.addEdge(nodes[9], nodes[3], 3);
		graph.addEdge(nodes[3], nodes[2], 15);
		graph.addEdge(nodes[3], nodes[7], 13);
		graph.addEdge(nodes[7], nodes[4], 13);
		graph.addEdge(nodes[7], nodes[2], 25); //??
		graph.addEdge(nodes[2], nodes[7],25);
		graph.addEdge(nodes[2], nodes[8], 4);
		graph.addEdge(nodes[2], nodes[10], 19);
		graph.addEdge(nodes[4], nodes[10], 1);
		graph.addEdge(nodes[4], nodes[0], 1);
		graph.addEdge(nodes[4], nodes[1], 13);
		graph.addEdge(nodes[8], nodes[6], 9);
		graph.addEdge(nodes[8], nodes[10], 9);

		System.out.println("initial node: " + nodes[5].getLabel());
		System.out.println("final node: " + nodes[10].getLabel());
		
		AStar aStar = new AStar(graph);
		List<Node> AStarPath = aStar.start(nodes[5], nodes[10]);
		aStar.printResult(AStarPath);
	}
}
