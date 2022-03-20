package search_algorithms;

import graph_utils.Edge;
import graph_utils.Graph;
import graph_utils.Node;

import java.util.*;
import java.util.stream.Collectors;

public class AStar extends SearchAlgorithm {
    Graph graph;
    public AStar(Graph graph) {
        super(graph);
        this.graph = graph;
    }

    @Override
    public List<Node> start(Node n_initial, Node n_final) {
        Set<Node> nodeSet = new HashSet<>();
        for (Edge e : graph.getEdges()) {
            nodeSet.add(e.getN0());
            nodeSet.add(e.getN1());
        }

        //Getting all nodes, ordered, in a linked list
        ArrayList<Node> unvisited = nodeSet.stream()
                .sorted(Comparator.comparingInt(n -> Integer.parseInt(n.getLabel())))
                .collect(Collectors.toCollection(ArrayList<Node>::new));
        Node[] nodeParent = new Node[graph.numberOfNodes()];
        
        //Setting all nodes at max cost, we'll keep the lowest later
        unvisited.forEach(n -> n.setCost(Integer.MAX_VALUE));
        
        Node currentNode = n_initial;
        unvisited.get(Integer.parseInt(currentNode.getLabel()) - 1).setCost(0);
        while (!unvisited.isEmpty()) {
            List<Edge> adjacentEdges = graph.getAdjacencyList().get(currentNode);
            if (adjacentEdges != null) {
                for (Edge edge : adjacentEdges) {
                    Node newNode = edge.getN1();
                    int newNodeIndex = Integer.parseInt(newNode.getLabel()) - 1;
                    if (edge.getCost() + currentNode.getCost() < newNode.getCost()) {
                        //changing values directly to the object reference
                        newNode.setCost(currentNode.getCost() + edge.getCost());
                        nodeParent[newNodeIndex] = currentNode;
                    }
                }
            }
            unvisited.remove(currentNode);
            
            //out of all unvisited nodes, select the one with the smallest f to visit
            Node tempNode = currentNode;
            int minF = Integer.MAX_VALUE;
            for (Node node : unvisited) {
                int index = Integer.parseInt(node.getLabel()) - 1;
                if (nodeParent[index] != null && node.getF() < minF) {
                    tempNode = node;
                    minF = node.getF();
                }
            }
            currentNode = tempNode;
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
