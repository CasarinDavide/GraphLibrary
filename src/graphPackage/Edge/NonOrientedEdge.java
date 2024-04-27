package graphPackage.Edge;

import graphPackage.Node.Node;

public class NonOrientedEdge<T,U> extends Edge<T,U>{

    public NonOrientedEdge(T value, Node<U> node1, Node<U> node2) {
        super(value, node1, node2);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof NonOrientedEdge<?, ?> edge)
        {
            return (node1 == edge.node1 || node2 == edge.node1) && (node1 == edge.node2 || node2 == edge.node2);
        }

        return false;
    }
}
