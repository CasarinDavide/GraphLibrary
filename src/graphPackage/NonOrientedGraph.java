package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Edge.NonOrientedEdge;
import graphPackage.Node.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NonOrientedGraph<NODE_VALUE_T,EDGE_VALUE_T> extends Graph<NODE_VALUE_T,EDGE_VALUE_T, NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>>{
    public NonOrientedGraph(List<Node<NODE_VALUE_T>> nodes, List<NonOrientedEdge<EDGE_VALUE_T, NODE_VALUE_T>> edges) {
        super(nodes, edges);
    }

    public NonOrientedGraph() {
        super();
    }

    @Override
    public double graphDensity() {
        return (double) this.edgesList.size() * 2 / this.nodesList.size() * this.nodesList.size() - this.nodesList.size() ;
    }


    public NonOrientedGraph<NODE_VALUE_T, EDGE_VALUE_T> kruskalAlgorithm(Comparator<NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>> comparator) {
        // Sorting
        NonOrientedGraph<NODE_VALUE_T, EDGE_VALUE_T> minimumSpanningTree = new NonOrientedGraph<>();
        List<NonOrientedEdge<EDGE_VALUE_T, NODE_VALUE_T>> sortedEdges = Edge.sortEdge(this.edgesList, comparator);

        for (NonOrientedEdge<EDGE_VALUE_T, NODE_VALUE_T> edge : sortedEdges) {
            NonOrientedGraph<NODE_VALUE_T,EDGE_VALUE_T> tmp = new NonOrientedGraph<>(this.nodesList,this.edgesList);
            tmp.edgesList.add(edge);
            if (tmp.isAcyclicGraph()) {
                minimumSpanningTree.addEdge(edge);
            }
        }

        return minimumSpanningTree;
    }

}
