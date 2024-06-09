package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Node.AbstractNode;
import graphPackage.Node.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GraphInterface<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE extends Edge<EDGE_VALUE_T,NODE_VALUE_T>> {

    void addNodes(Node<NODE_VALUE_T> node);
    Node<NODE_VALUE_T> removeNodes(Node<NODE_VALUE_T> node);
    boolean containsNode(Node<NODE_VALUE_T> node);
    void addEdge(EDGE_TYPE edge);
    EDGE_TYPE removeEdge(EDGE_TYPE edge);
    void setEdgeWeight(EDGE_TYPE edge, EDGE_VALUE_T value );
    boolean containsEdge(EDGE_TYPE edge);
    boolean isSubGraph(Graph<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE> g2);
    boolean isAcyclicGraph();
    public abstract double graphDensity();
    void breadthFirstSearch(Node<NODE_VALUE_T> node, Map<Node<NODE_VALUE_T>, Boolean> visitedMap);

    public abstract int getNodeDegree(Node<NODE_VALUE_T > node);

    public abstract int isRegularGraph();

    public abstract List<Node<NODE_VALUE_T>> getAllIsolatedVertex();

    public abstract List<Node<NODE_VALUE_T>> getAllAdjacentNode(Node<NODE_VALUE_T> node);

    public abstract List<EDGE_TYPE> getAllAdjacentEdge(Node<NODE_VALUE_T> node);

    public List<Node<NODE_VALUE_T>> getAllNodes();
    public List<EDGE_TYPE> getAllEdges();

}
