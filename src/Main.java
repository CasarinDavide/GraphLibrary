import graphPackage.Edge.NonOrientedEdge;
import graphPackage.Edge.OrientedEdge;
import graphPackage.Node.Node;
import graphPackage.NonOrientedGraph;
import graphPackage.OrientedGraph;
import graphPackage.PredecessorGraph;
import graphPackage.PredecessorNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Create nodes
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");

        // Create edges
        List<NonOrientedEdge<Integer, String>> edges = Arrays.asList(
                new NonOrientedEdge<>(1,nodeA, nodeB),
                new NonOrientedEdge<>( 5,nodeA, nodeC),
                new NonOrientedEdge<>(4,nodeB, nodeC),
                new NonOrientedEdge<>(2,nodeB, nodeD),
                new NonOrientedEdge<>(3,nodeC, nodeD),
                new NonOrientedEdge<>(7,nodeC, nodeE),
                new NonOrientedEdge<>(6,nodeD, nodeE)
        );

        // Create graph
        List<Node<String>> nodes = Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE);
        NonOrientedGraph<String, Integer> graph = new NonOrientedGraph<>(nodes, edges);

        // Comparator for edges based on their weight
        Comparator<NonOrientedEdge<Integer, String>> comparator = Comparator.comparingInt(NonOrientedEdge::getValue);

        // Run Kruskal's Algorithm
        NonOrientedGraph<String, Integer> mstKruskal = graph.kruskalAlgorithm(comparator);
        System.out.println("Minimum Spanning Tree (Kruskal's Algorithm):");
        printGraph(mstKruskal);

        // Run Prim's Algorithm
        PredecessorGraph<String, NonOrientedEdge<Integer, String>> mstPrim = graph.primAlgorithm(comparator);
        System.out.println("Minimum Spanning Tree (Prim's Algorithm):");
        printPredecessorGraph(mstPrim);
    }

    // Method to print the graph
    public static void printGraph(NonOrientedGraph<String, Integer> graph) {

        var edges = graph.getAllEdges();
        for (NonOrientedEdge<Integer, String> edge : edges ) {
            System.out.println(edge.getNode1().getIdentifier() + " - " + edge.getNode2().getIdentifier() + " : " + edge.getValue());
        }
    }

    // Method to print the predecessor graph
    public static void printPredecessorGraph(PredecessorGraph<String, NonOrientedEdge<Integer, String>> graph) {
        for (PredecessorNode<String, NonOrientedEdge<Integer, String>> node : graph.getNodeList()) {
            Node<String> pred = node.getPredecessor();
            if (pred != null) {
                System.out.println(pred.getIdentifier() + " -> " + node.getNode().getIdentifier() + " : " + node.getKey().getValue());
            }
        }
    }
}