package graphPackage;

import graphPackage.Edge.OrientedEdge;
import graphPackage.Node.Node;

import java.util.List;

public class OrientedLabeledGraph<NODE_TYPE> extends OrientedGraph<NODE_TYPE,String> {
    public OrientedLabeledGraph(List<Node<NODE_TYPE>> nodes, List<OrientedEdge<String, NODE_TYPE>> orientedEdges) {
        super(nodes, orientedEdges);
    }
}
