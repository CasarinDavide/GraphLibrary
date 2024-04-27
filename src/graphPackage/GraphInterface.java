package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Node.AbstractNode;
import graphPackage.Node.Node;

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
    Graph<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE> union(Graph<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE> g2);


}
