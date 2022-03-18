package tests;

import graph_utils.*;
import search_algorithms.*;

import java.util.List;

public class SolutionBreadthDepth {
	public static void main(String[] args) {
		/*
		 * TO DO
		 * Aqui deves:
		 * 		- criar a instancia do grafo que representa o mapa das masmorras (ver classe Exemplo.java)
		 * 		- colocar o c�digo para testar os algoritmos criados
		 * 	
		 */
		
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
		
//		//1
//		graph.addEdge(nodes[5], nodes[9], 1);
//		//2
//		graph.addEdge(nodes[9], nodes[3], 3);
//		//3
//		graph.addEdge(nodes[3], nodes[2], 15);
//		graph.addEdge(nodes[3], nodes[7], 13);
//		//4
//		graph.addEdge(nodes[2], nodes[8], 4);
//		graph.addEdge(nodes[2], nodes[10], 19);
//		//--
//		graph.addEdge(nodes[7], nodes[4], 13);
//		//5
//		graph.addEdge(nodes[8], nodes[6], 9);
//		graph.addEdge(nodes[8], nodes[10], 9);
//		//--
//		graph.addEdge(nodes[4], nodes[0], 1);
//		graph.addEdge(nodes[4], nodes[1], 13);
//		graph.addEdge(nodes[4], nodes[10], 1);
//		//6
//		graph.addEdge(nodes[6], nodes[8], 9);
//		graph.addEdge(nodes[10], nodes[8], 9);
//		graph.addEdge(nodes[10], nodes[4], 1);
//		//--
//		graph.addEdge(nodes[0], nodes[4], 1);
//		graph.addEdge(nodes[1], nodes[4], 13);
////		graph.addEdge(nodes[10], nodes[8], 9); //already added
//		graph.addEdge(nodes[10], nodes[2], 19);
//		//7
//		graph.addEdge(nodes[4], nodes[7], 13);
//		//--
//		graph.addEdge(nodes[8], nodes[2], 4);
//		graph.addEdge(nodes[2], nodes[3], 15);
//		//8
//		graph.addEdge(nodes[7], nodes[3], 13);
//		//--
//		graph.addEdge(nodes[3], nodes[9], 3);
//		//9
//		graph.addEdge(nodes[9], nodes[5], 1);
		
		
		System.out.println("initial node: " + nodes[5].getLabel());
		System.out.println("final node: " + nodes[10].getLabel());
		
//		System.out.println("-----BFS-----");
//		BFS bfs = new BFS(graph);
//		List<Node> BFSPath = bfs.startSearch(nodes[5], nodes[10]);
//		bfs.printResult(BFSPath);
//
//		System.out.println("-----DFS-----");
//		DFS dfs = new DFS(graph);
//		List<Node> DFSPath = dfs.startSearch(nodes[5], nodes[10]);
//		dfs.printResult(DFSPath);
		
		AStar aStar = new AStar(graph);
		List<Node> AStarPath = aStar.start(nodes[5], nodes[10]);
		aStar.printResult(AStarPath);
	}
}
