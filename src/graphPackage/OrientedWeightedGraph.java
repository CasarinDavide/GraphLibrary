package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Edge.OrientedEdge;
import graphPackage.Node.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class OrientedWeightedGraph<NODE_TYPE> extends OrientedGraph<NODE_TYPE,Number>{
    public OrientedWeightedGraph(List<Node<NODE_TYPE>> nodes, List<OrientedEdge<Number, NODE_TYPE>> orientedEdges) {
        super(nodes, orientedEdges);
    }


    /**
     * find the minumum path with s the source node
     */

    public void dijkstraAlgorithm(Node<NODE_TYPE> source)
    {
        PredecessorGraph<NODE_TYPE, OrientedEdge<Double,NODE_TYPE>> predecessorGraph = new PredecessorGraph<>(this.nodesList,source,null);



    }

}
