package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Node.Node;

import java.util.Comparator;

public class PredecessorNode<NODE_VALUE,EDGE_VALUE extends Edge> implements Comparable{

    private Node<NODE_VALUE> predecessor;
    final public Node<NODE_VALUE> node;
    private Comparator<EDGE_VALUE> comparator;

    private EDGE_VALUE key;

    public PredecessorNode(Node<NODE_VALUE> node,EDGE_VALUE key,Comparator<EDGE_VALUE> comparator)
    {
        this.node = node;
        predecessor = null;
        this.key = key;
    }

    public void setPredecessor(Node<NODE_VALUE> predecessor) {
        this.predecessor = predecessor;
    }

    public void setKey(EDGE_VALUE key) {
        this.key = key;
    }

    public Node<NODE_VALUE> getPredecessor() {
        return predecessor;
    }

    public EDGE_VALUE getKey() {
        return key;
    }

    public Node<NODE_VALUE> getNode() {
        return node;
    }

    @Override
    public int compareTo(Object o) {

        EDGE_VALUE value2 = (EDGE_VALUE) o;
        return this.comparator.compare(this.getKey(),value2);
    }
}
