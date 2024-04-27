package graphPackage.Edge;

import graphPackage.Node.Node;

public class BiOrdientedEdge<T,U> extends OrientedEdge<T,U>{

    public BiOrdientedEdge(T value, Node<U> node1, Node<U> node2) {
        super(value, node1, node2);
    }

    @Override
    public boolean isStartNode(Node<U> node)
    {
        return node == this.node1 || this.node2 == node;
    }

    @Override
    public boolean isToNode(Node<U> node)
    {
        return node == this.node2 || this.node1 == node;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof BiOrdientedEdge<?,?> edge)
        {
            return (node1 == edge.node1 || node2 == edge.node1) && (node1 == edge.node2 || node2 == edge.node2);
        }


        return false;
    }
}
