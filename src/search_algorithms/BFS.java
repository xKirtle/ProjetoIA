package search_algorithms;

import graph_utils.Edge;
import graph_utils.Graph;
import graph_utils.Node;

import java.util.*;

//BFS está a visitar primeiro o primeiro nó explorado
public class BFS extends SearchAlgorithm {
    Graph graph;
    public BFS(Graph graph) {
        super(graph);
        this.graph = graph;
    }

    @Override
    public List<Node> start(Node n_initial, Node n_final) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(n_initial);
        
        boolean[] visitedNodes = new boolean[graph.numberOfNodes()];
        boolean finalFound = false;
        Node[] nodeParent = new Node[graph.numberOfNodes()];
        
        while (queue.size() != 0) {
            Node currentNode = queue.poll();
            List<Edge> adjacentEdges = graph.getAdjacencyList().get(currentNode);
            if (adjacentEdges == null) continue;
            
            int currentNodeIndex = Integer.parseInt(currentNode.getLabel()) - 1;
            if (visitedNodes[currentNodeIndex]) continue;
            visitedNodes[currentNodeIndex] = true;
            
            for (int i = 0; i < adjacentEdges.size(); i++) {
                Node nodeToAdd = adjacentEdges.get(i).getN1();
                
                int nodeToAddIndex = Integer.parseInt(nodeToAdd.getLabel()) - 1;
                nodeParent[nodeToAddIndex] = currentNode;

                if (nodeToAdd.equals(n_final)) {
                    finalFound = true;
                    break;
                }
                
                queue.add(nodeToAdd);
            }
            
            if (finalFound) {
                break;
            }
        }

        //Getting the path order
        int index = Integer.parseInt(n_final.getLabel()) - 1;
        List<Node> result = new ArrayList<Node>();
        result.add(n_final);
        
        while (nodeParent[index] != null) {
            result.add(nodeParent[index]);
            index = Integer.parseInt(nodeParent[index].getLabel()) - 1;
        }
        
        Collections.reverse(result);
        return result;
    }
}
