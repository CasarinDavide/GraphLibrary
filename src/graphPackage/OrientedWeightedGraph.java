package graphPackage;

import graphPackage.Edge.OrientedEdge;
import graphPackage.Node.Node;

import java.util.List;

public class OrientedWeightedGraph<NODE_TYPE> extends OrientedGraph<NODE_TYPE,Number>{
    public OrientedWeightedGraph(List<Node<NODE_TYPE>> nodes, List<OrientedEdge<Number, NODE_TYPE>> orientedEdges) {
        super(nodes, orientedEdges);
    }
}
