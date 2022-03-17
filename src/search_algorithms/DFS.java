package search_algorithms;

import graph_utils.Edge;
import graph_utils.Graph;
import graph_utils.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//DFS está a visitar primeiro o último nó explorado
public class DFS extends SearchAlgorithm {
    Graph graph;
    public DFS(Graph graph) {
        super(graph);
        this.graph = graph;
    }

    @Override
    public List<Node> start(Node n_initial, Node n_final) {
        List<Node> result = DFS_recursion(n_initial, new boolean[graph.numberOfNodes()], n_final, new Node[graph.numberOfNodes()]);

        //Getting the path order
        int index = Integer.parseInt(n_final.getLabel()) - 1;
        List<Node> finalResult = new ArrayList<Node>();
        finalResult.add(n_final);

        while (result.get(index) != null) {
            finalResult.add(result.get(index));
            index = Integer.parseInt(result.get(index).getLabel()) - 1;
        }
        
        Collections.reverse(finalResult);
        return finalResult;
    }
    
    List<Node> DFS_recursion(Node currentNode, boolean[] visited, Node n_final, Node[] newParent) {
        List<Node> result = new ArrayList<Node>();
        Collections.addAll(result, newParent);
        
        visited[Integer.parseInt(currentNode.getLabel()) - 1] = true;
        List<Edge> edges = graph.getAdjacencyList().get(currentNode);
        if (edges == null || currentNode.equals(n_final)) return Arrays.asList(newParent);

        for (Edge edge : edges) {
            Node newNode = edge.getN1();
            if (!visited[Integer.parseInt(newNode.getLabel()) - 1]) {
                newParent[Integer.parseInt(newNode.getLabel()) - 1] = edge.getN0();
                
                if (newNode.equals(n_final)) {
                    newParent[Integer.parseInt(newNode.getLabel()) - 1] = currentNode;
                    return Arrays.asList(newParent);
                }
                result = DFS_recursion(newNode, visited, n_final, newParent);
            }
        }

        return result;
    }
}
