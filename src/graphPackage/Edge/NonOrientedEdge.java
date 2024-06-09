package graphPackage.Edge;

import graphPackage.Node.Node;

public class NonOrientedEdge<T,U> extends Edge<T,U>{

    public NonOrientedEdge(T value, Node<U> node1, Node<U> node2) {
        super(value, node1, node2);
    }

    /**
     * In an undirected graph there is not a real direction so, iff node exsists in the edge then its a starting node and even an destination node
     * @param node
     * @return
     */
    @Override
    public boolean isStartNode(Node<U> node) {
        return this.getNode1().equals(node) || this.getNode2().equals(node);
    }

    @Override
    public boolean isToNode(Node<U> node) {
        return this.getNode1().equals(node) || this.getNode2().equals(node);
    }

    @Override
    public Node<U> getToDestination(Node<U> node) {

        if (!this.isStartNode(node))
            return null;
        else
        {
            if (this.getNode2() == node)
                return this.getNode1();
            else
                return this.getNode2();
        }

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
