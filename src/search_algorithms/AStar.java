package search_algorithms;

import graph_utils.Edge;
import graph_utils.Graph;
import graph_utils.Node;

import java.util.*;

public class AStar extends SearchAlgorithm {
    Graph graph;
    public AStar(Graph graph) {
        super(graph);
        this.graph = graph;
    }

    @Override
    public List<Node> start(Node n_initial, Node n_final) {
        //heuristic, definir ao criar instancia de node..
        //node cost, custo definido no edge
        // f = heuristic + node cost
        //smaller f -> better path
    

//        Função de avaliação F(n) = G(n) + H(n)
//        • G(n) = custo até agora para alcançar n (desde estado inicial)
//        • H(n) = custo estimado de n para o objetivo (heurística)
//        • F(n) = custo total estimado do caminho através de n para o objetivo

        Stack<Node> stack = new Stack<Node>();
        stack.add(n_initial);
        
        boolean[] visitedNodes = new boolean[graph.numberOfNodes()];
        Node[] nodeParent = new Node[graph.numberOfNodes()];
        
        while (stack.size() != 0) {
            Node currentNode = stack.pop();
            
            List<Edge> adjacentEdges = graph.getAdjacencyList().get(currentNode);
            if (adjacentEdges == null) continue;
            
            int currentNodeIndex = Integer.parseInt(currentNode.getLabel()) - 1;
            if (visitedNodes[currentNodeIndex]) continue;
            visitedNodes[currentNodeIndex] = true;
            
            //Expandir o currentNode e ver qual o caminho com o melhor F
            //Adicionar caminhos ao stack por ordem decrescente?
            for (int i = 0; i < adjacentEdges.size(); i++) {
                
            }
        }
        
        
        return null;
    }
}
