package graphPackage.Edge;

import graphPackage.Node.Node;

public class OrientedEdge<T,U> extends Edge<T,U>{

    public OrientedEdge(T value, Node<U> node1, Node<U> node2) {
        super(value, node1, node2);
    }

    public boolean isStartNode(Node<U> node)
    {
        return node == this.node1;
    }

    public boolean isToNode(Node<U> node)
    {
        return node == this.node2;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj instanceof OrientedEdge<?,?> edge) {
            return edge.node1 == this.node1 && edge.node2 == this.node2;
        }

        return false;
    }
}
