package graphPackage.Edge;

import graphPackage.Node.Node;

public class SingleOrientedEdge<T,U> extends OrientedEdge<T,U>{

    public SingleOrientedEdge(T value, Node<U> node1, Node<U> node2) {
        super(value, node1, node2);
    }

    public Node<U> getStartNode()
    {
        return this.node1;
    }

    public Node<U> getToNode()
    {
        return this.node2;
    }

}
