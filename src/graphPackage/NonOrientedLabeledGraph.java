package graphPackage;

import graphPackage.Edge.NonOrientedEdge;
import graphPackage.Edge.OrientedEdge;
import graphPackage.Node.Node;

import java.util.List;

public class NonOrientedLabeledGraph<NODE_TYPE> extends NonOrientedGraph<NODE_TYPE,String>{

    public NonOrientedLabeledGraph(List<Node<NODE_TYPE>> nodes, List<NonOrientedEdge<String, NODE_TYPE>> nonOrientedEdges) {
        super(nodes, nonOrientedEdges);
    }
}
