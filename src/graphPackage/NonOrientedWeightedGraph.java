package graphPackage;

import graphPackage.Edge.NonOrientedEdge;
import graphPackage.Edge.OrientedEdge;
import graphPackage.Node.Node;

import java.util.List;

public class NonOrientedWeightedGraph<NODE_TYPE> extends NonOrientedGraph<NODE_TYPE,Number>{
    public NonOrientedWeightedGraph(List<Node<NODE_TYPE>> nodes, List<NonOrientedEdge<Number, NODE_TYPE>> nonOrientedEdges) {
        super(nodes, nonOrientedEdges);
    }
}
