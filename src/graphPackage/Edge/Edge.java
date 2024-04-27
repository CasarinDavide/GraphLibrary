package graphPackage.Edge;

import graphPackage.Node.Node;

public abstract class Edge<EDGE_VALUE_T,NODE_TYPE> extends AbstractEdge{

    protected EDGE_VALUE_T value;
    protected final Node<NODE_TYPE> node1;
    protected final Node<NODE_TYPE> node2;

    public Edge(EDGE_VALUE_T value,Node<NODE_TYPE> node1, Node<NODE_TYPE> node2)
    {
        this.value = value;
        this.node1 = node1;
        this.node2 = node2;
    }

    public EDGE_VALUE_T getValue() {
        return value;
    }

    public void setValue(EDGE_VALUE_T value) {
        this.value = value;
    }


}
